package ru.dzheb.clinic.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "doctors")
@Data
public class Doctor {
    @Id
    @Schema(name = "Id врача")
    @GeneratedValue(strategy =
            GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    @Schema(name = "Ф.И.О. врача",minimum ="3",maximum = "100")
    private  String fio;
    @Column()
    private long speciality;
    @Column()
    private long category;
    @Column()
    private LocalDate birth;

    @Override
    public String toString() {
        return this.id + ".   " + '"'+this.fio+'"'
                + '"'+this.speciality+'"';
    }
}
