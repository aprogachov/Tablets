package com.tablet.DAO;

import com.modelsale.model.Product;

import java.util.List;

public interface ProductDao {

    void addProduct(Product product);
    Product findById(int productId);
    List<Product> findAllProducts();
    void updateProduct(Product product);
    void deleteProduct(Product product);
}
