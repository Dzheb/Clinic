package ru.dzheb.clinic.service;

import ru.dzheb.clinic.model.Doctor;
import ru.dzheb.clinic.model.DoctorUI;

import java.util.List;

public interface DoctorService {
    Doctor getDoctorById(long id);

    Long addDoctor(Doctor doctor);

    String deleteDoctor(long id);

    List<Doctor> allDoctors();
    List<DoctorUI> allDoctorsUI();

    Doctor updateDoctor(long id,Doctor doctor);
}