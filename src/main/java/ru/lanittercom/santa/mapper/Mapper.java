package ru.lanittercom.santa.mapper;

import ru.lanittercom.santa.dto.BaseDTO;
import ru.lanittercom.santa.entity.BaseEntity;

public interface Mapper<Entity extends BaseEntity, DTO extends BaseDTO> {
    DTO entityToDto(Entity entity);

    Entity dtoToEntity(DTO dto);
}
