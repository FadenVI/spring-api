package com.faden.first_api_project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Products")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduct;

    private String name;
    private String description;
    private BigDecimal value;
    private String imageURL;

    // Vários produtos terão uma categoria
    @ManyToOne
    @JoinColumn(name = "category_id") // chave estrangeira
    private Category category; //Este campo é passado para o mapeamento da relação

    // Vários produtos terão uma marca
    @ManyToOne
    @JoinColumn(name = "brand_id") // chave estrangeira
    private Brand brand; //Este campo é passado para o mapeamento da relação


}
