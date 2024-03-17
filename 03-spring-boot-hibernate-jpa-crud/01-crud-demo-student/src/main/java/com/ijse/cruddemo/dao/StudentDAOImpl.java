package com.ijse.cruddemo.dao;

import com.ijse.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private final EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        //create query
        TypedQuery<Student> fromStudent = entityManager.createQuery("from Student", Student.class);

        // return query results
        return fromStudent.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> typedQuery =
                entityManager.createQuery("from Student where lastName=:theData", Student.class);

        //set query parameter
        typedQuery.setParameter("theData", lastName);

        // return query results
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        Student student = entityManager.find(Student.class, id);

        //remove student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numOfRowDeleted = entityManager.createQuery("DELETE FROM Student ").executeUpdate();
        return numOfRowDeleted;
    }
}
