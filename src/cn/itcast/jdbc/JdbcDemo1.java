package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onepiece","root","root");
        String sql = "update users set name = '罗彬彬' where id = 3";
        String sql1 = "select * from users";
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        final ResultSet rs = stmt.executeQuery(sql1);
        rs.next();
        int id = rs.getInt(1);
        String name = rs.getString("name");
        System.out.println(count);
        System.out.println(id);
        System.out.println(name);
        stmt.close();
        conn.close();
    }
}
