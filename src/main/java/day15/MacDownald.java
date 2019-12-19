package day15;

public class MacDownald implements Runnable{
    Repository repository;

    public MacDownald(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            Commodity commodity = new Commodity(String.format("订单号%d",i));
            System.out.println(String.format("生产商品-->%s",commodity.getName()));
            produce(this.repository,commodity);
        }
    }

    public void produce(Repository r,Commodity c){
        r.push(c);
    }
}
