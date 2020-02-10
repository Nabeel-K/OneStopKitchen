/**
 * 
 */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.Cart;
import com.kitchenworld.entity.User;

/**
 * @author CTStudent
 *
 */
public class UserService extends AbstractServices {
	
	public void addUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	public User findUserById(int id) {
		Query getUser = em.createNamedQuery("User.findById");
		getUser.setParameter("selectId", id);
		List<User> results = getUser.getResultList();
		
		return results.get(0);
	}
	
	public List<User> findAllUsers(){
		Query getUsers = em.createNamedQuery("User.findAll");
		List<User> results = getUsers.getResultList();
		
		return results;
	}
	
	public void updateUserFirstName(int id, String newName) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setFirstName(newName);
		em.getTransaction().commit();
	}
	
	public void updateUserLastName(int id, String newName) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setLastName(newName);
		em.getTransaction().commit();
	}
	
	public void updateUserEmail(int id, String newEmail) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setEmail(newEmail);
		em.getTransaction().commit();
	}
	
	public void updateUserAddress(int id, String newAddress) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setAddress(newAddress);
		em.getTransaction().commit();
	}
	
	public void updateUserCity(int id, String newCity) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setCity(newCity);
		em.getTransaction().commit();
	}
	
	public void updateUserState(int id, String newState) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setState(newState);
		em.getTransaction().commit();
	}
	
	public void updateUserCountry(int id, String newCountry) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setCountry(newCountry);
		em.getTransaction().commit();
	}
	
	public void updateUserZipCode(int id, String newZip) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setZipcode(newZip);
		em.getTransaction().commit();
	}
	
	public void updateCart(int id, Cart newCart) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setCart(newCart);
		em.getTransaction().commit();
	}
}
