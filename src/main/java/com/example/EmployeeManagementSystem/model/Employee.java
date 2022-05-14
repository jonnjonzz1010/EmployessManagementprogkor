package com.example.EmployeeManagementSystem.model;

import java.util.Objects;

public class Employee {
    private Long id;
    private String name;
    private Gender gender;
    private Departments departments;

    public Employee(){

    }

    public Employee(Long id, String name, Gender gender, Departments departments) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.departments = departments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) && name.equals(employee.name) && gender.equals(employee.gender) && departments.equals(employee.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, departments);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", departments=" + departments +
                '}';
    }
}
