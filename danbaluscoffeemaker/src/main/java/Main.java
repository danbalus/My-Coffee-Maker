import controller.BoilerController;
import controller.BrewButtonController;
import controller.IndicatorLightController;
import controller.WarmerPlateController;
import model.components.boiler.Boiler;
import model.components.buttons.BrewButton;
import model.components.light.IndicatorLight;
import model.components.plate.WarmerPlate;
import model.components.valve.ReliefValve;
import service.boiler.BoilerService;
import service.boiler.BoilerServiceImpl;
import service.brewbutton.BrewButtonService;
import service.brewbutton.BrewButtonServiceImpl;
import service.indicatorlight.IndicatorLightService;
import service.indicatorlight.IndicatorLightServiceImpl;
import service.reliefvalve.ReliefValveService;
import service.reliefvalve.ReliefValveServiceImpl;
import service.warmerplate.WarmerPlateService;
import service.warmerplate.WarmerPlateServiceImpl;
import view.CoffeeMakerGUI;

public class Main {

    public static void main(String args[]) {

        CoffeeMakerGUI coffeeMakerGUI = new CoffeeMakerGUI();

        Boiler boiler = new Boiler();
        IndicatorLight indicatorLIght = new IndicatorLight();
        WarmerPlate warmerPlate = new WarmerPlate();
        BrewButton brewButton = new BrewButton();
        ReliefValve reliefValve = new ReliefValve();

        BoilerService boilerService = new BoilerServiceImpl(boiler);
        IndicatorLightService indicatorLightService = new IndicatorLightServiceImpl(
                indicatorLIght);
        WarmerPlateService warmerPlateService = new WarmerPlateServiceImpl(warmerPlate);
        BrewButtonService brewButtonService = new BrewButtonServiceImpl(brewButton, boiler, reliefValve, indicatorLIght, warmerPlate);
        ReliefValveService reliefValveService = new ReliefValveServiceImpl(reliefValve);

        boiler.addObserver(boilerService);
        warmerPlate.addObserver(warmerPlateService);

        coffeeMakerGUI.createCoffeeMaker();

        BoilerController boilerController = new BoilerController(boilerService, coffeeMakerGUI, boiler);
        boilerController.controlWaterComboBox();
        boilerController.controlAddWaterButton();

        IndicatorLightController indicatorLightController = new IndicatorLightController(indicatorLightService, coffeeMakerGUI, indicatorLIght);

        BrewButtonController brewButtonController = new BrewButtonController(brewButtonService, coffeeMakerGUI);
        brewButtonController.controlBrewButton();

        WarmerPlateController warmerPlateController = new WarmerPlateController(warmerPlateService, coffeeMakerGUI, warmerPlate);
        warmerPlateController.controlWarmerPlateButton();
        warmerPlateController.controlWarmerPlateComboBox();

        warmerPlateController.controlPotButton();
        warmerPlateController.controlPotComboBox();

        Simulation simulation = new Simulation(coffeeMakerGUI, boilerService, brewButtonService, indicatorLightService,
                reliefValveService, warmerPlateService);
        new Thread(simulation).start();
    }
}
