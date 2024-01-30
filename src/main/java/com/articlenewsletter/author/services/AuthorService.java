package com.articlenewsletter.author.services;

import com.articlenewsletter.author.models.AuthorModel;
import com.articlenewsletter.author.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Transactional
    public AuthorModel save(AuthorModel authorModel) {
        return authorRepository.save(authorModel);
    }

    public List<AuthorModel> getAll() {
        return authorRepository.findAll();
    }

    public Optional<AuthorModel> getById(Long id) {
        return authorRepository.findById(id);
    }

    @Transactional
    public void delete(AuthorModel authorModel) {
        authorRepository.delete(authorModel);
    }

}
