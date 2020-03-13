package ru.lanittercom.santa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(PlantController.BASE_URI)
public class PlantController extends AbstractControllerAPI {
    protected static final String BASE_URI = AbstractControllerAPI.BASE_URI + "/plant";
    @GetMapping("/{type}/{quantity}")
    public ResponseEntity productions(@PathVariable String type, @PathVariable long quantity) {
        // производство
        log.info("Производим: " + type + " в колличестве " + quantity);
        return ResponseEntity.ok("Произвели");
    }
}
