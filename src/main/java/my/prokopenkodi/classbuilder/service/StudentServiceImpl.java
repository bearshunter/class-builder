package my.prokopenkodi.classbuilder.service;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.entity.Student;
import my.prokopenkodi.classbuilder.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository userRepository;

    @Override
    public boolean registerUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            return false;
        }
        Set<String> roles = new HashSet<>();
        roles.add("ROLE_USER");
        my.prokopenkodi.classbuilder.entity.Student student =
                new my.prokopenkodi.classbuilder.entity.Student(username, "{noop}"+password, roles);
        userRepository.save(student);
        return true;
    }

    @Override
    public List<Student> findAll() {
        return userRepository.findAll();
    }
}
