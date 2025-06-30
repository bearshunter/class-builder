package my.prokopenkodi.classbuilder.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "index", "/css/*","/js/*")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic();
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        final UserDetails user = User.builder()
                .username("dpo")
                .password(passwordEncoder.encode("test"))
                .roles("STUDENT")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
