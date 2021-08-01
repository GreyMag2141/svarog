package com.example.svarog.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"questionnaires"})
@EqualsAndHashCode(exclude = {"questionnaires"})
@Table(name = "prisoner")
@DynamicUpdate
public class Prisoner {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;

    @Column
    private String name;

    @Column
    private String sername;

    @Column
    private String patronymic;

    @Column(nullable = false)
    private ZonedDateTime dateBirth;

    @Column
    private String personalNumber; // № Личное дело

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender; // пол

    public enum Gender {
        MAN,
        WOMAN
    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prisoner", orphanRemoval = true)
    @Builder.Default
    private List<Questionnaire> questionnaires = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prisoner", orphanRemoval = true)
    @Builder.Default
    private List<Arrival> arrivals = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prisoner", orphanRemoval = true)
    @Builder.Default
    private List<Location> locations = new ArrayList<>();
}
