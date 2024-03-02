package ru.dzheb.clinic.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dzheb.clinic.model.Appointment;
import ru.dzheb.clinic.model.AppointmentUI;
import ru.dzheb.clinic.model.DoctorUI;
import ru.dzheb.clinic.service.AppointmentService;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/appointment")
@Tag(name = "Appointment")
public class AppointmentController {
    // dependency injection
    private final AppointmentService appointmentService;
    @GetMapping()
    @Operation(summary = "all appointment"
            ,description = "Поиск всех приёмов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    public List<AppointmentUI> allAppointments() {
        return appointmentService.allAppointmentsUI();
    }
    @GetMapping("/{id}")
    @Operation(summary = "get appointment by id"
            ,description = "Поиск приёма по идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    public ResponseEntity<Appointment> getAppointment(@PathVariable long id) {
        final Appointment appointment;
        appointment = appointmentService.getAppointmentById(id);
        if (appointment == null) {
            throw new NoSuchElementException("Приём не найден");
        } else {
            System.out.println("Приём: " + appointmentService.getAppointmentById(id));
            return ResponseEntity.status(HttpStatus.OK).body(appointment);

        }
    }

    @PostMapping
    @Operation(summary = "add appointment"
            ,description = "Добавление приёма")
    public Appointment addAppointment(@RequestBody AppointmentUI appointmentUI) {
        return appointmentService.addAppointmentUI(appointmentUI);

    }
    @PutMapping("/{id}")
    public long updateAppointment(@PathVariable Long id, @RequestBody AppointmentUI appointmentUI) {
        return appointmentService.updateAppointment(id, appointmentUI);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "delete appointment by id"
            ,description = "Удаление приёма по идентификатору")
    public String deleteAppointment(@PathVariable long id) {
        return appointmentService.deleteAppointment(id);
    }

}
