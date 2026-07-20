import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore fooSem;
    private Semaphore barSem;

    public FooBar(int n) {
        this.n = n;
        fooSem = new Semaphore(1); // foo starts first
        barSem = new Semaphore(0); // bar waits
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSem.acquire();
            printFoo.run();
            barSem.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSem.acquire();
            printBar.run();
            fooSem.release();
        }
    }
}