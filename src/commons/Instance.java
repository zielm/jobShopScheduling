package commons;

import generator.InstanceGenerator;

import java.util.List;

public class Instance {

    private List<Job> jobs;
    private int instanceSize;
    private String name;

    public Instance(String name, int instanceSize) {
        this.instanceSize = instanceSize;
        this.name = name + "_" + instanceSize;
        InstanceGenerator instanceGenerator = new InstanceGenerator(instanceSize);
        instanceGenerator.generate();
        jobs = instanceGenerator.getJobs();
    }

    public Instance(String name, int instanceSize, List<Job> jobs) {
        this.name = name;
        this.instanceSize = instanceSize;
        this.jobs = jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public int getInstanceSize() {
        return instanceSize;
    }

    public String getName() {
        return name;
    }
}
