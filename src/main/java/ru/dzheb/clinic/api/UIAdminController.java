package ru.dzheb.clinic.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @GetMapping("/admin")
    public String allDoctors(Model model) {
        model.addAttribute("doctors", doctorService.allDoctorsUI());
        model.addAttribute("patients", patientService.allPatients());
        model.addAttribute("appointments", appointmentService.allAppointmentsUI());
        return "admin";
    }

//
//    @GetMapping("/reader/{id}")
//    public String readerBooks(@PathVariable Long id, Model model) {
//        model.addAttribute("reader", readerService.getReaderById(id));
//        model.addAttribute("books", issuerService.getIssuesByReaderUI(id));
//        return "reader_books";
//    }

}
