package ru.dzheb.clinic.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "Doctors")
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
    private String speciality;
    @Column()
    private String category;
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date birth;
    @Column()
    private String image;

    @Override
    public String toString() {
        return this.id + ".   " + '"'+this.fio+'"'
                + '"'+this.speciality+'"';
    }
}
