package com.faden.first_api_project.controllers;

import com.faden.first_api_project.dtos.BrandRecordDTO;
<<<<<<< HEAD
=======
import com.faden.first_api_project.dtos.CategoryRecordDTO;
>>>>>>> 48088b39bb102aced0f340e51b05629c9bdf4ae2
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
<<<<<<< HEAD
    public ResponseEntity<List<Brand>> getBrands() {
=======
    public ResponseEntity<List<Brand>> getCategories() {
>>>>>>> 48088b39bb102aced0f340e51b05629c9bdf4ae2
        return ResponseEntity.status(HttpStatus.OK).body(brandService.getAllBrands());
    }

    @GetMapping("/brand/{id}")
<<<<<<< HEAD
    public ResponseEntity<Object> getBrandByID(@PathVariable(value = "id") UUID id) {
=======
    public ResponseEntity<Object> getCategoryByID(@PathVariable(value = "id") UUID id) {
>>>>>>> 48088b39bb102aced0f340e51b05629c9bdf4ae2
        return ResponseEntity.status(HttpStatus.OK).body(brandService.getBrandByID(id));
    }

    @PostMapping("/brand/new")
<<<<<<< HEAD
    public ResponseEntity<Brand> createBrand(@RequestBody @Valid BrandRecordDTO brandRecordDTO) {
=======
    public ResponseEntity<Brand> createCategory(@RequestBody @Valid BrandRecordDTO brandRecordDTO) {
>>>>>>> 48088b39bb102aced0f340e51b05629c9bdf4ae2
        var brand = brandService.createBrand(brandRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(brand);
    }

    @PutMapping("/brand/update/{id}")
<<<<<<< HEAD
    public ResponseEntity<Object> updateBrand(@RequestBody @Valid BrandRecordDTO brandRecordDTO,
=======
    public ResponseEntity<Object> updateCategory(@RequestBody @Valid BrandRecordDTO brandRecordDTO,
>>>>>>> 48088b39bb102aced0f340e51b05629c9bdf4ae2
                                                 @PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.updateBrand(id, brandRecordDTO));
    }

    @DeleteMapping("/brand/delete/{id}")
<<<<<<< HEAD
    public  ResponseEntity<Object> deleteBrand(@PathVariable(value = "id") UUID id) {
=======
    public  ResponseEntity<Object> deleteCategory(@PathVariable(value = "id") UUID id) {
>>>>>>> 48088b39bb102aced0f340e51b05629c9bdf4ae2
        return ResponseEntity.status(HttpStatus.OK).body(brandService.deleteBrand(id));
    }
}
