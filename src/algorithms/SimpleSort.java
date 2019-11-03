package algorithms;

import commons.Instance;
import commons.Job;
import commons.Machine;
import commons.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static configuration.Config.MACHINES;

public class SimpleSort {

    public static Result run (Instance instance) {
        int n = instance.getInstanceSize();
        List<Machine> machines = new ArrayList<>();
        for(int i = 0; i < MACHINES; i++) {
            machines.add(new Machine());
        }

        List<Job> sortedJobs = instance.getJobs();
        Collections.sort(sortedJobs);

        for (Job job : sortedJobs) {
            Machine m = machines.stream().min(Comparator.comparing(Machine::getLastFinished)).orElse(null);
            m.addScheduledJob(job);
        }

        return new Result(instance.getName(), n, machines);
    }
}
