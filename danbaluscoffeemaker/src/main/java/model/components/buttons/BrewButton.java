package model.components.buttons;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import model.hardwareapi.BrewButtonAPI;
import model.observer.SubjectObserver;

public class BrewButton implements BrewButtonAPI, SubjectObserver {

    private PropertyChangeSupport pcs;
    private int brewButtonStatus; // PUSHED or NOT_PUSHED

    private static final String PROPERTY_NAME = "brewButtonStatus";

    public BrewButton() {
        this.pcs = new PropertyChangeSupport(this);
        this.brewButtonStatus = BrewButtonAPI.BREW_BUTTON_NOT_PUSHED;
    }

    @Override
    public int getBrewButtonStatus() {
        return brewButtonStatus;
    }

    public void setBrewButtonStatus(int brewButtonStatus) {
        int oldbrewButtonStatus = this.brewButtonStatus;
        this.brewButtonStatus = brewButtonStatus;
        pcs.firePropertyChange(PROPERTY_NAME, oldbrewButtonStatus, brewButtonStatus);
    }

    @Override
    public void addObserver(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(PROPERTY_NAME, l);
    }
}
