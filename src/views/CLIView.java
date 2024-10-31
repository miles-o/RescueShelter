package views;

import models.animals.Animal;
import models.animals.Dog;
import models.vets.Vet;

public class CLIView extends View{
    private String mainMenu;
    private String newVetMenu;
    private String newAnimalMenu;
    private String removeVetMenu;
    private String removeAnimalMenu;
    private String modifyVetMenu;
    private String modifyAnimalMenu;
    private String reportViewerMenu;


    public CLIView() {
        mainMenu = """
                Select from functions:
                1 - Add vet
                2 - Add animal
                3 - Remove vet
                4 - Remove animal
                5 - Modify vet
                6 - Modify animal
                7 - Report viewer
                Q - Quit""";
//        newVetMenu = "New vet";
//        newAnimalMenu = "new animal menu";
//        removeVetMenu = "remove vet menu";
//        removeAnimalMenu = "remove animal menu";
//        modifyVetMenu = "modify vet menu";
//        modifyAnimalMenu = "modify animal menu";
        reportViewerMenu = """
                Select report:
                1 - All animals report
                2 - All vets report
                3 - High care fee dogs report
                4 - Cat friendly dog count
                Q - Quit to main menu
                """;
    }

    public void openMainMenu() {
        displayMenu(mainMenu);
        String input = System.console().readLine().toLowerCase();
        switch (input) {
            case "1" -> openNewVet();
            case "2" -> openNewAnimal();
            case "3" -> openRemoveVet();
            case "4" -> openRemoveAnimal();
            case "5" -> openModifyVet();
            case "6" -> openModifyAnimal();
            case "7" -> openReportViewer();
            case "q" -> System.exit(0);
            default -> super.displayError("Invalid input");
        }
    }

    public void openNewVet() {
        String name;
        String org = null;
        String phoneNumber;

        System.out.println("Enter vet name");
        name = System.console().readLine();

        do {
            System.out.println("Vet employed by shelter? y/n");
            switch (System.console().readLine()) {
                case "n" -> {
                    System.out.println("Enter vet organisation");
                    org = System.console().readLine();
                }
                case "y" -> org = "";
                default -> super.displayError("Invalid input");
            }
        } while (org == null);

        System.out.println("Enter phone number");
        phoneNumber = System.console().readLine();

        Vet vet = new Vet(name, org, phoneNumber);

        controller.addVet(vet);
    }

    public void openNewAnimal() {
        String id;
        String name;
        int age;
        String gender;
        String family;
        Animal animal;


        System.out.println("Enter animal ID");
        id = System.console().readLine();

        System.out.println("Enter animal name");
        name = System.console().readLine();

        while (true) {
            try {
                System.out.println("Enter animal age");
                age = Integer.parseInt(System.console().readLine());
                break;
            } catch (Exception e) {
                super.displayError("Age must be an integer");
            }
        }

        System.out.println("Enter animal gender");
        gender = System.console().readLine();


        System.out.println("Enter animal family");
        family = System.console().readLine();

        if (family.equalsIgnoreCase("dog")) {
            Vet vet;
            boolean desexed;
            boolean catFriendly;
            double careFees;

            while (true) {
                String vetReport = controller.getAllVetsReport();
                if (vetReport.equals("No vets currently stored")) {
                    super.displayError("Error: No vets currently stored\nDogs cannot exist without vet\nReturning to main menu");
                    return;
                } else {
                    System.out.println("Enter vet name");
                    System.out.println(vetReport);
                }
                String vetName = System.console().readLine();
                vet = controller.getVet(vetName);

                if (vet == null) {
                    super.displayError("Vet not found");
                } else {
                    break;
                }
            }


            System.out.println("Is dog desexed?");
            desexed = getBooleanInput();

            System.out.println("Is dog cat friendly?");
            catFriendly = getBooleanInput();


            while (true) {
                try {
                    System.out.println("Enter dogs care fees");
                    careFees = Double.parseDouble(System.console().readLine());
                    break;
                } catch (Exception e) {
                    super.displayError("Invalid input");
                }
            }

            animal = new Dog(id, name, age, gender, vet, desexed, catFriendly, careFees);
        } else {
            animal = new Animal(id, name, age, gender, family);
        }
        controller.addAnimal(animal);
    }

    public void openRemoveVet() {
        String vetReport = controller.getAllVetsReport();
        if (vetReport.equals("No vets currently stored")) {
            super.displayError("Error: No vets currently stored");
            return;
        } else {
            System.out.println("Enter vet name to remove");
            System.out.println(vetReport);
        }
        String vetName = System.console().readLine();

        controller.removeVet(vetName);
    }

    public void openRemoveAnimal() {
        String animalReport = controller.getAllAnimalsReport();
        if (animalReport.equals("No animals currently stored")) {
            super.displayError("Error: No animals currently stored");
            return;
        }
        System.out.println("Enter animal id to remove");
        System.out.println(animalReport);

        String animalName = System.console().readLine();

        controller.removeAnimal(animalName);
    }

