package ru.home.project.homepharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.project.homepharmacy.entities.Medicine;
import ru.home.project.homepharmacy.entities.Type;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}