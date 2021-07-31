package com.example.svarog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "arrival")
public class Arrival {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String 	mode_type;

    @Column(nullable = false)
    private String where_arrived;

    @Column(nullable = false)
    private String where_directed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prisoner_id", nullable = false)
    private Prisoner prisoner;

 }
