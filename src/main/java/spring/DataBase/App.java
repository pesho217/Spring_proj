package spring.DataBase;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVRecord;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.Reader;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


public class App {
    public static void main(String[] args) {


//        try{
//            Connection conn = DBConnection.getInstance();
//            String CreateTableQuery =
//                    "CREATE TABLE IF NOT EXISTS USERNAMES(USERNAME VARCHAR(255), ID INTEGER, FNAME VARCHAR(255), LNAME VARCHAR(255)) ";
//            String TruncateTableQuery = "TRUNCATE TABLE USERNAMES";
//            String InsertValuesQuery = "INSERT INTO USERNAMES(USERNAME, ID, FNAME, LNAME) VALUES(?, ?, ?, ?)";
//            Statement statement = conn.createStatement();
//
//            conn.setAutoCommit(false);
//
//            statement.execute(CreateTableQuery);
//            statement.execute(TruncateTableQuery);
//            PreparedStatement InsertValuesStatement = conn.prepareStatement(InsertValuesQuery);
//            try {
//                Reader in = new FileReader("C:\\Users\\Lenovo\\IdeaProjects\\Spring_proj\\src\\main\\resources\\username.csv");
//                Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().withDelimiter(';').parse(in);
//                for (CSVRecord record : records) {
//                    String username = record.get("Username");
//                    Integer Identifier = Integer.valueOf(record.get("Identifier"));
//                    String lastName = record.get("Last name");
//                    String firstName = record.get("First name");
//
//                    InsertValuesStatement.setString(1, username);
//                    InsertValuesStatement.setInt(2, Identifier);
//                    InsertValuesStatement.setString(3, lastName);
//                    InsertValuesStatement.setString(4, firstName);
//
//                    InsertValuesStatement.executeUpdate();
//                    InsertValuesStatement.addBatch();
//
//                }
//                InsertValuesStatement.executeBatch();
//                conn.commit();
//                statement.close();
//                conn.close();
//                InsertValuesStatement.close();
//            }catch(IOException e){
//                System.out.println(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        context.getBeanDefinitionNames();
        for(String bean: context.getBeanDefinitionNames()){
            System.out.println(bean);
        }
        String [] bean = context.getBeanDefinitionNames();
        for(int i = 0; i < bean.length; i++){
            System.out.println(bean[i]);
        }


    }
}
