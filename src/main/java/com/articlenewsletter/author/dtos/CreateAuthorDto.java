package com.articlenewsletter.author.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CreateAuthorDto(@NotBlank String name,
                              @NotBlank @Email String email,
                              String bio,
                              @NotBlank UUID userId) {
}
