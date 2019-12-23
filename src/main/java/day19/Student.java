package day19;

import java.util.Comparator;

public class Student implements Comparator {
    int number;
    String name;
    int age;
    int python;
    int java;
    int linux;
    int sql;
    int sum;
    int avg;

    public void setCourse(String course) {
        this.course = course;
    }

    String course=null;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPython() {
        return python;
    }

    public void setPython(int python) {
        this.python = python;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getLinux() {
        return linux;
    }

    public void setLinux(int linux) {
        this.linux = linux;
    }

    public int getSql() {
        return sql;
    }

    public void setSql(int sql) {
        this.sql = sql;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        String str = String.format("姓名:%s\n学号:%d\n年龄:%d\n平均分:%d\n", name, number, age, avg);
        return str;
    }


    public int compare(Object o1, Object o2) {
        Student student1 = (Student) o1;
        Student student2 = (Student) o2;

        switch (course) {

            case "java":
                return student1.getJava() - student2.getJava();

            case "linux":
                return student1.getLinux() - student2.getLinux();


            case "python":
                return student1.getPython() - student2.getPython();

            case "sql":
                return student1.getSql() - student2.getSql();

            default:
                return student1.getSum() - student2.getSum();
        }

    }
}
