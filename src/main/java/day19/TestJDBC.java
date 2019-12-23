package day19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/ConsoleCharRoomUsers";
            con = DriverManager.getConnection(url,"root","banyuan");
            System.out.println(con.isClosed());
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            Statement sq = con.createStatement();
            String sql = "create table users (stu_account varchar (10) not null,stu_password varchar (10),stu_nickname varchar (10));";
            sq.execute(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
