package ru.dzheb.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dzheb.clinic.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}