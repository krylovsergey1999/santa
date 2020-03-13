package ru.lanittercom.santa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ru.lanittercom.santa.controller.AbstractControllerAPI.BASE_URI;

// http://localhost:8080/api
@RestController
@RequestMapping(BASE_URI)
public class AbstractControllerAPI {
    protected static final String BASE_URI = "/api";
}
