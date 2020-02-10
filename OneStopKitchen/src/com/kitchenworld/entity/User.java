package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQueries(value = {
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findById", query="SELECT u FROM User u WHERE u.userId = :selectId")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userId;

	@Column(length=50)
	private String address;

	@Column(length=50)
	private String city;

	@Column(length=3)
	private String country;

	@Column(nullable=false, length=320)
	private String email;

	@Column(name="first_name", nullable=false, length=50)
	private String firstName;

	@Column(name="last_name", nullable=false, length=50)
	private String lastName;

	@Column(length=50)
	private String state;

	@Column(length=20)
	private String zipcode;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="user" , fetch=FetchType.EAGER)
	private List<Orders> orders;
	
	@OneToOne(mappedBy="user")
	private Cart cart;

	/**
	 * @param userId
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
	public User(int userId, String address, String city, String country, String email, String firstName,
			String lastName, String state, String zipcode, List<Orders> orders, Cart cart) {
		this.setUserId(userId);
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
	
	//May need to get rid of me
	public User(int userId, String address, String city, String country, String email, String firstName,
			String lastName, String state, String zipcode) {
		this.setUserId(userId);
		this.setAddress(address);
		this.setCity(city);
		this.setCountry(country);
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setState(state);
		this.setZipcode(zipcode);
	}
	
	//Constructor for information regarding the users name and location
	public User(String address, String city, String country, String email, String firstName,
			String lastName, String state, String zipcode) {
		this.setAddress(address);
		this.setCity(city);
		this.setCountry(country);
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setState(state);
		this.setZipcode(zipcode);
	}

	//Constructor using information necessary for account creation
	public User( String email, String firstName,
			String lastName) {
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	//Constructor for the above with id (to be removed)
	public User( int id, String email, String firstName,
			String lastName) {
		this.setUserId(id);
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public List<Orders> getOrders() {
		return this.orders;
	}

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
		builder.append(", address=");
		builder.append(address);
		builder.append(", city=");
		builder.append(city);
		builder.append(", country=");
		builder.append(country);
		builder.append(", email=");
		builder.append(email);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
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
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + userId;
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (userId != other.userId)
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

	

}