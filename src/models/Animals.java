package models;

import models.animals.*;
import models.vets.Vet;

import java.util.ArrayList;
import java.util.function.DoubleFunction;

public class Animals {
    private ArrayList<Animal> animals = new ArrayList<>();

    public String addAnimal(Animal animal) {
        for (Animal a : animals) {
            if (a.getId().equals(animal.getId())) {
                return "Error: Animal with id: \"" + animal.getId() + "\" already exists";
            }
        }
        animals.add(animal);
        return null;
    }

    public String removeAnimal(String id) {
        Animal animalToRemove = getAnimalById(id);

        if (animalToRemove != null) {
            animals.remove(animalToRemove);
            return null;
        } else {
            return "Error: Animal with id: \"" + id + "\" not found";
        }
    }


//**********************************************************************************************************************
// setters
//**********************************************************************************************************************

    // any animal
    public String setId(String currentId, String newId) {
        Animal animal = getAnimalById(currentId);
        if (animal != null) {
            animal.setId(newId);
            return null;
        } else {
            return "Error: Animal with id: \"" + currentId + "\" not found";
        }
    }

    public String setAnimalName(String id, String newName) {
        Animal animal = getAnimalById(id);
        if (animal != null) {
            animal.setName(newName);
            return null;
        } else {
            return "Error: Animal with id: \"" + id + "\" not found";
        }
    }

    public String setAnimalAge(String id, int age) {
        Animal animal = getAnimalById(id);
        if (animal != null) {
            animal.setAge(age);
            return null;
        } else {
            return "Error: Animal with id: \"" + id + "\" not found";
        }
    }

    public String setAnimalGender(String id, String gender) {
        Animal animal = getAnimalById(id);
        if (animal != null) {
            animal.setGender(gender);
            return null;
        } else {
            return "Error: Animal with id: \"" + id + "\" not found";
        }
    }

    public String setAnimalFamily(String id, String family) {
        Animal animal = getAnimalById(id);
        if (animal != null) {
            animal.setFamily(family);
            return null;
        } else {
            return "Error: Animal with id: \"" + id + "\" not found";
        }
    }


    // dog specific
    public String setVet(String id, Vet vet) {
        Animal animal = getAnimalById(id);
        if (animal != null) {
            if (animal instanceof Dog) {
                ((Dog) animal).setVet(vet);
                return null;
            } else {
                return "Error: Animal must be dog to change vet";
            }
        } else {
            return "Error: Animal with id: " + id + " not found";
        }
    }

    public String setAnimalDesexed(String animalId, boolean desexed) {
        Animal animal = getAnimalById(animalId);
        if (animal != null) {
            if (animal instanceof Dog) {
                ((Dog) animal).setDesexed(desexed);
                return null;
            } else {
                return "Error: Animal must be dog to change desexed";
            }
        } else {
            return "Error: Animal with id: " + animalId + " not found";
        }
    }

    public String setAnimalCatFriendly(String animalId, boolean catFriendly) {
        Animal animal = getAnimalById(animalId);
        if (animal != null) {
            if (animal instanceof Dog) {
                ((Dog) animal).setCatFriendly(catFriendly);
                return null;
            } else {
                return "Error: Animal must be dog to change cat friendly";
            }
        } else {
            return "Error: Animal with id: " + animalId + " not found";
        }
    }

    public String setCareFees(String id, Double careFees) {
        Animal animal = getAnimalById(id);
        if (animal != null) {
            if (animal instanceof Dog) {
                ((Dog) animal).setCareFees(careFees);
                return null;
            } else {
                return "Error: Animal must be dog to change care fees";
            }
        } else {
            return "Error: Animal with id: \"" + id + "\" not found";
        }
    }


//**********************************************************************************************************************
// reports
//**********************************************************************************************************************
    public String getHighCareFeeDogsReport() {
        StringBuilder string = new StringBuilder();
        string.append("Dogs with care fees over $110:\n");
        for (Animal animal : animals) {
            if (animal instanceof Dog && ((Dog) animal).getCareFees() > 110) {
                string.append(animal.reportDetails()).append("\n");
            }
        }
        return string.toString();
    }

    public int countCatFriendlyDogs() {
        int count = 0;
        for (Animal animal : animals) {
            if (animal instanceof Dog && ((Dog) animal).getCatFriendly()) {
                count++;
            }
        }
        return count;
    }

    public String getReport() {
        if (!animals.isEmpty()) {
            StringBuilder report = new StringBuilder();
            report.append("\nAnimals currently in system:");
            for (Animal animal : animals) {
                report.append("\n").append(animal.reportDetails());
            }
            report.append("\n");
            return report.toString();
        } else {
            return "No animals currently stored";
        }
    }

    public Animal getAnimalById(String id) {
        for (Animal animal : animals) {
            if (id.equals(animal.getId())) {
                return animal;
            }
        }
        return null;
    }
}
