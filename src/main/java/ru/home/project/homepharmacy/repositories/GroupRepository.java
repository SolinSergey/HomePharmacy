package ru.home.project.homepharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.project.homepharmacy.entities.Group;
import ru.home.project.homepharmacy.entities.Type;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findAllByTitle(String title);
}
