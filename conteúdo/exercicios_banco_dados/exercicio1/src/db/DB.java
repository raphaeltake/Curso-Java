package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection(){
        try{

            if (conn == null){
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }

            return conn;
        } catch (SQLException e) {
            throw new DbExcepetion(e.getMessage());
        }
    }

    public static void closeConnection(){
        try {

            if (conn != null){
                conn.close();
            }

        } catch (SQLException e) {
            throw new DbExcepetion(e.getMessage());
        }
    }

    private static Properties loadProperties(){
        try(FileInputStream fis = new FileInputStream("exercicio1/db.properties")) {

            Properties props = new Properties();
            props.load(fis);
            return props;

        } catch (IOException e){
            throw new DbExcepetion(e.getMessage());
        }
    }

    public static void closeResultSet(ResultSet rs){
        try{
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            throw new DbExcepetion(e.getMessage());
        }
    }

    public static void closeStatement(Statement st){
        try{
            if (st != null){
                st.close();
            }
        } catch (SQLException e){
            throw new DbExcepetion(e.getMessage());
        }
    }

}
