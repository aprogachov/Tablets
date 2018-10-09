package server.DAO;

import server.model.AuditOperation;
import java.util.List;

public interface AuditOperationDao {

    void addAuditOperation(AuditOperation auditOperation);
    AuditOperation findById(int auditOperationId);
    List findAllAuditOperations();
    void deleteAuditOperation(AuditOperation auditOperation);
}
