package com.lk.springdatajpa.service.impl;

import com.lk.springdatajpa.repository.StudentRepository;
import com.lk.springdatajpa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
}
