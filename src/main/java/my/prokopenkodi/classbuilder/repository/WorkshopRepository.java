package my.prokopenkodi.classbuilder.repository;

import my.prokopenkodi.classbuilder.model.entity.Student;
import my.prokopenkodi.classbuilder.model.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkshopRepository extends JpaRepository<Workshop, String>  {


    List<Workshop> findByCreator(Student creator);


}
