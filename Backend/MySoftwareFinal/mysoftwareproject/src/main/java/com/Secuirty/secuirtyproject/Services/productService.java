package com.Secuirty.secuirtyproject.Services;

import java.util.List;
import java.util.Optional;

import com.Secuirty.secuirtyproject.Entities.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Secuirty.secuirtyproject.Entities.product;
import com.Secuirty.secuirtyproject.Repository.productRepository;

@Service
public class productService {

    @Autowired
    private productRepository productRepository;

    public List<product> getProducts() {
        return productRepository.findAll();
    }

    public product addProduct(product productObj) {
        return productRepository.save(productObj);
    }

    public boolean deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return true;
    }

    public product updateProduct(product productObj) {
        return productRepository.save(productObj);
    }

    public List<product> searchByName(String name) {
        return productRepository.findByProductNameContainingIgnoreCase(name);
    }

    public Optional<product> findById(Integer id) {
        return productRepository.findById(id);
    }
}
