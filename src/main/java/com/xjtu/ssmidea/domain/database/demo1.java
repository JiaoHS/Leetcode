package com.xjtu.ssmidea.domain.database;

import java.sql.*;

public class demo1 {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
            //"com.mysql.jdbc.Driver";
            //"com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://47.95.218.154:3306/ipinfo?useSSL=false&serverTimezone=UTC&autoReconnect=true";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "passw0rd";

    public static void main(String[] args) throws SQLException {
        //demo2();
        //demo3();

        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM ipinfo LIMIT 100";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("ip");
                String url = rs.getString("ip");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

    public static void demo3() {
        System.out.println("MySQL JDBC Example.");
        Connection conn = null;
        String url = "jdbc:mysql://202.117.48.158:3306/ipinfo?autoReconnect=true&useSSL=false";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "root";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
            stmt = conn.createStatement();
            String sql = "select * from vpsip";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("ip");
                System.out.println("id = " + id + ", name = " + name);
            }
            // 关闭资源
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
            }
        }
    }

    public static void demo2() throws SQLException {
        //注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        //获取连接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://202.117.48.158:3306/ipinfo", "root", "root");
        //得到执行sequel语句的对象Statement
        Statement stmt = conn.createStatement();
        //执行sql语句，并返回结果
        ResultSet rs = stmt.executeQuery("select * from vpsip limit 10");

        //处理结果
        while(rs.next()){
            System.out.println(rs.getObject("id"));
            System.out.println(rs.getObject("ip"));
            System.out.println(rs.getObject("createtime"));
            System.out.println(rs.getObject("iplist"));
            System.out.println("-----------------");
        }

        //关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
