package com.ijse.demo.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
    private int id;
    private String name;
    private String address;
}
