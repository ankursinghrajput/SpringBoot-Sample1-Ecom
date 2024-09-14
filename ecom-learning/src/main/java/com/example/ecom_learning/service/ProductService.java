package com.example.ecom_learning.service;

import com.example.ecom_learning.model.Product;
import com.example.ecom_learning.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product) {
        if (repo.existsById(id)) {
            product.setId(id);
            return repo.save(product);
        } else {
            return null; 
        }
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}
