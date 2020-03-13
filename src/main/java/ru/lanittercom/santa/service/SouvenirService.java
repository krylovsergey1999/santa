package ru.lanittercom.santa.service;

import ru.lanittercom.santa.dto.SouvenirDTO;
import ru.lanittercom.santa.entity.Souvenir;

import java.util.List;

public interface SouvenirService extends AbstractService<Souvenir, SouvenirDTO> {
    List<SouvenirDTO> getAll();

    SouvenirDTO getSouvenir(String peopleName, String souvenirType);
}
