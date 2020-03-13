package ru.lanittercom.santa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.lanittercom.santa.dto.SouvenirDTO;
import ru.lanittercom.santa.entity.Log;
import ru.lanittercom.santa.entity.Souvenir;
import ru.lanittercom.santa.exception.NotFoundException;
import ru.lanittercom.santa.exception.PlantException;
import ru.lanittercom.santa.mapper.SouvenirMapper;
import ru.lanittercom.santa.proxy.PlantServiceProxy;
import ru.lanittercom.santa.repository.SouvenirRepository;
import ru.lanittercom.santa.service.LogService;
import ru.lanittercom.santa.service.SouvenirService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SouvenirServiceImpl implements SouvenirService {
    @Value("${mitCountSouvenir}")
    private long minCountSouvenir;

    @Value("${countProduce}")
    private long countProduce;

    private SouvenirRepository repository;
    private SouvenirMapper souvenirMapper;
    private PlantServiceProxy plantServiceProxy;
    private LogService logService;

    @Autowired
    public SouvenirServiceImpl(SouvenirRepository repository, SouvenirMapper souvenirMapper, PlantServiceProxy plantServiceProxy, LogService logService) {
        this.repository = repository;
        this.souvenirMapper = souvenirMapper;
        this.plantServiceProxy = plantServiceProxy;
        this.logService = logService;
    }

    @Override
    public SouvenirDTO create(SouvenirDTO newInstanceDto) {
        Souvenir souvenir = souvenirMapper.dtoToEntity(newInstanceDto);
        return souvenirMapper.entityToDto(repository.save(souvenir));
    }

    @Override
    public SouvenirDTO getById(Long id) {
        return souvenirMapper.entityToDto(repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Souvenir.class.getSimpleName())));
    }

    @Override
    public List<SouvenirDTO> getAll() {
        return repository.findAll()
                .stream().map(souvenirMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SouvenirDTO getSouvenir(String souvenirType, String peopleName) {
        Optional<Souvenir> souvenirOptional = repository.findSouvenirByType(souvenirType);
        Souvenir souvenir;
        long count = 0;
        if (!souvenirOptional.isPresent()) {
            souvenir = souvenirMapper.dtoToEntity(create(SouvenirDTO.builder().type(souvenirType).count(count).build()));
        } else {
            souvenir = souvenirOptional.get();
            count = souvenir.getCount();
        }
        try {
            while (count < minCountSouvenir + 1) {
                ResponseEntity responseEntity = plantServiceProxy.productions(souvenirType, countProduce);
                if (responseEntity.getStatusCodeValue() != 200) {
                    throw new PlantException();
                }
                count += countProduce;
            }
        } catch (Exception e) {
            Log log = Log.builder().peopleName(peopleName).message("Возникла ошибка " + e.getMessage()).build();
            logService.logging(log);
            throw new PlantException();
        }
        count -= 1;
        // был бы Security могли бы из контекста достать
        Log log = Log.builder().peopleName(peopleName).message("Получен подарок: " + souvenir.getType()).build();
        logService.logging(log);
        souvenir.setCount(count);
        repository.save(souvenir);
        return souvenirMapper.entityToDto(souvenir);
    }
}
