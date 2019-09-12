package service.warmerplate;

import java.beans.PropertyChangeEvent;

import model.components.plate.WarmerPlate;
import model.hardwareapi.WarmerPlateAPI;


public class WarmerPlateServiceImpl implements WarmerPlateService {

    private WarmerPlate warmerPlate;

    public WarmerPlateServiceImpl(WarmerPlate warmerPlate) {
        this.warmerPlate = warmerPlate;
    }

    public int getPotStatus() {
        return warmerPlate.getWarmerPlateStatus();
    }

    @Override
    public boolean turnWarmerPlateON() {
        if (warmerPlate.getWarmerPlateState() == WarmerPlateAPI.WARMER_ON) {
            return false; //already on
        } else {
            warmerPlate.setWarmerPlateState(WarmerPlateAPI.WARMER_ON);
        }
        return true;
    }

    @Override
    public boolean turnWarmerPlateOFF() {
        if (warmerPlate.getWarmerPlateState() == WarmerPlateAPI.WARMER_OFF) {
            return false; //already off
        } else {
            warmerPlate.setWarmerPlateState(WarmerPlateAPI.WARMER_OFF);
        }
        return true;
    }

    @Override
    public int placePot() {
        if (warmerPlate.getWarmerPlateStatus() == WarmerPlateAPI.WARMER_EMPTY) {
            warmerPlate.setWarmerPlateStatus(WarmerPlateAPI.POT_EMPTY);
            return 1;
        } else if (warmerPlate.getWarmerPlateStatus() == WarmerPlateAPI.POT_EMPTY ||
                warmerPlate.getWarmerPlateStatus() == WarmerPlateAPI.POT_NOT_EMPTY) {
            return 0;
        }
        return 2;
    }

    @Override
    public int takePot() {
        if (warmerPlate.getWarmerPlateStatus() == WarmerPlateAPI.WARMER_EMPTY) {
            return 0;
        } else if (warmerPlate.getWarmerPlateStatus() == WarmerPlateAPI.POT_EMPTY ||
                warmerPlate.getWarmerPlateStatus() == WarmerPlateAPI.POT_NOT_EMPTY) {
            warmerPlate.setWarmerPlateStatus(WarmerPlateAPI.WARMER_EMPTY);
            return 1;
        }
        return 2;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Variation of " + evt.getPropertyName());
        System.out.println("\t(" + evt.getOldValue() +
                " -> " + evt.getNewValue() + ")");
        System.out.println("Property in object " + evt.getSource().toString());
    }
}




