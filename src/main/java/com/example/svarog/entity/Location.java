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
@Table(name = "location")
@ToString(exclude = {"prisoner"})
@EqualsAndHashCode(exclude = {"prisoner"})
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prisoner_id")
    private Prisoner prisoner;
}
