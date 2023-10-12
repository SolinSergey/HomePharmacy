package ru.home.project.homepharmacy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "medicines")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "amount")
    private int amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Type type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amount_unit_id")
    private AmountUnit amountUnit;
}
