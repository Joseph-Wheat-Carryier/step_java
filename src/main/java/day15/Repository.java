package day15;

import java.util.LinkedList;
import java.util.List;

public class Repository {
    LinkedList<Commodity> commodities = new LinkedList<>();
    int count = 0;

    public synchronized void push(Commodity c) {
        if (count == 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        commodities.push(c);
        count++;
        if (count == 5) {

            this.notify();
        }
    }

    public synchronized Commodity pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        this.notify();
        return commodities.pop();
    }
}
