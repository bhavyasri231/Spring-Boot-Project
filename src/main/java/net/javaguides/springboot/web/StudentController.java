package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService theStudentService){

        studentService = theStudentService;
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage()
    {
        return "fancy-login";
    }

    @GetMapping("/list")
    public String listStudents(Model theModel){

        List<Student> theStudent = studentService.findAll();

        theModel.addAttribute("students",theStudent);

        return "list-students";
    }


    @GetMapping("/courseslist")
    public String CoursesList(Model theModel){

        List<Student> theStudent = studentService.findAll();

        theModel.addAttribute("students",theStudent);

        return "students/courses-form";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        Student theStudent = new Student();

        theModel.addAttribute("student",theStudent);

        return "students/student-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel){

        Student theStudent = studentService.findById(theId);

        theModel.addAttribute("student",theStudent);

        return "students/student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student theStudent){

        studentService.save(theStudent);

        return "redirect:/students/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int theId){

        studentService.deleteById(theId);

        return "redirect:/students/list";
    }

}
