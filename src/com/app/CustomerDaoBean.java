package com.app;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CustomerDaoBean {
	@Resource
	private EJBContext ejbContext;
	@PersistenceContext
	private EntityManager entityManager;
	
	public User findByEmail(String email) {
		Query query = entityManager.createQuery("SELECT u from User u WHERE u.email = :email");
		query.setParameter("email", email);
		User user = (User) query.getSingleResult();
		return user;
	}
	public List<User> getUsersWithRole() {
		Query query = entityManager.createQuery("SELECT u from User u ORDER BY u.id DESC");
		List<User> list = query.getResultList();
		return list;
	}
	@RolesAllowed("admin")
	public void createUser(User user,Group group) {
		if(user == null || group == null) {
			ejbContext.setRollbackOnly();
		}
		entityManager.persist(user);
		entityManager.persist(group);
	}
}
