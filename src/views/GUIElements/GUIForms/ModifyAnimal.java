package views.GUIElements.GUIForms;

import controllers.Controller;
import models.animals.Animal;
import views.GUIView;
import views.View;

import javax.swing.*;
import java.util.ArrayList;

public class ModifyAnimal {
    private JPanel panel;
    private JTextField tfId;
    private JTextField tfName;
    private JTextField tfAge;
    private JComboBox cbFamily;
    private JComboBox cbVet;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JComboBox cbGender;
    private JLabel familyLabel;
    private JTextField tfFamily;
    private JLabel vetLabel;
    private JLabel desexedLabel;
    private JLabel catFriendlyLabel;
    private JButton btnSave;
    private JButton btnCancel;
    private JComboBox cbDesexed;
    private JComboBox cbCatFriendly;
    private JComboBox cbAnimals;
    private View view;

    public ModifyAnimal(GUIView view, Controller controller) {
        ArrayList<Animal> animals = controller.getAnimalList();

        for (Animal animal : animals) {
            cbAnimal.addItem(animal.getId());
        }


        // on saveButton clicked
        //
        //     error = create new animal with attributes
        //     if (error == null) {
        //          delete old animal
        //          add new animal to animals
        //     } else {
        //          display error
        //          return
        //     }




    }

    public JPanel getPanel() {
        return panel;
    }
}
