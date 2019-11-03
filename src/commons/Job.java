package commons;

public class Job implements Comparable<Job> {
    private int jobId;
    private int processingTime;
    private int readyTime;
    private int dueTime;

    public Job(int jobId, int processingTime) {
        this.jobId = jobId;
        this.processingTime = processingTime;
    }

    public Job(int jobId, int processingTime, int readyTime, int dueTime) {
        this.jobId = jobId;
        this.processingTime = processingTime;
        this.readyTime = readyTime;
        this.dueTime = dueTime;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public int getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(int readyTime) {
        this.readyTime = readyTime;
    }

    public int getDueTime() {
        return dueTime;
    }

    public void setDueTime(int dueTime) {
        this.dueTime = dueTime;
    }

    @Override
    public int compareTo(Job j) {
        int result = Integer.compare(readyTime, j.getReadyTime());
        if (result == 0) {
            result = Integer.compare(dueTime, j.getDueTime());
            if(result == 0) {
                result = Integer.compare(processingTime, j.getProcessingTime());
            }
        }
        return result;
    }
}
