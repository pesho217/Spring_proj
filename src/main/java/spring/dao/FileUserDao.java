package spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileUserDao implements IUserDao{


    private FileUserDao fileUserDao;

    private JdbcTemplate jdbcTemplate;

    public FileUserDao(){
        System.out.println("FileUserDao executed!");
    }

    public FileUserDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void getAll(){
        String selectSql = "SELECT * FROM employees";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/myfirstdatabase",
                    "pesho","12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee emp = new Employee();
                emp.setId(resultSet.getInt("emp_id"));
                emp.setName(resultSet.getString("name"));
                emp.setPosition(resultSet.getString("position"));
                emp.setSalary(resultSet.getDouble("salary"));
                employees.add(emp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Employee employee) {
        String sql = "UPDATE employees SET name=?, position=?, salary=? WHERE id=?";
        return jdbcTemplate.update(sql, employee.getName(), employee.getPosition(), employee.getSalary(), employee.getId());
    }

    @Override
    public int insert(Employee employee) {
        String sql = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, employee.getName(), employee.getPosition(), employee.getSalary());
    }

    @Override
    public int delete(Employee employee) {
        return delete(employee.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM employees WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}


