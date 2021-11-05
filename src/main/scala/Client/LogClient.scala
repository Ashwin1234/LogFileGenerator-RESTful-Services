package Client

import Log.{LogRequest, LogResponse}
import scalaj.http.Http
import com.typesafe.config.{Config, ConfigFactory}

import java.util.Base64

// the client function for the gRPC lambda which sends a gRPC request to the Lambda function api
class LogClient {
  val config: Config = ConfigFactory.load("application.conf").getConfig("AWS")
  def check(logRequest: LogRequest): Boolean = {
    val url = config.getString("url_grpc")
    println("came here")
    val response=Http(url)
      .headers(Map(
        "Content-Type" -> "application/grpc+proto",
        "Accept" -> "application/grpc+proto"
      ))
      .timeout(connTimeoutMs = 20000, readTimeoutMs = 10000)
      .postData(logRequest.toByteArray)

      println("response output ")
    // Decode the output and extract the output from the body
    val message = Base64.getDecoder.decode(response.asBytes.body)
    //val message = request.asBytes.body
    val output =  LogResponse.parseFrom(message)
    //println("output status ",Base64.getDecoder.decode(response.asBytes.statusLine))
    output.status
  }
}
