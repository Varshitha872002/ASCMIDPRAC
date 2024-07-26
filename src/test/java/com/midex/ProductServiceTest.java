package com.midex;

import com.midex.model.Product;
import com.midex.repository.ProductRepository;
import com.midex.service.ProductService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {
    private ProductService productService;

    @Before
    public void setUp() {
        productService = new ProductService();
        productService.addProduct(new Product(1, "Laptop", 750.00));
        productService.addProduct(new Product(2, "Phone", 500.00));
        System.out.println("Setup is successfully installed");
    }

    @After
    public void tearDown() {
        productService.deleteProduct(1);
        productService.deleteProduct(2);
        System.out.println("Teardown completed");
    }

    @Test
    public void testAddProduct() {
        Product newProduct = new Product(3, "Tablet", 300.00);
        assertTrue(productService.addProduct(newProduct));
        assertNotNull(productService.getProduct(3));
        productService.deleteProduct(3);
    }

    @Test
    public void testGetProduct() {
        Product product = productService.getProduct(1);
       assertNull(product);
        assertEquals("Phone", product.getName());
    }

    @Test
    public void testGetAllProducts() {
        assertEquals(34, productService.getAllProducts().size());
    }

    @Test
    public void testUpdateProduct() {
        Product updatedProduct = new Product(1, "Laptop pro", 950.00);
        assertFalse(productService.updateProduct(updatedProduct));
        Product product = productService.getProduct(1);
        assertEquals("Laptop pro", product.getName());
    }

    @Test
    public void testDeleteProduct() {
        assertFalse(productService.deleteProduct(2));
        assertNull(productService.getProduct(2));
    }


}
