package dev.ranieri.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection(){

        try {
            // jdbc:postgresql://host/dbname?user=username&password=userpassword
            String dbInfo = System.getenv("DB_CONNECTION");
            Connection connection = DriverManager.getConnection(dbInfo);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
    }
}
