/*
 * Filename: User.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 
 * 
 * 
 * */
package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQueries(value = { @NamedQuery(name = "findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "findById", query = "SELECT u FROM User u WHERE u.userId = :selectId"),
		@NamedQuery(name = "deleteById", query = "DELETE FROM User u WHERE u.userId = :deleteId") })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(nullable = false, unique=true, length = 320)
	private String email;

	@Column(nullable = false, length = 60)
	private String password;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Column(length = 50)
	private String address;

	@Column(length = 50)
	private String city;

	@Column(length = 3)
	private String country;

	@Column(length = 50)
	private String state;

	@Column(length = 20)
	private String zipcode;

	// bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Orders> orders;

	@OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
	private Cart cart;

	/**
	 * @param userId
	 * @param email
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 * @param country
	 * @param state
	 * @param zipcode
	 * @param orders
	 * @param cart
	 */
	public User(Long userId, String email, String password, String firstName, String lastName, String address,
			String city, String country, String state, String zipcode, List<Orders> orders, Cart cart) {
		this.setUserId(userId);
		this.setPassword(password);
		this.setAddress(address);
		this.setCity(city);
		this.setCountry(country);
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setState(state);
		this.setZipcode(zipcode);
		this.setOrders(orders);
		this.setCart(cart);
	}

	/**
	 * @param address
	 * @param city
	 * @param country
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @param state
	 * @param zipcode
	 * @param orders
	 * @param cart
	 */

	// Constructor for information regarding the users name and location
	public User(String address, String city, String country, String email, String password, String firstName,
			String lastName, String state, String zipcode) {
		this.setAddress(address);
		this.setCity(city);
		this.setCountry(country);
		this.setEmail(email);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setState(state);
		this.setZipcode(zipcode);
	}

	// Constructor using information necessary for account creation
	public User(String email, String password, String firstName, String lastName) {
		this.setEmail(email);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public User() {
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the orders
	 */
	public List<Orders> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", address=");
		builder.append(address);
		builder.append(", city=");
		builder.append(city);
		builder.append(", country=");
		builder.append(country);
		builder.append(", state=");
		builder.append(state);
		builder.append(", zipcode=");
		builder.append(zipcode);
		builder.append(", orders=");
		builder.append(orders);
		builder.append(", cart=");
		builder.append(cart);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (cart == null) {
			if (other.cart != null) {
				return false;
			}
		} else if (!cart.equals(other.cart)) {
			return false;
		}
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (orders == null) {
			if (other.orders != null) {
				return false;
			}
		} else if (!orders.equals(other.orders)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		if (zipcode == null) {
			if (other.zipcode != null) {
				return false;
			}
		} else if (!zipcode.equals(other.zipcode)) {
			return false;
		}
		return true;
	}

}