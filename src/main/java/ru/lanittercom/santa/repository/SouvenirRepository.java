package ru.lanittercom.santa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lanittercom.santa.entity.Souvenir;

import java.util.Optional;

@Repository
public interface SouvenirRepository extends JpaRepository<Souvenir, Long> {
    Optional<Souvenir> findSouvenirByType(String souvenirType);
}
