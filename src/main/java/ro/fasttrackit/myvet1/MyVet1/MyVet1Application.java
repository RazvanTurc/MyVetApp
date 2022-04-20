package ro.fasttrackit.myvet1.MyVet1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.myvet1.MyVet1.model.Appointment;
import ro.fasttrackit.myvet1.MyVet1.service.AppointmentService;

import static ro.fasttrackit.myvet1.MyVet1.model.Times.*;

@SpringBootApplication
public class MyVet1Application {

	public static void main(String[] args) {
		SpringApplication.run(MyVet1Application.class, args);
	}

	@Bean
	CommandLineRunner atStartup(
			AppointmentService appointService) {
		return args -> {
			appointService.populateAppointments();
			appointService.registerAppointment(new Appointment("9:00", "Lorena", "Mana", "Razvan"));
			appointService.registerAppointment(new Appointment("11:00", "Lorena", "Chop", "Razvan"));
			appointService.registerAppointment(new Appointment("12:00", "Lorena", "Misa", "Razvan"));
			appointService.registerAppointment(new Appointment("13:00", "Lorena", "Dogo", "Doru"));
			appointService.registerAppointment(new Appointment("15:30", "Lorena", "Mana", "Razvan"));
		};
	}
}
