package views;

import controllers.Controller;

public abstract class View {
    protected Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void displayError(String errorMessage) {
        String divider = "******************************";
        System.out.println(divider);
        System.out.println(errorMessage);
        System.out.println(divider);
    }

    public void displayString(String string) {
        System.out.println(string);
    }

    public void openMainMenu() {
        System.out.println("Please define in child class tehe");
    }
}
