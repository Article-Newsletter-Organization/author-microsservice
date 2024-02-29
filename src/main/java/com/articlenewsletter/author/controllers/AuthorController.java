package com.articlenewsletter.author.controllers;

import com.articlenewsletter.author.dtos.CreateAuthorDto;
import com.articlenewsletter.author.dtos.UpdateAuthorDto;
import com.articlenewsletter.author.models.AuthorModel;
import com.articlenewsletter.author.services.AuthorService;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/author")
    public ResponseEntity<List<AuthorModel>> getAllAuthors() {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAll());
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Object> getAuthorById(@PathVariable UUID id) {
        Optional<AuthorModel> searchedAuthor = authorService.getById(id);
        if(searchedAuthor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(searchedAuthor.get());
    }

    @PostMapping("/author")
    public ResponseEntity<AuthorModel> saveAuthor(@RequestBody @Valid CreateAuthorDto createAuthorDto) {
        var authorModel = new AuthorModel();
        BeanUtils.copyProperties(createAuthorDto, authorModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.save(authorModel));
    }

    @PutMapping("/author/{id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable UUID id, @RequestBody @Valid UpdateAuthorDto updateAuthorDto) {
        Optional<AuthorModel> searchedAuthor = authorService.getById(id);
        if(searchedAuthor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found.");
        }
        var authorModel = searchedAuthor.get();
        BeanUtils.copyProperties(updateAuthorDto, authorModel);

        return ResponseEntity.status(HttpStatus.OK).body(authorService.save(authorModel));
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable UUID id) {
        Optional<AuthorModel> searchedAuthor = authorService.getById(id);
        if(searchedAuthor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found.");
        }
        authorService.delete(searchedAuthor.get());

        return ResponseEntity.status(HttpStatus.OK).body("Author deleted successfully");
    }

}
