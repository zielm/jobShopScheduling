package generator;

import commons.Job;

import java.util.ArrayList;
import java.util.Random;

import static configuration.Config.*;

public class InstanceGenerator {

    private int instanceSize;
    private ArrayList<Job> jobs;

    private static final Random random = new Random();

    public InstanceGenerator(int instanceSize) {
        this.instanceSize = instanceSize;
        setParameters();
    }

    private void setParameters() {
        if (PROCESSING_TIME_VAR) {
            MAX_PROCESSING_TIME = 6 + instanceSize / 75;
        }
    }

    public void generate() {
        jobs = new ArrayList<>();
        for (int i = 0; i < instanceSize; i++) {
            Job newJob = new Job(i, random.nextInt(MAX_PROCESSING_TIME) + MIN_PROCESSING_TIME);
            jobs.add(newJob);
        }

        int maxReadyTime = (int)(getMaxReadyTime() * PROCENT_READY_TIME);
        for (Job job : jobs) {
            int p = job.getProcessingTime();
            int r = random.nextInt(maxReadyTime + 1 - p);

            // Shift of the due time depends on processing time
            int shiftVar = (p/DENOMINATOR_SHIFT);
            int d = r + p + random.nextInt(shiftVar + SHIFT_DUE_TIME) ;

            job.setReadyTime(r);
            job.setDueTime(d);
        }
    }

    private int getMaxReadyTime() {
        int sum = 0;
        for (Job job : jobs) {
            sum += job.getProcessingTime();
        }
        return sum/MACHINES;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }
}
