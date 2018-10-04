package server.DAO;

import server.model.Transaction;
import java.util.List;

public interface TransactionDao {

    void addTransaction(Transaction transaction);
    Transaction findById(int transactionId);
    List findAllTransactions();
    void updateTransaction(Transaction transaction);
    void deleteTransaction(Transaction transaction);
}
