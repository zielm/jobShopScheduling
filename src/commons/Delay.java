package commons;

import java.util.List;

public class Delay {

    public static int calculateDelay(List<List<Job>> jobs) {
        int delay = 0;
        for (List<Job> listJob : jobs) {
            int lastFinished = listJob.get(0).getReadyTime();
            for (Job job : listJob) {
                lastFinished = Math.max(lastFinished, job.getReadyTime()) + job.getProcessingTime();
                delay += Math.max(0, (lastFinished - job.getDueTime()));
            }
        }
        return delay;
    }

}
