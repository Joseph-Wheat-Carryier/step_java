package day16;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class homework2 {
    static int i = 0;

    public static class I {
        int key = 2;

        public synchronized void plus() {
            System.out.printf("%s + 1 = %d   key:%d\n", Thread.currentThread().getName(), ++i,key);
            notifyAll();
        }


        public synchronized void minus() {
            System.out.printf("%s - 1 = %d   key:%d\n", Thread.currentThread().getName(), --i,key);
            notifyAll();
        }

    }

    public static class Plus implements Runnable {
        I i;

        Plus(I i) {
            this.i = i;
        }

        @Override
        public void run() {
            synchronized (i) {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i.key != 2) {
                    i.plus();
                    ++i.key;
                } else {
                    try {
                        i.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i.notifyAll();
                }}
            }
        }
    }

    public static class Minus implements Runnable {
        final I i;

        Minus(I i) {
            this.i = i;
        }

        @Override
        public void run() {
            synchronized (i) {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i.key != 0) {
                    i.minus();
                    --i.key;
                } else {
                    try {
                        i.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i.notifyAll();
                }}
            }
        }
    }

    public static void main(String[] args) {
        I i = new I();
        Thread t1 = new Thread(new Plus(i));
        Thread t2 = new Thread(new Plus(i));
        Thread t3 = new Thread(new Minus(i));
        Thread t4 = new Thread(new Minus(i));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
