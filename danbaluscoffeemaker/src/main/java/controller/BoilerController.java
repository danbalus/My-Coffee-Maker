package controller;

import javax.swing.*;

import model.components.boiler.Boiler;
import service.boiler.BoilerService;
import view.CoffeeMakerGUI;

public class BoilerController {
    private BoilerService boilerService;
    private CoffeeMakerGUI view;
    private Boiler boiler;
    private int cupsOfWater;

    public BoilerController(BoilerService boilerService, CoffeeMakerGUI view, Boiler boiler) {
        this.boilerService = boilerService;
        this.view = view;
        this.boiler = boiler;
    }

    public void controlWaterComboBox() {
        view.getWaterComboBox().addActionListener(e -> {
            JComboBox<String> combo = (JComboBox<String>) e.getSource();
            String selectedWaterOption = (String) combo.getSelectedItem();

            assert selectedWaterOption != null;
            switch (selectedWaterOption) {
                case "1":
                    System.out.println("1");
                    cupsOfWater = 1;
                    break;
                case "2":
                    System.out.println("2");
                    cupsOfWater = 2;
                    break;
                case "3":
                    System.out.println("3");
                    cupsOfWater = 3;
                    break;
                case "4":
                    System.out.println("4");
                    cupsOfWater = 4;
                    break;
                case "5":
                    System.out.println("5");
                    cupsOfWater = 5;
                    break;
                case "6":
                    System.out.println("6");
                    cupsOfWater = 6;
                    break;
                case "7":
                    System.out.println("7");
                    cupsOfWater = 7;
                    break;
                case "8":
                    System.out.println("8");
                    cupsOfWater = 8;
                    break;
                case "9":
                    System.out.println("9");
                    cupsOfWater = 9;
                    break;
                case "10":
                    System.out.println("10");
                    cupsOfWater = 10;
                    break;
                case "11":
                    System.out.println("11");
                    cupsOfWater = 11;
                    break;
                case "12":
                    System.out.println("12");
                    cupsOfWater = 12;
                    break;
            }
        });
    }

    public void controlAddWaterButton() {
        view.getAddWaterButton().addActionListener(e -> {
            System.out.println("addWaterButton");
            if (cupsOfWater < 1 || cupsOfWater == 1) {
                cupsOfWater = 1;
                view.writeInTextArea("Adding " + cupsOfWater + " cup of water...");
            } else {
                view.writeInTextArea("Adding " + cupsOfWater + " cups of water...");
            }

            double cupsOfWaterInBoiler = boilerService.addCupsOfWater(cupsOfWater);
            cupsOfWaterInBoiler = Math.floor(cupsOfWaterInBoiler * 100) / 100;

            if (cupsOfWaterInBoiler == 1) {
                view.writeInTextArea("Boiler have " + cupsOfWaterInBoiler + " cup of water");
                view.writeInTextArea("Water cups: " + Math.floor(boilerService.getCupsOfWaterFromBoiler() * 100) / 100 + "");

            } else {
                view.writeInTextArea("Boiler have " + cupsOfWaterInBoiler + " cups of water");
            }
        });
    }
}
