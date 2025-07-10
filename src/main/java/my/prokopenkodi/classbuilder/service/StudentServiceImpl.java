package my.prokopenkodi.classbuilder.service;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.model.entity.Student;
import my.prokopenkodi.classbuilder.model.entity.UserRole;
import my.prokopenkodi.classbuilder.repository.StudentRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<Student> registerUser(String username, String email, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already in use");
        }

        final Student student = new Student(username,  passwordEncoder.encode(password), Set.of(UserRole.USER));
        final Student savedEntity = userRepository.save(student);
        return Optional.of(savedEntity);
    }

    @Override
    public List<Student> findAll() {
        return userRepository.findAll();
    }


    @Override
    public Optional<Student> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<Student> findById(long id) {
        return userRepository.findById(id);
    }
}
