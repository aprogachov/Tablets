package server.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import server.model.Transaction;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TransactionMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setId(rs.getInt("TRANSACTION_ID"));
        transaction.setPatientId(rs.getInt("PATIENTID"));
        transaction.setProductId(rs.getInt("PRODUCTID"));
        transaction.setDateTransaction(rs.getDate("DATE_TRANSACTION"));
        return transaction;
    }
}