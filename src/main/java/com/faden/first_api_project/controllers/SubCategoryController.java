package com.faden.first_api_project.controllers;

import com.faden.first_api_project.dtos.SubCategoryDTO;
import com.faden.first_api_project.models.Brand;
import com.faden.first_api_project.models.SubCategory;
import com.faden.first_api_project.services.SubCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class SubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping("/subcategories")
    public ResponseEntity<List<SubCategory>> getSubCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(subCategoryService.getAllSubCategories());
    }

    @GetMapping("/subcategory/{id}")
    public ResponseEntity<Object> getSubCategoryByID(@PathVariable(value = "id") UUID id) {
        var subCategory = subCategoryService.getSubCategoryByID(id);
        return ResponseEntity.status(HttpStatus.OK).body(subCategory);
    }

    @PostMapping("/subcategory/new")
    public ResponseEntity<SubCategoryDTO> createSubCategory(@RequestBody @Valid SubCategoryDTO subCategoryDTO) {
        var subCategory = subCategoryService.createSubCategory(subCategoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryDTO);
    }





}
