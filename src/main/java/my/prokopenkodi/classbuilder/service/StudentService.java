package my.prokopenkodi.classbuilder.service;

import my.prokopenkodi.classbuilder.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> registerUser(String username, String email, String password);

    Optional<Student> findByUsername(String username);

    List<Student> findAll();

    Optional<Student> findById(long id);
}
