package day19;

import java.sql.*;

public class StudentJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/ConsoleCharRoomUsers";
        Connection con = DriverManager.getConnection(url,"root","banyuan");

        con.setAutoCommit(false);

        Statement stmt = con.createStatement();
/*
        for(int i=0;i<20000;i++) {
            String str = String.format("insert into students (stu_number,stu_name,stu_grade,stu_date) values(\"%d\",\"哈撒给%d\",100,now());", i, i);
            stmt.addBatch(str);
        }*/

        stmt.executeBatch();

        String str = "delete from students where stu_name = \"哈撒给19999\"";
        String str2 = "update students set stu_name=\"花无缺\" where stu_number like \"1999_\"";
        String str3 = "select * from students where stu_name like \"%花%\"";
        String str4 = "update students set stu_grade=stu_grade+5 where stu_name like \"哈%\";";
        stmt.execute(str);
        stmt.execute(str2);
        ResultSet rs = stmt.executeQuery(str3);
        while(rs.next()){
            System.out.printf("%s  %s  %d  %tF\n",rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDate(4));
        }

        stmt.execute(str4);

        rs.close();
        con.commit();
        stmt.close();
        con.close();
    }
}
