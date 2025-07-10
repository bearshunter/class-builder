package my.prokopenkodi.classbuilder.controller;

import org.springframework.ui.Model;
import my.prokopenkodi.classbuilder.security.PrincipalUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal PrincipalUser student, Model model) {
        model.addAttribute("username", student.getUsername());
        model.addAttribute("userId", student.id());
        return "dashboard";
    }

    @GetMapping("workshop/{id}")
    public String workshop(@AuthenticationPrincipal PrincipalUser student, Model model) {
        model.addAttribute("username", student.getUsername());
        model.addAttribute("userId", student.id());
        return "workshop";
    }
}
