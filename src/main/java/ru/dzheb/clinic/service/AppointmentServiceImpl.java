package ru.dzheb.clinic.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dzheb.clinic.DoctorProperties;
import ru.dzheb.clinic.api.AppointmentRequest;
import ru.dzheb.clinic.model.Appointment;
import ru.dzheb.clinic.model.AppointmentUI;
import ru.dzheb.clinic.repository.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentRepository appointmentRepository;
    private final DoctorProperties doctorProperties;

    public List<AppointmentUI> allAppointmentsUI() {
        List<AppointmentUI> appointmentUIS = new ArrayList<>();
        List<Appointment> appointments = appointmentRepository.findAll();
        for (Appointment appointment : appointments) {
            if (doctorService.getDoctorById(appointment.getDoctorId()) != null
                    && patientService.getPatientById(appointment.getPatientId()) != null) {
                AppointmentUI appointmentUI = new AppointmentUI(appointment.getId(),
                        doctorService.getDoctorById(appointment.getDoctorId())
                                .getFio(),
                        doctorService.getDoctorById(appointment.getDoctorId()).getId(),
                        patientService.getPatientById(appointment
                                .getPatientId()).getFamily() + " " +
                                patientService.getPatientById(appointment
                                        .getPatientId()).getName() + " " +
                                patientService.getPatientById(appointment
                                        .getPatientId()).getMiddle_name(),
                        patientService.getPatientById(appointment.getPatientId()).getId(),
                        appointment.getAppointment_start().toLocalDate(),
                        appointment.getAppointment_start().toLocalTime());
                appointmentUIS.add(appointmentUI);
            }
        }
        return appointmentUIS;
    }

    public List<Appointment> allAppointments() {

        return appointmentRepository.findAll();
    }


    public Appointment getAppointmentById(long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public AppointmentUI getAppointmentUIById(long id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment != null) {
            if (doctorService.getDoctorById(appointment.getDoctorId()) != null
                    && patientService.getPatientById(appointment.getPatientId()) != null) {
                AppointmentUI appointmentUI = new AppointmentUI(appointment.getId(),
                        doctorService.getDoctorById(appointment.getDoctorId())
                                .getFio(),
                        doctorService.getDoctorById(appointment.getDoctorId()).getId(),
                        patientService.getPatientById(appointment
                                .getPatientId()).getFamily() + " " +
                                patientService.getPatientById(appointment
                                        .getPatientId()).getName() + " " +
                                patientService.getPatientById(appointment
                                        .getPatientId()).getMiddle_name(),
                        patientService.getPatientById(appointment.getPatientId()).getId(),
                        appointment.getAppointment_start().toLocalDate(),
                        appointment.getAppointment_start().toLocalTime());
                return appointmentUI;
            }
        }
        return null;
    }

    public Appointment addAppointment(AppointmentRequest request) {
        if (doctorService.getDoctorById(request.getDoctorId()) == null) {
            throw new NoSuchElementException("Не найден врач с идентификатором \"" + request.getDoctorId() + "\"");
        }
        if (patientService.getPatientById(request.getPatientId()) == null) {
            throw new NoSuchElementException("Не найден пациент с идентификатором \"" + request.getPatientId() + "\"");
        }
        int appointmentInterval = doctorProperties.getMinAppointmentInterval();
        if (appointmentRepository.findAll().stream()
                .filter(it -> it.getDoctorId() == request.getDoctorId() &&
                        (request.getAppointmentTime().isAfter(it.getAppointment_start()
                        ) && request.getAppointmentTime()
                                .isBefore(it.getAppointment_start()
                                        .plusMinutes(appointmentInterval))
                                || (request.getAppointmentTime().plusMinutes(appointmentInterval)
                                .isAfter(it.getAppointment_start())
                                && request.getAppointmentTime().plusMinutes(appointmentInterval)
                                .isBefore(it.getAppointment_start().plusMinutes(appointmentInterval)))))
                .toList().size() != 0) {
            throw new NoSuchElementException("Время приёма совпадает с" +
                    " другим приёмом этого врача");
        }
        Appointment appointment = new Appointment(request.getDoctorId()
                , request.getPatientId(), request.getAppointmentTime());
        appointmentRepository.save(appointment);
        return appointment;
    }

    //
    public Appointment addAppointmentUI(AppointmentUI appointmentUI) {
        if (doctorService.getDoctorById(appointmentUI.getDoctorId()) == null) {
            throw new NoSuchElementException("Не найден врач ");
        }
        if (patientService.getPatientById(appointmentUI.getPatientId()) == null) {
            throw new NoSuchElementException("Не найден пациент");
        }
        int appointmentInterval = doctorProperties.getMinAppointmentInterval();
        if (appointmentRepository.findAll().stream()
                .filter(it -> it.getDoctorId() == appointmentUI.getDoctorId()
                        && appointmentUI.getAppointment_date().equals(it.getAppointment_start().toLocalDate())
                        && (appointmentUI.getAppointment_time().isAfter(it.getAppointment_start().toLocalTime())
                        && appointmentUI.getAppointment_time().isBefore(it.getAppointment_start().toLocalTime().plusMinutes(appointmentInterval))
                        || (appointmentUI.getAppointment_time().plusMinutes(appointmentInterval).isAfter(it.getAppointment_start().toLocalTime())
                        && appointmentUI.getAppointment_time().plusMinutes(appointmentInterval).isBefore(it.getAppointment_start().toLocalTime().plusMinutes(appointmentInterval))))
                ).toList().size() != 0) {
            throw new NoSuchElementException("Время приёма совпадает с" +
                    " другим приёмом этого врача");
        }
        Appointment appointment = new Appointment(appointmentUI.getDoctorId()
                , appointmentUI.getPatientId(), appointmentUI.getAppointment_time()
                .atDate(appointmentUI.getAppointment_date()));
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

    public long updateAppointment(long id, AppointmentUI appointmentUI) {
        Appointment appointmentToUpdate = getAppointmentById(id);
        if (appointmentToUpdate == null) {
            throw new NoSuchElementException("Не найден приём с идентификатором \"" + appointmentUI.getId() + "\"");
        }
        if (doctorService.getDoctorById(appointmentUI.getDoctorId()) == null) {
            throw new NoSuchElementException("Не найден врач с идентификатором \"" + appointmentUI.getDoctorId() + "\"");
        }
        if (patientService.getPatientById(appointmentUI.getPatientId()) == null) {
            throw new NoSuchElementException("Не найден пациент с идентификатором \"" + appointmentUI.getPatientId() + "\"");
        }
        appointmentToUpdate.setDoctorId(appointmentUI.getDoctorId());
        appointmentToUpdate.setPatientId(appointmentUI.getPatientId());
        appointmentToUpdate.setAppointment_start(appointmentUI.getAppointment_time()
                .atDate(appointmentUI.getAppointment_date()));
        appointmentRepository.saveAndFlush(appointmentToUpdate);
        return appointmentToUpdate.getId();
    }

    public void deleteAppointmentsByDoctorId(long id) {
        List<Appointment> appointments_to_delete =
                appointmentRepository.findAll().stream()
                        .filter(it -> it.getDoctorId() == id)
                        .toList();
        for (Appointment app : appointments_to_delete) {
            if (appointmentRepository.findById(app.getId()).isPresent())
                appointmentRepository.deleteById(app.getId());
        }
    }

    @Override
    public void deleteAppointmentsByPatientId(long id) {
        List<Appointment> appointments_to_delete =
                appointmentRepository.findAll().stream()
                        .filter(it -> it.getPatientId() == id)
                        .toList();
        for (Appointment app : appointments_to_delete) {
            if (appointmentRepository.findById(app.getId()).isPresent())
                appointmentRepository.deleteById(app.getId());
        }
    }


}