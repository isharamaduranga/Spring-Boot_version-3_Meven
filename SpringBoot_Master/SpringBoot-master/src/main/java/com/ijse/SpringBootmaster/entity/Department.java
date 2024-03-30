package com.ijse.SpringBootmaster.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Builder
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long departmentId;

    //   @Length(max = 10,min = 1)
    //   @Size(max = 10,min = 0)
    @NotBlank(message = "Please add Department Name")
    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_Address")
    private String departmentAddress;

    @Column(name = "department_code")
    private String departmentCode;

}
