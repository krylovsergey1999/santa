package ru.lanittercom.santa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lanittercom.santa.entity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
