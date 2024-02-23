package ru.dzheb.clinic.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "speciality")
@Data
public class Speciality {
    @Id
    @Schema(name = "Id специальности")
    @GeneratedValue(strategy =
            GenerationType.AUTO)
    private long id;
    @Column()
    private String speciality;

}

