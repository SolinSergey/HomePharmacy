package ru.home.project.homepharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.project.homepharmacy.entities.AmountUnit;
import ru.home.project.homepharmacy.entities.Type;

@Repository
public interface AmountUnitRepository extends JpaRepository<AmountUnit, Long> {
    AmountUnit findAllByTitle(String title);
}
