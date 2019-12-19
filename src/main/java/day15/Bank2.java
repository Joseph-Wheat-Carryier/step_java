package day15;

public class Bank2 {
    public static class Account {
        int restMoney;

        Account(int RestMoney) {
            this.restMoney = RestMoney;
        }


        void getMoney(int money) {
            if (restMoney >= money) {
                restMoney -= money;
            }
        }

        void saveMoney(int money) {
            restMoney += money;
        }

    }

    public static class Man implements Runnable {
        int money = 1000;
        String name;
        final Account account;

        Man(String name, Account account) {
            this.name = name;
            this.account = account;
        }

        void GetMoney(Account a, int money) {
            synchronized (account) {
                if (a.restMoney >= money) {
                    a.getMoney(money);
                    this.money += money;
                    System.out.printf("%s取钱%d元成功,余额%d元,现金%d元\n", name, money, a.restMoney,this.money);
                }
            }
        }

        void SaveMoney(Account a, int money) {
            synchronized (account) {
                if (this.money >= money) {
                    a.saveMoney(money);
                    this.money -= money;
                    System.out.printf("%s存钱%d元成功,余额%d元,现金%d元\n", name, money, a.restMoney,this.money);
                }
            }
        }

        @Override
        public void run() {
        }

    }

    public static void main(String[] args) {
        Account account = new Account(5000);
        Man man1 = new Man("小李", account);
        Man man2 = new Man("小王", account);
        new Thread(() -> {
            while (account.restMoney > 0) {
                try {
                    Thread.sleep((int)(Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int money = (int) (Math.random() * 200);
                man1.GetMoney(account, money);
                if (account.restMoney == 0&&man2.money==0)
                    break;
            }
        }).start();

        new Thread(() -> {
            while (man2.money > 0) {
                try {
                    Thread.sleep((int)(Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                man2.SaveMoney(account, (int) (Math.random() * 300));
            }
        }).start();
    }
}


