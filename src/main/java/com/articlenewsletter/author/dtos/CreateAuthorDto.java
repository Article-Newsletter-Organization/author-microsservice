package com.articlenewsletter.author.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateAuthorDto(@NotBlank String name,
                              @NotBlank @Email String email,
                              String bio,
                              @NotNull UUID userId) {
}
