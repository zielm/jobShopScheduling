package verifier;

import algorithms.Naive;
import algorithms.SimpleSort;
import commons.Instance;
import commons.Result;
import io.LoadFile;
import io.SaveFile;

import java.io.IOException;

import static configuration.Config.*;

public class Verifier {

    public static void main(String[] args) throws IOException {

        int mode = 2;

        // instance + result
        if (mode == 1) {
            int instanceSize = 10;
            Instance instance = LoadFile.loadInstance(INSTANCE_NAME, instanceSize);
            Result result = LoadFile.loadResult(instance);
            if (result.getDelay() == result.getLoadedDelay()) {
                System.out.println("OK");
            }
            else {
                System.out.println("Different values: " + result.getDelay() + " =/= " + result.getLoadedDelay());
            }
        }

        // instance + algorithm
        else {
            for (int i = 1; i <= INSTANCE_N; i++) {
                int instanceSize = i * INSTANCE_START_SIZE;
                Instance instance = LoadFile.loadInstance(INSTANCE_NAME, instanceSize);
                Result result = Naive.run(instance);
                SaveFile.saveResult("naive", result);
            }
        }

    }


}

