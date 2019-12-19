package day15;

class GuoYiXianTian {
    public static class OneLineSky {

    }

    public static class man implements Runnable {
        String name;
        final OneLineSky o;

        public man(String name, OneLineSky o) {
            this.name = name;
            this.o = o;
        }


        public void guoOneLineSky(OneLineSky o) throws InterruptedException {
            synchronized (this.o) {
                Thread.sleep(2000);
                System.out.println(this.name + "过了一线天");
            }
        }

        @Override
        public void run() {
            try {
                this.guoOneLineSky(this.o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            OneLineSky oneLineSky = new OneLineSky();
            man[] men = new man[10];
            for (int i = 0; i < 10; i++) {
                men[i] = new man(String.format("探险家%d号", i + 1), oneLineSky);
            }

            Thread[] thread = new Thread[10];
            for (int i = 0; i < 10; i++) {
                thread[i] = new Thread(men[i]);
            }

            thread[0].start();
            thread[1].start();
            thread[2].start();
            thread[3].start();
            thread[4].start();
            thread[5].start();
            thread[6].start();
            thread[7].start();
            thread[8].start();
            thread[9].start();
        }
    }
}
