package com.betPawa;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;


public class WalletClient {
    private static final Logger logger = Logger.getLogger(WalletClient.class);

    private final ManagedChannel channel;
    private final WalletGrpc.WalletBlockingStub blockingStub;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public WalletClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext(true)
                .build());
    }

    /** Construct client for accessing RouteGuide server using the existing channel. */
    WalletClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = WalletGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public void desposit(String userId, String amount, String currency) {
        DepositRequest depositRequest = DepositRequest.newBuilder().setUserId(userId).setAmount(amount).setCurrency(currency).build();

        try {

            com.google.protobuf.Empty empty = blockingStub.deposit(depositRequest);
        } catch (StatusRuntimeException e) {
            logger.warn("RPC failed: "+ e.getStatus());
            return;
        }
    }

    public void withdraw(String userId, String amount, String currency) {
        WithdrawRequest withdrawRequest = WithdrawRequest.newBuilder().setUserId(userId).setAmount(amount).setCurrency(currency).build();


        try {
            com.google.protobuf.Empty Empty = blockingStub.withdraw(withdrawRequest);
        } catch (StatusRuntimeException e) {
            logger.warn("RPC failed: "+ e.getStatus());
            return;
        }
        logger.info("Withdraw : Success");
    }

    public void getBalance(String userId) {
        BalanceRequest balanceRequest = BalanceRequest.newBuilder().setUserId(userId).build();

        BalanceResponse balanceResponse = null;
        try {
            balanceResponse = blockingStub.getBalance(balanceRequest);

        } catch (StatusRuntimeException e) {
            logger.warn("RPC failed: "+ e.getStatus());
            return;
        }
        logger.info(balanceResponse.getMessage());
    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static void main(String[] args) throws Exception {
        WalletClient client = new WalletClient("localhost", 50051);
        try {
            /* Access a service running on the local machine on port 50051 */
            String user = "world";
            if (args.length > 0) {
                user = args[0]; /* Use the arg as the name to greet if provided */
            }
            /*Make a withdrawal of USD 200 for user with id 1. Must return "insufficient_funds".
                    Make a deposit of USD 100 to user with id 1.
            Check that all balances are correct
            Make a withdrawal of USD 200 for user with id 1. Must return "insufficient_funds".
                    Make a deposit of EUR 100 to user with id 1.
            Check that all balances are correct
            Make a withdrawal of USD 200 for user with id 1. Must return "insufficient_funds".
                    Make a deposit of USD 100 to user with id 1.
            Check that all balances are correct
            Make a withdrawal of USD 200 for user with id 1. Must return "ok".
                    Check that all balances are correct
            Make a withdrawal of USD 200 for user with id 1. Must return "insufficient_funds".*/

            client.withdraw("1", "200", "USD");
            client.desposit("1", "100", "USD");
            client.getBalance("1");
            client.withdraw("1", "200", "USD");
            client.desposit("1", "100", "EUR");
            client.getBalance("1");
            client.withdraw("1", "200", "USD");
            client.desposit("1", "100", "USD");
            client.getBalance("1");
            client.withdraw("1", "200", "USD");
            client.getBalance("1");
            client.withdraw("1", "200", "USD");
           //client.withdraw();

            logger.info("**********************************************");
            client.withdraw("2", "100", "GBP");
            client.desposit("2", "300", "GBP");
            client.withdraw("2", "100", "GBP");
            client.withdraw("2", "100", "GBP");
            client.withdraw("2", "100", "GBP");

            logger.info("**********************************************");

            client.getBalance("3");
            client.desposit("3", "100", "USD");
            client.desposit("3", "100", "USD");
            client.withdraw("3", "100", "USD");
            client.desposit("3", "100", "USD");
            client.getBalance("3");
            client.withdraw("3", "200", "USD");
            client.getBalance("3");

        } finally {
            client.shutdown();
        }
    }
}