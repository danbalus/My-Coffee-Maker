package model.components.boiler;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import lombok.Getter;
import lombok.Setter;
import model.hardwareapi.BoilerAPI;
import model.observer.SubjectObserver;

@Getter
@Setter
public class Boiler implements BoilerAPI, SubjectObserver {

    private PropertyChangeSupport pcs;
    private int boilerStatus; // EMPTY or NOT_EMPTY
    private int boilerState; // ON or OFF

    private static final String PROPERTY_NAME = "boilerState";

    public Boiler() {
        this.pcs = new PropertyChangeSupport(this);
        this.boilerState = BOILER_OFF;
    }

    public int getBoilerStatus() {
        return boilerStatus;
    }

    public void setBoilerStatus(int boilerStatus) {
        this.boilerStatus = boilerStatus;
        System.out.println("boiler status is: " + ((this.boilerStatus == BoilerAPI.BOILER_EMPTY) ? "empty" : "not empty"));
    }

    public int getBoilerState() {
        return boilerState;
    }

    public void setBoilerState(int boilerState) {
        int oldBoilerState = this.boilerState;
        this.boilerState = boilerState;
        pcs.firePropertyChange(PROPERTY_NAME, oldBoilerState, boilerState);
        System.out.println("boiler state is: " + ((this.boilerState == BoilerAPI.BOILER_ON) ? "on" : "off"));
    }

    public void addObserver(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(PROPERTY_NAME, l);
    }

}
