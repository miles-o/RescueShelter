package views.GUIElements.GUIForms;

import views.GUIView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu{
    private JPanel panel;
    private JButton addAnimal;
    private JButton removeAnimal;
    private JButton removeVet;
    private JButton addVet;
    private JButton save;
    private JButton modifyAnimal;
    private JButton modifyVet;
    private JButton saveAndQuit;
    private JButton reportViewer;
    private GUIView view;

    public MainMenu(GUIView view) {
        this.view = view;
        addAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.openAddAnimal();
            }
        });
        removeAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.openRemoveAnimal();
            }
        });
        modifyAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.openModifyAnimal();
            }
        });
        addVet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.openAddVet();
            }
        });
        removeVet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.openRemoveVet();
            }
        });
        modifyVet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.openModifyVet();
            }
        });
        reportViewer.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               view.openReportViewer();
           }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveAndQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
    }
    public JPanel getPanel() {
        return panel;
    }
}
