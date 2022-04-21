package ro.fasttrackit.myvet1.MyVet1.model;

import javax.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private int id;
    private String preciseTime;
    private String vet;
    private String pet;
    private String owner;

    public Appointment() {}

    public Appointment(String preciseTime, String vet, String pet, String owner) {
        this.vet = isValid(vet);
        this.pet = isValid(pet);
        this.owner = isValid(owner);
        this.preciseTime = preciseTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    private String isValid(String input) {
        if(input.equals("--")) {
            return input;
        }else if(input.trim().matches("^[a-zA-Z]*$")) {
            return input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
        }
        return "N/A";
    }
    @Override
    public String toString() {
        return "Appointment: " + preciseTime +
                ", Vet: " + vet +
                ", Pet: " + pet;
    }
}

