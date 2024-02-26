package ru.dzheb.clinic.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dzheb.clinic.model.DoctorUI;
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
       public List<PatientUI> allPatients() {
        return patientservice.allPatientsUI();
    }
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
//            return ResponseEntity.notFound().build();
        } else {
            System.out.println("Пациент: " + patientservice.getPatientById(id));
            return ResponseEntity.status(HttpStatus.OK).body(patient);

        }
    }
    @PostMapping
    @Operation(summary = "add patient to the clinic"
            ,description = "Добавление пациента в клинику")
    public Long addPatient(@RequestBody PatientUI patient) {
        return patientservice.addPatient(patient);
    }
    @PutMapping("/{id}")
    public long updatePatient(@PathVariable Long id, @RequestBody PatientUI patient) {
        return patientservice.updatePatient(id, patient);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "delete patient by id"
            ,description = "Удаление пациента по идентификатору")
    public String deleteDoctor(@PathVariable long id) {
        return patientservice.deletePatient(id);
    }

}
