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
    //    поиск специальности врача в базе
    public String getSpecialityById(long id) {
        Speciality spec = specialityRepository.findById(id).orElse(null);
        if (spec != null) {
            return spec.getSpeciality();
        } else return "";
    }
    // вывод всех специальностей врача на экран
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
    //    поиск специальности врача в базе
    public SpecialityUI getSpecialityUIById(long id) {
        Speciality speciality = specialityRepository.findById(id).orElse(null);
        if (speciality == null) {
            return null;
        } else return new SpecialityUI(id, speciality.getSpeciality());
    }
    // добавление  специальности врача
    public long addSpeciality(SpecialityUI speciality) {
        Speciality newSpeciality = new Speciality();
        newSpeciality.setSpeciality(speciality.getSpeciality());
        return specialityRepository.saveAndFlush(newSpeciality).getId();
    }
    // изменение специальности врача
    public long updateSpeciality(long id, SpecialityUI speciality) {
        Speciality specialityToUpdate = specialityRepository.findById(id)
                .orElse(null);
        if (specialityToUpdate != null) {
            specialityToUpdate.setSpeciality(speciality.getSpeciality());
            return specialityRepository.saveAndFlush(specialityToUpdate).getId();
        } else return -1;
    }
    // удаление категории врача
    public String deleteSpeciality(long id) {
        String speciality = getSpecialityById(id);
        if (!speciality.equals("")) {
            specialityRepository.deleteById(id);
            return "Специальность врача id = " + id + " удалена";
        } else {
            return "Специальность врача = " + id + " не нрайдена";
        }
    }

}

