package com.example.dit.resteasy;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class ShopDAO {
	
	//1. Get the EntityManagerFactory 
	//2. Get the EntityManager from the Factory when we need to 
	 //talk to the DB
	//3. Call one of the operations on the EntityManager i.e., persist
	
	private static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("ShopPU"); 	
	
	public ShopDAO() {
	}
	
	public void persistSubscriber(Object object) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
		em.close();
	}
	public void remove(Object object) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(object));
		em.getTransaction().commit();
		em.close();
	}
	
	public Object merge(Object object) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Object updatedObject = em.merge(object);
		em.getTransaction().commit();
		em.close();
		return updatedObject;
	}
	
	public List<Product> getAllProducts() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT p FROM product p", Product.class).getResultList();
    }
	
	

}
