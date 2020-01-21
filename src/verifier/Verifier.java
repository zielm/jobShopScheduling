package verifier;

import algorithms.*;
import commons.Instance;
import commons.Result;
import io.LoadFile;
import io.SaveFile;

import javax.xml.transform.sax.SAXSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static configuration.Config.*;

public class Verifier {

    public static void main(String[] args) throws IOException {

        int mode = 1;
        // algorithmName: naive, simpleSort, advSort, dynamicMin
        String algorithmName = "advSort";
        // comparatorName for simpleSort: RDP, RPD, PDR, PRD, DPR, DRP
        String comparatorName = "";
        boolean measureTime = true;
        int measureTimeRepeat = 1;
        boolean advancedScheduling = true;

        String directoryName = algorithmName+comparatorName;
        if(advancedScheduling) directoryName = "advanced_new";

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
                    if(measureTime) {
                        long start, alltime = 0;
                        for (int r = 0; r < measureTimeRepeat; r++) {
                            instance = LoadFile.loadInstance(instName, instanceSize);
                            start = System.nanoTime();
                            result = DynamicMin.run(instance);
                            if(advancedScheduling) {
                                result = Shuffle.run(instance, result);
                            }
                            alltime += System.nanoTime() - start;
                        }
                        System.out.println((alltime / measureTimeRepeat));
                    }
                    else {
                        // list scheduling
                        switch (algorithmName) {
                            case "naive":
                                result = Naive.run(instance);
                                break;
                            case "simpleSort":
                                result = SimpleSort.run(instance, comparatorName);
                                break;
                            case "advSort":
                                result = AdvSort.run(instance);
                                break;
                            case "dynamicMin":
                                result = DynamicMin.run(instance);
                                break;
                        }

                        // advanced
                        if(advancedScheduling) {
                            result = Shuffle.run(instance, result);
                        }
                    }
                    resultsList.add(result.getDelay());
                    SaveFile.saveResult(directoryName, result);
                }
            }
            SaveFile.saveResultList(directoryName, resultsList);
        }
    }


}

