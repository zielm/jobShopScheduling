package verifier;

import algorithms.Naive;
import commons.Delay;
import commons.Instance;
import commons.Result;
import io.LoadFile;
import io.SaveFile;

import java.io.IOException;

import static configuration.Config.INSTANCE_NAME;

public class Verifier {

    public static void main(String[] args) throws IOException {

        int mode = 1;
        String filename = INSTANCE_NAME;
        int instanceSize = 10;
        Instance instance = LoadFile.loadInstance(filename, instanceSize);

        // instance + result
        if (mode == 1) {
            Result result = LoadFile.loadResult(instance);
            int calculatedDelay = Delay.calculateDelay(result.getJobs());
            if (result.getDelay() == calculatedDelay) {
                System.out.println("OK");
            }
            else {
                System.out.println("Different values: " + result.getDelay() + " =/= " + calculatedDelay);
            }
        }

        // instance + algorithm
        else {
            Result result = Naive.run(instance);
            SaveFile.saveResult(result);
        }

    }


}

