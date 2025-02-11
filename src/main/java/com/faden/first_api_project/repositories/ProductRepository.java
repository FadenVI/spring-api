package com.faden.first_api_project.repositories;

import com.faden.first_api_project.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// Habilita os métodos prontos para interação com o banco de dados
// Será necessário identificar o modelo da entidade o seu identificador
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {}
