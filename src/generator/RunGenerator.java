package generator;

import commons.Instance;
import io.SaveFile;

import java.io.IOException;

import static configuration.Config.*;

public class RunGenerator {

    public static void main(String[] args) throws IOException {

        for (int i = 1; i <= INSTANCE_N; i++) {
            int instanceSize = i * INSTANCE_START_SIZE;
                Instance instance = new Instance(INSTANCE_NAME, instanceSize);
                SaveFile.saveInstance(instance);
        }
    }
}
