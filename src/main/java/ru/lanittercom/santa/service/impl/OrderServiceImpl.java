package ru.lanittercom.santa.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lanittercom.santa.dto.OrderDTO;
import ru.lanittercom.santa.entity.Order;
import ru.lanittercom.santa.exception.BadBehavoirException;
import ru.lanittercom.santa.exception.NotFoundException;
import ru.lanittercom.santa.mapper.OrderMapper;
import ru.lanittercom.santa.repository.OrderRepository;
import ru.lanittercom.santa.service.OrderService;
import ru.lanittercom.santa.service.PeopleService;
import ru.lanittercom.santa.service.SouvenirService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;
    private PeopleService peopleService;
    private SouvenirService souvenirService;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, PeopleService peopleService, SouvenirService souvenirService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.peopleService = peopleService;
        this.souvenirService = souvenirService;
    }


    @Override
    public OrderDTO create(OrderDTO newInstanceDto) {
        Order order = orderRepository.save(orderMapper.dtoToEntity(newInstanceDto));
        boolean peopleBehavior = peopleService.getBehavior(order.getName()); // true - хорошее, false - плохое
        if (!peopleBehavior) {
            throw new BadBehavoirException();
        }
        return orderMapper.entityToDto(order);
    }

    @Override
    public OrderDTO getById(Long id) {
        return orderMapper.entityToDto(orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Order.class.getSimpleName())));
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll()
                .stream().map(orderMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
