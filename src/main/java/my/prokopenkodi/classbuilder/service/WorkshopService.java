package my.prokopenkodi.classbuilder.service;

import my.prokopenkodi.classbuilder.model.entity.Student;
import my.prokopenkodi.classbuilder.model.entity.Workshop;

public interface WorkshopService {

    Workshop createWorkshop(String name, Student creator, String text);
}
