package com.tablet.DAO;


import com.tablet.mapper.ProductMapper;
import com.modelsale.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.lang.*;
import java.util.Map;

@Repository
public class DAOproductImpl implements ProductDao {

	private JdbcTemplate jdbcTemplate;
	public DataSource ds;

	@Autowired
	public DAOproductImpl(JdbcTemplate jdbcTemplate, DataSource ds) {
		this.jdbcTemplate = jdbcTemplate;
		this.ds = ds;
	}

	@Override
	public void addProduct(Product product) {
		try {
			String sql = "INSERT INTO products(NAME, STATEID) VALUES (?,?)";
			jdbcTemplate.update(sql, product.getName(), product.getStateId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product findById(int productId) {
		String sql = "SELECT * FROM products WHERE PRODUCT_ID = ?";
		Product product = jdbcTemplate.queryForObject(sql, new Object[] { productId }, new ProductMapper());
		return product;
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			String sql = "SELECT * FROM products";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			for (Map row : rows) {
				Product product = new Product();
				product.setId(Integer.parseInt(String.valueOf(row.get("PRODUCT_ID"))));
				product.setName((String)row.get("NAME"));
				product.setStateId(Integer.parseInt(String.valueOf(row.get("STATEID"))));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void updateProduct(Product product) {
		try {
			String sql = "UPDATE products SET NAME=?, STATEID=? WHERE PRODUCT_ID=?";
			jdbcTemplate.update(sql, product.getName(), product.getStateId(), product.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(Product product) {
		try {
			String sql = "DELETE FROM products WHERE PRODUCT_ID=?";
			jdbcTemplate.update(sql, product.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
