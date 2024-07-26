CREATE DATABASE mid;

USE mid;

CREATE Table products(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50) NOT NULL, price DOUBLE NOT NULL);

INSERT INTO products(name, price) VALUES('Laptop', 750.00);
INSERT INTO products(name, price) VALUES('Phone', 500.00);

SELECT * from products;