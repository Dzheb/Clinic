package ru.dzheb.clinic.service;

import ru.dzheb.clinic.model.Doctor;
import ru.dzheb.clinic.model.DoctorUI;
import java.util.List;

public interface DoctorService {
    Doctor getDoctorById(long id);

    String deleteDoctor(long id);

    List<Doctor> allDoctors();

    DoctorUI getDoctorUIById(long id);

    Long addDoctor(DoctorUI doctor);

    long updateDoctor(long id, DoctorUI doctor);
    List<DoctorUI> allDoctorsUI();

    Doctor getDoctorByFio(String doctorName);
}