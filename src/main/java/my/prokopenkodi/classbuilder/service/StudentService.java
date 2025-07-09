package my.prokopenkodi.classbuilder.service;

import my.prokopenkodi.classbuilder.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    boolean registerUser(String username, String email, String password);

    Optional<Student> findByUsername(String username);

    List<Student> findAll();
}
