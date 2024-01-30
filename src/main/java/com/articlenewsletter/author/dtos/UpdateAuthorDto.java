package com.articlenewsletter.author.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateAuthorDto(@NotBlank String name,
                              @NotBlank @Email String email,
                              String bio) {
}
