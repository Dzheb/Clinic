package ru.dzheb.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dzheb.clinic.model.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality,Long> {
}
