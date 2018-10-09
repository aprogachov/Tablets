package server.DAO;

import org.springframework.stereotype.Component;
import server.mapper.AuditOperationMapper;
import server.model.AuditOperation;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.lang.*;

@Component
public class DAOauditOperationImpl implements AuditOperationDao {

	private JdbcTemplate jdbcTemplate;
	public DataSource ds;

	@Autowired
	public DAOauditOperationImpl(JdbcTemplate jdbcTemplate, DataSource ds) {
		this.jdbcTemplate = jdbcTemplate;
		this.ds = ds;
	}

	@Override
	public void addAuditOperation(AuditOperation auditOperation) {
		try {
			String sql = "INSERT INTO auditoperations(DATE_AUDIT, STATUS, ACTION) VALUES (?,?,?)";
			jdbcTemplate.update(sql, auditOperation.getDateAuditOperation(), auditOperation.getStatus(), auditOperation.getAction());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public AuditOperation findById(int auditOperationId) {
		String sql = "SELECT * FROM auditOperations WHERE AUDIT_ID = ?";
		AuditOperation auditOperation = jdbcTemplate.queryForObject(sql, new Object[] { auditOperationId }, new AuditOperationMapper());
		return auditOperation;
	}

	@Override
	public List findAllAuditOperations() {
		String sql = "SELECT * FROM auditOperations";
		List auditOperations = jdbcTemplate.query(sql, new AuditOperationMapper());
		return auditOperations;
	}


	@Override
	public void deleteAuditOperation(AuditOperation auditOperation) {
		try {
			String sql = "DELETE FROM auditoperations WHERE AUDIT_ID=?";
			jdbcTemplate.update(sql, auditOperation.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
