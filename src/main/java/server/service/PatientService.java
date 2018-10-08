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
import server.util.Audit;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements IPatientService {

	@Autowired
	private PatientDao patientDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Add patient")
	public void addPatient(Patient patient) {
		patientDao.addPatient(patient);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "FindById patient")
	public Patient findById(int patientId) {
		Patient dbpatient = patientDao.findById(patientId);
		return dbpatient;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Find all patients")
	public List<Patient> findAllPatients() {
		List<Patient> patients = patientDao.findAllPatients();
		return patients;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Update patient")
	public void updatePatient(Patient patient) {
		patientDao.updatePatient(patient);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Delete patient")
	public void deletePatient(Patient patient) {
		patientDao.deletePatient(patient);
	}
}