    public void openModifyVet() {
        String vetReport = controller.getAllVetsReport();
        if (vetReport.equals("No vets currently stored")) {
            super.displayError("Error: No vets currently stored");
            return;
        }

        System.out.println("Enter vet name to modify");
        System.out.println(vetReport);

        String vetName = System.console().readLine();

        while (true) {
            System.out.println("Select attribute to modify:\n1 - Name\n2 - Organisation\n3 - Phone number");
            String attribute = System.console().readLine();
            switch (attribute) {
                case "1" -> {
                    System.out.println("Enter new name");
                    String newName = System.console().readLine();
                    controller.setVetName(vetName, newName);
                    return;
                }
                case "2" -> {
                    System.out.println("Enter new organisation");
                    String newOrganisation = System.console().readLine();
                    controller.setVetOrg(vetName, newOrganisation);
                    return;
                }
                case "3" -> {
                    System.out.println("Enter new phone number");
                    String newPhoneNumber = System.console().readLine();
                    controller.setVetPhone(vetName, newPhoneNumber);
                    return;
                }
                default -> super.displayError("Invalid input");
            }
        }
    }

    public void openModifyAnimal() {
        String animalReport = controller.getAllAnimalsReport();
        if (animalReport.equals("No animals currently stored")) {
            super.displayError("Error: No animals currently stored");
            return;
        }

        System.out.println("Enter animal id to remove");
        System.out.println(animalReport);

        String animalId = System.console().readLine();

        Animal animal = controller.getAnimal(animalId);

        if (animal instanceof Dog) {
            System.out.println("Select attribute to modify:\n1 - ID\n2 - Name\n3 - Age\n4 - Gender\n5 - Vet\n6 - Desexed\n7 - Cat friendly\n8 - Care fees");
            String attribute = System.console().readLine();
            switch (attribute) {
                case "1" -> {
                    System.out.println("Enter new id");
                    String newId = System.console().readLine();
                    controller.setAnimalId(animalId, newId);
                }
                case "2" -> {
                    System.out.println("Enter new name");
                    String newName = System.console().readLine();
                    controller.setAnimalName(animalId, newName);
                }
                case "3" -> {
                    while (true) {
                        try {
                            System.out.println("Enter new age");
                            int newAge = Integer.parseInt(System.console().readLine());
                            controller.setAnimalAge(animalId, newAge);
                            return;
                        } catch (Exception e) {
                            super.displayError("Invalid input");
                        }
                    }
                }
                case "4" -> {
                    System.out.println("Enter new gender");
                    String newGender = System.console().readLine();
                    controller.setAnimalGender(animalId, newGender);
                }
                case "5" -> {
                    while (true) {
                        String vetReport = controller.getAllVetsReport();

                        System.out.println("Enter vet name");
                        System.out.println(vetReport);
                        String vetName = System.console().readLine();
                        Vet vet = controller.getVet(vetName);

                        if (vet == null) {
                            super.displayError("Vet not found");
                        } else {
                            controller.setAnimalVet(animalId, vet);
                            break;
                        }
                    }
                }
                case "6" -> {
                    System.out.println("Is dog desexed?");
                    boolean desexed = getBooleanInput();
                    controller.setAnimalDesexed(animalId, desexed);

                }
                case "7" -> {
                    System.out.println("Is dog cat friendly?");
                    boolean catFriendly = getBooleanInput();
                    controller.setAnimalCatFriendly(animalId, catFriendly);
                }
                case "8" -> {
                    while (true) {
                        try {
                            System.out.println("Enter new care fees");
                            double careFees = Double.parseDouble(System.console().readLine());
                            controller.setAnimalCareFees(animalId, careFees);
                            break;
                        } catch (Exception e) {
                            super.displayError("Invalid input");
                        }
                    }
                }
                default -> super.displayError("Invalid input");
            }
        }else {
            System.out.println("Select attribute to modify:\n1 - ID\n2 - Name\n3 - Age\n4 - Gender\n5 - Family");
            String attribute = System.console().readLine();
            switch (attribute) {
                case "1" -> {
                    System.out.println("Enter new id");
                    String newId = System.console().readLine();
                    controller.setAnimalId(animalId, newId);
                }
                case "2" -> {
                    System.out.println("Enter new name");
                    String newName = System.console().readLine();
                    controller.setAnimalName(animalId, newName);
                }
                case "3" -> {
                    while (true) {
                        try {
                            System.out.println("Enter new age");
                            int newAge = Integer.parseInt(System.console().readLine());
                            controller.setAnimalAge(animalId, newAge);
                            return;
                        } catch (Exception e) {
                            super.displayError("Invalid input");
                        }
                    }
                }
                case "4" -> {
                    System.out.println("Enter new gender");
                    String newGender = System.console().readLine();
                    controller.setAnimalGender(animalId, newGender);
                }
                case "5" -> {
                    System.out.println("Enter family");
                    String newFamily = System.console().readLine();
                    controller.setAnimalFamily(animalId, newFamily);
                }
                default -> super.displayError("Invalid input");
            }
        }
    }

    public void openReportViewer() {
        displayMenu(reportViewerMenu);

        String input = System.console().readLine();
        String output = "";

        switch (input) {
            case "1" -> output = controller.getAllAnimalsReport();
            case "2" -> output = controller.getAllVetsReport();
            case "3" -> output = controller.getHighCareFeeDogsReport();
            case "4" -> output = controller.getCatFriendlyDogsReport();
            case "Q" -> openMainMenu();
            default -> {
                super.displayError("Invalid input");
                openReportViewer();
            }
        }
        System.out.println(output);
    }

    private boolean getBooleanInput() {
        while (true) {
            System.out.println("Y/n");

            String input = System.console().readLine();

            if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("n")) {
                return false;
            } else {
                super.displayError("Invalid input");
            }
        }
    }

    private void displayMenu(String menu) {
        System.out.println(menu);
    }
}
