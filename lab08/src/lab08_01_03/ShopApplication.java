package lab08_01_03;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Producer implements Runnable {
    private Store store;
    private Random random = new Random();

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int productCount = random.nextInt(10) + 1; // Случайное количество продуктов от 1 до 10
            store.produce(productCount);

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private Store store;
    private Random random = new Random();

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int productCount = random.nextInt(10) + 1; // Случайное количество продуктов от 1 до 10
            store.consume(productCount);

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Store {
    private int productCount = 0;
    private Lock lock = new ReentrantLock();
    private Semaphore producerSemaphore = new Semaphore(1);
    private Semaphore consumerSemaphore = new Semaphore(0);

    public void produce(int count) {
        try {
            producerSemaphore.acquire();
            lock.lock();

            productCount += count;
            System.out.println("Производитель поставил на склад " + count + " продукт(ов). Общее количество: " + productCount);

            consumerSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume(int count) {
        try {
            consumerSemaphore.acquire();
            lock.lock();

            if (productCount >= count) {
                productCount -= count;
                System.out.println("Покупатель забрал " + count + " продукт(ов). Общее количество: " + productCount);
            } else {
                System.out.println("Недостаточно продуктов на складе");
            }

            producerSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ShopApplication {
    public static void main(String[] args) {
        Store store = new Store();

        Thread producerThread = new Thread(new Producer(store));
        Thread consumerThread = new Thread(new Consumer(store));

        producerThread.start();
        consumerThread.start();
    }
}
