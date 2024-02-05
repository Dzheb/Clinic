package ru.dzheb.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dzheb.clinic.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
