package ru.lanittercom.santa.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "plant", url = "localhost:8081/api")
public interface PlantServiceProxy {
    @GetMapping("/plant/{type}/{quantity}")
    public ResponseEntity productions(@PathVariable String type, @PathVariable long quantity);
}
