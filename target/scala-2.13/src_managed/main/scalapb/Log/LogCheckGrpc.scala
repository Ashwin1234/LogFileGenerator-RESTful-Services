package Log

object LogCheckGrpc {
  val METHOD_CHECK: _root_.io.grpc.MethodDescriptor[Log.LogRequest, Log.LogResponse] =
    _root_.io.grpc.MethodDescriptor.newBuilder()
      .setType(_root_.io.grpc.MethodDescriptor.MethodType.UNARY)
      .setFullMethodName(_root_.io.grpc.MethodDescriptor.generateFullMethodName("LogCheck", "check"))
      .setSampledToLocalTracing(true)
      .setRequestMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[Log.LogRequest])
      .setResponseMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[Log.LogResponse])
      .setSchemaDescriptor(_root_.scalapb.grpc.ConcreteProtoMethodDescriptorSupplier.fromMethodDescriptor(Log.LogProto.javaDescriptor.getServices().get(0).getMethods().get(0)))
      .build()
  
  val SERVICE: _root_.io.grpc.ServiceDescriptor =
    _root_.io.grpc.ServiceDescriptor.newBuilder("LogCheck")
      .setSchemaDescriptor(new _root_.scalapb.grpc.ConcreteProtoFileDescriptorSupplier(Log.LogProto.javaDescriptor))
      .addMethod(METHOD_CHECK)
      .build()
  
  /** The greeting service definition.
    */
  trait LogCheck extends _root_.scalapb.grpc.AbstractService {
    override def serviceCompanion = LogCheck
    /** Sends a greeting
      */
    def check(request: Log.LogRequest): scala.concurrent.Future[Log.LogResponse]
  }
  
  object LogCheck extends _root_.scalapb.grpc.ServiceCompanion[LogCheck] {
    implicit def serviceCompanion: _root_.scalapb.grpc.ServiceCompanion[LogCheck] = this
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = Log.LogProto.javaDescriptor.getServices().get(0)
    def scalaDescriptor: _root_.scalapb.descriptors.ServiceDescriptor = Log.LogProto.scalaDescriptor.services(0)
    def bindService(serviceImpl: LogCheck, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition =
      _root_.io.grpc.ServerServiceDefinition.builder(SERVICE)
      .addMethod(
        METHOD_CHECK,
        _root_.io.grpc.stub.ServerCalls.asyncUnaryCall(new _root_.io.grpc.stub.ServerCalls.UnaryMethod[Log.LogRequest, Log.LogResponse] {
          override def invoke(request: Log.LogRequest, observer: _root_.io.grpc.stub.StreamObserver[Log.LogResponse]): Unit =
            serviceImpl.check(request).onComplete(scalapb.grpc.Grpc.completeObserver(observer))(
              executionContext)
        }))
      .build()
  }
  
  /** The greeting service definition.
    */
  trait LogCheckBlockingClient {
    def serviceCompanion = LogCheck
    /** Sends a greeting
      */
    def check(request: Log.LogRequest): Log.LogResponse
  }
  
  class LogCheckBlockingStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[LogCheckBlockingStub](channel, options) with LogCheckBlockingClient {
    /** Sends a greeting
      */
    override def check(request: Log.LogRequest): Log.LogResponse = {
      _root_.scalapb.grpc.ClientCalls.blockingUnaryCall(channel, METHOD_CHECK, options, request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): LogCheckBlockingStub = new LogCheckBlockingStub(channel, options)
  }
  
  class LogCheckStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[LogCheckStub](channel, options) with LogCheck {
    /** Sends a greeting
      */
    override def check(request: Log.LogRequest): scala.concurrent.Future[Log.LogResponse] = {
      _root_.scalapb.grpc.ClientCalls.asyncUnaryCall(channel, METHOD_CHECK, options, request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): LogCheckStub = new LogCheckStub(channel, options)
  }
  
  def bindService(serviceImpl: LogCheck, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition = LogCheck.bindService(serviceImpl, executionContext)
  
  def blockingStub(channel: _root_.io.grpc.Channel): LogCheckBlockingStub = new LogCheckBlockingStub(channel)
  
  def stub(channel: _root_.io.grpc.Channel): LogCheckStub = new LogCheckStub(channel)
  
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = Log.LogProto.javaDescriptor.getServices().get(0)
  
}