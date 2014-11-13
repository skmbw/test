// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SearchRequest.proto

package com.vteba.protobuf;

/**
 * 
 * @author 2.6.1的编译器产生的文件
 * @see
 * @since
 */
public final class FirstProtobuf {
  private FirstProtobuf() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface SearchRequestOrBuilder extends
      // @@protoc_insertion_point(interface_extends:protobuf.SearchRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string query = 1;</code>
     */
    boolean hasQuery();
    /**
     * <code>required string query = 1;</code>
     */
    java.lang.String getQuery();
    /**
     * <code>required string query = 1;</code>
     */
    com.google.protobuf.ByteString
        getQueryBytes();

    /**
     * <code>optional int32 page_number = 2;</code>
     */
    boolean hasPageNumber();
    /**
     * <code>optional int32 page_number = 2;</code>
     */
    int getPageNumber();

    /**
     * <code>optional int32 result_per_page = 3;</code>
     */
    boolean hasResultPerPage();
    /**
     * <code>optional int32 result_per_page = 3;</code>
     */
    int getResultPerPage();

    /**
     * <code>repeated int32 samples = 4 [packed = true];</code>
     */
    java.util.List<java.lang.Integer> getSamplesList();
    /**
     * <code>repeated int32 samples = 4 [packed = true];</code>
     */
    int getSamplesCount();
    /**
     * <code>repeated int32 samples = 4 [packed = true];</code>
     */
    int getSamples(int index);
  }
  /**
   * Protobuf type {@code protobuf.SearchRequest}
   */
  public static final class SearchRequest extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:protobuf.SearchRequest)
      SearchRequestOrBuilder {
    // Use SearchRequest.newBuilder() to construct.
    private SearchRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private SearchRequest(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final SearchRequest defaultInstance;
    public static SearchRequest getDefaultInstance() {
      return defaultInstance;
    }

    public SearchRequest getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private SearchRequest(
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
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              query_ = bs;
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              pageNumber_ = input.readInt32();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              resultPerPage_ = input.readInt32();
              break;
            }
            case 32: {
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                samples_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000008;
              }
              samples_.add(input.readInt32());
              break;
            }
            case 34: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008) && input.getBytesUntilLimit() > 0) {
                samples_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000008;
              }
              while (input.getBytesUntilLimit() > 0) {
                samples_.add(input.readInt32());
              }
              input.popLimit(limit);
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
        if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
          samples_ = java.util.Collections.unmodifiableList(samples_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.vteba.protobuf.FirstProtobuf.internal_static_protobuf_SearchRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.vteba.protobuf.FirstProtobuf.internal_static_protobuf_SearchRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.vteba.protobuf.FirstProtobuf.SearchRequest.class, com.vteba.protobuf.FirstProtobuf.SearchRequest.Builder.class);
    }

    public static com.google.protobuf.Parser<SearchRequest> PARSER =
        new com.google.protobuf.AbstractParser<SearchRequest>() {
      public SearchRequest parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new SearchRequest(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<SearchRequest> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int QUERY_FIELD_NUMBER = 1;
    private java.lang.Object query_;
    /**
     * <code>required string query = 1;</code>
     */
    public boolean hasQuery() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string query = 1;</code>
     */
    public java.lang.String getQuery() {
      java.lang.Object ref = query_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          query_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string query = 1;</code>
     */
    public com.google.protobuf.ByteString
        getQueryBytes() {
      java.lang.Object ref = query_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        query_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PAGE_NUMBER_FIELD_NUMBER = 2;
    private int pageNumber_;
    /**
     * <code>optional int32 page_number = 2;</code>
     */
    public boolean hasPageNumber() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 page_number = 2;</code>
     */
    public int getPageNumber() {
      return pageNumber_;
    }

    public static final int RESULT_PER_PAGE_FIELD_NUMBER = 3;
    private int resultPerPage_;
    /**
     * <code>optional int32 result_per_page = 3;</code>
     */
    public boolean hasResultPerPage() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 result_per_page = 3;</code>
     */
    public int getResultPerPage() {
      return resultPerPage_;
    }

    public static final int SAMPLES_FIELD_NUMBER = 4;
    private java.util.List<java.lang.Integer> samples_;
    /**
     * <code>repeated int32 samples = 4 [packed = true];</code>
     */
    public java.util.List<java.lang.Integer>
        getSamplesList() {
      return samples_;
    }
    /**
     * <code>repeated int32 samples = 4 [packed = true];</code>
     */
    public int getSamplesCount() {
      return samples_.size();
    }
    /**
     * <code>repeated int32 samples = 4 [packed = true];</code>
     */
    public int getSamples(int index) {
      return samples_.get(index);
    }
    private int samplesMemoizedSerializedSize = -1;

    private void initFields() {
      query_ = "";
      pageNumber_ = 0;
      resultPerPage_ = 0;
      samples_ = java.util.Collections.emptyList();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasQuery()) {
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
        output.writeBytes(1, getQueryBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, pageNumber_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt32(3, resultPerPage_);
      }
      if (getSamplesList().size() > 0) {
        output.writeRawVarint32(34);
        output.writeRawVarint32(samplesMemoizedSerializedSize);
      }
      for (int i = 0; i < samples_.size(); i++) {
        output.writeInt32NoTag(samples_.get(i));
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
          .computeBytesSize(1, getQueryBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, pageNumber_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, resultPerPage_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < samples_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(samples_.get(i));
        }
        size += dataSize;
        if (!getSamplesList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        samplesMemoizedSerializedSize = dataSize;
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.vteba.protobuf.FirstProtobuf.SearchRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.vteba.protobuf.FirstProtobuf.SearchRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.vteba.protobuf.FirstProtobuf.SearchRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.vteba.protobuf.FirstProtobuf.SearchRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.vteba.protobuf.FirstProtobuf.SearchRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.vteba.protobuf.FirstProtobuf.SearchRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.vteba.protobuf.FirstProtobuf.SearchRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.vteba.protobuf.FirstProtobuf.SearchRequest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.vteba.protobuf.FirstProtobuf.SearchRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.vteba.protobuf.FirstProtobuf.SearchRequest parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.vteba.protobuf.FirstProtobuf.SearchRequest prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code protobuf.SearchRequest}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:protobuf.SearchRequest)
        com.vteba.protobuf.FirstProtobuf.SearchRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.vteba.protobuf.FirstProtobuf.internal_static_protobuf_SearchRequest_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.vteba.protobuf.FirstProtobuf.internal_static_protobuf_SearchRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.vteba.protobuf.FirstProtobuf.SearchRequest.class, com.vteba.protobuf.FirstProtobuf.SearchRequest.Builder.class);
      }

      // Construct using com.vteba.protobuf.FirstProtobuf.SearchRequest.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
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
        query_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        pageNumber_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        resultPerPage_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        samples_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.vteba.protobuf.FirstProtobuf.internal_static_protobuf_SearchRequest_descriptor;
      }

      public com.vteba.protobuf.FirstProtobuf.SearchRequest getDefaultInstanceForType() {
        return com.vteba.protobuf.FirstProtobuf.SearchRequest.getDefaultInstance();
      }

      public com.vteba.protobuf.FirstProtobuf.SearchRequest build() {
        com.vteba.protobuf.FirstProtobuf.SearchRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.vteba.protobuf.FirstProtobuf.SearchRequest buildPartial() {
        com.vteba.protobuf.FirstProtobuf.SearchRequest result = new com.vteba.protobuf.FirstProtobuf.SearchRequest(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.query_ = query_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.pageNumber_ = pageNumber_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.resultPerPage_ = resultPerPage_;
        if (((bitField0_ & 0x00000008) == 0x00000008)) {
          samples_ = java.util.Collections.unmodifiableList(samples_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.samples_ = samples_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.vteba.protobuf.FirstProtobuf.SearchRequest) {
          return mergeFrom((com.vteba.protobuf.FirstProtobuf.SearchRequest)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.vteba.protobuf.FirstProtobuf.SearchRequest other) {
        if (other == com.vteba.protobuf.FirstProtobuf.SearchRequest.getDefaultInstance()) return this;
        if (other.hasQuery()) {
          bitField0_ |= 0x00000001;
          query_ = other.query_;
          onChanged();
        }
        if (other.hasPageNumber()) {
          setPageNumber(other.getPageNumber());
        }
        if (other.hasResultPerPage()) {
          setResultPerPage(other.getResultPerPage());
        }
        if (!other.samples_.isEmpty()) {
          if (samples_.isEmpty()) {
            samples_ = other.samples_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensureSamplesIsMutable();
            samples_.addAll(other.samples_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasQuery()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.vteba.protobuf.FirstProtobuf.SearchRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.vteba.protobuf.FirstProtobuf.SearchRequest) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object query_ = "";
      /**
       * <code>required string query = 1;</code>
       */
      public boolean hasQuery() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string query = 1;</code>
       */
      public java.lang.String getQuery() {
        java.lang.Object ref = query_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            query_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string query = 1;</code>
       */
      public com.google.protobuf.ByteString
          getQueryBytes() {
        java.lang.Object ref = query_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          query_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string query = 1;</code>
       */
      public Builder setQuery(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        query_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string query = 1;</code>
       */
      public Builder clearQuery() {
        bitField0_ = (bitField0_ & ~0x00000001);
        query_ = getDefaultInstance().getQuery();
        onChanged();
        return this;
      }
      /**
       * <code>required string query = 1;</code>
       */
      public Builder setQueryBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        query_ = value;
        onChanged();
        return this;
      }

      private int pageNumber_ ;
      /**
       * <code>optional int32 page_number = 2;</code>
       */
      public boolean hasPageNumber() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional int32 page_number = 2;</code>
       */
      public int getPageNumber() {
        return pageNumber_;
      }
      /**
       * <code>optional int32 page_number = 2;</code>
       */
      public Builder setPageNumber(int value) {
        bitField0_ |= 0x00000002;
        pageNumber_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 page_number = 2;</code>
       */
      public Builder clearPageNumber() {
        bitField0_ = (bitField0_ & ~0x00000002);
        pageNumber_ = 0;
        onChanged();
        return this;
      }

      private int resultPerPage_ ;
      /**
       * <code>optional int32 result_per_page = 3;</code>
       */
      public boolean hasResultPerPage() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional int32 result_per_page = 3;</code>
       */
      public int getResultPerPage() {
        return resultPerPage_;
      }
      /**
       * <code>optional int32 result_per_page = 3;</code>
       */
      public Builder setResultPerPage(int value) {
        bitField0_ |= 0x00000004;
        resultPerPage_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 result_per_page = 3;</code>
       */
      public Builder clearResultPerPage() {
        bitField0_ = (bitField0_ & ~0x00000004);
        resultPerPage_ = 0;
        onChanged();
        return this;
      }

      private java.util.List<java.lang.Integer> samples_ = java.util.Collections.emptyList();
      private void ensureSamplesIsMutable() {
        if (!((bitField0_ & 0x00000008) == 0x00000008)) {
          samples_ = new java.util.ArrayList<java.lang.Integer>(samples_);
          bitField0_ |= 0x00000008;
         }
      }
      /**
       * <code>repeated int32 samples = 4 [packed = true];</code>
       */
      public java.util.List<java.lang.Integer>
          getSamplesList() {
        return java.util.Collections.unmodifiableList(samples_);
      }
      /**
       * <code>repeated int32 samples = 4 [packed = true];</code>
       */
      public int getSamplesCount() {
        return samples_.size();
      }
      /**
       * <code>repeated int32 samples = 4 [packed = true];</code>
       */
      public int getSamples(int index) {
        return samples_.get(index);
      }
      /**
       * <code>repeated int32 samples = 4 [packed = true];</code>
       */
      public Builder setSamples(
          int index, int value) {
        ensureSamplesIsMutable();
        samples_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 samples = 4 [packed = true];</code>
       */
      public Builder addSamples(int value) {
        ensureSamplesIsMutable();
        samples_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 samples = 4 [packed = true];</code>
       */
      public Builder addAllSamples(
          java.lang.Iterable<? extends java.lang.Integer> values) {
        ensureSamplesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, samples_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 samples = 4 [packed = true];</code>
       */
      public Builder clearSamples() {
        samples_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:protobuf.SearchRequest)
    }

    static {
      defaultInstance = new SearchRequest(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:protobuf.SearchRequest)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protobuf_SearchRequest_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_protobuf_SearchRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023SearchRequest.proto\022\010protobuf\"a\n\rSearc" +
      "hRequest\022\r\n\005query\030\001 \002(\t\022\023\n\013page_number\030\002" +
      " \001(\005\022\027\n\017result_per_page\030\003 \001(\005\022\023\n\007samples" +
      "\030\004 \003(\005B\002\020\001B#\n\022com.vteba.protobufB\rFirstP" +
      "rotobuf"
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
    internal_static_protobuf_SearchRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_protobuf_SearchRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_protobuf_SearchRequest_descriptor,
        new java.lang.String[] { "Query", "PageNumber", "ResultPerPage", "Samples", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
