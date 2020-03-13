package ru.lanittercom.santa.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String nameEntity) {
        super(nameEntity);
    }
}
