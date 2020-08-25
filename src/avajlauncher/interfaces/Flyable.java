package avajlauncher.interfaces;

import avajlauncher.simulator.*;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower WeatherTower);
}