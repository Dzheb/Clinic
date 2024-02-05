package ru.dzheb.clinic.service;

import ru.dzheb.clinic.model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor getDoctorById(long id);

    Long addDoctor(Doctor doctor);

    String deleteDoctor(long id);

    List<Doctor> allDoctors();
}