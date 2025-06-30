package my.prokopenkodi.classbuilder.service;

import my.prokopenkodi.classbuilder.entity.Student;

import java.util.List;

public interface StudentService {

    boolean registerUser(String username, String password);

    List<Student> findAll();
}
