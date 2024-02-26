package ru.dzheb.clinic.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dzheb.clinic.model.Category;
import ru.dzheb.clinic.model.Speciality;
import ru.dzheb.clinic.service.CategoryService;
import ru.dzheb.clinic.service.SpecialityService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

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
    public List<String> allSpeciality() {
        return specialityService.allSpecialityUI();
    }

    @GetMapping("/{id}")
    @Operation(summary = "поиск специализации"
            , description = "Поиск специализации по идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    public ResponseEntity<String> getCategory(@PathVariable long id) {
        final String speciality;
        speciality = specialityService.getSpecialityById(id);
        if (Objects.equals(speciality, "")) {
            throw new NoSuchElementException("Специализация не найдена");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(speciality);

        }
    }


}
