package com.faden.first_api_project.services;

import com.faden.first_api_project.dtos.CategoryRecordDTO;
import com.faden.first_api_project.models.Category;
import com.faden.first_api_project.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Object getCategoryByID(UUID id) {

        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }

        return optionalCategory.get();
    }

    public Category createCategory(CategoryRecordDTO categoryRecordDTO) {
        var category = new Category();
        BeanUtils.copyProperties(categoryRecordDTO, category);
        return categoryRepository.save(category);
    }

    public Object updateCategory(CategoryRecordDTO categoryRecordDTO, UUID id) {

        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }

        var category = optionalCategory.get();
        BeanUtils.copyProperties(categoryRecordDTO, category);

        return categoryRepository.save(category);
    }

    public Object deleteCategory(UUID id) {

        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }

        var category = optionalCategory.get();
        categoryRepository.deleteById(category.getIdCategory());

        return "Categoria " + optionalCategory.get().getName() + " excluída com sucesso";
    }
}
