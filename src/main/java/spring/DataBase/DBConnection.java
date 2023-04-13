package spring.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection dbConnection;
    private static final String DB_CONN_URL =
            "jdbc:h2:tcp://localhost/~/myfirstdatabase";
    private static final String DB_NAME = "pesho";
    private static final String DB_PASS = "12345";

    public static Connection getInstance() throws SQLException{
        if(dbConnection == null || dbConnection.isClosed()){
            dbConnection = DriverManager.
                    getConnection(DB_CONN_URL, DB_NAME, DB_PASS);

        }
        return dbConnection;
    }
    public void close() throws SQLException{
        if(dbConnection != null){
            dbConnection.close();
        }
    }
}
