package views.GUIElements.GUIForms;
import views.GUIView;

import controllers.Controller;

import models.animals.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveAnimal{
    private JPanel panel;
    private JComboBox cbAnimals;
    private JLabel label;
    private JButton btnConfirm;
    private JButton btnCancel;
    private GUIView view;
    private Controller controller;


    public RemoveAnimal(GUIView view, Controller controller) {
        this.view = view;
        this.controller = controller;

        ArrayList<Animal> animals = controller.getAnimalList();

        if (animals.isEmpty()) {
            view.displayError("No animals to remove");
        }

        for (Animal animal : animals) {
            cbAnimals.addItem(animal.getId());
        }

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.removeAnimal(cbAnimals.getSelectedItem().toString());
                view.openMainMenu();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.openMainMenu();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
