package com.betPawa.implementation;


import com.betPawa.WalletBusinessException;
import com.betPawa.entity.UserEURWallet;
import com.betPawa.entity.UserGBPWallet;
import com.betPawa.entity.UserUSDWallet;
import com.betPawa.util.HibernateUtil;
import com.betPawa.service.TransactionService;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {


  public void deposit(String userId, double amount, String currency){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            if ("USD".equals(currency)) {
                UserUSDWallet userUSDWallet = (UserUSDWallet)session.get(UserUSDWallet.class, userId);
                if (userUSDWallet != null && userId.equals(userUSDWallet.getUserID())){
                    userUSDWallet.setAmount(userUSDWallet.getAmount() + amount);
                    session.update(userUSDWallet);
                } else {
                    userUSDWallet = new UserUSDWallet(userId, amount);
                    session.save(userUSDWallet);
                }
            } else if ("EUR".equals(currency)) {
                UserEURWallet userEURWallet = (UserEURWallet)session.get(UserEURWallet.class, userId);
                if (userEURWallet != null && userId.equals(userEURWallet.getUserID())){
                    userEURWallet.setAmount(userEURWallet.getAmount() + amount);
                    session.update(userEURWallet);
                } else {
                    userEURWallet = new UserEURWallet(userId, amount);
                    session.save(userEURWallet);
                }
            } else {
                UserGBPWallet userGBPWallet = (UserGBPWallet)session.get(UserGBPWallet.class, userId);
                if (userGBPWallet != null && userId.equals(userGBPWallet.getUserID())){
                    userGBPWallet.setAmount(userGBPWallet.getAmount() + amount);
                    session.update(userGBPWallet);
                } else {
                    userGBPWallet = new UserGBPWallet(userId, amount);
                    session.save(userGBPWallet);
                }
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }



     public void withdraw(String userId, double amount, String currency) throws WalletBusinessException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
         Query query = null;
         try {
            transaction = session.beginTransaction();
            if ("USD".equals(currency)) {
                 query  = session.createQuery(" from UserUSDWallet where userID = :userID");
                 query.setParameter("userID", userId);
                List<UserUSDWallet> userUSDWalletList = query.list();
                if (userUSDWalletList.isEmpty()) {
                    throw new WalletBusinessException("insufficient funds");
                }
                UserUSDWallet userUSDWallet =  userUSDWalletList.get(0);

                if (checkBalance (userUSDWallet.getAmount(), amount)){
                    userUSDWallet.setAmount(userUSDWallet.getAmount() - amount);
                    session.update(userUSDWallet);
                }else {
                    throw new WalletBusinessException("insufficient funds");
                }

            } else if ("EUR".equals(currency)) {
                 query  = session.createQuery(" from UserEURWallet where userID = :userID");
                query.setParameter("userID", userId);
                List<UserEURWallet> userEURWalletList = query.list();
                if (userEURWalletList.isEmpty()) {
                    throw new WalletBusinessException("insufficient funds");
                }
                UserEURWallet userEURWallet =  userEURWalletList.get(0);

                if (checkBalance (userEURWallet.getAmount(), amount)){
                    userEURWallet.setAmount(userEURWallet.getAmount() - amount);
                    session.update(userEURWallet);
                }else {
                    throw new WalletBusinessException("insufficient funds");
                }
            } else {
                 query  = session.createQuery(" from UserGBPWallet where userID = :userID");
                query.setParameter("userID", userId);
                List<UserGBPWallet> userGBPWalletList = query.list();
                if (userGBPWalletList.isEmpty()) {
                    throw new WalletBusinessException("insufficient funds");
                }
                UserGBPWallet userGBPWallet =  userGBPWalletList.get(0);

                if (checkBalance (userGBPWallet.getAmount(), amount)){
                    userGBPWallet.setAmount(userGBPWallet.getAmount() - amount);
                    session.update(userGBPWallet);
                }else {
                    throw new WalletBusinessException("insufficient funds");
                }
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private boolean checkBalance(double avaiableAmount, double withDrawamount) {
        if(avaiableAmount >= withDrawamount ) {
            return true;
        }
        return false;
    }

    @Override
    public String getBalance(String userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Query query = null;
        StringBuffer amount = new StringBuffer();
        try {
            transaction = session.beginTransaction();

                query  = session.createQuery(" from UserUSDWallet where userID = :userID");
            query.setParameter("userID", userId);
                List userUSDWalletList = query.list();
                if (userUSDWalletList.isEmpty()) {
                    amount.append("USD").append("  ");
                } else {
                    UserUSDWallet userUSDWallet = (UserUSDWallet) userUSDWalletList.get(0);
                    amount.append("USD").append(userUSDWallet.getAmount());
                }



                System.out.print(amount.toString());
                query  = session.createQuery(" from UserEURWallet where userID = :userID");
                query.setParameter("userID", userId);
                List userEURWalletList = query.list();

                if (userEURWalletList.isEmpty()) {
                    amount.append("EUR").append("  ");
                } else {
                    UserEURWallet userEURWallet = (UserEURWallet)userEURWalletList.get(0);
                    amount.append("EUR").append(userEURWallet.getAmount());
                }

                query  = session.createQuery(" from  UserGBPWallet where userID = :userID");
                query.setParameter("userID", userId);
                List userGBPWalletList = query.list();
                if (userGBPWalletList.isEmpty()) {
                    amount.append("GBP").append("  ");
                } else {
                    UserGBPWallet userGBPWallet =  (UserGBPWallet)userGBPWalletList.get(0);
                    amount.append("GBP").append(userGBPWallet.getAmount());
                }

            session.getTransaction().commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return amount.toString();
    }
}
