package my.prokopenkodi.classbuilder.controller.rest;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.security.PrincipalUser;
import my.prokopenkodi.classbuilder.model.dto.WorkshopDto;
import my.prokopenkodi.classbuilder.model.entity.Student;
import my.prokopenkodi.classbuilder.model.entity.Workshop;
import my.prokopenkodi.classbuilder.service.StudentService;
import my.prokopenkodi.classbuilder.service.WorkshopService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/workshop")
@AllArgsConstructor
public class WorkshopController {

    private final StudentService studentService;
    private final WorkshopService workshopService;

    @GetMapping
    public List<WorkshopDto> workshops(@AuthenticationPrincipal PrincipalUser user) {
        Optional<Student> student = studentService.findById(user.id());
        List<Workshop> workshopsForCurrentUser = workshopService
                .findWorkshopsForCurrentUser(student.orElse(null));
        return null;
    }

    @GetMapping("{id}")
    public WorkshopDto workshop(@PathVariable(name = "id") String id,
                                @AuthenticationPrincipal PrincipalUser user) {
        Optional<Student> student = studentService.findById(user.id());
        Workshop workshopForCurrentUser = workshopService
                .findWorkshopsForCurrentUser(student.orElse(null))
                .stream()
                .filter(workshop -> id.equals(workshop.getId())).findFirst()
                .orElse(null);
        return null;
    }
}
