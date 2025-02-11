package com.faden.first_api_project.services;

import com.faden.first_api_project.dtos.ProductRecordDTO;
import com.faden.first_api_project.models.Brand;
import com.faden.first_api_project.models.Category;
import com.faden.first_api_project.models.Product;
import com.faden.first_api_project.repositories.BrandRepository;
import com.faden.first_api_project.repositories.CategoryRepository;
import com.faden.first_api_project.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BrandRepository brandRepository;

    @Transactional
    public Product createProduct(ProductRecordDTO productRecordDto) {
        var product = new Product();
        BeanUtils.copyProperties(productRecordDto, product);

        // Buscar a categoria no banco pelo ID recebido no DTO
        Category category = categoryRepository.findById(productRecordDto.category_id())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        // Buscar a marca no banco pelo ID recebido no DTO
        Brand brand = brandRepository.findById(productRecordDto.brand_id())
                .orElseThrow(() -> new RuntimeException("Marca não encontrada"));

        // Definir a categoria no produto
        product.setCategory(category);
        product.setBrand(brand);

        return productRepository.save(product);

    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Para reaproveitar essa função em outras, tenho que converter ela para retornar um Product e criar exceções personalizadas
    public Object getProductByID(UUID id) {

        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }

        return productOptional.get();
    }

    public Object updateProduct(UUID id, ProductRecordDTO productRecordDto) {

        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }

        var product = productOptional.get();
        BeanUtils.copyProperties(productRecordDto, product);

        // Buscar a categoria no banco pelo ID recebido no DTO
        Category category = categoryRepository.findById(productRecordDto.category_id())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        // Buscar a marca no banco pelo ID recebido no DTO
        Brand brand = brandRepository.findById(productRecordDto.brand_id())
                .orElseThrow(() -> new RuntimeException("Marca não encontrada"));

        // Definir a categoria no produto
        product.setCategory(category);
        product.setBrand(brand);

        return productRepository.save(product);
    }

    public Object deleteProduct(UUID id) {

        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }

        var product = productOptional.get();
        productRepository.deleteById(product.getIdProduct());

        return "Produto " + productOptional.get().getName() + " excluído com sucesso";
    }
}
