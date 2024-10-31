package models.animals;

import models.vets.Vet;

public class Dog extends Animal {
    private Vet vet;
    private boolean desexed;
    private boolean catFriendly;
    private double careFees;

    public Dog(String id, String name, int age, String gender, Vet vet, boolean desexed, boolean catFriendly, double careFees) {
        super(id, name, age, gender, "dog");
        this.vet = vet;
        this.desexed = desexed;
        this.catFriendly = catFriendly;
        this.careFees = careFees;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Vet getVet() {
        return vet;
    }

    public boolean getDesexed() {
        return desexed;
    }

    public boolean getCatFriendly() {
        return catFriendly;
    }

    public double getCareFees() {
        return careFees;
    }

    public void setDesexed(boolean desexed) {
        this.desexed = desexed;
    }

    public void setCareFees(double careFees) {
        this.careFees = careFees;
    }

    public void setCatFriendly(boolean catFriendly) {
        this.catFriendly = catFriendly;
    }

    @Override
    public String reportDetails() {
        return super.getName() + " (microchip: " + super.getId() + ") is a " + super.getGender() + " " + super.getFamily();
    }
}
