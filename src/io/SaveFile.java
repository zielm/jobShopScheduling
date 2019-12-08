package io;

import commons.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.System.out;

public class SaveFile {

    public static void saveInstance(Instance instance) throws IOException {

        int instanceSize = instance.getInstanceSize();

        String file = "instances/in" + instance.getName() + ".txt";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        out.write(Integer.toString(instanceSize) + "\n");

        List<Job> instanceJobs = instance.getJobs();
        for (Job job: instanceJobs) {
            out.write(Integer.toString(job.getProcessingTime()) + " " +
                    Integer.toString(job.getReadyTime()) + " " +
                    Integer.toString(job.getDueTime()) + "\n");

        }
        out.close();
    }

    public static void saveResult(String algorithm, Result result) throws IOException {
        int resultValue = result.getDelay();

        String filePath = "results/" + algorithm+ "/";
        Path path = Paths.get(filePath);
        if(!Files.exists(path)) {
            Files.createDirectory(path);
        }
        filePath += "out" + result.getInstanceName() + ".txt";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
        out.write(Integer.toString(resultValue) + "\n");

        for (Machine m : result.getMachines()) {
            for (ScheduledJob sjob : m.getScheduledJobs()) {
                out.write(Integer.toString(sjob.getJob().getJobId()) + " ");
            }
            out.write("\n");

        }
        out.close();
    }

    public static void saveResultList(String algorithm, List<Integer> resultList) throws IOException {

        String file = "results/list_" + algorithm + ".txt";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        for (int i : resultList) {
            out.write(Integer.toString(i) + "\n");
        }
        out.close();
    }
}
