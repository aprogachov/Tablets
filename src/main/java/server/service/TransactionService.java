package server.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import server.DAO.DAOtransactionImpl;
import server.DAO.PatientDao;
import server.DAO.ProductDao;
import server.DAO.TransactionDao;
import server.exception.StateException;
import server.mapper.TransactionMapper;
import server.model.Patient;
import server.model.Product;
import server.model.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import server.util.Audit;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements ITransactionService  {

	@Autowired
	private TransactionDao transactionDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Sale")
	public void addTransaction(Transaction transaction) throws Exception {
		Patient patient = patientDao.findById(transaction.getPatientId());
		Product product = productDao.findById(transaction.getProductId());
		if (patient.getStateId() == product.getStateId()){
			transactionDao.addTransaction(transaction);
		} else
			throw new StateException("The product is not for sale in this state");
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "FindById transaction")
	public Transaction findById(int transactionId) {
		Transaction dbtransaction = transactionDao.findById(transactionId);
		return dbtransaction;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Find all transactions")
	public List<Transaction> findAllTransactions() {
		List<Transaction> transactions = transactionDao.findAllTransactions();
		return transactions;
	}

//	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	public void updateTransaction(Transaction transaction) {
//		transactionDao.updateTransaction(transaction);
//	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Delete transaction")
	public void deleteTransaction(Transaction transaction) {
		transactionDao.deleteTransaction(transaction);
	}
}
