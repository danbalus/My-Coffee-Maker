package service.warmerplate;

import java.beans.PropertyChangeListener;

public interface WarmerPlateService extends PropertyChangeListener {

    boolean turnWarmerPlateON();

    boolean turnWarmerPlateOFF();

    int placePot();

    int takePot();

    int getPotStatus();
}
