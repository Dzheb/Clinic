package ru.dzheb.clinic.service;

import org.springframework.stereotype.Service;
import ru.dzheb.clinic.model.Category;
import ru.dzheb.clinic.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String getCategoryById(long id) {
        Category cat = categoryRepository.findById(id).orElse(null);
        if(cat != null)
        {
            return cat.getCategory();
        }
        else  return "";
    }

    @Override
    public List<Category> allCategory() {
        return categoryRepository.findAll();
    }
}
