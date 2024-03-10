package ru.dzheb.clinic.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Запись о приёме врача
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "appointments")
@Schema(name = "Приём")
public class Appointment {
    @Id
    @Schema(name = "Id приёма")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Column(nullable = false)
    @Schema(name = "Id врача")
    private  long doctorId;
    @Column(nullable = false)
    @Schema(name = "Id пациента")
    private  long patientId;
    @Column
    @Schema(name = "Время и дата приёма")
    private LocalDateTime appointment_start;
    @Column
    @Schema(name = "Данные анализов")
    private String analysis;
    @Column
    @Schema(name = "Информация о пациенте")
    private String patient_info;
    @Column
    @Schema(name = "Диагноз")
    private String diagnosis;
    @Column
    @Schema(name = "План лечения")
    private String recommendations;

    public Appointment(long doctorId, long patientId,
                       LocalDateTime appointment_start) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointment_start = appointment_start;
    }
    @Override
    public String toString() {
        return this.appointment_start + ".   " + '"'+this.doctorId+'"' + '"'+this.patientId+'"';
    }

}
