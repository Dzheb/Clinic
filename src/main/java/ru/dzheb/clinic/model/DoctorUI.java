package ru.dzheb.clinic.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@RequiredArgsConstructor
public class
DoctorUI {
   private long id;
   private  String fio;
   private String speciality;
   private String category;
   private LocalDate birth;

   public DoctorUI(long id, String fio, String speciality, String category, LocalDate birth) {
      this.id = id;
      this.fio = fio;
      this.speciality = speciality;
      this.category = category;
      this.birth = birth;
   }
}
