package com.faden.first_api_project.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "brands")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idBrand;

    private String name;
    public String description;

    //Uma marca terá vários produtos
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();
}
