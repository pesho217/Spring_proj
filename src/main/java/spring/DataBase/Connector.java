package spring.DataBase;

import java.sql.*;

public class Connector {
    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.
                    getConnection("jdbc:h2:tcp://localhost/~/myfirstdatabase",
                            "pesho","12345");
            System.out.println("Connection isValid/no:"
                    + conn.isValid(5));
            String querySellectAll = "SELECT * FROM STUDENTS";
            Statement StatementSelectAll = conn.createStatement();
            ResultSet rs = StatementSelectAll.executeQuery(querySellectAll);

            while(rs.next()){
                System.out.println(rs.getInt(("ID")));
                System.out.println(rs.getString("NAME"));
            }
            conn.close();

        } catch(SQLException e){
            System.out.println(e.getMessage());


        }
    }
}
