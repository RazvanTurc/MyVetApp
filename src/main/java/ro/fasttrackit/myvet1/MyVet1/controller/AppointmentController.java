package ro.fasttrackit.myvet1.MyVet1.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.myvet1.MyVet1.model.Appointment;
import ro.fasttrackit.myvet1.MyVet1.service.AppointmentService;

import java.util.Optional;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public Optional<Appointment> getAppointmentById(@PathVariable int id) {
        return service.getAppointmentById(id);
    }

    @PostMapping
    public Appointment registerAppointment(@RequestBody Appointment appointment) {
        return service.registerAppointment(appointment);
    }

    @PutMapping("{id}")
    public Appointment replaceAppointment(@PathVariable int id, @RequestBody Appointment appointment) {
        return service.replaceAppointment(id, appointment);
    }

    @DeleteMapping("{id}")
    public Optional<Appointment> deleteAppointment(@PathVariable int id) {
        return service.deleteAppointment(id);
    }
}
