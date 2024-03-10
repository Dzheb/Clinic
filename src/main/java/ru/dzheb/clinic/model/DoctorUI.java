package ru.dzheb.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class
DoctorUI {
   private long id;
   private  String fio;
   private String speciality;
   long specialityId;
   private String category;
   long categoryId;
   private LocalDate birth;

}
