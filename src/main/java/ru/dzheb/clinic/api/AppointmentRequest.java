package ru.dzheb.clinic.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Data
@RequiredArgsConstructor
@Schema(name = "Заявка на приём")
public class AppointmentRequest {

    /**
     * Идентификатор пациента
     */
    @Schema(name = "Id пациента")
    private long patientId;

    /**
     * Идентификатор врача
     */
    @Schema(name = "Id врача")
    private long doctorId;

    /**
     * Время приёма
     */
    @Schema(name = "Время приёма")
    //"2024-01-27T21:32:53"
    @Temporal(TemporalType.TIMESTAMP)
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime appointmentTime;

}