package my.prokopenkodi.classbuilder.service;

import lombok.AllArgsConstructor;
import my.prokopenkodi.classbuilder.model.entity.Student;
import my.prokopenkodi.classbuilder.model.entity.Workshop;
import my.prokopenkodi.classbuilder.model.entity.WorkshopStatus;
import my.prokopenkodi.classbuilder.repository.StudentRepository;
import my.prokopenkodi.classbuilder.repository.WorkshopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkshopServiceImpl implements WorkshopService {

    private final WorkshopRepository workshopRepository;
    private final StudentService studentService;

    @Override
    @Transactional
    public Workshop createWorkshop(String name, long creator, String text) {
        Workshop workshop = new Workshop();
        workshop.setName(name);
        workshop.setCreationDate(System.currentTimeMillis());
        workshop.setModificationDate(System.currentTimeMillis());
        workshop.setStatus(WorkshopStatus.PRIVATE);
        workshop.setCreator(studentService.findById(creator).orElse(null));
        workshop.setText(text);
        return workshopRepository.saveAndFlush(workshop);
    }


    @Override
    public List<Workshop> findWorkshopsForCurrentUser(Student creator) {
        return workshopRepository.findByCreator(creator);
    }
}
