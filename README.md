# Homework 3
The main aim of this assignment is to build a lambda function using API gateway and access it using gRPC and http calls. <br>
youtube - [video](https://www.youtube.com/watch?v=V07-cGly2AE)
## Prerequisites
Since we are using AWS it requires AWS account credentials.
Intellij with scala 2.13.6
scalapb version
## Instructions to run
clone the repo - ```https://github.com/Ashwin1234/LogFileGenerator-RESTful-Services.git``` <br>
After Intellij setup run the command ```sbt run``` in sbt terminal , this will run the grpc and http clients which inturn call the lambda functions.

## Instructions to deploy Lambda function in AWS

Create an AWS account <br>
Navigate to AWS lambda and create a function and specify the name of the function. Add permissions by creating a role with 2 polices ```cloudwatch logs ``` and ```s3 acces``` <br>
create a Fat JAR of the project with the Lambda function. <br>
Upload the JAR and create the function.<br>
Test the function and add a trigger to create an API endpoint using API Gateway.<br>


## Project Structure
1. Protobuf - It  contains the proto file. <br>
2. Resources - It contains the config files. <br>
3. Client - It contains the gRPC and REST client. <br>
4. Lambda - It contains the 2 Lambda functions. <br>
5. Service - It contains the server for gRPC <br>
6. Test - Contains certain tests. <br>

## The proto file 
```
syntax = "proto3";

// The greeting service definition.
service LogCheck {
  // Sends a greeting
  rpc check (LogRequest) returns (LogResponse) {}
}

message LogRequest {
  string time = 1;
  string time_interval=2;
}


message LogResponse {
  bool status = 1;
}



```
The above shows the proto file for gRPC. LogRequest is the request message which contains 2 parameters time and time_interval. LogResponse is the message containing the output parameter which is a boolean value which signifies whether the timestamp is present in the logfile. 
## Lambda gRPC

The Lambda function for gRPC accepts a APIGatewayProxyRequestEvent and return a APIGatewayProxyResponseEvent which uses a Base64 encoded data to transfer. It then uses a service which then determines the availability of the timestamp in the log file in O(log(n)) time complexity.
The client then makes a gRPC request to the Lambda function using the [Scalaj Http](https://github.com/scalaj/scalaj-http)
The api endpoint for this Lambda function - [https://jl1801co90.execute-api.us-east-2.amazonaws.com/default/LambdaService](https://jl1801co90.execute-api.us-east-2.amazonaws.com/default/LambdaService)
```
2021-11-04T17:18:17.821-05:00	START RequestId: a186798b-487d-4550-9157-b2bd9017a813 Version: $LATEST

2021-11-04T17:18:18.815-05:00	{resource: /LambdaService,path: /LambdaService,httpMethod: POST,headers: {Accept=application/grpc+proto, Accept-Encoding=gzip,deflate, Content-Type=application/grpc+proto, Host=jl1801co90.execute-api.us-east-2.amazonaws.com, User-Agent=scalaj-http/2.4.2, X-Amzn-Trace-Id=Root=1-61845c28-3e3f1fb4520d22c370df0b1b, X-Forwarded-For=131.193.64.146, X-Forwarded-Port=443, X-Forwarded-Proto=https},multiValueHeaders: {Accept=[application/grpc+proto], Accept-Encoding=[gzip,deflate], Content-Type=[application/grpc+proto], Host=[jl1801co90.execute-api.us-east-2.amazonaws.com], User-Agent=[scalaj-http/2.4.2], X-Amzn-Trace-Id=[Root=1-61845c28-3e3f1fb4520d22c370df0b1b], X-Forwarded-For=[131.193.64.146], X-Forwarded-Port=[443], X-Forwarded-Proto=[https]},requestContext: {accountId: 336731014158,resourceId: w7w1jw,stage: default,requestId: fba1c45c-ef5e-42f9-8d28-cc66ded05e66,identity: {sourceIp: 131.193.64.146,userAgent: scalaj-http/2.4.2,},resourcePath: /LambdaService,httpMethod: POST,apiId: jl1801co90,path: /default/LambdaService,},body:

2021-11-04T17:18:18.815-05:00	18:56:3800:00:01,isBase64Encoded: false}

2021-11-04T17:18:18.816-05:00	message input: {resource: /LambdaService,path: /LambdaService,httpMethod: POST,headers: {Accept=application/grpc+proto, Accept-Encoding=gzip,deflate, Content-Type=application/grpc+proto, Host=jl1801co90.execute-api.us-east-2.amazonaws.com, User-Agent=scalaj-http/2.4.2, X-Amzn-Trace-Id=Root=1-61845c28-3e3f1fb4520d22c370df0b1b, X-Forwarded-For=131.193.64.146, X-Forwarded-Port=443, X-Forwarded-Proto=https},multiValueHeaders: {Accept=[application/grpc+proto], Accept-Encoding=[gzip,deflate], Content-Type=[application/grpc+proto], Host=[jl1801co90.execute-api.us-east-2.amazonaws.com], User-Agent=[scalaj-http/2.4.2], X-Amzn-Trace-Id=[Root=1-61845c28-3e3f1fb4520d22c370df0b1b], X-Forwarded-For=[131.193.64.146], X-Forwarded-Port=[443], X-Forwarded-Proto=[https]},requestContext: {accountId: 336731014158,resourceId: w7w1jw,stage: default,requestId: fba1c45c-ef5e-42f9-8d28-cc66ded05e66,identity: {sourceIp: 131.193.64.146,userAgent: scalaj-http/2.4.2,},resourcePath: /LambdaService,httpMethod: POST,apiId: jl1801co90,path: /default/LambdaService,},body: 18:56:3800:00:01,isBase64Encoded: false}

2021-11-04T17:18:18.858-05:00	message message: (10, 8, 49, 56, 58, 53, 54, 58, 51, 56, 18, 8, 48, 48, 58, 48, 48, 58, 48, 49)

2021-11-04T17:18:19.095-05:00	time_input: LogRequest(18:56:38,00:00:01,UnknownFieldSet(Map()))

2021-11-04T17:18:26.117-05:00	false

2021-11-04T17:18:26.136-05:00	( reply ,LogResponse(false,UnknownFieldSet(Map())))

2021-11-04T17:18:26.616-05:00	output1 [B@ba8d91c

2021-11-04T17:18:26.635-05:00	output:

2021-11-04T17:18:27.054-05:00	END RequestId: a186798b-487d-4550-9157-b2bd9017a813
```
Example of logs generated by the Lambda function

## Lambda Rest
The functon for REST calls accepts a JSON Object and returns a JSON object which basically finds all the strings if the timestamp is present using Map and returns True if the strings match the designated regex pattern.
The client then makes a POST request to the Lambda function by sending the timestamp and the time interval in which the messages have to be searched.
The api endpoint for this Lambda function - [https://xnpgvlf1xd.execute-api.us-east-2.amazonaws.com/default/LogFunctionRest](https://84xniusr0i.execute-api.us-east-2.amazonaws.com/default/LogLambdaRest)

```
2021-11-04T03:41:38.382-05:00	START RequestId: 9db56f14-4206-4f0a-8431-747c32f1c996 Version: $LATEST

2021-11-04T03:41:46.545-05:00	{time=18:23:38, time_interval=00:00:01}

2021-11-04T03:41:49.281-05:00	time 18:23:38

2021-11-04T03:41:49.920-05:00	{status=true}

2021-11-04T03:41:50.024-05:00	END RequestId: 9db56f14-4206-4f0a-8431-747c32f1c996
```
These are the examples of log files generated by the Lambda function.

The log files are generated in s3 using log generator in ec2 instance which are accessed by the Lambda functions.
## Tests
1. To check the pattern <br>
2. To check the url for grpc <br>
3. To check the url for Rest <br>
4. To check the bucket name <br>

## References 
[scalaPB](https://scalapb.github.io/docs/grpc/) <br>
[Github](https://github.com/mayankrastogi/lambda-grpc-calculator)

