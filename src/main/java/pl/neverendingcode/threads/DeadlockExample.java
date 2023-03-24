package pl.neverendingcode.threads;

public class DeadlockExample {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("Metoda 1 uzyskała dostęp do lock1");
            synchronized (lock2) {
                System.out.println("Metoda 1 uzyskała dostęp do lock2");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("Metoda 2 uzyskała dostęp do lock2");
            synchronized (lock1) {
                System.out.println("Metoda 2 uzyskała dostęp do lock1");
            }
        }
    }

}
