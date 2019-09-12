package model.components.light;

import model.hardwareapi.IndicatorLightAPI;

public class IndicatorLight implements IndicatorLightAPI {

    private int indicatorLightStatus; // ON or OFF

    public IndicatorLight() {
        this.indicatorLightStatus = IndicatorLightAPI.INDICATOR_OFF;
    }

    @Override
    public void setIndicatorState(int indicatorState) {
        this.indicatorLightStatus = indicatorState;
    }

    public int getIndicatorLightStatus() {
        return this.indicatorLightStatus;
    }
}
