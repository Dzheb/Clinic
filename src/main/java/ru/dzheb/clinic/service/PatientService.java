package ru.dzheb.clinic.service;

import ru.dzheb.clinic.model.DoctorUI;
import ru.dzheb.clinic.model.Patient;
import ru.dzheb.clinic.model.PatientUI;

import java.util.List;

public interface PatientService {
    Patient getPatientById(long id);

    Long addPatient(Patient patient);

    String deletePatient(long id);

    List<Patient> allPatients();
    List<PatientUI> allPatientsUI();
    Long addPatient(PatientUI patient);
    long updatePatient(long id, PatientUI patient);
}