package com.tablet.DAO;

import com.modelsale.model.Transaction;

import java.util.List;

public interface TransactionDao {

    void addTransaction(Transaction transaction);
    Transaction findById(int transactionId);
    List findAllTransactions();
    void deleteTransaction(Transaction transaction);
}
