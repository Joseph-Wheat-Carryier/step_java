package day14;

import java.io.*;

public class E01_Objsteam {
    public static class Student implements Serializable {
        String name;
        int age;
        String des;

        @Override
        public String toString() {
            return String.format("姓名:%s,年龄:%s,地址:%s", name, age, des);
        }

        public Student(String name, int age, String des) {
            this.name = name;
            this.age = age;
            this.des = des;

        }
    }

    public static void main(String[] args) {
        Student stu1 = new Student("小李", 20, "仙林");
        Student stu2 = new Student("小张", 21, "鼓楼");
        Student stu3 = new Student("小赵", 22, "玄武湖");

        try (OutputStream os = new FileOutputStream(new File("src/students.txt")); ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(stu1);
            os.write('\n');
            oos.writeObject(stu2);
            os.write('\n');
            oos.writeObject(stu3);
            os.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream os = new FileInputStream(new File("src/students.txt")); ObjectInputStream oos = new ObjectInputStream(os)) {
            do {
                try {
                    Student temp = (Student) oos.readObject();

                    System.out.println(temp.toString());
                }catch (EOFException e){
                    System.out.println("读完了");
                    break;
                }
            } while (os.read() == '\n');

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
