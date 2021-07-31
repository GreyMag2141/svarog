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
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;

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
    @JoinColumn(name = "prisoner_id")
    private Prisoner prisoner;
}
