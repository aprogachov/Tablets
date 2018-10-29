package com.tablet.mapper;

import com.modelsale.model.AuditOperation;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AuditOperationMapper implements RowMapper<AuditOperation> {
    @Override
    public AuditOperation mapRow(ResultSet rs, int rowNum) throws SQLException {
        AuditOperation auditOperation = new AuditOperation();
        auditOperation.setId(rs.getInt("AUDIT_ID"));
        auditOperation.setDateAuditOperation(rs.getDate("DATE_AUDIT"));
        auditOperation.setStatus(rs.getString("STATUS"));
        auditOperation.setAction(rs.getString("ACTION"));
        return auditOperation;
    }
}