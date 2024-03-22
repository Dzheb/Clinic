package ru.dzheb.clinic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
@EnableConfigurationProperties(DoctorProperties.class)
public class ClinicApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ClinicApplication.class, args);
        DoctorProperties doctorProperties = context.getBean(DoctorProperties.class);
        log.info("max-allowed-appointments: {}", doctorProperties.getMaxAllowedAppointments());
        log.info("min-appointment-interval: {}", doctorProperties.getMinAppointmentInterval());
        log.info("tags: {}", doctorProperties.getTags());
    }
}


