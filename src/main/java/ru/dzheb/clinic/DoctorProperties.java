package ru.dzheb.clinic;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@ConfigurationProperties("application.doctor")
public class DoctorProperties {

    private Integer maxAllowedAppointments;
    private Integer minAppointmentInterval;

    private Map<String, String> tags;

}
