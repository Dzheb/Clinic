package ru.dzheb.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dzheb.clinic.model.Patient;
import ru.dzheb.clinic.repository.PatientRepository;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    private final PatientRepository repository;
    @Autowired
    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patient getPatientById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Long addPatient(Patient patient) {
        repository.save(patient);
        return patient.getId();
    }

    @Override
    public String deletePatient(long id) {
        Patient patient = getPatientById(id);
        if (patient != null) {
            repository.deleteById(id);
            return "Пациент id = " + id + " удален";
        } else {
            return "Пациент id = " + id + " не нрайден";
        }

    }

    @Override
    public List<Patient> allPatients() {
        return repository.findAll();
    }

}
