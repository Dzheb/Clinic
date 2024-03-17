package ru.dzheb.clinic.service;

import com.fasterxml.jackson.annotation.JacksonInject;
import ru.dzheb.clinic.model.Speciality;
import ru.dzheb.clinic.model.SpecialityUI;

import java.util.List;

public interface SpecialityService {
    String getSpecialityById(long id);

    List<SpecialityUI> allSpecialityUI();

    SpecialityUI getSpecialityUIById(long id);

    long addSpeciality(SpecialityUI speciality);

    long updateSpeciality(long id, SpecialityUI speciality);

    String deleteSpeciality(long id);

}