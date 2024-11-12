package ru.dzheb.clinic.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@CrossOrigin(origins = {"http://192.168.0.107:8080",
        "http://localhost:8080","https://localhost","https://192.168.0.107"})
@RequiredArgsConstructor
@RequestMapping("/admin")

    public class JWTController {
        @GetMapping
        public RedirectView loginClinic() {
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:3000");
            return redirectView;
        }
    }


