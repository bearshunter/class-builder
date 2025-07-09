package my.prokopenkodi.classbuilder.service;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.model.entity.Student;
import my.prokopenkodi.classbuilder.model.entity.Workshop;
import my.prokopenkodi.classbuilder.repository.WorkshopRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkshopServiceImpl implements WorkshopService {

    private final WorkshopRepository workshopRepository;

    @Override
    public Workshop createWorkshop(String name, Student creator, String text) {
        Workshop workshop = new Workshop();
        workshop.setName(name);
        workshop.setCreator(creator);
        workshop.setText(text);
        return workshopRepository.save(workshop);
    }
}
