package day15;

public class TestMacDownald {
    public static void main(String[] args) {
        Repository repository = new Repository();
        MacDownald macDownald = new MacDownald(repository);
        Customer customer = new Customer(repository);
        Thread thread1 = new Thread(macDownald);

        Thread thread2 = new Thread(customer);
        thread1.start();
        thread2.start();
    }
}