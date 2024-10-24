package models.vets;

public class Vet {
    private String name;
    private String organisation;
    private String phoneNumber;

    public Vet(String name, String organisation, String phoneNumber) {
        this.name = name;
        this.organisation = organisation;
        this.phoneNumber = phoneNumber;
    }

    public Vet(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.organisation = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String reportDetails() {
        return "Name: " + name + "\nOrg: " + organisation + "\nPh: " + phoneNumber + "\n";
    }
}
