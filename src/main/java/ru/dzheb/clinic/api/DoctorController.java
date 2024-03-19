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
// список всех врачей
    @GetMapping()
    @Operation(summary = "get all doctors"
            , description = "Поиск всех врачей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    public ResponseEntity<List<DoctorUI>> allDoctors() {
        return ResponseEntity.status(HttpStatus.OK).body(doctorservice.allDoctorsUI());
    }
    // поиск врача по идентификатору
    @GetMapping("/{id}")
    @Operation(summary = "get a doctor by id"
            , description = "Поиск врача по идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    public ResponseEntity<DoctorUI> getDoctor(@PathVariable long id) {
        final DoctorUI doctorUI;
        doctorUI = doctorservice.getDoctorUIById(id);
        if (doctorUI == null) {
            throw new NoSuchElementException("Врач не найден");
        } else {
            System.out.println("Врач: " + doctorservice.getDoctorById(id));
            return ResponseEntity.status(HttpStatus.OK).body(doctorUI);

        }
    }
    // добавление врача
    @PostMapping
    @Operation(summary = "add a doctor to the clinic"
            , description = "Добавление врача в клинику")
    public ResponseEntity<Long> addDoctor(@RequestBody DoctorUI doctor) {
        Long docId = doctorservice.addDoctor(doctor);
        return ResponseEntity.status(HttpStatus.OK).body(docId);
    }
    // изменение врача
    @PutMapping("/{id}")
    public ResponseEntity<Long> updateDoctor(@PathVariable Long id, @RequestBody DoctorUI doctor) {
        Long docId = doctorservice.updateDoctor(id, doctor);
        if (docId > 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(docId);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(docId);
        }
    }
    // удаление врача
    @DeleteMapping("/{id}")
    @Operation(summary = "delete doctor by id"
            , description = "Удаление врача по идентификатору")
    public ResponseEntity<String> deleteDoctor(@PathVariable long id) {
        String docId = doctorservice.deleteDoctor(id);
        return ResponseEntity.status(HttpStatus.OK).body(docId);
    }

}
