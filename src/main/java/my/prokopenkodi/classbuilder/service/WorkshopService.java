package my.prokopenkodi.classbuilder.service;

import my.prokopenkodi.classbuilder.model.entity.Student;
import my.prokopenkodi.classbuilder.model.entity.Workshop;

import java.util.List;

public interface WorkshopService {

    Workshop createWorkshop(String name, long creator, String text);

    List<Workshop> findWorkshopsForCurrentUser(Student creator);
}
