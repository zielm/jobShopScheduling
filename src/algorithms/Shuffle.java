package algorithms;

import commons.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static configuration.Config.MACHINES;

public class Shuffle {


    public static Result run(Instance instance, Result result) {
        List<Machine> machines = result.getMachines();
        int delay, new_delay, rerun = 0;

        do {
            rerun++;
            delay = result.getDelay();
            for (int i = 0; i < MACHINES; i++) {
                List<ScheduledJob> firstJobs = machines.get(i).getScheduledJobs();
                for (int firstJobNr = 0; firstJobNr < firstJobs.size(); firstJobNr++) {
                    ScheduledJob job = firstJobs.get(firstJobNr);
                    for (int j = 0; j < MACHINES; j++) {
                        if (i == j) continue;
                        List<ScheduledJob> secondJobs = machines.get(j).getScheduledJobs();
                        for (int secJobNr = 0; secJobNr < secondJobs.size(); secJobNr++) {
//                        if (job.getReadyTime() < secondJobs.get(secJobNr).getEndTime())
//                            continue;
//                        if(secJobNr != 0 && job.getEndTime() < secondJobs.get(secJobNr-1).getEndTime())
//                            break;
                            TryToShuffle(machines, i, firstJobNr, j, secJobNr);
                        }
                    }
                }
            }
            result.calculateDelay();
            new_delay = result.getDelay();
        } while(delay - new_delay > 100 || rerun < 5);
        return result;
    }

    private static void TryToShuffle(List<Machine> machines, int firstMachineId, int firstJobId, int secondMachineId, int secondJobId) {
        Machine m1 = machines.get(firstMachineId);
        Machine m2 = machines.get(secondMachineId);
        int delay = m1.getDelay() + m2.getDelay();

        List<ScheduledJob> tempFirstJobs = m1.getScheduledJobs();
        List<ScheduledJob> tempSecondJobs = m2.getScheduledJobs();

        ScheduledJob firstJob = tempFirstJobs.get(firstJobId);
        ScheduledJob secondJob = tempSecondJobs.get(secondJobId);

        tempFirstJobs.remove(firstJobId);
        tempFirstJobs.add(firstJobId, secondJob);

        tempSecondJobs.remove(secondJobId);
        tempSecondJobs.add(secondJobId, firstJob);

        int new_delay = m1.calculateDelayAgain() + m2.calculateDelayAgain();

        if (delay < new_delay) {
            tempFirstJobs.remove(firstJobId);
            tempFirstJobs.add(firstJobId, firstJob);
            tempSecondJobs.remove(secondJobId);
            tempSecondJobs.add(secondJobId, secondJob);
            m1.calculateDelayAgain();
            m2.calculateDelayAgain();
        }



    }
}
