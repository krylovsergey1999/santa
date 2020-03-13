package ru.lanittercom.santa.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lanittercom.santa.dto.OrderDTO;
import ru.lanittercom.santa.entity.Order;
import ru.lanittercom.santa.repository.OrderRepository;

import javax.annotation.PostConstruct;

@Component
public class OrderMapper extends AbstractMapper<Order, OrderDTO> {
    private OrderRepository repository;

    @Autowired
    public OrderMapper(ModelMapper mapper, OrderRepository repository) {
        super(Order.class, OrderDTO.class, mapper);
        this.repository = repository;
    }

    @PostConstruct
    public void setupMapper() {
        modelMapper.createTypeMap(Order.class, OrderDTO.class).setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(OrderDTO.class, Order.class).setPostConverter(toEntityConverter());
    }
}
