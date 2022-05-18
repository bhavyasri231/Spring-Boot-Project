package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository theStudentRepository)
    {
        studentRepository = theStudentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAllByOrderByLastNameAsc() ;
    }

    @Override
    public Student findById(int theId) {

        Optional<Student> result = studentRepository.findById(theId);

        Student theStudent = null;

        if(result.isPresent()){
            theStudent = result.get();
        }
        else {
            throw new RuntimeException("Did not find the student id - " + theId);
        }

        return theStudent;
    }

    @Override
    public void save(Student theStudent) {

        studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {

        studentRepository.deleteById(theId);
    }
}
