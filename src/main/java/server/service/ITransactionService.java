package server.service;

import server.model.Transaction;
import java.util.List;

public interface ITransactionService {

    void addTransaction(Transaction transaction)throws Exception ;
    Transaction findById(int transactionId);
    List findAllTransactions();
    void deleteTransaction(Transaction transaction);
}
