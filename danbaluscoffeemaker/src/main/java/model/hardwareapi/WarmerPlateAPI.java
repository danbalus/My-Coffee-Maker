package model.hardwareapi;

public interface WarmerPlateAPI {

    /**
     * This function returns the status of the warmer-plate
     * sensor. This sensor detects the presence of the pot
     * and whether it has coffee in it.
     */
    int getWarmerPlateStatus();

    int WARMER_EMPTY = 0;
    int POT_EMPTY = 1;
    int POT_NOT_EMPTY = 2;

    /**
     * This function turns the heating element in the warmer
     * plate on or off.
     */
    void setWarmerPlateState(int warmerPlateState);

    int WARMER_ON = 0;
    int WARMER_OFF = 1;

}
