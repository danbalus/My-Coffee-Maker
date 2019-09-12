package view;

import java.awt.*;

import javax.swing.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeMakerGUI {


    private JComboBox waterComboBox;
    private JPanel panel1;
    private JTextArea actionsTextArea;
    private JButton startBrewButton;
    private JProgressBar progressBar;
    private JButton addWaterButton;
    private JComboBox potComboBox;
    private JButton potButton;
    private JLabel waterLabel;
    private JComboBox warmerPlateComboBox;
    private JButton warmerPlateButton;

    public JComboBox getWaterComboBox() {
        return waterComboBox;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JTextArea getActionsTextArea() {
        return actionsTextArea;
    }

    public JButton getStartBrewButton() {
        return startBrewButton;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public JButton getAddWaterButton() {
        return addWaterButton;
    }

    public JComboBox getPotComboBox() {
        return potComboBox;
    }

    public JButton getPotButton() {
        return potButton;
    }

    public JLabel getWaterLabel() {
        return waterLabel;
    }

    public JComboBox getWarmerPlateComboBox() {
        return warmerPlateComboBox;
    }

    public JButton getWarmerPlateButton() {
        return warmerPlateButton;
    }


    public CoffeeMakerGUI() {

        waterQuantityOptionsInitialization();
        textAreaOptionsInitialization();
        progressBarInitialization();
        potOptionsInitialization();
        warmerPlateOptionsInitialization();
    }

    private void warmerPlateOptionsInitialization() {
        warmerPlateComboBox.addItem("ON Warmer Plate");
        warmerPlateComboBox.addItem("OFF Warmer Plate");
    }

    private void potOptionsInitialization() {
        potComboBox.addItem("Place Pot");
        potComboBox.addItem("Take Pot");
    }

    private void progressBarInitialization() {
        progressBar.setValue(100);
        progressBar.setStringPainted(true);
    }

    private void textAreaOptionsInitialization() {
        actionsTextArea.setEditable(false);
        actionsTextArea.setFont(new Font("Serif", Font.ITALIC, 12));
    }

    private void waterQuantityOptionsInitialization() {
        waterComboBox.addItem("1");
        waterComboBox.addItem("2");
        waterComboBox.addItem("3");
        waterComboBox.addItem("4");
        waterComboBox.addItem("5");
        waterComboBox.addItem("6");
        waterComboBox.addItem("7");
        waterComboBox.addItem("8");
        waterComboBox.addItem("9");
        waterComboBox.addItem("10");
        waterComboBox.addItem("11");
        waterComboBox.addItem("12");
    }

    public void writeInTextArea(String text) {
        actionsTextArea.append(text);
        actionsTextArea.append("\n");
    }

    public void createCoffeeMaker() {
        JFrame frame = new JFrame("Coffee Maker");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setContentPane(scrollPane);
        //frame.setSize(555,555);
        frame.pack();
        frame.setVisible(true);

    }
}


