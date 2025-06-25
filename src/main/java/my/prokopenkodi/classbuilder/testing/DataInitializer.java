package my.prokopenkodi.classbuilder.testing;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.registerUser("Dmytro Prokopenko", "secretPassword420");
    }
}
