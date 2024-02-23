package ru.dzheb.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dzheb.clinic.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

//    Optional<Role> findByLogin(String role);

}
