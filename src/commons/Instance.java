package commons;

import generator.InstanceGenerator;

import java.util.List;

public class Instance {

    private List<Job> jobs;
    private int instanceSize;

    public Instance(int instanceSize) {
        this.instanceSize = instanceSize;
        InstanceGenerator instanceGenerator = new InstanceGenerator(instanceSize);
        instanceGenerator.generate();
        jobs = instanceGenerator.getJobs();
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

}
