package my.prokopenkodi.classbuilder.config;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.entity.Student;
import my.prokopenkodi.classbuilder.repository.StudentRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsCustom implements UserDetailsService {
    private final StudentRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new org.springframework.security.core.userdetails.User(
                student.getUsername(),
                student.getPassword(),
                student.getRoles().stream()
                        .map(SimpleGrantedAuthority::new)
                        .toList());
    }
}
