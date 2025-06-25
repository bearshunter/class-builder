package my.prokopenkodi.classbuilder.repository;

import my.prokopenkodi.classbuilder.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUsername(String username);
}
