package ru.lanittercom.santa.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.lanittercom.santa.proxy.PlantServiceProxy;

@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadBehavoirException.class)
    protected ResponseEntity<BadBehavior> handleBadBehavior() {
        return new ResponseEntity<>(new BadBehavior("Ребенок плохо себя вел!"), HttpStatus.BAD_REQUEST);
    }

    @Data
    @AllArgsConstructor
    private static class BadBehavior {
        private String message;
    }

    @ExceptionHandler(PlantException.class)
    protected ResponseEntity<PlantNotWorking> handlePlantNotWorking() {
        return new ResponseEntity<>(new PlantNotWorking("Завод не работает"), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Data
    @AllArgsConstructor
    private static class PlantNotWorking {
        private String message;
    }
}