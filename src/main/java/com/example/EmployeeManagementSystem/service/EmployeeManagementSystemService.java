package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.model.Employee;

import java.util.List;

public interface EmployeeManagementSystemService {
    List<Employee> getAllEmployees();
    Employee getEmployee(Long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employeeChane);
    void deleteEmployee(Long id);


}
