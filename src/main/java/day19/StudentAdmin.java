package day19;

import java.util.HashMap;
import java.util.TreeMap;

public class StudentAdmin {
    HashMap<Integer, Student> studentHashMap = new HashMap<>();

    void menu(int number, Student student, int stuNumber, String course) {
        while (true) {
            switch (number) {
                case 10:
                    create(student, number);

                case 11:
                    select(number);

                case 12:
                    update(student, number);

                case 13:
                    delete(number);


                case 15:
                    courseSort(course);

                case 16:
                    sumSort();


                default:
                    break;
            }
        }
    }

    void input(int number,int level) {
        studentHashMap.get(number).setSum(level);
    }

    Student select(int number) {
        return studentHashMap.get(number);
    }

    void intindex(Student student, int number) {
        student.setNumber(number);
    }

    void print() {
        for (Integer i : studentHashMap.keySet()) {
            System.out.println(studentHashMap.get(i).toString());
        }
    }


    void create(Student student, int number) {
        intindex(student, number);
        studentHashMap.put(student.number, student);
    }

    void update(Student student, int number) {
        studentHashMap.replace(number, student);
    }

    void delete(int number) {
        studentHashMap.remove(number);
    }

    void courseSort(String course) {
        TreeMap<Integer, Student> treeMap = new TreeMap<>();
        for (Integer i : studentHashMap.keySet()) {
            studentHashMap.get(i).setCourse(course);
            treeMap.put(studentHashMap.get(i).getNumber(), studentHashMap.get(i));
            studentHashMap.putAll(treeMap);
        }
    }

    void sumSort() {
        TreeMap<Integer, Student> treeMap = new TreeMap<>();
        for (Integer i : studentHashMap.keySet()) {
            treeMap.put(studentHashMap.get(i).getNumber(), studentHashMap.get(i));
            studentHashMap.putAll(treeMap);
        }
    }
}
