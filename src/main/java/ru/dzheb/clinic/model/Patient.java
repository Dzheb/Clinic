package ru.dzheb.clinic.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Patients")
public class Patient {
    @Id
    @Schema(name = "Id врача")
    @GeneratedValue(strategy =
            GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    @Schema(name = "Фамилия пациента", minimum = "3", maximum = "100")
    private String Family;
    @Column(nullable = false)
    private String Name;
    @Column()
    private String Middle_name;
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date birth;
    @Column()
    private String Phone;
    @Column()
    private String Email;
    @Column()
    private String Policy;
    @Column()
    private String Deseases;
    @Column()
    private String Allergy;
    @Column()
    private String Operations;

    @Override
    public String toString() {
        return this.id + ".   " + '"' + this.getFamily() + '"'
                + '"' + this.getName() + '"' + this.getMiddle_name() + '"';
    }
}
