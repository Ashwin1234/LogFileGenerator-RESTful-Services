package service
import Log.{LogCheckGrpc, LogRequest, LogResponse}
import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.amazonaws.services.lambda.runtime.events.{APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent, APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse}
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.typesafe.config.{Config, ConfigFactory}

import java.io.{BufferedReader, InputStreamReader}
import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.concurrent.Future
import scala.io.Source

// the srvice function
object LogService extends LogCheckGrpc.LogCheck{
  /** Sends a greeting
   */
  val config: Config = ConfigFactory.load("application.conf").getConfig("AWS")

  override def check(request: LogRequest): Future[LogResponse] = {
    // access the s3 bucket using the amazons3Client
    val ACCESS_KEY = config.getString("access_key")
    val SECRET_KEY = config.getString("secret_key")
    val bucket_name = config.getString("bucket_name")
    val file_name = config.getString("file_name")

    val amazonS3Client = new AmazonS3Client()

    // Access s3 bucket
    val obj = amazonS3Client.getObject(bucket_name,file_name)
    val reader = new BufferedReader(new InputStreamReader(obj.getObjectContent()))  // read the input file from s3 and store it in a ListBuffer
    val linesBuffer : ListBuffer[String] = ListBuffer()
     reader.lines().forEach( value =>
       linesBuffer+=value
     )
    println(linesBuffer)
    val time = request.time
    val interval = request.time
   // val lines = Source.fromFile("input.log").getLines.toList
    val result = find_timestamp(linesBuffer,time, 0, linesBuffer.length-1)
    println(result)
    val reply = LogResponse(status = result)
    println(" reply " ,reply)
    Future.successful(reply)
  }

  // The function which finds whether the given timestamp is present in the log file using Binary Search
  def find_timestamp(lines: ListBuffer[String], time : String, low: Int, high: Int): Boolean={
    if (low > high){
      return false
    }
    val mid = (low+high)/2

    if(lines(mid).split(" ")(0).split('.')(0) == time){
      true
    }
    else if (time<lines(mid).split(" ")(0).split('.')(0)){
     val high = mid-1
      find_timestamp(lines, time, low, high)
    }
    else {
      val low = mid+1
      find_timestamp(lines,time, low , high)
    }


  }

}
