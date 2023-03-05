package com.example.employeemanagementjdbc.model;

public class Employee {
    protected int id;
    protected String employee_id;
    protected String name;
    protected String id_number;
    protected String phone;
    protected String address;
    protected String email;
    protected String note;

    public Employee() {
    }

    public Employee(String employee_id, String name, String id_number, String phone, String address, String email, String note) {
        this.employee_id = employee_id;
        this.name = name;
        this.id_number = id_number;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.note = note;
    }

    public Employee(int id, String employee_id, String name, String id_number, String phone, String address, String email, String note) {
        super();
        this.id = id;
        this.employee_id = employee_id;
        this.name = name;
        this.id_number = id_number;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
