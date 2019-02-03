
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    //Parking place is busy - true, free - false
    private static final boolean[] PARKING_PLACES = new boolean[5];
    //Setting "fair" flag to true, in this case aсquire()
    //will guarantee first-in first-out granting of permits under contention
    private static final Semaphore SEMAPHORE = new Semaphore(5, true);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 7; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(400);
        }
        System.out.println(" ============================ ");
    }

    public static class Car implements Runnable {
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            System.out.printf("Car #%d has came to parking place.\n", carNumber);
            try {
                //Acquires a permit from this semaphore, blocking until one is available,
                // or the thread is {@linkplain Thread#interrupt interrupted}
                SEMAPHORE.acquire();

                int parkingNumber = -1;

                //checking free parking place
                synchronized (PARKING_PLACES) {
                    for (int i = 0; i < 5; i++)
                        if (!PARKING_PLACES[i]) {
                            PARKING_PLACES[i] = true;
                            //Semaphore guarantees free parking places
                            parkingNumber = i;
                            System.out.println(String.format("Car #%d has parked at place %d."
                                    , carNumber, i));
                            break;
                        }
                }
                //take our time TODO: smth
                Thread.sleep(5000);

                synchronized (PARKING_PLACES) {
                    PARKING_PLACES[parkingNumber] = false;//release parking place
                }

                //Releases a permit, returning it to the semaphore
                SEMAPHORE.release();
                System.out.println(String.format("Car #%d has left parking.", carNumber));
            } catch (InterruptedException e) {
            }
        }
    }
}
