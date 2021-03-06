/*
 * Filename: Orders.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 
 * 
 * 
 * */
package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the orders database table.
 * 
 * @author Nabeel
 */
@Entity
@Table(name = "orders")
@NamedQueries(value = {
		@NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.orderId = :selectId"),
		@NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
		@NamedQuery(name = "Orders.deleteById", query = "DELETE FROM Orders o WHERE o.orderId = :deleteId") })
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Id of this order
	 */
	@Id
	@Column(name = "order_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	/**
	 * Date this order was placed
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date_ordered", nullable = false)
	private Date dateOrdered;

	/**
	 * Status of this order
	 */
	@Column(name = "order_status", length = 15)
	private String orderStatus;

	/**
	 * Details in this order
	 */
	// bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;

	/**
	 * The user this order belongs to
	 */
	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * Shipments related to this order, not yet implemented
	 */
	// bi-directional many-to-one association to Shipment
	@OneToMany(mappedBy = "order")
	private List<Shipment> shipments;

	public Orders() {
	}

	/**
	 * Full Constructor
	 * 
	 * @param orderId
	 * @param dateOrdered
	 * @param orderStatus
	 * @param orderDetails
	 * @param user
	 * @param shipments
	 */
	public Orders(Long orderId, Date dateOrdered, String orderStatus, List<OrderDetail> orderDetails, User user,
			List<Shipment> shipments) {
		this.setOrderId(orderId);
		this.setDateOrdered(dateOrdered);
		this.setOrderStatus(orderStatus);
		this.setOrderDetails(orderDetails);
		this.setUser(user);
		this.setShipments(shipments);
	}

	/**
	 * Constructor for testing
	 * 
	 * @param dateOrdered
	 * @param orderStatus
	 * @param orderDetails
	 * @param user
	 * @param shipments
	 */
	public Orders(Date dateOrdered, String orderStatus, List<OrderDetail> orderDetails, User user,
			List<Shipment> shipments) {
		this.setDateOrdered(dateOrdered);
		this.setOrderStatus(orderStatus);
		this.setOrderDetails(orderDetails);
		this.setUser(user);
		this.setShipments(shipments);
	}

	/**
	 * In case order was made by a guest, in which case user will be null
	 * 
	 * @param dateOrdered
	 * @param orderStatus
	 * @param orderDetails
	 * @param shipments
	 */
	public Orders(Date dateOrdered, String orderStatus, List<OrderDetail> orderDetails, List<Shipment> shipments) {
		this.setDateOrdered(dateOrdered);
		this.setOrderStatus(orderStatus);
		this.setOrderDetails(orderDetails);
		this.setShipments(shipments);
	}

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the dateOrdered
	 */
	public Date getDateOrdered() {
		return dateOrdered;
	}

	/**
	 * @param dateOrdered the dateOrdered to set
	 */
	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the orderDetails
	 */
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the shipments
	 */
	public List<Shipment> getShipments() {
		return shipments;
	}

	/**
	 * @param shipments the shipments to set
	 */
	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orders [orderId=");
		builder.append(orderId);
		builder.append(", dateOrdered=");
		builder.append(dateOrdered);
		builder.append(", orderStatus=");
		builder.append(orderStatus);
		builder.append(", orderDetails=");
		builder.append(orderDetails);
		builder.append(", user=");
		if (this.getUser() == null) {
			builder.append("null");
		} else {
			builder.append(user.getEmail());
		}
		builder.append(", shipments=");
		builder.append(shipments);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOrdered == null) ? 0 : dateOrdered.hashCode());
		result = prime * result + ((orderDetails == null) ? 0 : orderDetails.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((shipments == null) ? 0 : shipments.hashCode());
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
		Orders other = (Orders) obj;
		if (dateOrdered == null) {
			if (other.dateOrdered != null) {
				return false;
			}
		} else if (!dateOrdered.equals(other.dateOrdered)) {
			return false;
		}
		if (orderDetails == null) {
			if (other.orderDetails != null) {
				return false;
			}
		} else if (!orderDetails.equals(other.orderDetails)) {
			return false;
		}
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (orderStatus == null) {
			if (other.orderStatus != null) {
				return false;
			}
		} else if (!orderStatus.equals(other.orderStatus)) {
			return false;
		}
		if (shipments == null) {
			if (other.shipments != null) {
				return false;
			}
		} else if (!shipments.equals(other.shipments)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

}