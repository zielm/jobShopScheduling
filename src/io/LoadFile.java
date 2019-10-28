package io;

import commons.Instance;
import commons.Job;
import commons.Result;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static configuration.Config.MACHINES;

public class LoadFile {

    public static Instance loadInstance(String filename, int instanceSize) throws IOException {
        String file = "instances/in" + filename + "_" + instanceSize;
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));
        BufferedReader in = new BufferedReader(new InputStreamReader(stream));

        int n = Integer.parseInt(in.readLine());
        Instance loadedInstance = new Instance(filename, n);

        String line;
        String[] lineSplit;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            line = in.readLine();
            lineSplit = line.split(" ");
            Job job = new Job(
                    i+1,
                    Integer.parseInt(lineSplit[0]),
                    Integer.parseInt(lineSplit[1]),
                    Integer.parseInt(lineSplit[2]));
            jobs.add(job);
        }
        loadedInstance.setJobs(jobs);
        return loadedInstance;
    }

    public static Result loadResult(Instance instance) throws IOException {

        String file = "results/out" + instance.getName();
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));
        BufferedReader in = new BufferedReader(new InputStreamReader(stream));

        int delay = Integer.parseInt(in.readLine());

        String line;
        String[] lineSplit;
        List <Job> jobsInstance = instance.getJobs();
        List<List<Job>> scheduledJobs = new ArrayList<>();
        for (int i = 0; i < MACHINES; i++) {
            scheduledJobs.add(new ArrayList<>());
            line = in.readLine();
            lineSplit = line.split(" ");
            for (String jobNumber : lineSplit) {
                scheduledJobs.get(i).add(jobsInstance.get(Integer.parseInt(jobNumber)-1));
            }
        }

        return new Result("A", 2, delay, scheduledJobs);
    }
}
