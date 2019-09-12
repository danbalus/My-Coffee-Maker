package service.reliefvalve;

import model.components.valve.ReliefValve;
import model.hardwareapi.ReliefValveAPI;

public class ReliefValveServiceImpl implements ReliefValveService {
    private ReliefValve reliefValve;

    public ReliefValveServiceImpl(ReliefValve reliefValve) {
        this.reliefValve = reliefValve;
    }

    @Override
    public void reliefValve() {
        reliefValve.setReliefValveState(ReliefValveAPI.VALVE_OPEN);
    }
}
