package models.animals;

public class Animal {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String family;

    public Animal(String id, String name, int age, String gender, String family) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.family = family;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getFamily() {
        return family;
    }

    // setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    // reports
    public String reportDetails() {
        return name + " (id: " + id + ") is a " + gender + " " + family;
    }
}
