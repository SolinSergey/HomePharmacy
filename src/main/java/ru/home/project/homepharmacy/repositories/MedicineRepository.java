package ru.home.project.homepharmacy.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.project.homepharmacy.entities.AmountUnit;
import ru.home.project.homepharmacy.entities.Group;
import ru.home.project.homepharmacy.entities.Medicine;
import ru.home.project.homepharmacy.entities.Type;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    Medicine findByAmountUnitAndTypeAndGroupAndTitle(AmountUnit amountUnit, Type type, Group group, String title, Sort sort);

    List<Medicine> findAllByGroupAndType(Group group, Type type, Sort sort);

    List<Medicine> findAllByGroup(Group group, Sort sort);

    List<Medicine> findAllByType(Type type, Sort sort);
}
