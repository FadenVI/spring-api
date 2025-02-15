package com.faden.first_api_project.controllers;

import com.faden.first_api_project.dtos.ProductRecordDTO;
import com.faden.first_api_project.models.Product;
import com.faden.first_api_project.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000") // Permite requisições do React
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<Object> getProductByID(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByID(id));
    }

    @PostMapping("/product/new")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRecordDTO productRecordDto) {
        var product = productService.createProduct(productRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid ProductRecordDTO productRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.updateProduct(id, productRecordDto));
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
    }

    @GetMapping("/products/search/{query}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable(value = "query") String query) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductsByName(query));
    }

}
