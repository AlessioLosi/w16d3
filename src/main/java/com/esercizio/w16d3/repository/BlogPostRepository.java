package com.esercizio.w16d3.repository;

import com.esercizio.w16d3.entities.Blogpost;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface BlogPostRepository extends JpaRepository<Blogpost, Integer> {

    Page findAll(Pageable pageable);
}
