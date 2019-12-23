package day19;

public class StudentTest {
    public static void main(String[] args) {
        StudentAdmin studentAdmin = new StudentAdmin();
        Student student1 = new Student();
        student1.setNumber(1);
        student1.setName("小张");

        Student student2 = new Student();
        student1.setNumber(2);
        student1.setName("小李");
        student1.setJava(100);
        studentAdmin.create(student1,1);

        studentAdmin.input(1,100);

        studentAdmin.create(student2,2);

        studentAdmin.courseSort("java");

        studentAdmin.print();

    }
}
