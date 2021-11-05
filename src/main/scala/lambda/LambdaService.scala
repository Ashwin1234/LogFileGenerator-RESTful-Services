package lambda
import Log.LogRequest
import Log.LogRequest.messageCompanion
import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.amazonaws.services.lambda.runtime.events.{APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent, APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse}
import com.google.api.LogProto
import com.google.protobuf.timestamp.Timestamp.defaultInstance.seconds
import scalapb.json4s.JsonFormat
import service.LogService
import sun.rmi.runtime.Log

import java.util.Base64
import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.concurrent.duration._
import scala.collection.JavaConverters._

// The class lambdaService which contains the Lambda function
class LambdaService extends RequestHandler[APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent] {

  override def handleRequest(input: APIGatewayProxyRequestEvent, context: Context): APIGatewayProxyResponseEvent = {
    val logger = context.getLogger
    println(input)
    logger.log(s"message input: $input")
    val message = if (input.getIsBase64Encoded) Base64.getDecoder.decode(input.getBody.getBytes) else input.getBody.getBytes
    logger.log(s"message message: (${message.mkString(", ")})")
    val time_input = LogRequest.parseFrom(message)
    logger.log(s"time_input: $time_input")
    // calls the service which checks for the timestamp in log files in s3.
    val result = Await.result(LogService.check(time_input), Duration(15, "seconds"))
    logger.log(s"output1 ${result.toByteArray}")
    val output = Base64.getEncoder.encodeToString(result.toByteArray)
    logger.log(s"output: $output")

    // return an APIGatewayProxyResponseEvent
    new APIGatewayProxyResponseEvent()
      .withStatusCode(200)
      .withHeaders(Map("Content-Type" -> "application/grpc+proto").asJava)
      .withIsBase64Encoded(true)
      .withBody(output)
  }
}
