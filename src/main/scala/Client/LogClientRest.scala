package Client

import Log.{LogRequest, LogResponse}
import com.google.gson.Gson
import com.typesafe.config.{Config, ConfigFactory}
import scalaj.http.Http

import java.util
import scalapb.json4s.JsonFormat

import scala.collection.mutable.ListBuffer

/*The client class for the REST Lambda function which sends a POST request to the REST lambda api*/
class LogClientRest {
  val config: Config = ConfigFactory.load("application.conf").getConfig("AWS")
  def check(logRequest: LogRequest): Boolean = {
    val gson = new Gson
    val url = config.getString("url_rest")
    val logMap = gson.fromJson(JsonFormat.toJsonString(logRequest), classOf[util.Map[String, Object]])
    println(logMap)
    println(gson.toJson(logMap))
    val response = Http(url)
      .headers(Map(
        "Content-Type" -> "application/json",
        "Accept" -> "application/json"
      ))
      .timeout(connTimeoutMs = 2000, readTimeoutMs = 10000)
      .postData(gson.toJson(logMap))
    //val response = Http(url).param("time"->logRequest.time)
    //println(request.asString.body)

    //val message = Base64.getDecoder.decode(request.asBytes.body)
    //val message = request.asBytes.body
    //val output =  LogResponse.parseFrom(message)
    println(response.asString.body)
    val output = JsonFormat.fromJsonString[LogResponse](response.asString.body)

    output.status
  }
}
