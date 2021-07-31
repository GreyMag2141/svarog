package com.example.svarog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "arrival")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prisoner_id")
    private Prisoner prisoner;

 }
