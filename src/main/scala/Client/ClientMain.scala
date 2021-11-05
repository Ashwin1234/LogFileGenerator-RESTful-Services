package Client

import Log.LogRequest
import scala.io.StdIn

// The main function which inputs the timestamp and time interval to the client functions
object ClientMain {
   def main(args: Array[String]): Unit = {
    val time = "18:56:36"
    val time_interval = "00:00:01"
    val request = LogRequest(
      time, time_interval
    )
   // println(args)
    /*if (args.length > 0) {
      if (args(0) == "grpc") {
        println("grpc")
        val client = new LogClient()
        val response = client.check(request)
        println(response)
      }
      else if (args(0) == "rest") {
        println("rest")
        val client = new LogClientRest()
        val response = client.check(request)
        println(response)
      }
    }*/
     /*val clientrest = new LogClientRest()
     println(clientrest.check(request))*/
    val clientgRPC = new LogClient()
     val response = clientgRPC.check(request)
     println(response)
     if(response){
       val clientRest = new LogClientRest()
       println(clientRest.check(request))
     }
     else{
       println("The timestamp is not present in ",response)
     }

  }

}
