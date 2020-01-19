package commons;

import javax.crypto.Mac;
import java.util.List;

import static configuration.Config.MACHINES;

public class Result {
    private int delay = 0;
    private int loadedDelay;
    private int instanceSize;
    private String instanceName;
    private List<Machine> machines;

    public Result(String instanceName, int instanceSize, List<Machine> machines) {
        this.instanceName = instanceName;
        this.instanceSize = instanceSize;
        this.machines = machines;
        calculateDelay();
    }

    public Result(String instanceName, int instanceSize, int loadedDelay, List<Machine> machines) {
        this.instanceName = instanceName;
        this.instanceSize = instanceSize;
        this.loadedDelay = loadedDelay;
        this.machines = machines;
        calculateDelay();
    }

    public int getInstanceSize() {
        return instanceSize;
    }

    public int getDelay() {
        return delay;
    }

    public int getLoadedDelay() {
        return loadedDelay;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public String getInstanceName() {
        return instanceName + "_" + instanceSize;
    }

    public void calculateDelay() {
        delay = 0;
        for (Machine m : machines) {
            delay += m.getDelay();
        }
    }
}
