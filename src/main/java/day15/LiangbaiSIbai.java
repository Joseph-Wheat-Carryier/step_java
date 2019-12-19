package day15;

public class LiangbaiSIbai {
    public static class Count implements Runnable {
        Integer i;

        Count(Integer i) {
            this.i = i;
        }

        public void count(Integer i) {
            synchronized (i) {
                while (i < 400) {
                    i++;
                    if (i % 2 == 0)
                        System.out.println(i);
                    else
                        System.out.println(i.toString() + Thread.currentThread());
                }
            }
        }

        @Override
        public void run() {
            count(this.i);
        }
    }

    public static void main(String[] args) {
        Integer i = new Integer(200);

        Thread thread1 = new Thread(new Count(i));
        Thread thread2 = new Thread(new Count(i));
        Thread thread3 = new Thread(new Count(i));

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
