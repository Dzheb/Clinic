package ru.dzheb.clinic.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
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


