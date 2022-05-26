package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();

    public Student findById(int theId);

    public void save(Student theStudent);

    public void deleteById(int theId);


    public Student findByEmail(String theEmail);
}
