package com.midex.service;

import com.midex.model.Product;
import com.midex.repository.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    // addProduct
    public boolean addProduct(Product product) {
        if (Product.getName() == null || product.getPrice() < 0) {
            return false;
        }
        return productRepository.addProduct(product);
    }

    // getProduct
    public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }

    //getAllProducts
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    // updateProduct
    public boolean updateProduct(Product product) {
        if (Product.getName() == null || product.getPrice() < 0) {
            return false;
        }
        return productRepository.updateProduct(product);
    }

    //deleteProduct
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }
}
