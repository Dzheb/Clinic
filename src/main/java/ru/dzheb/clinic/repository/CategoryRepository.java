package ru.dzheb.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dzheb.clinic.model.Category;
import ru.dzheb.clinic.model.Doctor;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
