/*
 * Filename: UserService.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 2-23-20 Updated Constructor
 * Maint Date: 3-12-20 Updated delete method
 * 
 * */
package com.kitchenworld.services;

import java.util.List;

import javax.persistence.Query;

import org.mindrot.jbcrypt.BCrypt;

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

	public User loginMatch(String email, String password) {
		Query findUser = em.createQuery("SELECT u FROM User u WHERE u.email= :email").setParameter("email", email);

		List<User> matches = findUser.getResultList();
		User authenticatedUser = null;
		if (!matches.isEmpty() && BCrypt.checkpw(password, matches.get(0).getPassword())) {
			authenticatedUser = matches.get(0);
		}
		return authenticatedUser;

	}

	public void addUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	public User findUserById(Long id) {
		Query getUser = em.createNamedQuery("findById");
		getUser.setParameter("selectId", id);
		return (User) getUser.getResultList().get(0);
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
	 * @param id      (Comment here)
	 * @param newCart
	 */
	public void updateCart(Long id, Cart newCart) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setCart(newCart);
		em.getTransaction().commit();
	}

	public void deleteUser(User user) {
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	}
}
