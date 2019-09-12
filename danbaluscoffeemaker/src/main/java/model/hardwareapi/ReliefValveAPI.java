package model.hardwareapi;

public interface ReliefValveAPI {

    /**
     * This function opens and closes the pressure-relief
     * valve. When this valve is closed, steam pressure in
     * the boiler will force hot water to spray out over
     * the coffee filter. When the valve is open, the steam
     * in the boiler escapes into the environment, and the
     * water in the boiler will not spray out over the filter.
     */
    void setReliefValveState(int reliefValveState);

    int VALVE_OPEN = 0;
    int VALVE_CLOSED = 1;
}
