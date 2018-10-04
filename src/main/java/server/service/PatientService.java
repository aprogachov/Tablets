package server.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import server.DAO.DAOpatientImpl;
import server.DAO.PatientDao;
import server.mapper.PatientMapper;
import server.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

	@Autowired
	private PatientDao patientDao;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addPatient(Patient patient) {
		patientDao.addPatient(patient);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Patient findById(int patientId) {
		Patient dbpatient = patientDao.findById(patientId);
		return dbpatient;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Patient> findAllPatients() {
		List<Patient> patients = patientDao.findAllPatients();
		return patients;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updatePatient(Patient patient) {
		patientDao.updatePatient(patient);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deletePatient(Patient patient) {
		patientDao.deletePatient(patient);
	}
}
