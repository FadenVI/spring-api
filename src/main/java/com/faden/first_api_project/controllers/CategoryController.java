package com.faden.first_api_project.controllers;

import com.faden.first_api_project.dtos.CategoryRecordDTO;
import com.faden.first_api_project.models.Category;
import com.faden.first_api_project.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000") // Permite requisições do React
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Object> getCategoryByID(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryByID(id));
    }

    @PostMapping("/category/new")
    public ResponseEntity<Category> createCategory(@RequestBody @Valid CategoryRecordDTO categoryRecordDTO) {
        var category = categoryService.createCategory(categoryRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping("/category/update/{id}")
    public ResponseEntity<Object> updateCategory(@RequestBody @Valid CategoryRecordDTO categoryRecordDTO,
                                                 @PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.updateCategory(categoryRecordDTO, id));
    }

    @DeleteMapping("/category/delete/{id}")
    public  ResponseEntity<Object> deleteCategory(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.deleteCategory(id));
    }

}
