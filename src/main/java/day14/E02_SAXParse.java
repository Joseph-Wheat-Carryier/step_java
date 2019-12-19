package day14;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class E02_SAXParse {
    public static class Student {
        String name;
        int age;
        String addess;

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

        public String getAddess() {
            return addess;
        }

        public void setAddess(String addess) {
            this.addess = addess;
        }

        public String toString() {
            return String.format("姓名:%s年龄:%d地址%s", name, age, addess);
        }
    }

    public static class MyHandler extends DefaultHandler {
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        String tempQName;

        public void listToString() {
            System.out.println(list.toString());
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("开始解析");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("结束解析");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName != null) {
                tempQName = qName;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("student")) {
                list.add(student);
                student = new Student();
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (tempQName.equals("name")) {
                student.setName(new String(ch, start, length));
            }
            if (tempQName.equals("age")) {
                student.setAge(new Integer(new String(ch, start, length)));
            }
            if (tempQName.equals("address")) {
                student.setAddess(new String(ch, start, length));
            }
        }
    }

    ;

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();

        parser.parse("students.xml", handler);
        handler.listToString();
    }
}
