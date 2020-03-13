package ru.lanittercom.santa.service;

import java.util.List;

public interface AbstractService<E, DTO> {
    DTO create(DTO newInstanceDto);

    DTO getById(Long id);

    List<DTO> getAll();
}
