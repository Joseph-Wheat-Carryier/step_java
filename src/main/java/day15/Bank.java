package day15;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    public static class Account {
        int RestMoney;

        Account(int RestMoney) {
            this.RestMoney = RestMoney;
        }
    }

    public static class Man implements Runnable {
        String name;
        int getMoney;
        Account account;
        private Lock accountLock = new ReentrantLock();
        private Condition sufficient = accountLock.newCondition();

        Man(String name, int getMoney, Account account) {
            this.name = name;
            this.getMoney = getMoney;
            this.account = account;
        }

        void GetMoney(Account a) {
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            //accountLock.lock();
            synchronized (a) {
                try {
                    if (a.RestMoney >= getMoney) {
                        a.RestMoney -= this.getMoney;
                        System.out.println(String.format("%s取了%d钱,余额%d", this.name, getMoney, account.RestMoney));
                    }
                } finally {
                    //accountLock.unlock();
                }
            }
        }

        @Override
        public void run() {

            while ((account.RestMoney >= getMoney)) {
                try {
                    Thread.sleep((int) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetMoney(account);
            }
        }
    }

    public static void main(String[] args) {
        Account account = new Account(5000);
        Man man1 = new Man("小李", (int) (Math.random() * 100), account);
        Man man2 = new Man("小王", (int) (Math.random() * 200), account);
        new Thread(man1).start();
        new Thread(man2).start();
    }
}


