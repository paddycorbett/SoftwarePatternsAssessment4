package com.example.dit.resteasy;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class ShopDAO {

	
	private static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("ShopPU"); 	
	
	public ShopDAO() {
	}
	
	public void persist(Object object) {
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
	
	
	
	////// Product queries/////////
	public List<Product> getAllProducts() {
        EntityManager em = emf.createEntityManager();
        try 
        {
        	return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        } finally 
        {
            em.close();
        }
        
        
    }
	
	
	
	/////// User Queries /////////
	
	public User getUserByUsername(String username) {
	    EntityManager em = emf.createEntityManager();
	    List<User> users = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class).setParameter("username", username).getResultList();
	    em.close();
	    if (users.isEmpty()) return null;
	    else return users.get(0);
	}
	
	public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return users;
    }
	
	

}
