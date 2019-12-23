package day19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Tiankong8 {
    public static class Worker {
        private int age;
        private String name;
        private double salary;
        public Worker (){}
        public Worker (String name, int age, double salary){
            this.name=name;
            this.age = age;
            this.salary = salary;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name= name;
        }
        public double getSalary(){
            return salary;
        }
        public void setSalary(double salary){
            this.salary = salary;
        }
        public void work(){
            System.out.println(name + "work");
        }

        //重写equals方法


        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Worker)){
                return false;
            }
            Worker worker = (Worker)obj;
            if(worker.getSalary()==this.salary&&worker.getAge()==this.age&&worker.getName().equals(this.name)){
                return true;
            }else {
                return false;
            }
        }

        public int hashCode(){
            String str =  String.format("%s@%d%.2f",name.hashCode(),age,salary);
            return Integer.getInteger(str);
        }

        /*1) 创建一个List，在List 中增加三个工人，基本信息如下：
                姓名年龄工资
                zhang3 18 3000
                li4 25 3500
                wang5 22 3200
                2) 在li4 之前插入一个工人，信息为：姓名：zhao6，年龄：24，工资3300
                3) 删除wang5 的信息
                4) 利用for 循环遍历，打印List 中所有工人的信息
                5) 利用迭代遍历，对List 中所有的工人调用work 方法。
                6) 为Worker 类重写equals 方法，当姓名、年龄、工资全部相等时候才返回true
                7. （Set，Hash 算法）为上一题的Worker 类，在添加完equals 方法的基础上，添加一个hashCode 方法。*/
        public static void main(String[] args) {
            //第1题
            List <Worker>list = new ArrayList<>();
            Worker worker1 = new Worker("zhang3",18,3000);
            Worker worker2 = new Worker("li4",25,3500);
            Worker worker3 = new Worker("wang5",18,3200);
            list.add(worker1);
            list.add(worker2);
            list.add(worker3);
            list.add(1,new Worker("zhao6",24,3300));

            list.remove(worker3);

            for(Worker w:list){
                System.out.println(String.format("姓名:%s年龄:%d工资%.2f",w.getName(),w.getAge(),w.getSalary()));
            }

            for(Iterator <Worker>iterator=list.iterator();iterator.hasNext();){
                iterator.next().work();
            }
        }
    }
}
