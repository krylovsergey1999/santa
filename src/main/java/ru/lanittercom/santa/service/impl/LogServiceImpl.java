package ru.lanittercom.santa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lanittercom.santa.entity.Log;
import ru.lanittercom.santa.repository.LogRepository;
import ru.lanittercom.santa.service.LogService;

@Service
public class LogServiceImpl implements LogService {

    private LogRepository logRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void logging(Log log) {
        logRepository.save(log);
    }
}
