package my.prokopenkodi.classbuilder.config;


import my.prokopenkodi.classbuilder.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner dataLoader(StudentService studentService) {
        return args -> {
            studentService.registerUser("user1", "test","test");
            studentService.registerUser("admin", "test","test");
            studentService.registerUser("api", "test","test");
            studentService.registerUser("dpo", "test","test");
        };
    }
}
