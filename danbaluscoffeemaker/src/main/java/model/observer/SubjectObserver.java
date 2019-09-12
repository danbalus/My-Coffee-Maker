package model.observer;

import java.beans.PropertyChangeListener;

public interface SubjectObserver {
    void addObserver(PropertyChangeListener l);
}
