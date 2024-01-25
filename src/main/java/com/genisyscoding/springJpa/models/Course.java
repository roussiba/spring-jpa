package com.genisyscoding.springJpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Course extends BaseEntity{

    private String name;

    private String description;

    @ManyToMany(mappedBy = "courses")
    private List<Author> authors;

    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}
