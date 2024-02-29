package com.articlenewsletter.author.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.articlenewsletter.author.models.AuthorModel;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}
