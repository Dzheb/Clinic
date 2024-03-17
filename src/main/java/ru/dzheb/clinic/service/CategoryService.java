package ru.dzheb.clinic.service;

import ru.dzheb.clinic.model.Category;
import ru.dzheb.clinic.model.CategoryUI;

import java.util.List;

public interface CategoryService {


    List<Category> allCategories();

    List<CategoryUI> allCategoriesUI();

    String getCategoryById(long id);

    CategoryUI getCategoryUIById(long id);

    long addCategory(CategoryUI category);

    long updateCategory(long id, CategoryUI category);

    String deleteCategory(long id);
}