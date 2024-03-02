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
    // dependency injection
    private final CategoryService categoryService;
    @GetMapping()
    @Operation(summary = "get all categories"
            ,description = "Поиск всех категорий врачей")
//       public List<Category> allCategories() {
//        return categoryService.allCategories();
    //}
    public List<CategoryUI> allCategoriesUI() {
        return categoryService.allCategoriesUI();
    }
    @GetMapping("/{id}")
    @Operation(summary = "get patient by id"
            ,description = "Поиск пациента по идентификатору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ошибка клиента")
    })
    public ResponseEntity<String> getCategory(@PathVariable long id) {
        final String category;
        category = categoryService.getCategoryById(id);
        if (category == "") {
            throw new NoSuchElementException("Категория не найдена");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(category);

        }
    }


}
