package ro.fasttrackit.myvet1.MyVet1.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.fasttrackit.myvet1.MyVet1.model.Times;
import ro.fasttrackit.myvet1.MyVet1.service.AppointmentService;

import java.time.LocalDate;

@Controller
@RequestMapping("appointments")
public class AppointmentControllerHtml {
    private final AppointmentService appointmentService;


    public AppointmentControllerHtml(
            AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @GetMapping
    String getAppointmentsPage(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        model.addAttribute("times", Times.values());
        model.addAttribute("today", LocalDate.now());

        return "appointments";
    }
}
