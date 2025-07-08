package my.prokopenkodi.classbuilder.controller;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.model.Student;
import my.prokopenkodi.classbuilder.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {


    private final StudentService studentService;


    @GetMapping
    public List<Student> getStudents() {
        return studentService.findAll();
    }
}
