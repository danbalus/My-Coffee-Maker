package controller;

import model.components.light.IndicatorLight;
import service.indicatorlight.IndicatorLightService;
import view.CoffeeMakerGUI;

public class IndicatorLightController {
    private IndicatorLightService indicatorLightService;
    private CoffeeMakerGUI view;
    private IndicatorLight indicatorLight;

    public IndicatorLightController(IndicatorLightService indicatorLightService, CoffeeMakerGUI view, IndicatorLight indicatorLight) {
        this.indicatorLightService = indicatorLightService;
        this.view = view;
        this.indicatorLight = indicatorLight;
    }
}
