package currencyconverter;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The CurrencyConverter service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: currency_converter.proto")
public final class CurrencyConverterGrpc {

  private CurrencyConverterGrpc() {}

  public static final String SERVICE_NAME = "currencyconverter.CurrencyConverter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<currencyconverter.CurrencyConverterOuterClass.ConversionRequest,
      currencyconverter.CurrencyConverterOuterClass.ConversionResult> getConvertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Convert",
      requestType = currencyconverter.CurrencyConverterOuterClass.ConversionRequest.class,
      responseType = currencyconverter.CurrencyConverterOuterClass.ConversionResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<currencyconverter.CurrencyConverterOuterClass.ConversionRequest,
      currencyconverter.CurrencyConverterOuterClass.ConversionResult> getConvertMethod() {
    io.grpc.MethodDescriptor<currencyconverter.CurrencyConverterOuterClass.ConversionRequest, currencyconverter.CurrencyConverterOuterClass.ConversionResult> getConvertMethod;
    if ((getConvertMethod = CurrencyConverterGrpc.getConvertMethod) == null) {
      synchronized (CurrencyConverterGrpc.class) {
        if ((getConvertMethod = CurrencyConverterGrpc.getConvertMethod) == null) {
          CurrencyConverterGrpc.getConvertMethod = getConvertMethod =
              io.grpc.MethodDescriptor.<currencyconverter.CurrencyConverterOuterClass.ConversionRequest, currencyconverter.CurrencyConverterOuterClass.ConversionResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Convert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  currencyconverter.CurrencyConverterOuterClass.ConversionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  currencyconverter.CurrencyConverterOuterClass.ConversionResult.getDefaultInstance()))
              .setSchemaDescriptor(new CurrencyConverterMethodDescriptorSupplier("Convert"))
              .build();
        }
      }
    }
    return getConvertMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CurrencyConverterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CurrencyConverterStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CurrencyConverterStub>() {
        @java.lang.Override
        public CurrencyConverterStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CurrencyConverterStub(channel, callOptions);
        }
      };
    return CurrencyConverterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CurrencyConverterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CurrencyConverterBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CurrencyConverterBlockingStub>() {
        @java.lang.Override
        public CurrencyConverterBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CurrencyConverterBlockingStub(channel, callOptions);
        }
      };
    return CurrencyConverterBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CurrencyConverterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CurrencyConverterFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CurrencyConverterFutureStub>() {
        @java.lang.Override
        public CurrencyConverterFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CurrencyConverterFutureStub(channel, callOptions);
        }
      };
    return CurrencyConverterFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The CurrencyConverter service definition.
   * </pre>
   */
  public static abstract class CurrencyConverterImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Converts an amount between two currencies.
     * </pre>
     */
    public void convert(currencyconverter.CurrencyConverterOuterClass.ConversionRequest request,
        io.grpc.stub.StreamObserver<currencyconverter.CurrencyConverterOuterClass.ConversionResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getConvertMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getConvertMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                currencyconverter.CurrencyConverterOuterClass.ConversionRequest,
                currencyconverter.CurrencyConverterOuterClass.ConversionResult>(
                  this, METHODID_CONVERT)))
          .build();
    }
  }

  /**
   * <pre>
   * The CurrencyConverter service definition.
   * </pre>
   */
  public static final class CurrencyConverterStub extends io.grpc.stub.AbstractAsyncStub<CurrencyConverterStub> {
    private CurrencyConverterStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyConverterStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CurrencyConverterStub(channel, callOptions);
    }

    /**
     * <pre>
     * Converts an amount between two currencies.
     * </pre>
     */
    public void convert(currencyconverter.CurrencyConverterOuterClass.ConversionRequest request,
        io.grpc.stub.StreamObserver<currencyconverter.CurrencyConverterOuterClass.ConversionResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getConvertMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The CurrencyConverter service definition.
   * </pre>
   */
  public static final class CurrencyConverterBlockingStub extends io.grpc.stub.AbstractBlockingStub<CurrencyConverterBlockingStub> {
    private CurrencyConverterBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyConverterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CurrencyConverterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Converts an amount between two currencies.
     * </pre>
     */
    public currencyconverter.CurrencyConverterOuterClass.ConversionResult convert(currencyconverter.CurrencyConverterOuterClass.ConversionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getConvertMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The CurrencyConverter service definition.
   * </pre>
   */
  public static final class CurrencyConverterFutureStub extends io.grpc.stub.AbstractFutureStub<CurrencyConverterFutureStub> {
    private CurrencyConverterFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyConverterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CurrencyConverterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Converts an amount between two currencies.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<currencyconverter.CurrencyConverterOuterClass.ConversionResult> convert(
        currencyconverter.CurrencyConverterOuterClass.ConversionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getConvertMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONVERT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CurrencyConverterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CurrencyConverterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONVERT:
          serviceImpl.convert((currencyconverter.CurrencyConverterOuterClass.ConversionRequest) request,
              (io.grpc.stub.StreamObserver<currencyconverter.CurrencyConverterOuterClass.ConversionResult>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CurrencyConverterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CurrencyConverterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return currencyconverter.CurrencyConverterOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CurrencyConverter");
    }
  }

  private static final class CurrencyConverterFileDescriptorSupplier
      extends CurrencyConverterBaseDescriptorSupplier {
    CurrencyConverterFileDescriptorSupplier() {}
  }

  private static final class CurrencyConverterMethodDescriptorSupplier
      extends CurrencyConverterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CurrencyConverterMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CurrencyConverterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CurrencyConverterFileDescriptorSupplier())
              .addMethod(getConvertMethod())
              .build();
        }
      }
    }
    return result;
  }
}
