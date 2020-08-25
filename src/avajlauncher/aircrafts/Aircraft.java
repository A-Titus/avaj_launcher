package avajlauncher.aircrafts;

import avajlauncher.simulator.*;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    private static long idCounter = 0; //static so that all instances have access to common info

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return ++idCounter;//increment id counter each time
    }
}