package server.service;

import server.model.AuditOperation;
import java.util.List;

public interface IAuditOperationService {

    void addAuditOperation(AuditOperation auditOperation);
    AuditOperation findById(int auditOperationId);
    List findAllAuditOperations();
//    void updateAuditOperation(AuditOperation auditOperation);
    void deleteAuditOperation(AuditOperation auditOperation);
}
