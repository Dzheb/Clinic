package ru.dzheb.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dzheb.clinic.model.Doctor;
import ru.dzheb.clinic.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}