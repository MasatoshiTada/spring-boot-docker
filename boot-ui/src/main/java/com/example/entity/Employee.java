package com.example.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {

    private Integer id;

    private String name;

    private LocalDate joinedDate;

    private Department department;

    public Employee() {}

    public Employee(String name, LocalDate joinedDate, Department department) {
        this.name = name;
        this.joinedDate = joinedDate;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
