package com.tablet.service;

import com.tablet.model.Patient;
import com.tablet.model.Transaction;
import com.tablet.util.Audit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.tablet.DAO.PatientDao;
import com.tablet.DAO.ProductDao;
import com.tablet.DAO.TransactionDao;
import com.tablet.exception.StateException;
import com.tablet.model.Product;

import org.springframework.beans.factory.annotation.Autowired;

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
	@Audit(action = "SALE")
	public void addTransaction(Transaction transaction) throws Exception {
		Patient patient = patientDao.findById(transaction.getPatientId());
		Product product = productDao.findById(transaction.getProductId());
		if (patient.getStateId() == product.getStateId()){
			transactionDao.addTransaction(transaction);
		} else
			throw new StateException("THE PRODUCT IS NOT FOR SALE IN THIS STATE");
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


	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Delete transaction")
	public void deleteTransaction(Transaction transaction) {
		transactionDao.deleteTransaction(transaction);
	}
}
