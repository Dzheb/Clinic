package ru.dzheb.clinic.service;

import org.springframework.stereotype.Service;
import ru.dzheb.clinic.model.Category;
import ru.dzheb.clinic.model.CategoryUI;
import ru.dzheb.clinic.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    поиск категории врача в базе
       public String getCategoryById(long id) {
        Category cat = categoryRepository.findById(id).orElse(null);
        if (cat != null) {
            return cat.getCategory();
        } else return "";
    }


    //    поиск категории врача в базе
    public CategoryUI getCategoryUIById(long id) {

        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null) {
            return null;
        } else return new CategoryUI(id, category.getCategory());

    }
    // вывод всех категорий врача
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    // вывод всех категорий врача на экран
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

    // добавление  категории врача
    public long addCategory(CategoryUI category) {
        Category newCategory = new Category();
        newCategory.setCategory(category.getCategory());
        return categoryRepository.saveAndFlush(newCategory).getId();
    }

// изменение категории врача
    public long updateCategory(long id, CategoryUI category) {
        Category categoryToUpdate = categoryRepository.findById(id)
                .orElse(null);
        if (categoryToUpdate != null) {
            categoryToUpdate.setCategory(category.getCategory());
            return categoryRepository.saveAndFlush(categoryToUpdate).getId();
        } else return -1;
    }

// удаление категории врача
    public String deleteCategory(long id) {
        String category = getCategoryById(id);
        if (!category.equals("")) {
            categoryRepository.deleteById(id);
            return "Категория врача id = " + id + " удалена";
        } else {
            return "Категория врача = " + id + " не нрайдена";
        }
    }

}
