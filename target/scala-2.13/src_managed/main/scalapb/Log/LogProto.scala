// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package Log

object LogProto extends _root_.scalapb.GeneratedFileObject {
  lazy val dependencies: Seq[_root_.scalapb.GeneratedFileObject] = Seq.empty
  lazy val messagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] =
    Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]](
      Log.LogRequest,
      Log.LogResponse
    )
  private lazy val ProtoBytes: _root_.scala.Array[Byte] =
      scalapb.Encoding.fromBase64(scala.collection.immutable.Seq(
  """CglMb2cucHJvdG8iYwoKTG9nUmVxdWVzdBIdCgR0aW1lGAEgASgJQgniPwYSBHRpbWVSBHRpbWUSNgoNdGltZV9pbnRlcnZhb
  BgCIAEoCUIR4j8OEgx0aW1lSW50ZXJ2YWxSDHRpbWVJbnRlcnZhbCIyCgtMb2dSZXNwb25zZRIjCgZzdGF0dXMYASABKAhCC+I/C
  BIGc3RhdHVzUgZzdGF0dXMyMAoITG9nQ2hlY2sSJAoFY2hlY2sSCy5Mb2dSZXF1ZXN0GgwuTG9nUmVzcG9uc2UiAGIGcHJvdG8z"""
      ).mkString)
  lazy val scalaDescriptor: _root_.scalapb.descriptors.FileDescriptor = {
    val scalaProto = com.google.protobuf.descriptor.FileDescriptorProto.parseFrom(ProtoBytes)
    _root_.scalapb.descriptors.FileDescriptor.buildFrom(scalaProto, dependencies.map(_.scalaDescriptor))
  }
  lazy val javaDescriptor: com.google.protobuf.Descriptors.FileDescriptor = {
    val javaProto = com.google.protobuf.DescriptorProtos.FileDescriptorProto.parseFrom(ProtoBytes)
    com.google.protobuf.Descriptors.FileDescriptor.buildFrom(javaProto, _root_.scala.Array(
    ))
  }
  @deprecated("Use javaDescriptor instead. In a future version this will refer to scalaDescriptor.", "ScalaPB 0.5.47")
  def descriptor: com.google.protobuf.Descriptors.FileDescriptor = javaDescriptor
}