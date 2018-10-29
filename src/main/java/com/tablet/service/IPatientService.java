package com.tablet.service;

import com.modelsale.model.Patient;

import java.util.List;

public interface IPatientService {

    void addPatient(Patient patient);
    Patient findById(int patientId);
    List<Patient> findAllPatients();
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);
}
