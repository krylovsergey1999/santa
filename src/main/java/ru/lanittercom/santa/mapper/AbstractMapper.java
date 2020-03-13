package ru.lanittercom.santa.mapper;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import ru.lanittercom.santa.dto.BaseDTO;
import ru.lanittercom.santa.entity.BaseEntity;

@Slf4j
public abstract class AbstractMapper<Entity extends BaseEntity, DTO extends BaseDTO> implements Mapper<Entity, DTO> {

    protected ModelMapper modelMapper;
    private Class<Entity> entityClass;
    private Class<DTO> dtoClass;

    AbstractMapper(Class<Entity> entityClass, Class<DTO> dtoClass, ModelMapper mapper) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
        this.modelMapper = mapper;
    }

    @Override
    public Entity dtoToEntity(DTO dto) {
        return Objects.isNull(dto)
                ? null
                : modelMapper.map(dto, entityClass);
    }

    @Override
    public DTO entityToDto(Entity entity) {
        return Objects.isNull(entity)
                ? null
                : modelMapper.map(entity, dtoClass);
    }

    Converter<Entity, DTO> toDtoConverter() {
        return context -> {
            Entity source = context.getSource();
            DTO destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    Converter<DTO, Entity> toEntityConverter() {
        return context -> {
            DTO source = context.getSource();
            Entity destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    void mapSpecificFields(Entity source, DTO destination) {
    }

    void mapSpecificFields(DTO source, Entity destination) {
    }
}
