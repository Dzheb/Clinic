package ru.dzheb.clinic.service;

import ru.dzheb.clinic.api.AppointmentRequest;
import ru.dzheb.clinic.model.Appointment;
import ru.dzheb.clinic.model.AppointmentUI;

import java.util.List;

public interface AppointmentService {
    List<Appointment> allAppointments();
    List<AppointmentUI> allAppointmentsUI();
    Appointment addAppointmentUI(AppointmentUI appointmentUI);

    Appointment getAppointmentById(long id);

    Appointment addAppointment(AppointmentRequest request);

    String deleteAppointment(long id);

    long updateAppointment(long id, AppointmentUI appointmentUI);
}
