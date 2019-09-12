package service.boiler;

import java.beans.PropertyChangeEvent;

import model.components.boiler.Boiler;
import model.hardwareapi.BoilerAPI;

public class BoilerServiceImpl implements BoilerService {
    private Boiler boiler;
    private double cupsOfWaterInBoiler;

    public double getCupsOfWaterFromBoiler() {
        return cupsOfWaterInBoiler;
    }

    @Override
    public void setCupsOfWater(int cupsOfWaterInBoiler) {
        this.cupsOfWaterInBoiler = cupsOfWaterInBoiler;
    }

    public BoilerServiceImpl(Boiler boiler) {
        this.boiler = boiler;
    }

    public Boiler getBoiler() {
        return boiler;
    }

    @Override
    public double addCupsOfWater(double cupsOfWater) {
        cupsOfWaterInBoiler = cupsOfWaterInBoiler + cupsOfWater;
        if (cupsOfWaterInBoiler > 12) {
            cupsOfWaterInBoiler = 12;
        }
        if (cupsOfWaterInBoiler <= 0.5) {
            boiler.setBoilerState(BoilerAPI.BOILER_EMPTY);
            System.out.println("Boiler is empty");

        } else {
            boiler.setBoilerStatus(BoilerAPI.BOILER_NOT_EMPTY);
        }
        return cupsOfWaterInBoiler;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Variation of " + evt.getPropertyName());
        System.out.println("\t(" + evt.getOldValue() +
                " -> " + evt.getNewValue() + ")");
        System.out.println("Property in object " + evt.getSource());
    }
}
