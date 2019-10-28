package generator;

import commons.Instance;
import io.SaveInstance;

import java.io.IOException;

import static configuration.Config.INSTANCE_N;
import static configuration.Config.INSTANCE_START_SIZE;

public class RunGenerator {

    public static void main(String[] args) throws IOException {

        for (int i = 1; i <= INSTANCE_N; i++) {
            int instanceSize = i * INSTANCE_START_SIZE;
                Instance instance = new Instance(instanceSize);
                SaveInstance.save(instance);
        }
    }
}
