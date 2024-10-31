package views.GUIElements.GUIForms;

import controllers.Controller;
import models.vets.Vet;
import views.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddVet {
    private JTextField tfName;
    private JTextField tfPhone;
    private JComboBox cbOrg;
    private JTextField tfOrg;
    private JButton saveButton;
    private JButton cancelButton;
    private JPanel panel;

    public AddVet(View view, Controller controller) {
        cbOrg.addItem("Yes");
        cbOrg.addItem("No");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vet vet;

                String name = tfName.getText();
                String phone = tfPhone.getText();
                if (cbOrg.getSelectedItem().toString().equals("No")) {
                    if (tfOrg.getText().equals("")) {
                        view.displayError("Vet organisation cannot be empty unless employed by shelter");
                        return;
                    } else {
                        vet = new Vet(name, phone, tfOrg.getText());
                    }
                } else {
                    vet = new Vet(name, phone);
                }

                controller.addVet(vet);
                view.openMainMenu();
            }
        });
        cbOrg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfOrg.setEnabled(!cbOrg.getSelectedItem().toString().equals("Yes"));
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
