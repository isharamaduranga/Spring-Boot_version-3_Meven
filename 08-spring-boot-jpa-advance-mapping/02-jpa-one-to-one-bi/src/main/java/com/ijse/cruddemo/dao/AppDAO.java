package com.ijse.cruddemo.dao;

import com.ijse.cruddemo.entity.Instructor;
import com.ijse.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailsById(int id);

}
