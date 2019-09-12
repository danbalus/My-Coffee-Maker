import model.hardwareapi.BoilerAPI;
import model.hardwareapi.BrewButtonAPI;
import model.hardwareapi.WarmerPlateAPI;
import service.boiler.BoilerService;
import service.brewbutton.BrewButtonService;
import service.indicatorlight.IndicatorLightService;
import service.reliefvalve.ReliefValveService;
import service.warmerplate.WarmerPlateService;
import view.CoffeeMakerGUI;

public class Simulation implements Runnable {

    private CoffeeMakerGUI view;
    private BoilerService boilerService;
    private BrewButtonService brewButtonService;
    private IndicatorLightService indicatorLightService;
    private ReliefValveService reliefValveService;
    private WarmerPlateService warmerPlateService;
    final private static int SECONDS = 100;
    private int simulationTime = SECONDS;
    private int oldStatePot = -1;
    private int newStatePot = -1;

    public Simulation(CoffeeMakerGUI view, BoilerService boilerService, BrewButtonService brewButtonService, IndicatorLightService indicatorLightService,
                      ReliefValveService reliefValveService, WarmerPlateService warmerPlateService) {
        this.view = view;
        this.boilerService = boilerService;
        this.brewButtonService = brewButtonService;
        this.indicatorLightService = indicatorLightService;
        this.reliefValveService = reliefValveService;
        this.warmerPlateService = warmerPlateService;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Running... Waiting for user input");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (BrewButtonAPI.BREW_BUTTON_PUSHED == brewButtonService.getBrewButton().getBrewButtonStatus()) {
                simulationTime = SECONDS;
                simulation_start();
            }

        }
    }

    public void simulation_start() {
        while (simulationTime != 0) {
            try {
                Thread.sleep(1000); //check user input at the interval of one second.

                simulationTime--;
                boilerService.addCupsOfWater(-0.2);
                view.getProgressBar().setValue(simulationTime);
                view.writeInTextArea("Water cups: " + Math.floor(boilerService.getCupsOfWaterFromBoiler() * 100) / 100 + "");
                if (boilerService.getCupsOfWaterFromBoiler() < 0.5) {
                    simulationTime = 0;
                    boilerService.getBoiler().setBoilerState(BoilerAPI.BOILER_OFF);
                    view.writeInTextArea("Boiler is off");
                    brewButtonService.resetBrewButtonStatus();
                    indicatorLightService.turnOffLight();
                    view.writeInTextArea("Light is off");
                    boilerService.getBoiler().setBoilerStatus(BoilerAPI.BOILER_EMPTY);
                    view.writeInTextArea("Light is empty");
                }
                if (simulationTime <= 0.1) {
                    boilerService.getBoiler().setBoilerState(BoilerAPI.BOILER_OFF);
                    view.writeInTextArea("Boiler is off");
                    warmerPlateService.turnWarmerPlateON();
                    view.writeInTextArea("Warmer Plate is ON");
                    indicatorLightService.turnOnLight();
                    view.writeInTextArea("Light is ON");
                }
                newStatePot = warmerPlateService.getPotStatus();
                if (oldStatePot == WarmerPlateAPI.POT_NOT_EMPTY || oldStatePot == WarmerPlateAPI.POT_EMPTY) { //pot exist
                    if (newStatePot == WarmerPlateAPI.WARMER_EMPTY) {
                        reliefValveService.reliefValve();
                        view.writeInTextArea("Relief Valve OPEN");
                        boilerService.getBoiler().setBoilerState(BoilerAPI.BOILER_OFF);
                        view.writeInTextArea("Boiler is off");
                        warmerPlateService.turnWarmerPlateOFF();
                        view.writeInTextArea("Warmer Plate is off");
                        indicatorLightService.turnOnLight();
                        view.writeInTextArea("Light is on");
                        //boilerService.setCupsOfWater(0);
                        simulationTime = 0;
                        view.getProgressBar().setValue(simulationTime);
                        brewButtonService.resetBrewButtonStatus();
                    }
                }
                oldStatePot = warmerPlateService.getPotStatus();
                System.out.println(simulationTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
