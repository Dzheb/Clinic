package ru.dzheb.clinic.service;

import ru.dzheb.clinic.model.Patient;

import java.util.List;

public interface PatientService {
    Patient getPatientById(long id);

    Long addPatient(Patient patient);

    String deletePatient(long id);

    List<Patient> allPatients();
}