package com.faden.first_api_project.dtos;

import jakarta.validation.constraints.NotBlank;

public record CategoryRecordDTO(@NotBlank String name, @NotBlank String description) {}
