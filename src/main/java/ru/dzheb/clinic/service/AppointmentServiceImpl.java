package ru.dzheb.clinic.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import ru.dzheb.clinic.DoctorProperties;
import ru.dzheb.clinic.api.AppointmentRequest;
import ru.dzheb.clinic.model.Appointment;
import ru.dzheb.clinic.repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentRepository appointmentRepository;
//    private final ConfigurableApplicationContext context;
private final DoctorProperties doctorProperties;
//    @Value("${application.min-appointment-interval:3600}")
//    private int minAppointmentInterval;
    public List<Appointment> allAppointments() {

        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(long id) {

        return appointmentRepository.findById(id).orElse(null);
    }

    public Appointment addAppointment(AppointmentRequest request) {
        if (doctorService.getDoctorById(request.getDoctorId()) == null) {
            throw new NoSuchElementException("Не найден врач с идентификатором \"" + request.getDoctorId() + "\"");
        }
        if (patientService.getPatientById(request.getPatientId()) == null) {
            throw new NoSuchElementException("Не найден пациент с идентификатором \"" + request.getPatientId() + "\"");
        }
//        DoctorProperties doctorProperties = context.getBean(DoctorProperties.class);
        int appointmentInterval = doctorProperties.getMinAppointmentInterval();
        if(appointmentRepository.findAll().stream()
                .filter(it -> it.getDoctorId() == request.getDoctorId() &&
                        (request.getAppointmentTime().isAfter(it.getAppointment_start()
                                ) && request.getAppointmentTime()
                                .isBefore(it.getAppointment_start()
                                        .plusMinutes(appointmentInterval))
                        || (request.getAppointmentTime().plusMinutes(appointmentInterval)
                                .isAfter(it.getAppointment_start())
                                && request.getAppointmentTime().plusMinutes(appointmentInterval)
                                .isBefore(it.getAppointment_start().plusMinutes(appointmentInterval)))))
                .toList().size()!= 0 ){
            throw new NoSuchElementException("Время приёма совпадает с" +
                    " другим приёмом этого врача");
        }
        Appointment appointment = new Appointment(request.getDoctorId()
                , request.getPatientId(), request.getAppointmentTime());
        System.out.println(appointment.getAppointment_start());
        appointmentRepository.save(appointment);
        return appointment;
    }

    public String deleteAppointment(long id) {
        if (appointmentRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException();
        }
        appointmentRepository.deleteById(id);
        return "Приём id № " + id + " удалён";

    }
}
