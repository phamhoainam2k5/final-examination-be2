package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.internal.build.AllowNonPortable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name-city")
    private String nameCity;

    @Column(name = "quocgia")
    private String quocgia;

    @Column(name = "s")
    private Long s;

    @Column(name = "people")
    private Long peopleCity;

    @Column(name = "GDP")
    private Long gdp;

    @Column(name = "description")
    private String description;
}
