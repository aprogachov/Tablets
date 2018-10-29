package com.tablet.service;

import com.modelsale.model.AuditOperation;
import java.util.List;

public interface IAuditOperationService {

    void addAuditOperation(AuditOperation auditOperation);
    AuditOperation findById(int auditOperationId);
    List findAllAuditOperations();
    void deleteAuditOperation(AuditOperation auditOperation);
}
