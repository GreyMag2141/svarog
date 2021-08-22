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
@Table(name = "arrival")
@ToString(exclude = {"prisoner"})
@EqualsAndHashCode(exclude = {"prisoner"})
public class Arrival {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String 	mode_type;

    @Column(nullable = false)
    private String where_arrived;

    @Column(nullable = false)
    private String where_directed;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prisoner_id")
    private Prisoner prisoner;

 }
