package server.DAO;

import org.springframework.stereotype.Component;
import server.model.Patient;

import java.util.List;

@Component
public interface PatientDao {

    void addPatient(Patient patient);
    Patient findById(int patientId);
    List<Patient> findAllPatients();
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);
}
