package commons;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private List<Job> jobs = new ArrayList<>();
    private int delay;
    private int lastFinished;

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public int getDelay() {
        calculateTimes();
        return delay;
    }

    public int getLastFinished() {
        calculateTimes();
        return lastFinished;
    }

    private void calculateTimes() {
        delay = 0;
        lastFinished = jobs.get(0).getReadyTime();
        for (Job job : jobs) {
            lastFinished = Math.max(lastFinished, job.getReadyTime()) + job.getProcessingTime();
            delay += Math.max(0, (lastFinished - job.getDueTime()));
        }
    }
}
