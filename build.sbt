name := "LogRestFullServices"

version := "0.1"

scalaVersion := "2.13.6"

val logbackVersion = "1.3.0-alpha10"
val sfl4sVersion = "2.0.0-alpha5"
val typesafeConfigVersion = "1.4.1"
val apacheCommonIOVersion = "2.11.0"
val scalacticVersion = "3.2.9"
val generexVersion = "1.0.2"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-core" % logbackVersion,
  "ch.qos.logback" % "logback-classic" % logbackVersion,
  "org.slf4j" % "slf4j-api" % sfl4sVersion,
  "com.typesafe" % "config" % typesafeConfigVersion,
  "commons-io" % "commons-io" % apacheCommonIOVersion,
  "org.scalactic" %% "scalactic" % scalacticVersion,
  "org.scalatest" %% "scalatest" % scalacticVersion % Test,
  "org.scalatest" %% "scalatest-featurespec" % scalacticVersion % Test,
  "com.typesafe" % "config" % typesafeConfigVersion,
  "com.github.mifmif" % "generex" % generexVersion,
)

Compile / PB.targets := Seq(
  scalapb.gen() -> (Compile / sourceManaged).value / "scalapb"
)

// (optional) If you need scalapb/scalapb.proto or anything from
// google/protobuf/*.proto



libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
)
libraryDependencies ++= Seq(
  "io.grpc" % "grpc-netty" % scalapb.compiler.Version.grpcJavaVersion,
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion
)

assemblyJarName in assembly := "lambda-scala-seed.jar"

lazy val assemblySettings =
  assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
  }
assemblyMergeStrategy in assembly := {
  case x if x.contains("io.netty.versions.properties") => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
lazy val json4s = "com.thesamet.scalapb" %% "scalapb-json4s" % "0.7.0"

// AWS Lambda SDK
lazy val awsCore = "com.amazonaws" % "aws-lambda-java-core" % "1.2.0"
lazy val awsEvents = "com.amazonaws" % "aws-lambda-java-events" % "2.2.6"


// ScalaJ HTTP Library
lazy val scalaJHTTP = "org.scalaj" %% "scalaj-http" % "2.4.1"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-lambda-java-core" % "1.2.1",
  "com.amazonaws" % "aws-lambda-java-events" % "3.10.0",
)

libraryDependencies += "com.thesamet.scalapb" %% "scalapb-json4s" % "0.12.0"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.4.2"
libraryDependencies += "com.amazonaws" % "aws-java-sdk-s3" % "1.12.99"




