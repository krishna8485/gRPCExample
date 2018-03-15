 package com.betPawa;

import com.betPawa.Business.WalletBusiness;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.log4j.Logger;

import java.io.IOException;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

 public class WalletServer {
    private static final Logger logger = Logger.getLogger(WalletServer.class);

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new WalletImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                WalletServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final WalletServer server = new WalletServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class WalletImpl extends WalletGrpc.WalletImplBase {


        private WalletBusiness walletBusiness = new WalletBusiness();


        @Override
        public void deposit(com.betPawa.DepositRequest request,
                            io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
            try {
                walletBusiness.deposit(request);
                com.google.protobuf.Empty empty = com.google.protobuf.Empty.newBuilder().build();
                responseObserver.onNext(empty);
                responseObserver.onCompleted();
            } catch (WalletBusinessException e) {
                logger.info("Exception", e);
                responseObserver.onError(e);
            }
        }

        @Override
        public void withdraw(com.betPawa.WithdrawRequest request,
                             io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {

            try {
                walletBusiness.withdraw(request);
                // withdrawResponse = WithdrawResponse.newBuilder().setMessage("Withdraw ").build();
                com.google.protobuf.Empty empty = com.google.protobuf.Empty.newBuilder().build();
                responseObserver.onNext(empty);
                responseObserver.onCompleted();
            } catch (WalletBusinessException e) {
                logger.info("Exception", e);
                responseObserver.onError(e);

            }


        }

        @Override
        public void getBalance(com.betPawa.BalanceRequest request,
                               io.grpc.stub.StreamObserver<com.betPawa.BalanceResponse> responseObserver) {
            String message = null;
            BalanceResponse balanceResponse = null;
            message = walletBusiness.getBalance(request);
            balanceResponse = BalanceResponse.newBuilder().setMessage("Balance : " + message).build();
            responseObserver.onNext(balanceResponse);
            responseObserver.onCompleted();
        }
    }
 }
