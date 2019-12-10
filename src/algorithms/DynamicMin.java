package algorithms;

import commons.Instance;
import commons.Job;
import commons.Machine;
import commons.Result;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static configuration.Config.MACHINES;

public class DynamicMin {

    public static Result run(Instance instance) {
        int n = instance.getInstanceSize();
        List<Machine> machines = new ArrayList<>();
        for (int i = 0; i < MACHINES; i++) {
            machines.add(new Machine());
        }

        List<Job> jobs = instance.getJobs();


        while (!jobs.isEmpty()) {
            Machine machine = machines.stream().min(Comparator.comparing(Machine::getLastFinished)).orElse(null);
            Job job = jobs.stream()
                    .min(Comparator.comparingInt(j -> {
                        int timeFinished = (j).getReadyTime() - machine.getLastFinished();
                        if(timeFinished < 0) return Integer.MIN_VALUE + (j).getProcessingTime();
                        return timeFinished;
                    })).orElse(null);
            machine.addScheduledJob(job);
            jobs.remove(job);
        }
        return new Result(instance.getName(), n, machines);
    }
}
