package my.prokopenkodi.classbuilder.service;
import my.prokopenkodi.classbuilder.model.dto.WorkshopDto;
import my.prokopenkodi.classbuilder.model.entity.Workshop;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WorkshopMapper {

    List<WorkshopDto> toDto(List<Workshop> entity);

    WorkshopDto toDto( Workshop entity);

}
