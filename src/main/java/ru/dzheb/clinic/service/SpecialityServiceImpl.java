package ru.dzheb.clinic.service;

import org.springframework.stereotype.Service;
import ru.dzheb.clinic.model.Category;
import ru.dzheb.clinic.model.Speciality;
import ru.dzheb.clinic.repository.CategoryRepository;
import ru.dzheb.clinic.repository.SpecialityRepository;

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
        if(spec != null)
        {
            return spec.getSpeciality();
        }
        else  return "";
    }

    @Override
    public List<Speciality> allSpeciality() {
        return specialityRepository.findAll();
    }
}
