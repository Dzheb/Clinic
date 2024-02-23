package ru.dzheb.clinic.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests(configurer -> configurer
                                .requestMatchers("/css/**").permitAll()
                                .requestMatchers("/ui/user/**").hasAuthority("user")
                                .requestMatchers("/ui/admin/**").hasAuthority("admin")
                                .requestMatchers("/ui/doctors/**").authenticated()
                                .requestMatchers("/ui/**").permitAll()
                        .anyRequest().denyAll()
                )
                .formLogin(Customizer.withDefaults())
//                .formLogin()
 //       https://docs.spring.io/spring-security/site/docs/5.5.4/guides/form-javaconfig.html
//                .loginPage("/login")
                .build();
    }
}
