// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package Log

/** The request message containing the user's name.
  */
@SerialVersionUID(0L)
final case class LogRequest(
    time: _root_.scala.Predef.String = "",
    timeInterval: _root_.scala.Predef.String = "",
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[LogRequest] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = time
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
        }
      };
      
      {
        val __value = timeInterval
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
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
        val __v = time
        if (!__v.isEmpty) {
          _output__.writeString(1, __v)
        }
      };
      {
        val __v = timeInterval
        if (!__v.isEmpty) {
          _output__.writeString(2, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withTime(__v: _root_.scala.Predef.String): LogRequest = copy(time = __v)
    def withTimeInterval(__v: _root_.scala.Predef.String): LogRequest = copy(timeInterval = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = time
          if (__t != "") __t else null
        }
        case 2 => {
          val __t = timeInterval
          if (__t != "") __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(time)
        case 2 => _root_.scalapb.descriptors.PString(timeInterval)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = Log.LogRequest
    // @@protoc_insertion_point(GeneratedMessage[LogRequest])
}

object LogRequest extends scalapb.GeneratedMessageCompanion[Log.LogRequest] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[Log.LogRequest] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): Log.LogRequest = {
    var __time: _root_.scala.Predef.String = ""
    var __timeInterval: _root_.scala.Predef.String = ""
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __time = _input__.readStringRequireUtf8()
        case 18 =>
          __timeInterval = _input__.readStringRequireUtf8()
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    Log.LogRequest(
        time = __time,
        timeInterval = __timeInterval,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[Log.LogRequest] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      Log.LogRequest(
        time = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        timeInterval = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse("")
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = LogProto.javaDescriptor.getMessageTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = LogProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = Log.LogRequest(
    time = "",
    timeInterval = ""
  )
  implicit class LogRequestLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, Log.LogRequest]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, Log.LogRequest](_l) {
    def time: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.time)((c_, f_) => c_.copy(time = f_))
    def timeInterval: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.timeInterval)((c_, f_) => c_.copy(timeInterval = f_))
  }
  final val TIME_FIELD_NUMBER = 1
  final val TIME_INTERVAL_FIELD_NUMBER = 2
  def of(
    time: _root_.scala.Predef.String,
    timeInterval: _root_.scala.Predef.String
  ): _root_.Log.LogRequest = _root_.Log.LogRequest(
    time,
    timeInterval
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[LogRequest])
}
