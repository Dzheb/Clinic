package ru.dzheb.clinic.service;

import org.springframework.stereotype.Service;
import ru.dzheb.clinic.model.*;
import ru.dzheb.clinic.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;

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
    public Long addDoctor(DoctorUI doctor) {
        Doctor newDoctor = new Doctor();
        newDoctor.setFio(doctor.getFio());
        newDoctor.setCategory(doctor.getCategoryId());
        newDoctor.setSpeciality(doctor.getSpecialityId());
        newDoctor.setBirth(doctor.getBirth());
        return repository.saveAndFlush(newDoctor).getId();

    }

    @Override
    public long updateDoctor(long id, DoctorUI doctorUI) {
        Doctor doctorToUpdate = getDoctorById(id);
        if (doctorToUpdate != null) {
            doctorToUpdate.setFio(doctorUI.getFio());
            doctorToUpdate.setCategory(doctorUI.getCategoryId());
            doctorToUpdate.setSpeciality(doctorUI.getSpecialityId());
            doctorToUpdate.setBirth(doctorUI.getBirth());
            System.out.println(doctorToUpdate.getBirth() + "  "
                    + doctorUI.getBirth());
            repository.saveAndFlush(doctorToUpdate);
            return doctorToUpdate.getId();
        } else return -1;
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
                    doctor.getSpeciality(),
                    categoryService.getCategoryById(doctor.getCategory()),
                    doctor.getCategory(),
                    doctor.getBirth());
            doctorUIS.add(doctorUI);

        }
        return doctorUIS;
    }

    @Override
    public Doctor getDoctorByFio(String doctorName) {
        return repository.findAll().stream()
                .filter(it -> it.getFio().equals(doctorName))
        .findFirst().orElse(null);

    }

}
