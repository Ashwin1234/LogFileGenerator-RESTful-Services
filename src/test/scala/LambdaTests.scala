import com.typesafe.config.{Config, ConfigFactory}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class LambdaTests extends AnyFlatSpec with Matchers {

  behavior of "configuration parameters module"
  val config: Config = ConfigFactory.load("application.conf").getConfig("AWS")


  it should "ragex pattern" in {
    config.getString("regex_pattern") shouldBe "(.*?)"
  }
  it should "url for grpc" in {
    config.getString("url_grpc") shouldBe "https://jl1801co90.execute-api.us-east-2.amazonaws.com/default/LambdaService"
  }
  it should "url for REST" in {
    config.getString("url_rest") shouldBe "https://xnpgvlf1xd.execute-api.us-east-2.amazonaws.com/default/LogFunctionRest"
  }
  it should "bucket name" in {
    config.getString("bucket_name") shouldBe "logservice-1"
  }




}
