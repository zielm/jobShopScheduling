package algorithms;

import commons.Instance;
import commons.Job;
import commons.Machine;
import commons.Result;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static configuration.Config.MACHINES;

public class AdvSort {

    static int window_r = 0;

    public static Result run(Instance instance) {
        int n = instance.getInstanceSize();
        List<Machine> machines = new ArrayList<>();
        for (int i = 0; i < MACHINES; i++) {
            machines.add(new Machine());
        }

        List<Job> jobs = instance.getJobs();
        for (Job j : jobs) {
            window_r += j.getDueTime() - j.getReadyTime() - j.getProcessingTime();
        }
        window_r = window_r/n;

        jobs.sort(new Compare3R1DwithWindow());

        for (Job job : jobs) {
            Machine m = machines.stream().min(Comparator.comparing(Machine::getLastFinished)).orElse(null);
            m.addScheduledJob(job);
        }

        return new Result(instance.getName(), n, machines);
    }




    //better
    public static final class Compare3R1DwithWindow implements Comparator<Job> {
        @Override
        public int compare(Job j1, Job j2) {
            return (3*j1.getReadyTime() + j1.getDueTime()) - (j1.getDueTime() - j1.getReadyTime() - j1.getProcessingTime() )
                    - ((3*j2.getReadyTime()+ j2.getDueTime()) - (j2.getDueTime() - j2.getReadyTime() - j2.getProcessingTime() ));
        }
    }


    public static final class Compare2R1D implements Comparator<Job> {
        @Override
        public int compare(Job j1, Job j2) {
            int result = (2*j1.getReadyTime() + j1.getDueTime()) - (2*j2.getReadyTime() + j2.getDueTime());
            return result;
        }
    }
}