package my.prokopenkodi.classbuilder.controller;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RegisterController {

    private final UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.registerUser(username, password)) {
            return "redirect:/login";
        } else {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
    }
}
