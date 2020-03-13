package ru.lanittercom.santa.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lanittercom.santa.dto.OrderDTO;
import ru.lanittercom.santa.dto.SouvenirDTO;
import ru.lanittercom.santa.entity.Order;
import ru.lanittercom.santa.entity.Souvenir;
import ru.lanittercom.santa.repository.SouvenirRepository;

import javax.annotation.PostConstruct;

@Component
public class SouvenirMapper extends AbstractMapper<Souvenir, SouvenirDTO> {

    private SouvenirRepository repository;

    @Autowired
    public SouvenirMapper(ModelMapper mapper, SouvenirRepository repository) {
        super(Souvenir.class, SouvenirDTO.class, mapper);
        this.repository = repository;
    }

    @PostConstruct
    public void setupMapper() {
        modelMapper.createTypeMap(Souvenir.class, SouvenirDTO.class).setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(SouvenirDTO.class, Souvenir.class).setPostConverter(toEntityConverter());
    }
}