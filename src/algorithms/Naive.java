package algorithms;

import commons.Instance;
import commons.Job;
import commons.Result;

import java.util.ArrayList;
import java.util.List;

public class Naive {

    public static Result run (Instance instance) {
        int cnt = 0;
        int n = instance.getInstanceSize();
        int threshold = (int)Math.round(n/4.0);
        List<List<Job>> jobs = new ArrayList<>();
        jobs.add(new ArrayList<>());
        jobs.add(new ArrayList<>());
        jobs.add(new ArrayList<>());
        jobs.add(new ArrayList<>());

        for (Job job : instance.getJobs()) {
            jobs.get(cnt/threshold).add(job);
            cnt++;
        }

        return new Result(instance.getName(), n, jobs);
    }

}
