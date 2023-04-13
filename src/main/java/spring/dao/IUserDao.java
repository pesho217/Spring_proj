package spring.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import spring.DataBase.Connector;

public interface IUserDao {
    public void getAll();
    int update(Employee employee);
    int insert(Employee employee);
    int delete(Employee employee);
    int delete(int id);

}
