package com.tablet.service;

import com.modelsale.model.Product;
import java.util.List;

public interface IProductService {

    void addProduct(Product product);
    Product findById(int productId);
    List<Product> findAllProducts();
    void updateProduct(Product product);
    void deleteProduct(Product product);
}
