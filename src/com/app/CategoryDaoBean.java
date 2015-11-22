package com.app;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CategoryDaoBean {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Category> getCategories() {
		Query query = entityManager.createQuery("SELECT c FROM Category c");
		List<Category> list = query.getResultList();
		return list;
		
	}
}
