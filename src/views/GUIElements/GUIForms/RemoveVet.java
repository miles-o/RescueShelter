package views.GUIElements.GUIForms;

import controllers.Controller;
import models.vets.Vet;
import views.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveVet {
    private JComboBox cbVet;
    private JButton saveButton;
    private JButton cancelButton;
    private JPanel panel;


    public RemoveVet(View view, Controller controller) {

        ArrayList<Vet> vets = controller.getVetList();

        if (vets.isEmpty()) {
            view.displayError("No vets to remove");
        }

        for (Vet vet : vets) {
            cbVet.addItem(vet.getName());
        }

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.removeVet(cbVet.getSelectedItem().toString());
                view.openMainMenu();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
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
