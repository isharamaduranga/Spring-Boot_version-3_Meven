package com.ijse.SpringBootmaster.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class DepartmentDTO {
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
