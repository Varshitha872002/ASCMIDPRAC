package com.midex.ui;

import com.midex.model.Product;
import com.midex.service.ProductService;

import java.util.List;



public class App {
    private static ProductService productService = new ProductService();

    public static void main(String[] args) {
         // username and password
        String username = "varshi";
        String password = "varshi123";

        if(login(username, password)) {
            System.out.println("Login succesful");
            performCRUDOperations();
            System.out.println("Logout successful");
        }
        else {
            System.out.println("Login failed");
        }
    }

    private static boolean login(String username, String password) {
        // the below checks the username and password matches or not
        return "varshi".equals(username) && "varshi123".equals(password);
    }

    private static void performCRUDOperations() {
        // addProduct -> Adding products
        productService.addProduct(new Product(1, "Laptop", 750.00));
        productService.addProduct(new Product(2, "Phone", 500.00));
        System.out.println("Products are added");

        // getProduct -> search operation by id
        Product product = productService.getProduct(1);
        System.out.println("searching by id:");
        System.out.println("Product ID: " + product.getId() +", Name: " + product.getName() + ", Price: " + product.getPrice());

        // getAllProducts -> read operation
        List<Product> products = productService.getAllProducts();
        for (Product p : products) {
            System.out.println("Product ID: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
        }

        // updateProduct -> Updating the product
        Product updatedProduct = new Product(1, "Laptop pro", 950.00);
        productService.updateProduct(updatedProduct);
        System.out.println("The product is updated");

        //deleteProduct -> Deleting a product
        productService.deleteProduct(2);
        System.out.println("deleted 2nd product succesfully");

        //final print
        System.out.println("Product operations completed successfully");
    }

}


