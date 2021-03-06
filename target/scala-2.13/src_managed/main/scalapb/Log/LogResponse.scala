// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package Log

/** The response message containing the greetings
  */
@SerialVersionUID(0L)
final case class LogResponse(
    status: _root_.scala.Boolean = false,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[LogResponse] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = status
        if (__value != false) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeBoolSize(1, __value)
        }
      };
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      {
        val __v = status
        if (__v != false) {
          _output__.writeBool(1, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withStatus(__v: _root_.scala.Boolean): LogResponse = copy(status = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = status
          if (__t != false) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PBoolean(status)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = Log.LogResponse
    // @@protoc_insertion_point(GeneratedMessage[LogResponse])
}

object LogResponse extends scalapb.GeneratedMessageCompanion[Log.LogResponse] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[Log.LogResponse] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): Log.LogResponse = {
    var __status: _root_.scala.Boolean = false
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __status = _input__.readBool()
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    Log.LogResponse(
        status = __status,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[Log.LogResponse] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      Log.LogResponse(
        status = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Boolean]).getOrElse(false)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = LogProto.javaDescriptor.getMessageTypes().get(1)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = LogProto.scalaDescriptor.messages(1)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = Log.LogResponse(
    status = false
  )
  implicit class LogResponseLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, Log.LogResponse]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, Log.LogResponse](_l) {
    def status: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Boolean] = field(_.status)((c_, f_) => c_.copy(status = f_))
  }
  final val STATUS_FIELD_NUMBER = 1
  def of(
    status: _root_.scala.Boolean
  ): _root_.Log.LogResponse = _root_.Log.LogResponse(
    status
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[LogResponse])
}
