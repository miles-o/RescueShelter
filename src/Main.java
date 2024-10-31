import controllers.Controller;
import models.Animals;
import models.Vets;
import models.animals.*;
import models.vets.*;
import views.CLIView;
import views.GUIView;
import views.View;

public class Main {
    public static void main(String[] args) {
        Animals animals = new Animals();
        Vets vets = new Vets();
        View view = selectView();
        Controller controller = new Controller(vets, animals, view);
        controller.begin();
    }

    public static View selectView() {
        while (true) {
            System.out.println("Select view for program to run in:\n1. GUI\n2. CLI\n");
            String input = System.console().readLine();

            if (input.equals("1")) {
                return new GUIView();
            } else if (input.equals("2")) {
                return new CLIView();
            } else {
                System.out.println("Invalid selection. Try again.");
            }
        }
    }
}
