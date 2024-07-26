package com.midex.repository;

import com.midex.model.Product;
import com.midex.util.DatabaseConnection;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private Connection connection;

    // get DatabaseConnection class into product repository for connection
    public ProductRepository() {
        connection = DatabaseConnection.getConnection();
    }

    // CRUD - CREATE OPERATION -> addProduct()
    public boolean addProduct(Product product) {
        try {
            String query = "INSERT INTO products(name, price) VALUES('" + product.getName() + "', " + product.getPrice() + ")";
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result > 0;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    //SEARCH OPERATION
    public Product getProduct(int id) {
        try {
            String query = "SELECT * FROM products WHERE id = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")
                );
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    // CRUD - READ OPERATION
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String query = "SELECT * FROM products";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")
                ));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return products;
    }

    //CRUD - UPDATE OPERATION -> updateProduct

    public boolean updateProduct(Product product) {
        try {
            String query = "UPDATE products SET name = '" + product.getName() +"', price = " + product.getPrice() + "WHERE id = " + product.getId();
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result > 0;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    // CRUD - DELETE OPERATION -> deleteProduct
    public boolean deleteProduct(int id) {
        try {
            String query = "DELETE FROM products WHERE id = " + id;
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result > 0;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }
}
