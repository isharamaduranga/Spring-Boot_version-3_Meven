package com.ijse.employeems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    private String empAddress;
    private String empMNumber;

    public Employee(String empName, String empAddress, String empMNumber) {
        this.empName = empName;
        this.empAddress = empAddress;
        this.empMNumber = empMNumber;
    }
}
