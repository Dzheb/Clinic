package ru.dzheb.clinic.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class AppointmentUI {
    long id;
    String DoctorName;
    String PatientName;
    LocalDateTime appointment_start;
    LocalDateTime appointment_end;

//    public AppointmentUI(long id, String bookName,
//                   String readerName,
//                   LocalDateTime issued_at,
//                   LocalDateTime returned_at) {
//        this.id = id;
//        this.bookName = bookName;
//        this.readerName = readerName;
//        this.issued_at = issued_at;
//        this.returned_at = returned_at;
//    }
    @Override
    public String toString() {
        return "# "+this.id + ", Врач: " + '"'+this.getDoctorName()+'"' ;
    }
}
