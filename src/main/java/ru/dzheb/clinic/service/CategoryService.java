package ru.dzheb.clinic.service;

import ru.dzheb.clinic.model.Category;
import ru.dzheb.clinic.model.CategoryUI;
import ru.dzheb.clinic.model.Patient;

import java.util.List;

public interface CategoryService {
    String getCategoryById(long id);

    List<Category> allCategories();

    Category getCategoryByCategory(String category);

    List<CategoryUI> allCategoriesUI();
}