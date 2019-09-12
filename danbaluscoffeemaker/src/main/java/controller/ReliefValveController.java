package controller;

import model.components.valve.ReliefValve;
import service.reliefvalve.ReliefValveService;
import view.CoffeeMakerGUI;

public class ReliefValveController {
    private ReliefValveService reliefValveService;
    private CoffeeMakerGUI view;
    private ReliefValve reliefValve;

    public ReliefValveController(ReliefValveService reliefValveService, CoffeeMakerGUI view, ReliefValve reliefValve) {
        this.reliefValveService = reliefValveService;
        this.view = view;
        this.reliefValve = reliefValve;
    }
}
