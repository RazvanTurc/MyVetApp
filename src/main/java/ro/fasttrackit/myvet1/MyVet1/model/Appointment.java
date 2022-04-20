package ro.fasttrackit.myvet1.MyVet1.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private int id;
//    private Times time;
    private String preciseTime;
    private String vet;
    private String pet;
    private String owner;

    public Appointment() {}

//    public Appointment(String preciseTime) {
////        this.time = time;
//        this.vet = null;
//        this.pet = null;
//        this.owner = null;
//        this.preciseTime = preciseTime;
//    }

    public Appointment(String preciseTime, String vet, String pet, String owner) {
//        this.time = time.getTimesFromString(preciseTime);
        this.vet = vet;
        this.pet = pet;
        this.owner = owner;
        this.preciseTime = preciseTime;
    }

//    public Appointment(Times time, String vet, String pet, String owner) {
//        this.time = time;
//        this.vet = vet;
//        this.pet = pet;
//        this.owner = owner;
//        this.preciseTime = time.getTimeString();
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Times getTime() {
//        return time;
//    }
//
//    public void setTime(Times time) {
//        this.time = time;
//    }

    public String getPreciseTime() {
        return preciseTime;
    }

    public void setPreciseTime(String preciseTime) {
        this.preciseTime = preciseTime;
    }

    public String getVet() {
        return vet;
    }

    public void setVet(String vet) {
        this.vet = vet;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

//    public int getOrder() {
//        switch (preciseTime) {
//            case "9:00": return 1;
//            case "9:30": return 2;
//            case "10:00": return 3;
//            case "10:30": return 4;
//            case "11:00": return 5;
//            case "11:30": return 6;
//            case "12:00": return 7;
//            case "12:30": return 8;
//            case "13:00": return 9;
//            case "13:30": return 10;
//            case "14:00": return 11;
//            case "14:30": return 12;
//            case "15:00": return 13;
//            case "15:30": return 14;
//            case "16:00": return 15;
//            case "16:30": return 16;
//            case "17:00": return 17;
//            case "17:30": return 18;
//            case "18:00": return 19;
//            default: throw new RuntimeException("Invalid Time");
//        }
//    }




    @Override
    public String toString() {
        return "Appointment: " + preciseTime +
                ", Vet: " + vet +
                ", Pet: " + pet;
    }
}

