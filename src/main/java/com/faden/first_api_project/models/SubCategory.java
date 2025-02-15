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
@Table(name = "subcategories")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SubCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idSubCategory;

    private String name;
    public String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "subCategory", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();
}
