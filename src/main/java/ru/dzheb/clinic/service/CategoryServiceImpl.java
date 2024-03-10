package ru.dzheb.clinic.service;

import org.springframework.stereotype.Service;
import ru.dzheb.clinic.model.Category;
import ru.dzheb.clinic.model.CategoryUI;
import ru.dzheb.clinic.model.Patient;
import ru.dzheb.clinic.model.PatientUI;
import ru.dzheb.clinic.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public String getCategoryById(long id) {
        Category cat = categoryRepository.findById(id).orElse(null);
        if (cat != null) {
            return cat.getCategory();
        } else return "";
    }

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }


    public Category getCategoryByCategory(String category) {
        Category cat = categoryRepository.findAll().stream()
                .filter(it -> it.getCategory()
                        .equals(category)).findFirst().orElse(null);
        return categoryRepository.findAll().stream()
                .filter(it -> it.getCategory()
                        .equals(category)).findFirst().orElse(null);
    }

    public List<CategoryUI> allCategoriesUI() {
        List<CategoryUI> categoryUIS = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            CategoryUI categoryUI = new CategoryUI(
                    category.getId(),
                    category.getCategory());

            categoryUIS.add(categoryUI);

        }
        return categoryUIS;
    }
}
