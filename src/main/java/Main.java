import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static constants.MaxNumberOfThreads.MAX_THREADS;

public class Main {
    public static void main(String[] args) {
        BaseHamburger[] baseHamburgers;
        JacksonObjectDeserializer jacksonObjectDeserializer =
                new JacksonObjectDeserializer();
        baseHamburgers = jacksonObjectDeserializer.getHamburgers();

        ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREADS);
        for (BaseHamburger hamburger : baseHamburgers
        ) {
            CustomThread customThread = new CustomThread(hamburger);
            threadPool.execute(customThread);
        }
        threadPool.shutdown();
    }
}