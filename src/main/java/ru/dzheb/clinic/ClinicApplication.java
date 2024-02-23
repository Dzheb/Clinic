package ru.dzheb.clinic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.dzheb.clinic.model.Role;
import ru.dzheb.clinic.model.User;
import ru.dzheb.clinic.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
@EnableConfigurationProperties(DoctorProperties.class)
public class ClinicApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ClinicApplication.class, args);
		DoctorProperties doctorProperties = context.getBean(DoctorProperties.class);
		// Инициализация пользователей с ролями
//		UserRepository userRepository = context.getBean(UserRepository.class);
//		userRepository.save(createUser());
//		userRepository.save(createAdmin());
		log.info("max-allowed-appointments: {}", doctorProperties.getMaxAllowedAppointments());
		log.info("min-appointment-interval: {}", doctorProperties.getMinAppointmentInterval());
		log.info("tags: {}", doctorProperties.getTags());
	}
	private static User createUser() {
		User reader = new User();
		reader.setLogin("user1");
		reader.setPassword("user1");
		Role role = new Role();
		role.setRole("user");
		List<Role> roles = Collections.singletonList(role);
		reader.setRoles(roles);
		return reader;
	}

	private static User createAdmin() {
		User admin = new User();
		admin.setLogin("admin");
		admin.setPassword("admin");
		Role role1 = new Role();
		role1.setRole("admin");
		Role role2 = new Role();
		role2.setRole("user");
		List<Role> roles = new ArrayList<>();
		roles.add(role1);
		roles.add(role2);
		admin.setRoles(roles);
		return admin;

	}
	}


