package ru.home.project.homepharmacy.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "types")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
}
