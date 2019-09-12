package model.components.valve;

import model.hardwareapi.ReliefValveAPI;

public class ReliefValve implements ReliefValveAPI {

    private int reliefValveState; // OPEN or CLOSED

    @Override
    public void setReliefValveState(int reliefValveState) {
        this.reliefValveState = reliefValveState;
    }

    public int getReliefValveState() {
        return this.reliefValveState;
    }

}
