package model.hardwareapi;

public interface BrewButtonAPI {
    /**
     * This function returns the status of the brew button.
     * The brew button is a momentary switch that remembers
     * its state. Each call to this function returns the
     * remembered state and then resets that state to
     * BREW_BUTTON_NOT_PUSHED.
     * <p>
     * Thus, even if this function is polled at a very slow
     * rate, it will still detect when the brew button is
     * pushed.
     */
    int getBrewButtonStatus();

    int BREW_BUTTON_PUSHED = 0;
    int BREW_BUTTON_NOT_PUSHED = 1;
}
