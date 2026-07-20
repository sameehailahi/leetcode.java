import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    private Lock[] forks;

    public DiningPhilosophers() {
        forks = new Lock[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        // To avoid deadlock, take forks in fixed order
        Lock first = forks[Math.min(leftFork, rightFork)];
        Lock second = forks[Math.max(leftFork, rightFork)];

        first.lock();
        second.lock();

        try {
            pickLeftFork.run();
            pickRightFork.run();

            eat.run();

            putLeftFork.run();
            putRightFork.run();

        } finally {
            second.unlock();
            first.unlock();
        }
    }
}