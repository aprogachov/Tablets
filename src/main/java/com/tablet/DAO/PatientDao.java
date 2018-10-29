package com.tablet.DAO;

import com.modelsale.model.Patient;

import java.util.List;

public interface PatientDao {

    void addPatient(Patient patient);
    Patient findById(int patientId);
    List<Patient> findAllPatients();
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);
}
