package generator;

import commons.Instance;
import io.SaveFile;

import java.io.IOException;

import static configuration.Config.*;

public class RunGenerator {

    public static void main(String[] args) throws IOException {
        String newInstanceName = "00";
        for (int i = 1; i <= INSTANCE_N; i++) {
            int instanceSize = i * INSTANCE_START_SIZE;
                Instance instance = new Instance(newInstanceName, instanceSize);
                SaveFile.saveInstance(instance);
        }
    }
}
