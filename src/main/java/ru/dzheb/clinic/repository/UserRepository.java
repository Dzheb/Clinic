package ru.dzheb.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dzheb.clinic.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByLogin(String login);

}
