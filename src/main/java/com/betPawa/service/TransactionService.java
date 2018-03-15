package com.betPawa.service;

import com.betPawa.WalletBusinessException;

/**
 *
 */
public interface TransactionService {

    public void deposit(String userId, double amount, String currency);
    public void withdraw(String userId, double amount, String currency) throws WalletBusinessException;
    public String getBalance(String userId);
}
