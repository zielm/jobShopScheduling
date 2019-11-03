package commons;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private List<ScheduledJob> scheduledJobs = new ArrayList<>();

    public List<ScheduledJob> getScheduledJobs() {
        return scheduledJobs;
    }

    public void setScheduledJobs(List<ScheduledJob> scheduledJobs) {
        this.scheduledJobs = scheduledJobs;
    }

    public int getDelay() {
        int delay = 0;
        for(ScheduledJob job : scheduledJobs) {
            delay += job.getDelay();
        }
        return delay;
    }

    public int getLastFinished() {
        if (scheduledJobs.isEmpty()) return 0;
        return scheduledJobs.get(scheduledJobs.size() - 1).getEndTime();
    }

    public void addScheduledJob(Job newJob) {
        scheduledJobs.add(new ScheduledJob(newJob, Math.max(newJob.getReadyTime(), getLastFinished())));
    }


}
