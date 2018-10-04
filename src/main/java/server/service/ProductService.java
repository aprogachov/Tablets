package server.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import server.DAO.DAOproductImpl;
import server.DAO.ProductDao;
import server.mapper.ProductMapper;
import server.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Product findById(int productId) {
		Product dbproduct = productDao.findById(productId);
		return dbproduct;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Product> findAllProducts() {
		List<Product> products = productDao.findAllProducts();
		return products;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
	}
}
