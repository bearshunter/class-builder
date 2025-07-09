package my.prokopenkodi.classbuilder.repository;

import my.prokopenkodi.classbuilder.model.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepository extends JpaRepository<Workshop, String>  {
}
