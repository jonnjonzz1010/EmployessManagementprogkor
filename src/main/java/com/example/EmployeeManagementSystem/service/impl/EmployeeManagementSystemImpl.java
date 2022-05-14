package com.example.EmployeeManagementSystem.service.impl;

import com.example.EmployeeManagementSystem.model.Departments;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.model.Gender;
import com.example.EmployeeManagementSystem.model.exception.NotFoundException;
import com.example.EmployeeManagementSystem.service.EmployeeManagementSystemService;
import com.example.EmployeeManagementSystem.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeManagementSystemImpl implements EmployeeManagementSystemService {

    private final List<Employee> dataBase = new ArrayList<>();

    @Autowired
    public EmployeeManagementSystemImpl(){
        dataBase.add(new Employee(1L, "Dominik Varga", Gender.MALE, Departments.NYIREGYHAZA));
        dataBase.add(new Employee(2L, "Kis Katalin", Gender.MALE, Departments.WIEN));

    }

    public EmployeeManagementSystemImpl(final List<Employee> employees) {dataBase.addAll(employees);}

    @Override
    public Employee getEmployee(final Long id){
        return dataBase.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);

    }

    @Override
    public Employee createEmployee(final Employee employee){
        employee.setId(getNextId());
        dataBase.add(employee);
        return employee;


    }

    @Override
    public Employee updateEmployee(final Long id, final Employee employeeChange){
        final Employee employee = getEmployee(id);
        employee.setName(employee.getName());
        employee.setDepartments(employee.getDepartments());
        employee.setGender(employee.getGender());
        return employee;

    }


    @Override
    public void deleteEmployee(final Long id){
        final Employee employee = getEmployee(id);
        dataBase.remove(employee);


    }

    private Long getNextId(){
        return getLastId() + 1L;

    }

    private Long getLastId(){
        return dataBase.stream()
                .mapToLong(employee::getId)
                .max()
                .orElse(0);


    }

}
