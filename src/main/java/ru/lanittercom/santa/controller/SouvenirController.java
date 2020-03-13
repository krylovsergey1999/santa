package ru.lanittercom.santa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lanittercom.santa.service.SouvenirService;

@RestController
@RequestMapping(AbstractControllerAPI.BASE_URI + "/souvenir")
public class SouvenirController extends AbstractControllerAPI {

    private SouvenirService service;

    @Autowired
    public SouvenirController(SouvenirService souvenirService) {
        this.service = souvenirService;
    }
}
