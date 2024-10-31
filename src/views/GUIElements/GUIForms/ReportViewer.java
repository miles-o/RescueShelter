package views.GUIElements.GUIForms;

import controllers.Controller;
import views.GUIView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportViewer {
    private JPanel panel;
    private JComboBox comboBox;
    private JTextPane textPane;
    private JButton doneButton;

    public ReportViewer(GUIView view, Controller controller) {
        comboBox.addItem("All vets");
        comboBox.addItem("All animals");
        comboBox.addItem("Dogs with high care fees");
        comboBox.addItem("Cat friendly dogs");


        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String report;
                int index = comboBox.getSelectedIndex();

                switch (index) {
                    case 0 -> report = controller.getAllVetsReport();
                    case 1 -> report = controller.getAllAnimalsReport();
                    case 2 -> report = controller.getHighCareFeeDogsReport();
                    case 3 -> report = controller.getCatFriendlyDogsReport();
                    default -> report = "No report selected";
                }

                textPane.setText(report);
            }
        });
        doneButton.addActionListener(new ActionListener() {
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
