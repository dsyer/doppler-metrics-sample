// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: uuid.proto

package org.springframework.boot.actuate.metrics.doppler.events;

public final class Uuid {
  private Uuid() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface UUIDOrBuilder extends
      // @@protoc_insertion_point(interface_extends:events.UUID)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required uint64 low = 1;</code>
     */
    boolean hasLow();
    /**
     * <code>required uint64 low = 1;</code>
     */
    long getLow();

    /**
     * <code>required uint64 high = 2;</code>
     */
    boolean hasHigh();
    /**
     * <code>required uint64 high = 2;</code>
     */
    long getHigh();
  }
  /**
   * Protobuf type {@code events.UUID}
   *
   * <pre>
   *&#47; Type representing a 128-bit UUID.
   * </pre>
   */
  public static final class UUID extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:events.UUID)
      UUIDOrBuilder {
    // Use UUID.newBuilder() to construct.
    private UUID(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private UUID(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final UUID defaultInstance;
    public static UUID getDefaultInstance() {
      return defaultInstance;
    }

    public UUID getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private UUID(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              low_ = input.readUInt64();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              high_ = input.readUInt64();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.springframework.boot.actuate.metrics.doppler.events.Uuid.internal_static_events_UUID_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.springframework.boot.actuate.metrics.doppler.events.Uuid.internal_static_events_UUID_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID.class, org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID.Builder.class);
    }

    public static com.google.protobuf.Parser<UUID> PARSER =
        new com.google.protobuf.AbstractParser<UUID>() {
      public UUID parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new UUID(input, extensionRegistry);
      }
    };

    @Override
    public com.google.protobuf.Parser<UUID> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int LOW_FIELD_NUMBER = 1;
    private long low_;
    /**
     * <code>required uint64 low = 1;</code>
     */
    public boolean hasLow() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required uint64 low = 1;</code>
     */
    public long getLow() {
      return low_;
    }

    public static final int HIGH_FIELD_NUMBER = 2;
    private long high_;
    /**
     * <code>required uint64 high = 2;</code>
     */
    public boolean hasHigh() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required uint64 high = 2;</code>
     */
    public long getHigh() {
      return high_;
    }

    private void initFields() {
      low_ = 0L;
      high_ = 0L;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasLow()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasHigh()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeUInt64(1, low_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeUInt64(2, high_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(1, low_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(2, high_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    protected Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code events.UUID}
     *
     * <pre>
     *&#47; Type representing a 128-bit UUID.
     * </pre>
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:events.UUID)
        org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUIDOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.springframework.boot.actuate.metrics.doppler.events.Uuid.internal_static_events_UUID_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.springframework.boot.actuate.metrics.doppler.events.Uuid.internal_static_events_UUID_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID.class, org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID.Builder.class);
      }

      // Construct using events.Uuid.UUID.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        low_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        high_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.springframework.boot.actuate.metrics.doppler.events.Uuid.internal_static_events_UUID_descriptor;
      }

      public org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID getDefaultInstanceForType() {
        return org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID.getDefaultInstance();
      }

      public org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID build() {
        org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID buildPartial() {
        org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID result = new org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.low_ = low_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.high_ = high_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID) {
          return mergeFrom((org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID other) {
        if (other == org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID.getDefaultInstance()) return this;
        if (other.hasLow()) {
          setLow(other.getLow());
        }
        if (other.hasHigh()) {
          setHigh(other.getHigh());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasLow()) {

          return false;
        }
        if (!hasHigh()) {

          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (org.springframework.boot.actuate.metrics.doppler.events.Uuid.UUID) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private long low_ ;
      /**
       * <code>required uint64 low = 1;</code>
       */
      public boolean hasLow() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required uint64 low = 1;</code>
       */
      public long getLow() {
        return low_;
      }
      /**
       * <code>required uint64 low = 1;</code>
       */
      public Builder setLow(long value) {
        bitField0_ |= 0x00000001;
        low_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint64 low = 1;</code>
       */
      public Builder clearLow() {
        bitField0_ = (bitField0_ & ~0x00000001);
        low_ = 0L;
        onChanged();
        return this;
      }

      private long high_ ;
      /**
       * <code>required uint64 high = 2;</code>
       */
      public boolean hasHigh() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required uint64 high = 2;</code>
       */
      public long getHigh() {
        return high_;
      }
      /**
       * <code>required uint64 high = 2;</code>
       */
      public Builder setHigh(long value) {
        bitField0_ |= 0x00000002;
        high_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint64 high = 2;</code>
       */
      public Builder clearHigh() {
        bitField0_ = (bitField0_ & ~0x00000002);
        high_ = 0L;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:events.UUID)
    }

    static {
      defaultInstance = new UUID(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:events.UUID)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_events_UUID_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_events_UUID_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\nuuid.proto\022\006events\"!\n\004UUID\022\013\n\003low\030\001 \002(" +
      "\004\022\014\n\004high\030\002 \002(\004"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_events_UUID_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_events_UUID_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_events_UUID_descriptor,
        new String[] { "Low", "High", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}