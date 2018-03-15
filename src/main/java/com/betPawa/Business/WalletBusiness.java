package com.betPawa.Business;

import com.betPawa.WalletBusinessException;
import com.betPawa.implementation.TransactionServiceImpl;
import com.betPawa.service.TransactionService;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class WalletBusiness {
    private static final TransactionService transactionService = new TransactionServiceImpl();
    private static final Logger logger = Logger.getLogger(WalletBusiness.class.getName());
    private static final List<String> currencyList = Arrays.asList("EUR", "USD", "GBP");

    /**
     *
     * @param request
     * @throws WalletBusinessException
     */
    public void deposit(com.betPawa.DepositRequest request) throws WalletBusinessException {
        String userId = null;
        String amount = null;
        String currency = null;


        if (request == null) {
            logger.info("REQUEST IS NULL");
            throw new WalletBusinessException("REQUEST IS NULL");
        } else {
            //validate request values
            userId = request.getUserId();
            amount = request.getAmount();
            currency = request.getCurrency();
            if (userId != null && amount != null && currency != null) {
                if (currencyList.contains(currency)) {
                    transactionService.deposit(userId, Double.parseDouble(amount), currency);
                } else {
                    logger.info("Unknown currency");
                    throw new WalletBusinessException("Unknown currency");
                }
            }
        }

    }

    /**
     *
     * @param request
     * @throws WalletBusinessException
     */
    public void withdraw(com.betPawa.WithdrawRequest request) throws WalletBusinessException {
        String userId = null;
        String amount = null;
        String currency = null;

        if (request == null) {
            logger.info("REQUEST IS NULL");
            throw new WalletBusinessException("REQUEST IS NULL");
        } else {
            //validate request values
            userId = request.getUserId();
            amount = request.getAmount();
            currency = request.getCurrency();
            if (userId != null && amount != null && currency != null) {
                if (currencyList.contains(currency)) {
                    transactionService.withdraw(userId, Double.parseDouble(amount), currency);
                } else {
                    logger.info("Unknown currency");
                    throw new WalletBusinessException("Unknown currency");
                }
            }
        }

    }

    /**
     *
     * @param balanceRequest
     * @return
     */
    public String getBalance(com.betPawa.BalanceRequest balanceRequest){
        String userId = null;
        //validate request values
            userId = balanceRequest.getUserId();
            if (userId != null) {
                   return transactionService.getBalance(userId);

            }
            return "";

    }

}
