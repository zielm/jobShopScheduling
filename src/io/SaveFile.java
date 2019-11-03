package io;

import commons.Instance;
import commons.Job;
import commons.Machine;
import commons.Result;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaveFile {

    public static void saveInstance(Instance instance) throws IOException {

        int instanceSize = instance.getInstanceSize();

        String plik = "instances/in" + instance.getName() + ".txt";
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

    public static void saveResult(Result result) throws IOException {
        int resultValue = result.getDelay();

        String plik = "results/out" + result.getInstanceName();
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(plik)));
        out.write(Integer.toString(resultValue) + "\n");

        for (Machine m : result.getMachines()) {
            for (Job job : m.getJobs()) {
                out.write(Integer.toString(job.getJobId()) + " ");
            }
            out.write("\n");

        }
        out.close();
    }
}
