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

    public int getStartTime() {
        return startTime;
    }

    public int getProcessingTime() {
        return job.getProcessingTime();
    }

    public int getReadyTime() {
        return job.getReadyTime();
    }

    public int getDueTime() {
        return job.getDueTime();
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
}
