package server.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import server.mapper.PatientMapper;
import server.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.lang.*;
import java.util.Map;

@Repository
public class DAOpatientImpl implements PatientDao {

	private JdbcTemplate jdbcTemplate;
	public DataSource ds;

	@Autowired
	public DAOpatientImpl(JdbcTemplate jdbcTemplate, DataSource ds) {
		this.jdbcTemplate = jdbcTemplate;
		this.ds = ds;
	}

	@Override
	public void addPatient(Patient patient) {
		try {
			String sql = "INSERT INTO patients(PHONE, STATEID) VALUES (?,?)";
			jdbcTemplate.update(sql, patient.getPhone(), patient.getStateId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Patient findById(int patientId) {
		String sql = "SELECT * FROM patients WHERE PATIENT_ID = ?";
		Patient patient = jdbcTemplate.queryForObject(sql, new Object[] { patientId }, new PatientMapper());
		return patient;
	}

	@Override
	public List<Patient> findAllPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		try {
			String sql = "SELECT * FROM patients";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			for (Map row : rows) {
				Patient patient = new Patient();
				patient.setId(Integer.parseInt(String.valueOf(row.get("PATIENT_ID"))));
				patient.setPhone((String)row.get("PHONE"));
				patient.setStateId(Integer.parseInt(String.valueOf(row.get("STATEID"))));
				patients.add(patient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patients;
	}

	@Override
	public void updatePatient(Patient patient) {
		try {
			String sql = "UPDATE patients SET PHONE=?, STATEID=? WHERE PATIENT_ID=?";
			jdbcTemplate.update(sql, patient.getPhone(), patient.getStateId(), patient.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePatient(Patient patient) {
		try {
			String sql = "DELETE FROM patients WHERE PATIENT_ID=?";
			jdbcTemplate.update(sql, patient.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
