package com.tablet.mapper;

import com.modelsale.model.Patient;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PatientMapper implements RowMapper<Patient> {
    @Override
    public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Patient patient = new Patient();
        patient.setId(rs.getInt("PATIENT_ID"));
        patient.setPhone(rs.getString("PHONE"));
        patient.setStateId(rs.getInt("STATEID"));
        return patient;
    }
}