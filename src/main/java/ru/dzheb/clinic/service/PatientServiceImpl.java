package ru.dzheb.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dzheb.clinic.model.Doctor;
import ru.dzheb.clinic.model.DoctorUI;
import ru.dzheb.clinic.model.Patient;
import ru.dzheb.clinic.model.PatientUI;
import ru.dzheb.clinic.repository.PatientRepository;

import java.util.ArrayList;
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
    @Override
    public List<PatientUI> allPatientsUI() {
        List<PatientUI> patientUIS = new ArrayList<>();
        List<Patient> patients = repository.findAll();
        for (Patient patient : patients) {
            PatientUI patientUI = new PatientUI(
                    patient.getId(),
                    patient.getFamily(),
                    patient.getName(),
                    patient.getMiddle_name());
            patientUIS.add(patientUI);

        }
        return patientUIS;
    }
    @Override
    public Long addPatient(PatientUI patient) {
        Patient newPatient = new Patient();
        newPatient.setFamily(patient.getFamily());
        newPatient.setName(patient.getName());
        newPatient.setMiddle_name(patient.getMiddle_name());

        return repository.saveAndFlush(newPatient).getId();

    }

    @Override
    public long updatePatient(long id, PatientUI patientUI) {
        Patient patientToUpdate = getPatientById(id);
        if (patientToUpdate != null) {
            patientToUpdate.setFamily(patientUI.getFamily());
            patientToUpdate.setName(patientUI.getName());
            patientToUpdate.setMiddle_name(patientUI.getMiddle_name());
            repository.saveAndFlush(patientToUpdate);
            return patientToUpdate.getId();
        } else return -1;
    }
}
