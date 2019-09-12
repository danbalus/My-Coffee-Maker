package model.hardwareapi;

public interface BoilerAPI {
    /**
     * This function turns the heating element in the boiler
     * on or off.
     */
    void setBoilerState(int boilerStatus);

    int BOILER_ON = 0;
    int BOILER_OFF = 1;

    /**
     * This function returns the status of the boiler switch.
     * The boiler switch is a float switch that detects if
     * there is more than 1/2 cup of water in the boiler.
     */
    int getBoilerStatus();

    int BOILER_EMPTY = 0;
    int BOILER_NOT_EMPTY = 1;
}
