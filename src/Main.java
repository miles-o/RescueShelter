import controllers.Controller;
import models.Animals;
import models.Vets;
import models.animals.*;
import models.vets.*;
import views.CLIView;

public class Main {
    public static void main(String[] args) {
        Animals animals = new Animals();
        Vets vets = new Vets();
        CLIView view = new CLIView();
        Controller controller = new Controller(vets, animals, view);
    }
}
