package com.example.svarog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String state;

    @Column
    private String region;

    @Column
    private String city;

    @Column
    private String address;

    @Column
    private String bomj;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prisoner_id", nullable = false)
    private Prisoner prisoner;
}
