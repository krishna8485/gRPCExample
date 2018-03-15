package com.betPawa;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: walletServer.proto")
public final class WalletGrpc {

  private WalletGrpc() {}

  public static final String SERVICE_NAME = "walletServer.Wallet";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDepositMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.betPawa.DepositRequest,
      com.google.protobuf.Empty> METHOD_DEPOSIT = getDepositMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.betPawa.DepositRequest,
      com.google.protobuf.Empty> getDepositMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.betPawa.DepositRequest,
      com.google.protobuf.Empty> getDepositMethod() {
    return getDepositMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.betPawa.DepositRequest,
      com.google.protobuf.Empty> getDepositMethodHelper() {
    io.grpc.MethodDescriptor<com.betPawa.DepositRequest, com.google.protobuf.Empty> getDepositMethod;
    if ((getDepositMethod = WalletGrpc.getDepositMethod) == null) {
      synchronized (WalletGrpc.class) {
        if ((getDepositMethod = WalletGrpc.getDepositMethod) == null) {
          WalletGrpc.getDepositMethod = getDepositMethod = 
              io.grpc.MethodDescriptor.<com.betPawa.DepositRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "walletServer.Wallet", "deposit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.betPawa.DepositRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletMethodDescriptorSupplier("deposit"))
                  .build();
          }
        }
     }
     return getDepositMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWithdrawMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.betPawa.WithdrawRequest,
      com.google.protobuf.Empty> METHOD_WITHDRAW = getWithdrawMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.betPawa.WithdrawRequest,
      com.google.protobuf.Empty> getWithdrawMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.betPawa.WithdrawRequest,
      com.google.protobuf.Empty> getWithdrawMethod() {
    return getWithdrawMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.betPawa.WithdrawRequest,
      com.google.protobuf.Empty> getWithdrawMethodHelper() {
    io.grpc.MethodDescriptor<com.betPawa.WithdrawRequest, com.google.protobuf.Empty> getWithdrawMethod;
    if ((getWithdrawMethod = WalletGrpc.getWithdrawMethod) == null) {
      synchronized (WalletGrpc.class) {
        if ((getWithdrawMethod = WalletGrpc.getWithdrawMethod) == null) {
          WalletGrpc.getWithdrawMethod = getWithdrawMethod = 
              io.grpc.MethodDescriptor.<com.betPawa.WithdrawRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "walletServer.Wallet", "withdraw"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.betPawa.WithdrawRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletMethodDescriptorSupplier("withdraw"))
                  .build();
          }
        }
     }
     return getWithdrawMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetBalanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.betPawa.BalanceRequest,
      com.betPawa.BalanceResponse> METHOD_GET_BALANCE = getGetBalanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.betPawa.BalanceRequest,
      com.betPawa.BalanceResponse> getGetBalanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.betPawa.BalanceRequest,
      com.betPawa.BalanceResponse> getGetBalanceMethod() {
    return getGetBalanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.betPawa.BalanceRequest,
      com.betPawa.BalanceResponse> getGetBalanceMethodHelper() {
    io.grpc.MethodDescriptor<com.betPawa.BalanceRequest, com.betPawa.BalanceResponse> getGetBalanceMethod;
    if ((getGetBalanceMethod = WalletGrpc.getGetBalanceMethod) == null) {
      synchronized (WalletGrpc.class) {
        if ((getGetBalanceMethod = WalletGrpc.getGetBalanceMethod) == null) {
          WalletGrpc.getGetBalanceMethod = getGetBalanceMethod = 
              io.grpc.MethodDescriptor.<com.betPawa.BalanceRequest, com.betPawa.BalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "walletServer.Wallet", "getBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.betPawa.BalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.betPawa.BalanceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletMethodDescriptorSupplier("getBalance"))
                  .build();
          }
        }
     }
     return getGetBalanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WalletStub newStub(io.grpc.Channel channel) {
    return new WalletStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WalletBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WalletBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WalletFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WalletFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class WalletImplBase implements io.grpc.BindableService {

    /**
     */
    public void deposit(com.betPawa.DepositRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDepositMethodHelper(), responseObserver);
    }

    /**
     */
    public void withdraw(com.betPawa.WithdrawRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getWithdrawMethodHelper(), responseObserver);
    }

    /**
     */
    public void getBalance(com.betPawa.BalanceRequest request,
        io.grpc.stub.StreamObserver<com.betPawa.BalanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBalanceMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDepositMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.betPawa.DepositRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DEPOSIT)))
          .addMethod(
            getWithdrawMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.betPawa.WithdrawRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_WITHDRAW)))
          .addMethod(
            getGetBalanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.betPawa.BalanceRequest,
                com.betPawa.BalanceResponse>(
                  this, METHODID_GET_BALANCE)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class WalletStub extends io.grpc.stub.AbstractStub<WalletStub> {
    private WalletStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WalletStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WalletStub(channel, callOptions);
    }

    /**
     */
    public void deposit(com.betPawa.DepositRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDepositMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void withdraw(com.betPawa.WithdrawRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWithdrawMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBalance(com.betPawa.BalanceRequest request,
        io.grpc.stub.StreamObserver<com.betPawa.BalanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBalanceMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class WalletBlockingStub extends io.grpc.stub.AbstractStub<WalletBlockingStub> {
    private WalletBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WalletBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WalletBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty deposit(com.betPawa.DepositRequest request) {
      return blockingUnaryCall(
          getChannel(), getDepositMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty withdraw(com.betPawa.WithdrawRequest request) {
      return blockingUnaryCall(
          getChannel(), getWithdrawMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.betPawa.BalanceResponse getBalance(com.betPawa.BalanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBalanceMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class WalletFutureStub extends io.grpc.stub.AbstractStub<WalletFutureStub> {
    private WalletFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WalletFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WalletFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deposit(
        com.betPawa.DepositRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDepositMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> withdraw(
        com.betPawa.WithdrawRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWithdrawMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.betPawa.BalanceResponse> getBalance(
        com.betPawa.BalanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBalanceMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DEPOSIT = 0;
  private static final int METHODID_WITHDRAW = 1;
  private static final int METHODID_GET_BALANCE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WalletImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WalletImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DEPOSIT:
          serviceImpl.deposit((com.betPawa.DepositRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_WITHDRAW:
          serviceImpl.withdraw((com.betPawa.WithdrawRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_BALANCE:
          serviceImpl.getBalance((com.betPawa.BalanceRequest) request,
              (io.grpc.stub.StreamObserver<com.betPawa.BalanceResponse>) responseObserver);
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

  private static abstract class WalletBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WalletBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.betPawa.walletServerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Wallet");
    }
  }

  private static final class WalletFileDescriptorSupplier
      extends WalletBaseDescriptorSupplier {
    WalletFileDescriptorSupplier() {}
  }

  private static final class WalletMethodDescriptorSupplier
      extends WalletBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WalletMethodDescriptorSupplier(String methodName) {
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
      synchronized (WalletGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WalletFileDescriptorSupplier())
              .addMethod(getDepositMethodHelper())
              .addMethod(getWithdrawMethodHelper())
              .addMethod(getGetBalanceMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
