package ru.dzheb.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class
PatientUI {
   private long id;
   private  String family;
   private String name;
   private String middle_name;
   private String fio;

}
