package com.tablet.service;

import com.modelsale.model.Transaction;

import java.util.List;

public interface ITransactionService {

    void addTransaction(Transaction transaction)throws Exception ;
    Transaction findById(int transactionId);
    List findAllTransactions();
    void deleteTransaction(Transaction transaction);
}
