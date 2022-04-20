package ro.fasttrackit.myvet1.MyVet1.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.myvet1.MyVet1.model.Appointment;
import ro.fasttrackit.myvet1.MyVet1.model.Times;
import ro.fasttrackit.myvet1.MyVet1.repository.AppointmentRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    private List<Appointment> beforePopulate() {
        List<Appointment> result = new ArrayList<>();
        for(Times t : Times.values()) {
            result.add(new Appointment(t.getTimeString(),"--","--","--"));
        }
        return result;
    }

    public List<Appointment> populateAppointments() {
        return repository.saveAll(beforePopulate());
    }

    private Appointment checkAppointment(Appointment appointment) {
//        Optional<Appointment> appointment = repository.findById(id);
//        replaceAppointment(id, new Appointment(appointment.get().getPreciseTime(),"--","--","--"));
//
        Appointment currentAppointment = getAppointmentByPreciseTime(appointment.getPreciseTime());
        return replaceAppointment(currentAppointment.getId(), appointment);

    }

    public Optional<Appointment> getAppointmentById(int id) {
        return repository.findById(id);
    }

    private Appointment getAppointmentByPreciseTime(String preciseTime) {
        return repository.findAppointmentByPreciseTime(preciseTime);
    }

    public Appointment registerAppointment(Appointment appointment) {
                return repository.save(checkAppointment(appointment));
    }

    public List<Appointment> getAllAppointments() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(Appointment::getId)).collect(Collectors.toList());
    }

    public Appointment replaceAppointment(int id, Appointment appointment) {
        Appointment newAppointment = new Appointment(
                appointment.getPreciseTime(),
                appointment.getVet(),
                appointment.getPet(),
                appointment.getOwner());
        newAppointment.setId(id);
        return repository.save(newAppointment);
    }

    public Optional<Appointment> deleteAppointment(int id) {
        Optional<Appointment> appointment = repository.findById(id);
        replaceAppointment(id, new Appointment(appointment.get().getPreciseTime(),"--","--","--"));

        return appointment;
    }
}

