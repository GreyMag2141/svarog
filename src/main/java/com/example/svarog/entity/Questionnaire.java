package com.example.svarog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@Entity
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questionnaire")
@ToString(exclude = {"prisoner"})
@EqualsAndHashCode(exclude = {"prisoner"})
public class Questionnaire {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String citizenship;

    @Column
    private String nationality;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prisoner_id")
    private Prisoner prisoner;

}
