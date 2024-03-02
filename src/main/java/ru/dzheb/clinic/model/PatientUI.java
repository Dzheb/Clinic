package ru.dzheb.clinic.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@Data
@RequiredArgsConstructor
public class
PatientUI {
   private long id;
   private  String family;
   private String name;
   private String middle_name;
   private String fio;

   public PatientUI(long id, String family, String name, String middle_name, String fio) {
      this.id = id;
      this.family = family;
      this.name = name;
      this.middle_name = middle_name;
      this.fio = fio;
   }
}
