package com.esercizio.w16d3.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "blogpost")
public class Blogpost {
    @Id
    @GeneratedValue
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public void setAuthorId(int authorId) {

    }
}
