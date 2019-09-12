package service.brewbutton;

import java.beans.PropertyChangeListener;
import java.util.List;

import model.ReturnCode;
import model.components.buttons.BrewButton;

public interface BrewButtonService extends PropertyChangeListener {
    List<ReturnCode> turnOnTheBrewButton();

    BrewButton getBrewButton();

    void resetBrewButtonStatus();

}
