package commons;

public class ScheduledJob {
    private Job job;
    private int startTime;

    public ScheduledJob(Job job, int startTime) {
        this.job = job;
        this.startTime = startTime;
    }

    public Job getJob() {
        return job;
    }

    public int getEndTime() {
        return (startTime + job.getProcessingTime());
    }

    public int getDelay() {
        return Math.max(0, getEndTime() - job.getDueTime());
    }

}
