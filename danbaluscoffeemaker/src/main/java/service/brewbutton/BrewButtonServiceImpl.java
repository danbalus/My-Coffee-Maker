package service.brewbutton;


import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import model.ReturnCode;
import model.components.boiler.Boiler;
import model.components.buttons.BrewButton;
import model.components.light.IndicatorLight;
import model.components.plate.WarmerPlate;
import model.components.valve.ReliefValve;
import model.hardwareapi.BoilerAPI;
import model.hardwareapi.BrewButtonAPI;
import model.hardwareapi.IndicatorLightAPI;
import model.hardwareapi.ReliefValveAPI;
import model.hardwareapi.WarmerPlateAPI;

import static model.ReturnCode.BOILER_EMPTY_CODE;
import static model.ReturnCode.BOILER_OFF_CODE;
import static model.ReturnCode.BREW_BUTTON_PUSHED_AGAIN_CODE;
import static model.ReturnCode.BREW_BUTTON_PUSHED_CODE;
import static model.ReturnCode.WARMER_EMPTY_CODE;

public class BrewButtonServiceImpl implements BrewButtonService {

    private BrewButton brewButton;
    private Boiler boiler;
    private ReliefValve reliefValve;
    private IndicatorLight indicatorLight;
    private WarmerPlate warmerPlate;

    public BrewButtonServiceImpl(BrewButton brewButton, Boiler boiler, ReliefValve reliefValve, IndicatorLight indicatorLight, WarmerPlate warmerPlate) {
        this.brewButton = brewButton;
        this.boiler = boiler;
        this.reliefValve = reliefValve;
        this.indicatorLight = indicatorLight;
        this.warmerPlate = warmerPlate;
    }

    public void resetBrewButtonStatus() {
        brewButton.setBrewButtonStatus(BrewButtonAPI.BREW_BUTTON_NOT_PUSHED);
    }

    public BrewButton getBrewButton() {
        return brewButton;
    }

    @Override
    public List<ReturnCode> turnOnTheBrewButton() {
        List<ReturnCode> returnCodes = new ArrayList<>();
        if (boiler.getBoilerState() == BoilerAPI.BOILER_OFF &&
                boiler.getBoilerStatus() == BoilerAPI.BOILER_NOT_EMPTY &&
                warmerPlate.getWarmerPlateStatus() != WarmerPlateAPI.WARMER_EMPTY &&
                brewButton.getBrewButtonStatus() == BrewButtonAPI.BREW_BUTTON_NOT_PUSHED) {
            reliefValve.setReliefValveState(ReliefValveAPI.VALVE_CLOSED);
            indicatorLight.setIndicatorState(IndicatorLightAPI.INDICATOR_OFF);
            boiler.setBoilerState(BoilerAPI.BOILER_ON);
            brewButton.setBrewButtonStatus(BrewButtonAPI.BREW_BUTTON_PUSHED);
            returnCodes.add(BREW_BUTTON_PUSHED_CODE);
        } else {
            if (boiler.getBoilerState() == BoilerAPI.BOILER_OFF) {
                returnCodes.add(BOILER_OFF_CODE);
            }
            if (boiler.getBoilerStatus() == BoilerAPI.BOILER_EMPTY) {
                returnCodes.add(BOILER_EMPTY_CODE);
            }
            if (warmerPlate.getWarmerPlateStatus() == WarmerPlateAPI.WARMER_EMPTY) {
                returnCodes.add(WARMER_EMPTY_CODE);
            }
            if (brewButton.getBrewButtonStatus() == BrewButtonAPI.BREW_BUTTON_PUSHED) {
                returnCodes.add(BREW_BUTTON_PUSHED_AGAIN_CODE);
            }
        }
        System.out.println(returnCodes.toString());
        return returnCodes;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Variation of " + evt.getPropertyName());
        System.out.println("\t(" + evt.getOldValue() +
                " -> " + evt.getNewValue() + ")");
        System.out.println("Property in object " + evt.getSource());
    }
}

