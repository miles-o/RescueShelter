package views;

import views.GUIElements.GUIDialogs.Error;
import views.GUIElements.GUIForms.*;

import javax.swing.*;
import java.awt.*;

public class GUIView extends View {
    private JFrame frame;


    public GUIView(){
        frame = new JFrame("app");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(600, 400));
    }

    @Override
    public void begin() {
        openMainMenu();
        frame.setVisible(true);
    }

    public void openAddAnimal() {
        setPane(new AddAnimal(this, controller).getPanel());
    }

    public void openAddVet() {
        setPane(new AddVet(this, controller).getPanel());
    }

    public void openMainMenu() {
        setPane(new MainMenu(this).getPanel());
    }

    public void openModifyAnimal() {
        setPane(new ModifyAnimal(this, controller).getPanel());
    }

    public void openModifyVet() {
        setPane(new ModifyVet(this, controller).getPanel());
    }


    public void openRemoveAnimal() {
        setPane(new RemoveAnimal(this, controller).getPanel());
    }

    public void openRemoveVet() {
        setPane(new RemoveVet(this, controller).getPanel());
    }

    public void openReportViewer() {
        setPane(new ReportViewer(this, controller).getPanel());
    }

    public void setPane(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }


    @Override
    public void displayError(String errorMessage) {
        Error dialog = new Error(errorMessage);
        dialog.pack();
        dialog.setVisible(true);
    }



}
