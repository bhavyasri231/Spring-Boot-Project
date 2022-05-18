package net.javaguides.springboot.security;

import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.repository.StudentRepository;
import net.javaguides.springboot.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    void findAll() {
        when(studentRepository.findAllByOrderByLastNameAsc())
                .thenReturn(Stream.of(
                                new Student(10,"kavya","mudhiraj","kavya@gmail.com","spring"),
                                new Student(11,"rani","raj","rani@gmail.com","HTML")).
                        collect(Collectors.toList()));

        assertEquals(2, studentService.findAll().size());
    }

    @Test
    void findById() {
        int id = 0;
        Student student = new Student();
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        assertEquals(student, studentService.findById(0));
    }

    @Test
    void save() {
        Student student = new Student(9,"abdulla","begum","abdulla@gmail.com","java");
        studentService.save(student);
        verify(studentRepository,times(1)).save(student);
    }

    @Test
    void deleteById() {
        Student student = new Student();
        student.setId(9);
        studentService.deleteById(9);
        verify(studentRepository,times(1)).deleteById(9);
    }
}