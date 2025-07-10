package my.prokopenkodi.classbuilder.security;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.model.entity.Student;
import my.prokopenkodi.classbuilder.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/css/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


    @Bean
    public UserDetailsService userDetailsService(StudentService studentService) {
        return username -> {
            Optional<Student> student = studentService.findByUsername(username);
            if (student.isEmpty()) {
                throw new UsernameNotFoundException("User '" + username + "' not found");
            }
            return createUserDetails(student.get());
        };
    }

    private PrincipalUser createUserDetails(Student student) {
        return new PrincipalUser(student.getId(), student.getUsername(), student.getPassword());
    }
}
