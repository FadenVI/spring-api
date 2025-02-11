package com.faden.first_api_project.services;

import com.faden.first_api_project.dtos.BrandRecordDTO;
import com.faden.first_api_project.models.Brand;
import com.faden.first_api_project.repositories.BrandRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Object getBrandByID(UUID id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);

        if (optionalBrand.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }

        return optionalBrand.get();
    }

    public Brand createBrand(BrandRecordDTO brandRecordDTO) {
        var brand = new Brand();
        BeanUtils.copyProperties(brandRecordDTO, brand);
        return brandRepository.save(brand);
    }

    public Object updateBrand(UUID id, BrandRecordDTO brandRecordDTO) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);

        if (optionalBrand.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }

        var brand = optionalBrand.get();
        BeanUtils.copyProperties(brandRecordDTO, brand);

        return brandRepository.save(brand);
    }

    public Object deleteBrand(UUID id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);

        if (optionalBrand.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }

        var brand = optionalBrand.get();
        brandRepository.deleteById(brand.getIdBrand());

        return "Marca " + optionalBrand.get().getName() + " excluída com sucesso";
    }

}
