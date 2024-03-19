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
    // список всех приёмов
    @GetMapping()
    @Operation(summary = "all appointment"
            ,description = "Поиск всех приёмов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    public ResponseEntity<List<AppointmentUI>> allAppointments() {

        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.allAppointmentsUI());
    }
    @GetMapping("/{id}")
    @Operation(summary = "get appointment by id"
            ,description = "Поиск приёма по идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    // поиск приёма по идентификатору
    public ResponseEntity<AppointmentUI> getAppointment(@PathVariable long id) {
        final AppointmentUI appointmentUI;
        appointmentUI = appointmentService.getAppointmentUIById(id);
        if (appointmentUI == null) {
            throw new NoSuchElementException("Приём не найден");
        } else {
            System.out.println("Приём: " + appointmentService.getAppointmentById(id));
            return ResponseEntity.status(HttpStatus.OK).body(appointmentUI);

        }
    }
    // добавление приёма
    @PostMapping
    @Operation(summary = "add appointment"
            ,description = "Добавление приёма")
    public ResponseEntity<Appointment> addAppointment(@RequestBody AppointmentUI appointmentUI) {
        Appointment app = appointmentService.addAppointmentUI(appointmentUI);
        return ResponseEntity.status(HttpStatus.OK).body(app);
    }
    // изменение приёма
    @PutMapping("/{id}")
    public ResponseEntity<Long> updateAppointment(@PathVariable Long id, @RequestBody AppointmentUI appointmentUI) {
        Long appId = appointmentService.updateAppointment(id, appointmentUI);
        if (appId > 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(appId);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(appId);
        }
     }
    // удаление приёма
    @DeleteMapping("/{id}")
    @Operation(summary = "delete appointment by id"
            ,description = "Удаление приёма по идентификатору")
    public ResponseEntity<String> deleteAppointment(@PathVariable long id) {
        String appId = appointmentService.deleteAppointment(id);
        return ResponseEntity.status(HttpStatus.OK).body(appId);
    }
    @DeleteMapping("doctor/{id}")
    @Operation(summary = "delete appointment by doctor id"
            ,description = "Удаление приёма по идентификатору врача")
    public void deleteAppointmentByDoctorId(@PathVariable long id) {
        appointmentService.deleteAppointmentsByDoctorId(id);
    }
    @DeleteMapping("patient/{id}")
    @Operation(summary = "delete appointment by patient id"
            ,description = "Удаление приёма по идентификатору пациента")
    public void deleteAppointmentByPatientId(@PathVariable long id) {
        appointmentService.deleteAppointmentsByPatientId(id);
    }

}
