package views.GUIElements.GUIForms;

import controllers.Controller;
import models.animals.Animal;
import models.animals.Dog;
import models.vets.Vet;
import views.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class AddAnimal {
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
    private View view;

    public AddAnimal(View view, Controller controller) {
        this.view = view;
        ArrayList<Vet> vets = controller.getVetList();

        cbFamily.addItem("Dog");
        cbFamily.addItem("Other");

        cbGender.addItem("Female");
        cbGender.addItem("Male");

        cbDesexed.addItem("True");
        cbDesexed.addItem("False");

        cbCatFriendly.addItem("True");
        cbCatFriendly.addItem("False");

        for (Vet vet : vets) {
            cbVet.addItem(vet);
        }

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Animal animal;
                    Vet vet = new Vet("name", "11");

                    String id = tfId.getText();
                    String name = tfName.getText();
                    int age = Integer.parseInt((tfAge.getText()));
                    String gender = Objects.requireNonNull(cbGender.getSelectedItem()).toString();
                    String family;

                    if (Objects.requireNonNull(cbFamily.getSelectedItem()).toString().equals("Dog")) {
                        animal = new Dog(id, name, age, gender, vet, true, true, 1);
                    } else {
                        family = tfFamily.getText();
                        animal = new Animal(id, name, age, gender, family);
                    }

                    controller.addAnimal(animal);
                } catch (Exception ex) {
                    view.displayError(String.valueOf(ex));
                    return;
                }
                view.openMainMenu();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.openMainMenu();
            }
        });
        cbFamily.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbFamily.getSelectedItem().toString().equals("Other")) {
                    cbVet.setEnabled(false);
                    cbDesexed.setEnabled(false);
                    cbCatFriendly.setEnabled(false);
                    tfFamily.setEnabled(true);
                } else {
                    cbVet.setEnabled(true);
                    cbDesexed.setEnabled(true);
                    cbCatFriendly.setEnabled(true);
                    tfFamily.setEnabled(false);
                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
