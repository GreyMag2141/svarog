package com.example.svarog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
//@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prisoner")
public class Prisoner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sername;

    @Column
    private String patronymic;

    @Column(nullable = false)
    private ZonedDateTime date_birth;

    @Column
    private String personal_number; // № Личное дело

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
}
