package ru.dzheb.clinic.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dzheb.clinic.model.Doctor;
import ru.dzheb.clinic.model.DoctorUI;
import ru.dzheb.clinic.service.DoctorService;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/doctor")
@Tag(name = "Doctor")
public class DoctorController {
    private final DoctorService doctorservice;

    @GetMapping()
    @Operation(summary = "get all doctors"
            , description = "Поиск всех врачей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    public List<DoctorUI> allDoctors() {
        return doctorservice.allDoctorsUI();
    }

    @GetMapping("/{id}")
    @Operation(summary = "get a doctor by id"
            , description = "Поиск врача по идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    public ResponseEntity<Doctor> getDoctor(@PathVariable long id) {
        final Doctor doctor;
        doctor = doctorservice.getDoctorById(id);
        if (doctor == null) {
            throw new NoSuchElementException("Врач не найден");
            //      return ResponseEntity.notFound().build();
        } else {
            System.out.println("Врач: " + doctorservice.getDoctorById(id));
            return ResponseEntity.status(HttpStatus.OK).body(doctor);

        }
    }

    @PostMapping
    @Operation(summary = "add a doctor to the clinic"
            , description = "Добавление врача в клинику")
    public Long addDoctor(@RequestBody DoctorUI doctor) {
        return doctorservice.addDoctor(doctor);

    }

    @PutMapping("/{id}")
    public long updateDoctor(@PathVariable Long id, @RequestBody DoctorUI doctor) {
        return doctorservice.updateDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete doctor by id"
            , description = "Удаление врача по идентификатору")
    public String deleteDoctor(@PathVariable long id) {
        return doctorservice.deleteDoctor(id);
    }

}
