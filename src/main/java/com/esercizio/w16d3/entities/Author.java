package com.esercizio.w16d3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private String email;
    private String dateOfBirth;
    private String avatar;
    @OneToMany(mappedBy = "author")
    private List<Blogpost> blogpostList;
}
