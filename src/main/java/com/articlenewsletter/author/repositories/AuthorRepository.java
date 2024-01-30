package com.articlenewsletter.author.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.articlenewsletter.author.models.AuthorModel;

public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {
}
