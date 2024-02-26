package ru.dzheb.clinic.service;

import com.fasterxml.jackson.annotation.JacksonInject;
import ru.dzheb.clinic.model.Speciality;

import java.util.List;

public interface SpecialityService {
    String getSpecialityById(long id);

    List<String> allSpecialityUI();

    Speciality getSpecialityBySpeciality(String speciality);
}