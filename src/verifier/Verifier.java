package verifier;

import algorithms.Naive;
import algorithms.SimpleSort;
import commons.Instance;
import commons.Result;
import io.LoadFile;
import io.SaveFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static configuration.Config.*;

public class Verifier {

    public static void main(String[] args) throws IOException {

        int mode = 2;
        // naive, simpleSort
        String algorithmName = "simpleSort";
        // Simple: RDP, RPD, PDR, PRD, DPR, DRP
        String comparatorName = "RPD";

        // instance + result
        if (mode == 1) {
            int instanceSize = 10;
            Instance instance = LoadFile.loadInstance(INSTANCE_NAMES[0], instanceSize);
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
            List<Integer> resultsList = new ArrayList<>();
            for (String instName : INSTANCE_NAMES) {
                for (int i = 1; i <= INSTANCE_N; i++) {
                    int instanceSize = i * INSTANCE_START_SIZE;
                    Instance instance = LoadFile.loadInstance(instName, instanceSize);
                    Result result = null;
                    switch (algorithmName){
                        case "naive":
                            result = Naive.run(instance);
                            break;
                        case "simpleSort":
                            result = SimpleSort.run(instance, comparatorName);
                            break;
                    }
                    resultsList.add(result.getDelay());
                    SaveFile.saveResult(algorithmName+comparatorName, result);
                }
            }
            SaveFile.saveResultList(algorithmName+comparatorName, resultsList);
        }
    }


}

