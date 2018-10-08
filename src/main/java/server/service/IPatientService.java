package server.service;

import org.springframework.stereotype.Component;
import server.model.Patient;

import java.util.List;

@Component
public interface IPatientService {

    void addPatient(Patient patient);
    Patient findById(int patientId);
    List<Patient> findAllPatients();
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);
}
