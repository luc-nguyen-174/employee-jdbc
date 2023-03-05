package com.example.employeemanagementjdbc.dao;

import com.example.employeemanagementjdbc.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/employee_management?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Nguyenluc97";
    private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employees(employee_id, name, id_number, phone, address, email, note) VALUES (?,?,?,?,?,?,?)";
    private static final String SELECT_EMPLOYEE_BY_ID = "select id, employee_id, name, id_number, phone, address, email, note from employees where id =?";
    private static final String SELECT_ALL_EMPLOYEES = "select * from employees";
    private static final String DELETE_EMPLOYEES_SQL = "delete from employees where id = ?;";
    private static final String UPDATE_EMPLOYEES_SQL = "update employees set employee_id = ? , name = ?, id_number = ?, phone = ?, address = ?, email = ?, note = ? where id = ?;";

    public EmployeeDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEES_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL)
        ) {
            preparedStatement.setString(1, employee.getEmployee_id());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getId_number());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getNote());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String employee_id = rs.getString("employee_id");
                String name = rs.getString("name");
                String id_number = rs.getString("id_number");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String note = rs.getString("note");
                employee = new Employee(id, employee_id, name, id_number, phone, address, email, note);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployees() {
        List<Employee> employee = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
        ) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String employee_id = rs.getString("employee_id");
                String name = rs.getString("name");
                String id_number = rs.getString("id_number");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String note = rs.getString("note");
                employee.add(new Employee(id, employee_id, name, id_number, phone, address, email, note));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE_EMPLOYEES_SQL)) {
            prepareStatement.setInt(1, id);
            rowDeleted = prepareStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }


    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEES_SQL);) {
            preparedStatement.setString(1, employee.getEmployee_id());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getId_number());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getNote());
            preparedStatement.setInt(8, employee.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
