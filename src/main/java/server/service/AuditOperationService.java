package server.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import server.DAO.DAOauditOperationImpl;
import server.DAO.AuditOperationDao;
import server.mapper.AuditOperationMapper;
import server.model.AuditOperation;

import org.springframework.beans.factory.annotation.Autowired;
import server.util.Audit;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditOperationService implements IAuditOperationService {

	@Autowired
	private AuditOperationDao auditOperationDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addAuditOperation(AuditOperation auditOperation) {
		auditOperationDao.addAuditOperation(auditOperation);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "FindById auditOperation")
	public AuditOperation findById(int auditOperationId) {
		AuditOperation dbauditOperation = auditOperationDao.findById(auditOperationId);
		return dbauditOperation;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Find all auditOperations")
	public List<AuditOperation> findAllAuditOperations() {
		List<AuditOperation> auditOperations = auditOperationDao.findAllAuditOperations();
		return auditOperations;
	}

//	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	public void updateAuditOperation(AuditOperation auditOperation) {
//		auditOperationDao.updateAuditOperation(auditOperation);
//	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Delete auditOperation")
	public void deleteAuditOperation(AuditOperation auditOperation) {
		auditOperationDao.deleteAuditOperation(auditOperation);
	}
}
