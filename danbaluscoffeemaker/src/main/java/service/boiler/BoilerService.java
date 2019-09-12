package service.boiler;

import java.beans.PropertyChangeListener;

import model.components.boiler.Boiler;


public interface BoilerService extends PropertyChangeListener {
    double addCupsOfWater(double cupsOfWater);

    Boiler getBoiler();

    double getCupsOfWaterFromBoiler();

    void setCupsOfWater(int i);
}

