package verifier;

import algorithms.Naive;
import commons.Instance;
import commons.Result;
import io.LoadFile;
import io.SaveFile;

import java.io.IOException;

import static configuration.Config.INSTANCE_NAME;

public class Verifier {

    public static void main(String[] args) throws IOException {

        int mode = 1;
        int instanceSize = 10;
        Instance instance = LoadFile.loadInstance(INSTANCE_NAME, instanceSize);

        // instance + result
        if (mode == 1) {
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
            Result result = Naive.run(instance);
            SaveFile.saveResult(result);
        }

    }


}

