package com.faden.first_api_project.services;

import com.faden.first_api_project.dtos.SubCategoryDTO;
import com.faden.first_api_project.models.Category;
import com.faden.first_api_project.models.Product;
import com.faden.first_api_project.models.SubCategory;
import com.faden.first_api_project.repositories.CategoryRepository;
import com.faden.first_api_project.repositories.SubCategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SubCategoryService {

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public SubCategory createSubCategory(SubCategoryDTO subCategoryDTO) {
        var subCategory = new SubCategory();

        BeanUtils.copyProperties(subCategoryDTO, subCategory);

        // Buscar a categoria no banco pelo ID recebido no DTO
        Category category = categoryRepository.findById(subCategoryDTO.category_id())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));


        // Definir a categoria no produto
        subCategory.setCategory(category);

        return subCategoryRepository.save(subCategory);

    }

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public Object getSubCategoryByID(UUID id) {

        Optional<SubCategory> subCategory = subCategoryRepository.findById(id);

        if (subCategory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subcategoria não encontrada");
        }

        return subCategory.get();
    }
}
