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
   long specialityId;
   private String category;
   long categoryId;
   private LocalDate birth;

   public DoctorUI(long id, String fio, String speciality, long specialityId, String category, long categoryId, LocalDate birth) {
      this.id = id;
      this.fio = fio;
      this.speciality = speciality;
      this.specialityId = specialityId;
      this.category = category;
      this.categoryId = categoryId;
      this.birth = birth;
   }
}
