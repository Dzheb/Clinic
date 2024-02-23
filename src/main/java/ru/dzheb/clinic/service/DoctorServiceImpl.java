package ru.dzheb.clinic.service;

import org.springframework.stereotype.Service;
import ru.dzheb.clinic.model.*;
import ru.dzheb.clinic.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository repository;
    private final SpecialityService specialityService;
    private final CategoryService categoryService;

    public DoctorServiceImpl(DoctorRepository repository, SpecialityService specialityService, CategoryService categoryService) {
        this.repository = repository;
        this.specialityService = specialityService;
        this.categoryService = categoryService;
    }


    @Override
    public Doctor getDoctorById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Long addDoctor(Doctor doctor) {
        repository.saveAndFlush(doctor);
        return doctor.getId();
    }

    @Override
    public Doctor updateDoctor(long id, Doctor doctor) {
        Doctor doctorToUpdate = getDoctorById(id);
        if(doctorToUpdate != null) {
            doctorToUpdate.setFio(doctor.getFio());
            doctorToUpdate.setCategory(doctor.getCategory());
            doctorToUpdate.setSpeciality(doctor.getSpeciality());
            doctorToUpdate.setBirth(doctor.getBirth());
            repository.save(doctorToUpdate);
            return doctorToUpdate;
        }
        else return null;
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

    @Override
    public List<DoctorUI> allDoctorsUI() {
        List<DoctorUI> doctorUIS = new ArrayList<>();
        List<Doctor> doctors = repository.findAll();
        for (Doctor doctor : doctors) {
            DoctorUI doctorUI = new DoctorUI(
                    doctor.getId(),
            doctor.getFio(),
            specialityService.getSpecialityById(doctor.getSpeciality()),
            categoryService.getCategoryById(doctor.getCategory()),
            doctor.getBirth());
            doctorUIS.add(doctorUI);

        }
        return doctorUIS;
    }

}
