package server.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import server.DAO.DAOtransactionImpl;
import server.DAO.TransactionDao;
import server.mapper.TransactionMapper;
import server.model.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addTransaction(Transaction transaction) {
		transactionDao.addTransaction(transaction);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Transaction findById(int transactionId) {
		Transaction dbtransaction = transactionDao.findById(transactionId);
		return dbtransaction;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Transaction> findAllTransactions() {
		List<Transaction> transactions = transactionDao.findAllTransactions();
		return transactions;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateTransaction(Transaction transaction) {
		transactionDao.updateTransaction(transaction);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteTransaction(Transaction transaction) {
		transactionDao.deleteTransaction(transaction);
	}
}
