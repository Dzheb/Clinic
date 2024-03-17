package ru.dzheb.clinic.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dzheb.clinic.model.SpecialityUI;
import ru.dzheb.clinic.service.SpecialityService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/speciality")
@Tag(name = "Speciality")
public class SpecialityController {
    // dependency injection
    private final SpecialityService specialityService;

    @GetMapping()
    @Operation(summary = "get all specialities"
            , description = "Поиск всех специализаций врачей")
    public List<SpecialityUI> allSpeciality() {
        return specialityService.allSpecialityUI();
    }

    //    поиск категории по id
    @GetMapping("/{id}")
    @Operation(summary = "поиск специализации"
            , description = "Поиск специализации по идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    public ResponseEntity<SpecialityUI> getSpeciality(@PathVariable long id) {
        SpecialityUI specialityUI = specialityService.getSpecialityUIById(id);
        if (specialityUI == null) {
            throw new NoSuchElementException("Категория не найдена");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(specialityUI);

        }
    }

    // добавление специальности врача
    @PostMapping
    @Operation(summary = "add a doctor speciality to the clinic"
            , description = "Добавление специальности врача в клинику")
    public long addSpeciality(@RequestBody SpecialityUI speciality) {
        return specialityService.addSpeciality(speciality);
    }

    // изменение  специальности врача
    @PutMapping("/{id}")
    public long updateSpeciality(@PathVariable Long id, @RequestBody SpecialityUI speciality) {
        return specialityService.updateSpeciality(id, speciality);
    }

    // удаление  категории врача
    @DeleteMapping("/{id}")
    @Operation(summary = "delete speciality by id"
            , description = "Удаление специальности врача по идентификатору")
    public String deleteSpeciality(@PathVariable long id) {
        return specialityService.deleteSpeciality(id);
    }
}

