package models;

import models.animals.Animal;
import models.vets.Vet;

import java.util.ArrayList;

public class Vets {
    private ArrayList<Vet> vets = new ArrayList<>();

    public Vet getVet(String name) {
        for (Vet vet : vets) {
            if (vet.getName().equals(name)) {
                return vet;
            }
        }
        return null;
    }

    public ArrayList<Vet> getVetList() {
        return vets;
    }

    public String addVet(Vet vet) {
        for (Vet v : vets) {
            if (v.getName().equals(vet.getName())) {
                return "Error adding vet: Vet with name: \"" + vet.getName() + "\" already exists";
            }
        }
        vets.add(vet);
        return null;
    }

    public String removeVet(String name) {
        Vet vetToRemove = null;
        for (Vet vet : vets) {
            if (name.equals(vet.getName())) {
                vetToRemove = vet;
            }
        }
        if (vetToRemove != null) {
            vets.remove(vetToRemove);
            return null;
        } else {
            return "Error removing animal: Vet with name: \"" + name + "\" not found";
        }
    }

    public String setVetName(String oldName, String newName) {
        Vet vet = null;
        for (Vet v : vets) {
            if (v.getName().equals(oldName)) {
                vet = v;
            }
        }
        if (vet == null) {
            return "Vet not found";
        }  else {
            vet.setName(newName);
            return null;
        }
    }

    public String setVetOrg(String vetName, String org) {
        Vet vet = null;
        for (Vet v : vets) {
            if (v.getName().equals(vetName)) {
                vet = v;
            }
        }
        if (vet == null) {
            return "Vet not found";
        }  else {
            vet.setOrganisation(org);
            return null;
        }
    }

    public String setVetPhone(String vetName, String newNumber) {
        Vet vet = null;
        for (Vet v : vets) {
            if (v.getName().equals(vetName)) {
                vet = v;
            }
        }
        if (vet == null) {
            return "Vet not found";
        }  else {
            vet.setPhoneNumber(newNumber);
            return null;
        }
    }

    public String getReport() {
        if (!vets.isEmpty()) {
            StringBuilder report = new StringBuilder();
            report.append("\nVets currently in system:");
            for (Vet vet : vets) {
                report.append("\n").append(vet.reportDetails());
            }
            report.append("\n");
            return report.toString();
        } else {
            return "No vets currently stored";
        }
    }
}
