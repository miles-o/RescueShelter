package controllers;

import models.animals.Animal;
import models.vets.Vet;
import models.*;
import views.View;

import java.util.ArrayList;


public class Controller {
    private View view;
    private Animals animals;
    private Vets vets;

    public Controller(Vets vets, Animals animals, View view) {
        this.animals = animals;
        this.vets = vets;
        this.view = view;

        loadData();
        view.setController(this);
    }

    public void begin() {
        view.begin();
    }

    //getters
    public Vet getVet(String name) {
        Vet vet = vets.getVet(name);

        return vet;
    }

    public ArrayList<Vet> getVetList() {
        return vets.getVetList();
    }

    public ArrayList<Animal> getAnimalList() {
        return animals.getAnimalList();
    }

    public Animal getAnimal(String id) {
        return animals.getAnimalById(id);
    }

    // add data
    public void addVet(Vet vet) {
        String error = vets.addVet(vet);

        if (error != null) {
            throwError(error);
        }
    }

    public void addAnimal(Animal animal) {
        String error = animals.addAnimal(animal);

        if (error != null) {
            throwError(error);
        }
    }

    // remove data
    public void removeVet(String vetName) {
        String error = vets.removeVet(vetName);

        if (error != null) {
            throwError(error);
        }
    }

    public void removeAnimal(String animalId) {
        String error = animals.removeAnimal(animalId);

        if (error != null) {
            throwError(error);
        }
    }

//**********************************************************************************************************************
// modifying functions
//**********************************************************************************************************************

    // animals
    public void setAnimalId(String currentId, String newId) {
        String error = animals.setId(currentId, newId);

        if (error != null) {
            throwError(error);
        }
    }

    public void setAnimalName(String id, String newName) {
        String error = animals.setAnimalName(id, newName);

        if (error != null) {
            throwError(error);
        }
    }

    public void setAnimalAge(String id, int age) {
        String error = animals.setAnimalAge(id, age);

        if (error != null) {
            throwError(error);
        }
    }

    public void setAnimalGender(String id, String gender) {
        String error = animals.setAnimalGender(id, gender);

        if (error != null) {
            throwError(error);
        }
    }

    public void setAnimalFamily(String id, String family) {
        String error = animals.setAnimalFamily(id, family);

        if (error != null) {
            throwError(error);
        }
    }

    // dogs
    public void setAnimalVet(String animalId, Vet vet) {
        String error = animals.setVet(animalId, vet);

        if (error != null) {
            throwError(error);
        }
    }

    public void setAnimalDesexed(String animalId, boolean desexed) {
        String error = animals.setAnimalDesexed(animalId, desexed);

        if (error != null) {
            throwError(error);
        }
    }

    public void setAnimalCatFriendly(String animalid, boolean catFriendly) {
        String error = animals.setAnimalCatFriendly(animalid, catFriendly);

        if (error != null) {
            throwError(error);
        }
    }

    public void setAnimalCareFees(String animalId, double careFees) {
        String error = animals.setCareFees(animalId, careFees);

        if (error != null) {
            throwError(error);
        }
    }

    // vets
    public void setVetName(String oldName, String newName) {
        String error = vets.setVetName(oldName, newName);

        if (error != null) {
            throwError(error);
        }
    }

    public void setVetOrg(String vetName, String org) {
        String error = vets.setVetOrg(vetName, org);

        if (error != null) {
            throwError(error);
        }
    }

    public void setVetPhone(String vetName, String newNumber) {
        String error = vets.setVetPhone(vetName, newNumber);

        if (error != null) {
            throwError(error);
        }
    }


//**********************************************************************************************************************
// reports
//**********************************************************************************************************************
    public String getAllVetsReport() {
        return vets.getReport();
    }

    public String getAllAnimalsReport() {
        return animals.getReport();
    }

    public String getHighCareFeeDogsReport() {
        return animals.getHighCareFeeDogsReport();
    }

    public String getCatFriendlyDogsReport() {
        String count = String.valueOf(animals.countCatFriendlyDogs());

        return "Cat freindly dogs count: " + count;
    }


    // save and load data
    public void loadData() {
        // BufferedReader reader = new BufferedReader();

    }

    public void saveData() {
        // save to vets.txt
    }

    // helper functions
    private void throwError(String error) {
        view.displayError(error);
    }
}
