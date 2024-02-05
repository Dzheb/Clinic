package ru.dzheb.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dzheb.clinic.model.Doctor;
import ru.dzheb.clinic.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    private final DoctorRepository repository;
    @Autowired
    public DoctorServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Doctor getDoctorById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Long addDoctor(Doctor doctor) {
//        Doctor doctor = new Doctor();
        repository.save(doctor);
        return doctor.getId();
    }

    @Override
    public String deleteDoctor(long id) {
        Doctor doctor = getDoctorById(id);
        if (doctor != null) {
            repository.deleteById(id);
            return "Врач id = " + id + " удален";
        } else {
            return "Врач id = " + id + " не нрайден";
        }

    }

    @Override
    public List<Doctor> allDoctors() {
        return repository.findAll();
    }

}
