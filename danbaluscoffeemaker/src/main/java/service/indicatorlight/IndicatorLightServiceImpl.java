package service.indicatorlight;

import model.components.light.IndicatorLight;
import model.hardwareapi.IndicatorLightAPI;

public class IndicatorLightServiceImpl implements IndicatorLightService {


    private IndicatorLight indicatorLight;

    public int getIndicatorLightStatus() {
        return indicatorLight.getIndicatorLightStatus();
    }

    public IndicatorLightServiceImpl(IndicatorLight indicatorLight) {
        this.indicatorLight = indicatorLight;
    }

    @Override
    public void turnOnLight() {
        indicatorLight.setIndicatorState(IndicatorLightAPI.INDICATOR_ON);
    }

    @Override
    public void turnOffLight() {
        indicatorLight.setIndicatorState(IndicatorLightAPI.INDICATOR_OFF);
    }
}
