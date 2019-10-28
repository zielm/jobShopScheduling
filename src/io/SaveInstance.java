package io;

import commons.Instance;
import commons.Job;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaveInstance {

    public static void save(Instance instance) throws IOException {

        int instanceSize = instance.getInstanceSize();

        String plik = "instances/in132348_" + instanceSize + ".txt";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(plik)));
        out.write(Integer.toString(instanceSize) + "\n");

        List<Job> instanceJobs = instance.getJobs();
        for (Job job: instanceJobs) {
            out.write(Integer.toString(job.getProcessingTime()) + " " +
                    Integer.toString(job.getReadyTime()) + " " +
                    Integer.toString(job.getDueTime()) + "\n");

        }

        out.close();

    }
}
