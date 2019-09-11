package org.zoo.manager.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "kind")
    private String kind;

    @Column(name = "age")
    private Integer age;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "animal_disease",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "disease_id"))
    private List<Disease> diseases;

    public void addDisease(Disease disease) {
        if (diseases == null) {
            diseases = new ArrayList<Disease>();
        }
        this.diseases.add(disease);
    }
}
