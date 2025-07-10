package my.prokopenkodi.classbuilder.controller;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String register(@RequestParam("username") String username,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password) {
        if (studentService.registerUser(username, email, password).isPresent()) {
            return "login";
        }
        return "register";
    }
}
