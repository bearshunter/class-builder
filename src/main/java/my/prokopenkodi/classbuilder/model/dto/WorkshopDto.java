package my.prokopenkodi.classbuilder.model.dto;

import my.prokopenkodi.classbuilder.model.entity.WorkshopStatus;

import java.time.Instant;

public record WorkshopDto(
        String id,
        String name,
        String text,
        WorkshopStatus status,
        Instant created,
        IdAndNameDto creator) {

}
