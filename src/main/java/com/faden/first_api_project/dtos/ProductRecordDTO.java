package com.faden.first_api_project.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

// Conversão do JSON para modelo JAVA
// Mapear os campos do JSON
// Passa os campos dentro dos parênteses que serão recebidos via JSON
public record ProductRecordDTO(
                                @NotBlank String name,
                                @NotBlank String description,
                                @NotNull UUID brand_id,
                                @NotNull UUID category_id,
                                @NotNull BigDecimal value,
                                String imageURL) {}
