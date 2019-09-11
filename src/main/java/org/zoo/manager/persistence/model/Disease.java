package org.zoo.manager.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "disease")
public class Disease {
    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "animal_disease",
            joinColumns = @JoinColumn(name = "disease_id"),
            inverseJoinColumns = @JoinColumn(name = "animal_id"))
    private List<Animal> animals;
}
