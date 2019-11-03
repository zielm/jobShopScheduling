package algorithms;

import commons.Instance;
import commons.Job;
import commons.Machine;
import commons.Result;

import java.util.ArrayList;
import java.util.List;

import static configuration.Config.MACHINES;

public class Naive {

    public static Result run (Instance instance) {
        int cnt = 0;
        int n = instance.getInstanceSize();
        int threshold = (int)Math.round(n/4.0);
        List<Machine> machines = new ArrayList<>();
        for(int i = 0; i < MACHINES; i++) {
            machines.add(new Machine());
        }

        for (Job job : instance.getJobs()) {
            machines.get(cnt/threshold).getJobs().add(job);
            cnt++;
        }

        return new Result(instance.getName(), n, machines);
    }

}
