package com.faden.first_api_project.controllers;

import com.faden.first_api_project.dtos.BrandRecordDTO;
import com.faden.first_api_project.dtos.CategoryRecordDTO;
import com.faden.first_api_project.models.Brand;
import com.faden.first_api_project.services.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000") // Permite requisições do React
@RestController
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> getCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.getAllBrands());
    }

    @GetMapping("/brand/{id}")
    public ResponseEntity<Object> getCategoryByID(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.getBrandByID(id));
    }

    @PostMapping("/brand/new")
    public ResponseEntity<Brand> createCategory(@RequestBody @Valid BrandRecordDTO brandRecordDTO) {
        var brand = brandService.createBrand(brandRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(brand);
    }

    @PutMapping("/brand/update/{id}")
    public ResponseEntity<Object> updateCategory(@RequestBody @Valid BrandRecordDTO brandRecordDTO,
                                                 @PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.updateBrand(id, brandRecordDTO));
    }

    @DeleteMapping("/brand/delete/{id}")
    public  ResponseEntity<Object> deleteCategory(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.deleteBrand(id));
    }
}
