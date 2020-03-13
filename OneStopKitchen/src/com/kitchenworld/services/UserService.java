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

import static com.kitchenworld.util.JpqlConstants.*;

/**
 * Service methods for user entities
 * 
 * @author Nabeel
 *
 */
@SuppressWarnings("unchecked")
public class UserService extends AbstractServices {

	public UserService() {
		super();
	}

	/**
	 * @param email    to compare against database
	 * @param password to compare against database
	 * @return the user that has input email and password, or null if no matches
	 *         were found
	 */
	public User loginMatch(String email, String password) {
		Query findUser = em.createQuery(QUERY_USERS + " WHERE u.email= :email").setParameter("email", email);

		List<User> matches = findUser.getResultList();
		User authenticatedUser = null;
		if (!matches.isEmpty() && BCrypt.checkpw(password, matches.get(0).getPassword())) {
			authenticatedUser = matches.get(0);
		}
		return authenticatedUser;

	}

	/**
	 * Adds user to the database
	 * 
	 * @param user to add
	 */
	public void addUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	/**
	 * @param id of the user to find
	 * @return the user found by the given id
	 */
	public User findUserById(Long id) {
		Query getUser = em.createNamedQuery("findById");
		getUser.setParameter(SELECT_ID, id);
		return (User) getUser.getResultList().get(0);
	}

	/**
	 * @return all users in database
	 */
	public List<User> findAllUsers() {
		return em.createNamedQuery("findAll").getResultList();
	}

	/**
	 * Updates first name of the user
	 * 
	 * @param id      of user to update
	 * @param newName to replace old first name
	 */
	public void updateUserFirstName(Long id, String newName) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setFirstName(newName);
		em.getTransaction().commit();
	}

	/**
	 * Updates last name of the user
	 * 
	 * @param id      of user to update
	 * @param newName to replace old last name
	 */
	public void updateUserLastName(Long id, String newName) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setLastName(newName);
		em.getTransaction().commit();
	}

	/**
	 * Updates email of the user
	 * 
	 * @param id       of user to update
	 * @param newEmail to replace old email
	 */
	public void updateUserEmail(Long id, String newEmail) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setEmail(newEmail);
		em.getTransaction().commit();
	}

	/**
	 * Updates password of the user
	 * 
	 * @param id      of user to update
	 * @param newPass to replace old password
	 */
	public void updateUserPassword(Long id, String newPass) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setPassword(newPass);
		em.getTransaction().commit();
	}

	/**
	 * Updates address of the user
	 * 
	 * @param id         of user to update
	 * @param newAddress to replace old address
	 */
	public void updateUserAddress(Long id, String newAddress) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setAddress(newAddress);
		em.getTransaction().commit();
	}

	/**
	 * Updates city of the user
	 * 
	 * @param id      of user to update
	 * @param newCity to replace old city
	 */
	public void updateUserCity(Long id, String newCity) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setCity(newCity);
		em.getTransaction().commit();
	}

	/**
	 * Updates state of the user
	 * 
	 * @param id       of user to update
	 * @param newState to replace old state
	 */
	public void updateUserState(Long id, String newState) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setState(newState);
		em.getTransaction().commit();
	}

	/**
	 * Updates Country of the user
	 * 
	 * @param id         of user to update
	 * @param newCountry to replace old country
	 */
	public void updateUserCountry(Long id, String newCountry) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setCountry(newCountry);
		em.getTransaction().commit();
	}

	/**
	 * Updates zipcode of the user
	 * 
	 * @param id     of user to update
	 * @param newZip to replace old zipcode
	 */
	public void updateUserZipCode(Long id, String newZip) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setZipcode(newZip);
		em.getTransaction().commit();
	}

	/**
	 * Updates cart of the user
	 * 
	 * @param id      of user to update
	 * @param newCart to replace old cart
	 */
	public void updateCart(Long id, Cart newCart) {
		em.getTransaction().begin();
		User userToUpdate = em.find(User.class, id);
		userToUpdate.setCart(newCart);
		em.getTransaction().commit();
	}

	/**
	 * Remove user from database
	 * 
	 * @param user to remove
	 */
	public void deleteUser(User user) {
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	}
}
