package lambda

import Log.{LogRequest, LogResponse}
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.amazonaws.services.lambda.runtime.events.{APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent}
import com.amazonaws.services.s3.AmazonS3Client
import com.google.gson.Gson
import com.typesafe.config.{Config, ConfigFactory}
import org.json4s.JsonInput
import scalapb.json4s.JsonFormat
import service.{LogService, LogsOutput}
import service.LogService.config

import java.util
import java.io.{BufferedReader, InputStreamReader}
import java.util.Base64
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import org.json4s._
import org.json4s.jackson.JsonMethods._
import scalaj.http.HttpRequest
import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Map}
import scala.io.Source


// The class lambdaService which contains the Lambda function
class LambdaServiceRest extends RequestHandler[util.Map[String,Object],util.Map[String,Object]] {
  val config: Config = ConfigFactory.load("application.conf").getConfig("AWS")

  override def handleRequest(input: util.Map[String,Object], context: Context): util.Map[String,Object] = {
    val ACCESS_KEY = config.getString("access_key")
    val SECRET_KEY = config.getString("secret_key")
    val bucket_name = config.getString("bucket_name")
    val file_name = config.getString("file_name")
    val awscredentials = new BasicAWSCredentials(ACCESS_KEY,SECRET_KEY)
    val amazonS3Client = new AmazonS3Client(awscredentials)
    val logger = context.getLogger
    val gson = new Gson




    //logger.log(s"message input: $message")
    logger.log(s"input $input")
    val message = JsonFormat.fromJsonString[LogRequest](gson.toJson(input))
    val time = message.time
    logger.log(s"time $time")

    // Read from s3 file
    val obj = amazonS3Client.getObject(bucket_name,file_name)
    val reader = new BufferedReader(new InputStreamReader(obj.getObjectContent()))
    val linesBuffer : ListBuffer[String] = ListBuffer()
    reader.lines().forEach( value =>
      linesBuffer+=value
    )
    logger.log(s"inputs $linesBuffer")
    val map1: Map[String, ListBuffer[String]] = Map()
    // Find the strings which match the input regex pattern and return true if they exists
    linesBuffer.foreach(value => {

      val timestamp = value.split(" ")(0).split('.')(0)
      if (map1.contains(timestamp)){
        map1(timestamp) = map1(timestamp)+=value
      }
      else{
        map1(timestamp) = ListBuffer(value)
      }
    })
    val pattern_strings: ListBuffer[String] = ListBuffer()



    val pattern = config.getString("regex_pattern").r
    map1(time).foreach(value => {
      pattern.findFirstMatchIn(value) match {
        case Some(pat) => {
          pattern_strings+=value
        }
      }
    })


    // Return a JSON response
    val response = gson.fromJson(JsonFormat.toJsonString(LogResponse(status = true)),classOf[util.Map[String, Object]])

    //val response = Map("pattern" -> pattern_strings)

    println(response)

    response
  }

}
