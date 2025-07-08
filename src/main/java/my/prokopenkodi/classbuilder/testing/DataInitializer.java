package my.prokopenkodi.classbuilder.testing;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        studentService.registerUser("dpo", "test", "test");
    }
}
