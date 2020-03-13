package ru.lanittercom.santa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lanittercom.santa.dto.OrderDTO;
import ru.lanittercom.santa.dto.SouvenirDTO;
import ru.lanittercom.santa.proxy.PlantServiceProxy;
import ru.lanittercom.santa.service.OrderService;
import ru.lanittercom.santa.service.SouvenirService;

// api/order/
@Slf4j
@RestController
@RequestMapping(OrderController.BASE_URI)
public class OrderController extends AbstractControllerAPI {
    protected static final String BASE_URI = AbstractControllerAPI.BASE_URI + "/order";
    private OrderService orderService;
    private SouvenirService souvenirService;

    @Autowired
    public OrderController(OrderService orderService, SouvenirService souvenirService) {
        this.orderService = orderService;
        this.souvenirService = souvenirService;
    }

    @PostMapping("/create")
    public ResponseEntity<SouvenirDTO> addOrder(OrderDTO orderDTO) {
        orderService.create(orderDTO);
        SouvenirDTO souvenirDTO = souvenirService.getSouvenir(orderDTO.getName(), orderDTO.getType_souvenir());
        return ResponseEntity.status(HttpStatus.CREATED).body(souvenirDTO);
    }
}
