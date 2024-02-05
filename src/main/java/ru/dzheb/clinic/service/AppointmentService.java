package ru.dzheb.clinic.service;

import ru.dzheb.clinic.api.AppointmentRequest;
import ru.dzheb.clinic.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> allAppointments();


    Appointment getAppointmentById(long id);

    Appointment addAppointment(AppointmentRequest request);

    String deleteAppointment(long id);
}
