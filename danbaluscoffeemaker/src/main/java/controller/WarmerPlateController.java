package controller;

import javax.swing.*;

import model.components.plate.WarmerPlate;
import service.warmerplate.WarmerPlateService;
import view.CoffeeMakerGUI;

public class WarmerPlateController {

    private WarmerPlateService warmerPlateService;
    private CoffeeMakerGUI view;
    private WarmerPlate warmerPlate;
    private int warmerPlateStatus = 1;
    private int potStatus = 1;

    public WarmerPlateController(WarmerPlateService warmerPlateService, CoffeeMakerGUI view, WarmerPlate warmerPlate) {
        this.warmerPlateService = warmerPlateService;
        this.view = view;
        this.warmerPlate = warmerPlate;
    }

    public void controlWarmerPlateComboBox() {
        view.getWarmerPlateComboBox().addActionListener(e -> {
            JComboBox<String> combo = (JComboBox<String>) e.getSource();
            String selectedWarmerPlateOption = (String) combo.getSelectedItem();

            assert selectedWarmerPlateOption != null;
            switch (selectedWarmerPlateOption) {
                case "ON Warmer Plate":
                    System.out.println("ON Warmer Plate");
                    warmerPlateStatus = 1;
                    break;
                case "OFF Warmer Plate":
                    System.out.println("OFF Warmer Plate");
                    warmerPlateStatus = 0;
                    break;
            }
        });
    }

    public void controlWarmerPlateButton() {
        view.getWarmerPlateButton().addActionListener(e -> {
            System.out.println("warmerPlateButton");
            if (warmerPlateStatus == 1) {
                view.writeInTextArea("Turning ON Warmer Plate");
                boolean status = warmerPlateService.turnWarmerPlateON();
                if (status) {
                    view.writeInTextArea("Warmer plate is ON");
                } else {
                    view.writeInTextArea("Warmer plate is already ON");
                }
            } else {
                view.writeInTextArea("Turning OFF Warmer Plate");
                boolean status = warmerPlateService.turnWarmerPlateOFF();
                if (status) {
                    view.writeInTextArea("Warmer plate is OFF");
                } else {
                    view.writeInTextArea("Warmer plate is already OFF");
                }
            }
        });
    }

    public void controlPotComboBox() {
        view.getPotComboBox().addActionListener(e -> {
            JComboBox<String> combo = (JComboBox<String>) e.getSource();
            String selectedPotOption = (String) combo.getSelectedItem();

            assert selectedPotOption != null;
            switch (selectedPotOption) {
                case "Place Pot":
                    System.out.println("Place pot...");
                    potStatus = 1;
                    break;
                case "Take Pot":
                    System.out.println("Take Pot...");
                    potStatus = 0;
                    break;
            }
        });
    }

    public void controlPotButton() {
        view.getPotButton().addActionListener(e -> {
            System.out.println("potButton");
            if (potStatus == 1) {
                view.writeInTextArea("Placing Pot");
                int status = warmerPlateService.placePot();
                if (status == 1) {
                    view.writeInTextArea("Pot Placed");
                } else if (status == 0) {
                    view.writeInTextArea("Pot is already Placed");
                }
            } else {
                view.writeInTextArea("Taking Pot");
                int status = warmerPlateService.takePot();
                if (status == 1) {
                    view.writeInTextArea("Pot Taken");
                } else if (status == 0) {
                    view.writeInTextArea("Pot is already Taken");
                }
            }
        });
    }
}

