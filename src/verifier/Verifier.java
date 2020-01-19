package verifier;

import algorithms.AdvSort;
import algorithms.DynamicMin;
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

        int mode = 1;
        // naive, simpleSort, advSort, dynamicMin
        String algorithmName = "dynamicMin";
        // Simple: RDP, RPD, PDR, PRD, DPR, DRP
        String comparatorName = "";

        // instance + result
        if (mode == 1) {
            for (String instName : INSTANCE_NAMES) {
                for (int i = 1; i <= INSTANCE_N; i++) {
                    Instance instance = LoadFile.loadInstance(instName, i * 50);
                    Result result = LoadFile.loadResult(instance);
                    if (result.getDelay() != result.getLoadedDelay()) {
                        System.out.println("Different values: " + result.getDelay() + " =/= " + result.getLoadedDelay());
                    }
                }
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
                    long start, alltime = 0;
                    for (int r = 0; r < 500; r++) {
                        instance = LoadFile.loadInstance(instName, instanceSize);
                        start = System.nanoTime();
                        result = DynamicMin.run(instance);
                        alltime += System.nanoTime() - start;
                    }
                    System.out.println((alltime/500));
//                    Result result = null;
//                    switch (algorithmName){
//                        case "naive":
//                            result = Naive.run(instance);
//                            break;
//                        case "simpleSort":
//                            result = SimpleSort.run(instance, comparatorName);
//                            break;
//                        case "advSort":
//                            result = AdvSort.run(instance);
//                            break;
//                        case "dynamicMin":
//                            result = DynamicMin.run(instance);
//                            break;
//                    }
                    resultsList.add(result.getDelay());
                    SaveFile.saveResult(algorithmName+comparatorName, result);
                }
            }
            SaveFile.saveResultList(algorithmName+comparatorName, resultsList);
        }
    }


}

