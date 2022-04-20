package ro.fasttrackit.myvet1.MyVet1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.myvet1.MyVet1.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query("SELECT a FROM Appointment a WHERE a.preciseTime = ?1")
    Appointment findAppointmentByPreciseTime(String preciseTime);

}
