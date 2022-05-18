package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    public List<Student> findAllByOrderByLastNameAsc();

}
