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
import ru.dzheb.clinic.model.CategoryUI;
import ru.dzheb.clinic.model.Patient;
import ru.dzheb.clinic.service.CategoryService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/category")
@Tag(name = "Category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping()
    @Operation(summary = "get all categories"
            , description = "Поиск всех категорий врачей")
// все категории врачей
    public ResponseEntity<List<CategoryUI>> allCategoriesUI() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.allCategoriesUI());
    }

    //    поиск категории по id
    @GetMapping("/{id}")
    @Operation(summary = "get category by id"
            , description = "Поиск категории по идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    public ResponseEntity<CategoryUI> getCategory(@PathVariable long id) {
        CategoryUI categoryUI = categoryService.getCategoryUIById(id);
        if (categoryUI == null) {
            throw new NoSuchElementException("Категория не найдена");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(categoryUI);

        }
    }

    // добавление категории врача
    @PostMapping
    @Operation(summary = "add a doctor category to the clinic"
            , description = "Добавление категории врача в клинику")
    public ResponseEntity<Long>  addCategory(@RequestBody CategoryUI category) {
        Long catId = categoryService.addCategory(category);
            return ResponseEntity.status(HttpStatus.OK).body(catId);
    }

    // изменение  категории врача
    @PutMapping("/{id}")
    public ResponseEntity<Long> updateCategory(@PathVariable Long id, @RequestBody CategoryUI category) {
        Long catId = categoryService.updateCategory(id, category);
        if (catId > 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(catId);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(catId);
        }

    }

    // удаление  категории врача
    @DeleteMapping("/{id}")
    @Operation(summary = "delete category by id"
            , description = "Удаление категории врача по идентификатору")
    public ResponseEntity<String> deleteCategory(@PathVariable long id) {
        String catId = categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(catId);
    }
}
