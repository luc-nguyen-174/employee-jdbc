package com.example.employeemanagementjdbc.controller;

import com.example.employeemanagementjdbc.dao.EmployeeDAO;
import com.example.employeemanagementjdbc.model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    /*------------------------------Method Get-------------------------------*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showUpdateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                break;
            default:
                listEmployees(request, response);
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDAO.selectEmployee(id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employee/delete.jsp");
        request.setAttribute("employee", employee);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDAO.selectEmployee(id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employee/edit.jsp");
        request.setAttribute("employee", employee);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeDAO.selectAllEmployees();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/list.jsp");
        requestDispatcher.forward(request, response);
    }



    /*------------------------------Method Post-------------------------------*/


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            employeeDAO.deleteEmployee(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Employee> employeeList = employeeDAO.selectAllEmployees();
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("message","Employee was deleted successfully");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employee/delete.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String employee_id = request.getParameter("employee_id");
        String name = request.getParameter("name");
        String id_number = request.getParameter("id_number");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String note = request.getParameter("note");
        Employee employee = new Employee(employee_id, name, id_number, phone, address, email, note);
        try {
            employeeDAO.insertEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employee/create.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        String employee_id = request.getParameter("employee_id");
        String name = request.getParameter("name");
        String id_number = request.getParameter("id_number");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String note = request.getParameter("note");

        Employee employee = new Employee(id, employee_id, name, id_number, phone, address, email, note);
        try {
            employeeDAO.updateEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employee/edit.jsp");
        request.setAttribute("message", "Customer information was updated");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
