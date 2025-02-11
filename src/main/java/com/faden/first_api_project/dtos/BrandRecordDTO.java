package com.faden.first_api_project.dtos;

import jakarta.validation.constraints.NotBlank;

public record BrandRecordDTO(@NotBlank String name, @NotBlank String description) {}
