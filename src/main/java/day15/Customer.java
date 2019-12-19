package day15;

public class Customer implements Runnable{
    Repository r;

    public Customer(Repository r) {
        this.r = r;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            this.getCommodidy(this.r);
        }
    }

    public void getCommodidy(Repository r){
        System.out.println(String.format("取到了商品  %s",r.pop().getName()));
    }
}
