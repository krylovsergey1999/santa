package ru.lanittercom.santa.service.impl;

import org.springframework.stereotype.Service;
import ru.lanittercom.santa.service.PeopleService;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class PeopleServiceImpl implements PeopleService {
    ThreadLocalRandom random = ThreadLocalRandom.current();

    /**
     * Теоретически мы должны по имени куда то стучаться и узнавать, хорошо или плохо себя вел
     *
     * @param name
     * @return
     */
    @Override
    public boolean getBehavior(String name) {
        return random.nextBoolean();
    }
}
