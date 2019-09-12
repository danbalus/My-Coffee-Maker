package controller;

import java.util.List;

import model.ReturnCode;
import service.brewbutton.BrewButtonService;
import view.CoffeeMakerGUI;

import static model.ReturnCode.BOILER_EMPTY_CODE;
import static model.ReturnCode.BOILER_OFF_CODE;
import static model.ReturnCode.BREW_BUTTON_PUSHED_AGAIN_CODE;
import static model.ReturnCode.BREW_BUTTON_PUSHED_CODE;
import static model.ReturnCode.WARMER_EMPTY_CODE;

public class BrewButtonController {

    private BrewButtonService brewButtonService;
    private CoffeeMakerGUI view;


    public BrewButtonController(BrewButtonService brewButtonService, CoffeeMakerGUI view) {
        this.brewButtonService = brewButtonService;
        this.view = view;

    }

    public void controlBrewButton() {
        view.getStartBrewButton().addActionListener(e -> {
            System.out.println("startBrewButton");
            List<ReturnCode> statusCodes = brewButtonService.turnOnTheBrewButton();
            for (ReturnCode status : statusCodes) {
                if (status == BREW_BUTTON_PUSHED_CODE) {
                    view.writeInTextArea("Valve closed");
                    view.writeInTextArea("Indicator off");
                    view.writeInTextArea("Brew button pushed");
                    break;
                }
                if (status == BOILER_OFF_CODE) {
                    view.writeInTextArea("Boiler is OFF");
                }
                if (status == BOILER_EMPTY_CODE) {
                    view.writeInTextArea("Boiler is EMPTY");
                }
                if (status == WARMER_EMPTY_CODE) {
                    view.writeInTextArea("Pot is not placed");
                }
                if (status == BREW_BUTTON_PUSHED_AGAIN_CODE) {
                    view.writeInTextArea("The button is already pressed.");
                }
            }
        });
    }
}




