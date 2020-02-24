/*
 * Filename: UserService.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-23-20 Updated Constructor
 * 
 * 
 * */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import com.kitchenworld.entity.Cart;
import com.kitchenworld.entity.User;

/**
 * @author Nabeel
 *
 */
@SuppressWarnings("unchecked")
public class UserService extends AbstractServices {

	public UserService() {
		super();
	}
	
	public boolean loginMatch(User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		boolean match;
		
		Query findUser = em.createQuery("SELECT u FROM User u WHERE u.email=\"" + email + "\" AND u.password = \"" + password +"\"");
		List<User> matches = findUser.getResultList();
		
		if (matches.size() == 1) {
			User authenticatedUser = matches.get(0);
			user.setAddress(authenticatedUser.getAddress());
			user.setFirstName(authenticatedUser.getFirstName());
			user.setLastName(authenticatedUser.getLastName());
			user.setCity(authenticatedUser.getCity());
			user.setCountry(authenticatedUser.getCountry());
			user.setState(authenticatedUser.getState());
			user.setZipcode(authenticatedUser.getZipcode());
			user.setOrders(authenticatedUser.getOrders());
			user.setCart(authenticatedUser.getCart());
			match =  true;
		} else {
			match = false;
		}
		return match;
		
	}
	
	public void addUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	public User findUserById(Long id) {
		Query getUser = em.createNamedQuery("findById");
		getUser.setParameter("selectId", id);
		return (User)getUser.getResultList().get(0);
	}

	public List<User> findAllUsers() {
		return em.createNamedQuery("findAll").getResultList();	
	}

	public void updateUserFirstName(Long id, String newName) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setFirstName(newName);
		em.getTransaction().commit();
	}

	public void updateUserLastName(Long id, String newName) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setLastName(newName);
		em.getTransaction().commit();
	}

	public void updateUserEmail(Long id, String newEmail) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setEmail(newEmail);
		em.getTransaction().commit();
	}

	public void updateUserPassword(Long id, String newPass) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setPassword(newPass);
		em.getTransaction().commit();
	}

	public void updateUserAddress(Long id, String newAddress) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setAddress(newAddress);
		em.getTransaction().commit();
	}

	public void updateUserCity(Long id, String newCity) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setCity(newCity);
		em.getTransaction().commit();
	}

	public void updateUserState(Long id, String newState) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setState(newState);
		em.getTransaction().commit();
	}

	public void updateUserCountry(Long id, String newCountry) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setCountry(newCountry);
		em.getTransaction().commit();
	}

	public void updateUserZipCode(Long id, String newZip) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setZipcode(newZip);
		em.getTransaction().commit();
	}

	/**
	 * @param id (Comment here)
	 * @param newCart
	 */
	public void updateCart(Long id, Cart newCart) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setCart(newCart);
		em.getTransaction().commit();
	}

	public void deleteUser(Long id) {
		Query getUser = em.createNamedQuery("findById");
		getUser.setParameter("selectId", id);
		List<User> results = getUser.getResultList();
		User user = results.get(0);

		em.getTransaction().begin();
		em.remove(user);
		em.flush();
		em.getTransaction().commit();
	}
}
