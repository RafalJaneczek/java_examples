package pl.neverendingcode.threads;

public class VolatileExample {

    public static void main(String[] args) throws InterruptedException {
        SharedData data = new SharedData();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                data.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println(data.getCounter());
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter value: " + data.getCounter());
    }

}

class SharedData {
    static volatile int counter = 0;

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

}