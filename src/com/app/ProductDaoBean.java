package com.app;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProductDaoBean {
	@PersistenceContext
	private EntityManager entityManager;
	@Resource
	private EJBContext ejbContext;
	
	public List<Product> getProducts() {
		Query query = entityManager.createQuery("SELECT p FROM Product p");
		List<Product> list = query.getResultList();
		return list;
	}
	public void addProduct(Product product, int category)  {
		if(product.getProductImage() == null || product == null && category == 0)  {
			ejbContext.setRollbackOnly();
		}
		Category categoryEntity = entityManager.find(Category.class, category);
		product.setCategory(categoryEntity);
		entityManager.persist(product);
	}
}
