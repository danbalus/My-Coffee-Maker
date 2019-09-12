package model.components.plate;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import lombok.Getter;
import lombok.Setter;
import model.hardwareapi.WarmerPlateAPI;
import model.observer.SubjectObserver;

@Setter
@Getter
public class WarmerPlate implements WarmerPlateAPI, SubjectObserver {

    private static final String PROPERTY_NAME = "warmerPlateState";
    private int warmerPlateState; // heater: ON or OFF


    private int warmerPlateStatus; // sensor: WARMER_EMPTY or POT_EMPTY or POT NOT_EMPTY
    private PropertyChangeSupport pcs;

    public WarmerPlate() {
        this.pcs = new PropertyChangeSupport(this);
        warmerPlateState = WarmerPlateAPI.WARMER_OFF;
    }

    public int getWarmerPlateState() {
        return warmerPlateState;
    }

    @Override
    public void setWarmerPlateState(int warmerPlateState) {
        int oldWarmerPlateState = this.warmerPlateState;
        this.warmerPlateState = warmerPlateState;
        pcs.firePropertyChange(PROPERTY_NAME, oldWarmerPlateState, warmerPlateState);
        System.out.println("Warmer Plate state is: " + ((this.warmerPlateState == WarmerPlateAPI.WARMER_ON) ? "on" : "off"));
    }

    @Override
    public int getWarmerPlateStatus() {
        return warmerPlateStatus;
    }

    public void setWarmerPlateStatus(int warmerPlateStatus) {
        this.warmerPlateStatus = warmerPlateStatus;
    }

    @Override
    public void addObserver(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(PROPERTY_NAME, l);
    }
}