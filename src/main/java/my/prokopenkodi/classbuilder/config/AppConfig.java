package my.prokopenkodi.classbuilder.config;


import my.prokopenkodi.classbuilder.model.entity.Student;
import my.prokopenkodi.classbuilder.service.StudentService;
import my.prokopenkodi.classbuilder.service.WorkshopService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner dataLoader(StudentService studentService, WorkshopService workshopService) {
        return args -> {
            studentService.registerUser("user1", "test", "test");
            studentService.registerUser("admin", "test", "test");
            studentService.registerUser("api", "test", "test");
            Optional<Student> student = studentService.registerUser("dpo", "test", "test");

            student.ifPresent(student1 -> createTestWorkshops(workshopService, student1));

        };
    }

    private  void createTestWorkshops(WorkshopService workshopService, Student creator) {
         workshopService.createWorkshop(
                "bear pair",
                4,
                "bay pay\n" +
                        "\n" +
                        "bear pair\n" +
                        "\n" +
                        "bet pet\n" +
                        "\n" +
                        "bill pill\n" +
                        "\n" +
                        "bin pin\n" +
                        "\n" +
                        "bore poor\n" +
                        "\n" +
                        "bought port\n" +
                        "\n" +
                        "cub cup");
        workshopService.createWorkshop(
                "tie die",
                4,
                "tie die\n" +
                        "\n" +
                        "ton done\n" +
                        "\n" +
                        "too do\n" +
                        "\n" +
                        "touch Dutch\n" +
                        "\n" +
                        "train drain\n" +
                        "\n" +
                        "try dry\n" +
                        "\n" +
                        "\n" +
                        "Intermediate\n" +
                        "tear dare\n" +
                        "\n" +
                        "tear dear\n" +
                        "\n" +
                        "ten den\n" +
                        "\n" +
                        "tide dyed\n" +
                        "\n" +
                        "tip dip\n" +
                        "\n" +
                        "tongue dung\n" +
                        "\n" +
                        "torn dawn"); workshopService.createWorkshop(
                "cave gave",
                4,
                "cave gave\n" +
                        "\n" +
                        "clean glean\n" +
                        "\n" +
                        "cot got\n" +
                        "\n" +
                        "crate great\n" +
                        "\n" +
                        "crease Greece\n" +
                        "\n" +
                        "\n" +
                        "Intermediate\n" +
                        "cap gap\n" +
                        "\n" +
                        "cash gash\n" +
                        "\n" +
                        "Co. go\n" +
                        "\n" +
                        "coast ghost\n" +
                        "\n" +
                        "coat goat\n" +
                        "\n" +
                        "come gum\n" +
                        "\n" +
                        "con gone\n" +
                        "\n" +
                        "course gorse\n" +
                        "\n" +
                        "crab grab\n" +
                        "\n" +
                        "cram gram\n" +
                        "\n" +
                        "creek Greek\n" +
                        "\n" +
                        "crepe grape\n" +
                        "\n" +
                        "crew grew\n" +
                        "\n" +
                        "croup group\n" +
                        "\n" +
                        "crow grow\n" +
                        "\n" +
                        "curly girly\n" +
                        "\n" +
                        "cut gut\n" +
                        "\n" +
                        "K gay\n" +
                        "\n" +
                        "key ghee\n" +
                        "\n" +
                        "kill gill");
    }
}
