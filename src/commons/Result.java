package commons;

import commons.Job;

import java.util.List;

public class Result {
    private int delay = 0;
    private int instanceSize;
    private String instanceName;
    private List<List<Job>> jobs;

    public Result(String instanceName, int instanceSize, List<List<Job>> jobs) {
        this.instanceName = instanceName;
        this.instanceSize = instanceSize;
        this.jobs = jobs;
        delay = Delay.calculateDelay(jobs);
    }

    public Result(String instanceName, int instanceSize, int delay, List<List<Job>> jobs) {
        this.instanceName = instanceName;
        this.instanceSize = instanceSize;
        this.delay = delay;
        this.jobs = jobs;
    }

    public int getInstanceSize() {
        return instanceSize;
    }

    public int getDelay() {
        return delay;
    }

    public List<List<Job>> getJobs() {
        return jobs;
    }

    public String getInstanceName() {
        return instanceName;
    }

}
