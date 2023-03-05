package com.example.employeemanagementjdbc.dao;

import com.example.employeemanagementjdbc.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDAO {
    public void insertEmployee(Employee employee) throws SQLException;

    public Employee selectEmployee(int id);

    public List<Employee> selectAllEmployees();

    public boolean deleteEmployee(int id) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;
}
