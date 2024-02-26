package ru.dzheb.clinic.service;

import org.springframework.stereotype.Service;
import ru.dzheb.clinic.model.Category;
import ru.dzheb.clinic.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String getCategoryById(long id) {
        Category cat = categoryRepository.findById(id).orElse(null);
        if (cat != null) {
            return cat.getCategory();
        } else return "";
    }

    @Override
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByCategory(String category) {
        System.out.println(category);
        Category cat = categoryRepository.findAll().stream()
                .filter(it -> it.getCategory()
                        .equals(category)).findFirst().orElse(null);
        System.out.println(cat.getCategory());
        return categoryRepository.findAll().stream()
                .filter(it -> it.getCategory()
                        .equals(category)).findFirst().orElse(null);
    }

    @Override
    public List<String> allCategoriesUI() {
        return categoryRepository.findAll().stream().map(Category::getCategory).toList();
    }
}
