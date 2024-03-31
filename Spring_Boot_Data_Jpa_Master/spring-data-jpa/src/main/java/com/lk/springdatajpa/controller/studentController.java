package com.lk.springdatajpa.controller;

import com.lk.springdatajpa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class studentController {
    private final StudentService studentService;

}
