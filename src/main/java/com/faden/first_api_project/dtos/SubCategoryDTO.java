package com.faden.first_api_project.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SubCategoryDTO(@NotBlank String name, @NotBlank String description, @NotNull UUID category_id) {}
