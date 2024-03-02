package ru.dzheb.clinic.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@RequiredArgsConstructor
public class AppointmentUI {
    long id;
    String doctorName;
    long doctorId;
    String patientName;
    long patientId;
    LocalDate appointment_date;
    LocalTime appointment_time;


    public AppointmentUI(long id, String doctorName, long doctorId,  String patientName, long patientId, LocalDate appointment_date, LocalTime appointment_time) {
        this.id = id;
        this.doctorName = doctorName;
        this.doctorId = doctorId;
        this.patientName = patientName;
         this.patientId = patientId;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
    }
}
