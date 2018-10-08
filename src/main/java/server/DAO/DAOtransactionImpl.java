package server.DAO;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import server.mapper.TransactionMapper;
import server.model.Transaction;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.lang.*;

@Component
public class DAOtransactionImpl implements TransactionDao {

	private JdbcTemplate jdbcTemplate;
	public DataSource ds;

	@Autowired
	public DAOtransactionImpl(JdbcTemplate jdbcTemplate, DataSource ds) {
		this.jdbcTemplate = jdbcTemplate;
		this.ds = ds;
	}

	@Override
	public void addTransaction(Transaction transaction) {
		try {
			String sql = "INSERT INTO transactions(PATIENTID, PRODUCTID, DATE_TRANSACTION) VALUES (?,?,?)";
			jdbcTemplate.update(sql, transaction.getPatientId(), transaction.getProductId(), transaction.getDateTransaction());
		} catch (Exception e) {
			e.printStackTrace();
		}

//		try {
//			String sql = "INSERT INTO transactions (PATIENTID, PRODUCTID, DATE_TRANSACTION) VALUES (?, ?, ?)";
//			GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
//			jdbcTemplate.update(connection -> {
//				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//				ps.setInt(1, transaction.getPatientId());
//				ps.setInt(2, transaction.getProductId());
//				ps.setDate(3, transaction.getDateTransaction());
//				return ps;
//			}, generatedKeyHolder);
//			transaction.setId(generatedKeyHolder.getKey().intValue());
//		} catch (Exception e){
//			e.printStackTrace();
//		}

	}

	@Override
	public Transaction findById(int transactionId) {
		String sql = "SELECT * FROM transactions WHERE TRANSACTION_ID = ?";
		Transaction transaction = jdbcTemplate.queryForObject(sql, new Object[] { transactionId }, new TransactionMapper());
		return transaction;
	}

	@Override
	public List findAllTransactions() {
			String sql = "SELECT * FROM transactions";
			List transactions = jdbcTemplate.query(sql, new TransactionMapper());
		return transactions;
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		try {
			String sql = "UPDATE transactions SET PATIENTID=?, PRODUCTID=?, DATE_TRANSACTION=? WHERE TRANSACTION_ID=?";
			jdbcTemplate.update(sql, transaction.getPatientId(), transaction.getProductId(), transaction.getDateTransaction(), transaction.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTransaction(Transaction transaction) {
		try {
			String sql = "DELETE FROM transactions WHERE TRANSACTION_ID=?";
			jdbcTemplate.update(sql, transaction.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
