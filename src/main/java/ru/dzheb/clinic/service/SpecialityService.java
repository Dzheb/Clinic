package ru.dzheb.clinic.service;

import ru.dzheb.clinic.model.Speciality;

import java.util.List;

public interface SpecialityService {
    String getSpecialityById(long id);

    List<Speciality> allSpeciality();
}