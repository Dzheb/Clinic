package ru.dzheb.clinic.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@CrossOrigin(origins = "http://localhost:3000")
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(configurer -> configurer
                        //.csrf((csrf) -> csrf.ignoringRequestMatchers("/api/v1/**"));
                        //.requestMatchers("/api/v1/").permitAll()
//                        .requestMatchers("/category/**").authenticated()
//                        .requestMatchers("/patient/**").authenticated()
//                        .requestMatchers("/doctor/**").authenticated()
//                        .requestMatchers("/speciality/**").authenticated()
//                        .requestMatchers("/appointment/**").authenticated()
//                        .requestMatchers("/admin/**").authenticated()
//                        .requestMatchers("/api/**").permitAll()
//                              .anyRequest().denyAll()
                        .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                //.defaultSuccessUrl("/homepage.html", true)
                //.successHandler(new RefererRedirectionAuthenticationSuccessHandler());
                .csrf(AbstractHttpConfigurer::disable)
                .build();
//                .formLogin()
//       https://docs.spring.io/spring-security/site/docs/5.5.4/guides/form-javaconfig.html
//                .loginPage("/login")
    }
}
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(registry -> registry
//                        .anyRequest().permitAll()
//                )
//                .formLogin(form -> form.loginPage("/ui/login").permitAll().defaultSuccessUrl("/ui/books"))
////                .formLogin(Customizer.withDefaults())
//                .exceptionHandling(accessDenied -> accessDenied.accessDeniedPage("/ui/403"))
//                .logout(form -> form.logoutSuccessUrl("/ui/login").permitAll())
//                .build();
//    }
