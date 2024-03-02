package ru.dzheb.clinic.service;

import org.springframework.stereotype.Service;
import ru.dzheb.clinic.model.Category;
import ru.dzheb.clinic.model.CategoryUI;
import ru.dzheb.clinic.model.Speciality;
import ru.dzheb.clinic.model.SpecialityUI;
import ru.dzheb.clinic.repository.CategoryRepository;
import ru.dzheb.clinic.repository.SpecialityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public String getSpecialityById(long id) {
        Speciality spec = specialityRepository.findById(id).orElse(null);
        if (spec != null) {
            return spec.getSpeciality();
        } else return "";
    }

//    @Override
//    public List<Speciality> allSpeciality() {
//        return specialityRepository.findAll();
//    }
    @Override
    public List<SpecialityUI> allSpecialityUI() {
        List<SpecialityUI> specialityUIS = new ArrayList<>();
        List<Speciality> specialities = specialityRepository.findAll();
        for (Speciality speciality : specialities) {
            SpecialityUI specialityUI = new SpecialityUI(
                    speciality.getId(),
                    speciality.getSpeciality());

            specialityUIS.add(specialityUI);

        }
        return specialityUIS;
     }

    @Override
    public Speciality getSpecialityBySpeciality(String speciality) {
        return specialityRepository.findAll().stream()
                .filter(it -> it.getSpeciality()
                        .equals(speciality)).findFirst().orElse(null);
    }
}

