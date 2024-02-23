package ru.dzheb.clinic.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class AppointmentUI {
    long id;
    String doctorName;
    String patientName;
    LocalDateTime appointment_start;
    LocalDateTime appointment_end;

    public AppointmentUI(long id, String doctorName,
                   String patientName,
                   LocalDateTime appointment_start,
                   LocalDateTime appointment_end) {
        this.id = id;
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.appointment_start = appointment_start;
        this.appointment_end = appointment_end;
    }
    @Override
    public String toString() {
        return "# "+this.id + ", Врач: " + '"'+this.getDoctorName()+'"' ;
    }
}
