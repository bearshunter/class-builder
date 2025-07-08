package my.prokopenkodi.classbuilder.controller;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.model.Student;
import my.prokopenkodi.classbuilder.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {

    private final StudentService studentService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(Student student) {
        studentService.registerUser(student.getUsername(), student.getPassword());
        return "redirect:/dashboard";
    }
}
