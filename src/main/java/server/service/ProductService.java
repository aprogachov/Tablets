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
import server.util.Audit;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Add product")
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "FindById product")
	public Product findById(int productId) {
		Product dbproduct = productDao.findById(productId);
		return dbproduct;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Find all products")
	public List<Product> findAllProducts() {
		List<Product> products = productDao.findAllProducts();
		return products;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Update product")
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Audit(action = "Delete product")
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
	}
}
