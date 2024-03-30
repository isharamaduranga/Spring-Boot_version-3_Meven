package com.ijse.SpringBootmaster.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ErrorMessage {
    private HttpStatus status;
    private String message;

}
