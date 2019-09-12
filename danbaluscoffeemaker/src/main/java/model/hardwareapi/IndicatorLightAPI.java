package model.hardwareapi;

public interface IndicatorLightAPI {
    /**
     * This function turns the indicator light on or off.
     * The indicator light should be turned on at the end
     * of the brewing cycle. It should be turned off when
     * the user presses the brew button.
     */
    void setIndicatorState(int indicatorState);

    int INDICATOR_ON = 0;
    int INDICATOR_OFF = 1;
}
