package ru.dzheb.clinic.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dzheb.clinic.model.Patient;
import ru.dzheb.clinic.model.PatientUI;
import ru.dzheb.clinic.service.PatientService;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/patient")
@Tag(name = "Patient")
public class PatientController {
    // dependency injection
    private final PatientService patientservice;
    @GetMapping()
    @Operation(summary = "get all patients"
            ,description = "Поиск всех пациентов")
    // список всех пациентов
       public ResponseEntity<List<PatientUI>> allPatients() {

        return ResponseEntity.status(HttpStatus.OK).body(patientservice.allPatientsUI());
    }
    // поиск пациента по идентификатору
    @GetMapping("/{id}")
    @Operation(summary = "get patient by id"
            ,description = "Поиск пациента по идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    public ResponseEntity<Patient> getPatient(@PathVariable long id) {
        final Patient patient;
        patient = patientservice.getPatientById(id);
        if (patient == null) {
            System.out.println("Пациент не найден");
            throw new NoSuchElementException("Пациент не найден");
        } else {
            System.out.println("Пациент: " + patientservice.getPatientById(id));
            return ResponseEntity.status(HttpStatus.OK).body(patient);

        }
    }
    // добавление пациента
    @PostMapping
    @Operation(summary = "add patient to the clinic"
            ,description = "Добавление пациента в клинику")
    public ResponseEntity<Long> addPatient(@RequestBody PatientUI patient) {
        Long patId = patientservice.addPatient(patient);
        return ResponseEntity.status(HttpStatus.OK).body(patId);
    }
    // изменение пациента
    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePatient(@PathVariable Long id, @RequestBody PatientUI patient) {
        Long patId = patientservice.updatePatient(id, patient);
        if (patId > 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(patId);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(patId);
        }
    }
    // удаление пациента
    @DeleteMapping("/{id}")
    @Operation(summary = "delete patient by id"
            ,description = "Удаление пациента по идентификатору")
    public ResponseEntity<String> deleteDoctor(@PathVariable long id) {
        String patId = patientservice.deletePatient(id);
        return ResponseEntity.status(HttpStatus.OK).body(patId);
    }

}
