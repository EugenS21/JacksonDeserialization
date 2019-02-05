import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomThread extends Thread {
    private Logger threadLogger = LoggerFactory.getLogger(Thread.class);

    public CustomThread(BaseHamburger baseHamburger) {
        this.run(baseHamburger.getPreparationTime());
    }

    public void run(int preparationTime) {
        try {
            System.out.println("Wait for preparation of the burger to complete");
            sleep(preparationTime * 1000);
        } catch (InterruptedException e) {
            threadLogger.warn("Cant wait for preparation time to finish");
        }
    }
}
