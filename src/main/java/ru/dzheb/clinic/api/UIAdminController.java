package ru.dzheb.clinic.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dzheb.clinic.service.AppointmentService;
import ru.dzheb.clinic.service.DoctorService;
import ru.dzheb.clinic.service.PatientService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ui")
public class UIAdminController {
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentService appointmentService;
//
//    @GetMapping("/books")
//    public String allBooks(Model model) {
//        model.addAttribute("books", bookService.allBooks());
//        return "books";
//    }
//
    @GetMapping("/admin")
    public String allDoctors(Model model) {
        model.addAttribute("doctors", doctorService.allDoctors());
        model.addAttribute("patients", patientService.allPatients());
        model.addAttribute("appointments", appointmentService.allAppointments());
        return "admin";
    }
//
//    @GetMapping("/issues")
//    public String allIssues(Model model) {
//        model.addAttribute("issuesUI", issuerService.allIssues());
//        return "issues";
//    }
//
//    @GetMapping("/reader/{id}")
//    public String readerBooks(@PathVariable Long id, Model model) {
//        model.addAttribute("reader", readerService.getReaderById(id));
//        model.addAttribute("books", issuerService.getIssuesByReaderUI(id));
//        return "reader_books";
//    }

}
