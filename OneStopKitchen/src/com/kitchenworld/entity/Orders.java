package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQueries(value= {
		@NamedQuery(name="Orders.findById", query="SELECT o FROM Orders o WHERE o.orderId = :selectId"),
		@NamedQuery(name="Orders.findAll", query="SELECT o FROM Orders o"),
		@NamedQuery(name="Orders.deleteById", query="DELETE FROM Orders o WHERE o.orderId = :deleteId")
})
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id", unique=true, nullable=false)
	private int orderId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_ordered", nullable=false)
	private Date dateOrdered;

	@Column(name="order_status", length=1)
	private String orderStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="ship_date")
	private Date shipDate;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	//bi-directional many-to-one association to Shipment
	@OneToMany(mappedBy="order")
	private List<Shipment> shipments;

	public Orders() {
	}

	/**
	 * @param orderId
	 * @param dateOrdered
	 * @param orderStatus
	 * @param shipDate
	 * @param orderDetails
	 * @param user
	 * @param shipments
	 */
	public Orders(int orderId, Date dateOrdered, String orderStatus, Date shipDate, List<OrderDetail> orderDetails,
			User user, List<Shipment> shipments) {
		this.setOrderId(orderId);
		this.setDateOrdered(dateOrdered);
		this.setOrderStatus(orderStatus);
		this.setShipDate(shipDate);
		this.setOrderDetails(orderDetails);
		this.setUser(user);
		this.setShipments(shipments);
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDateOrdered() {
		return this.dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getShipDate() {
		return this.shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Shipment> getShipments() {
		return this.shipments;
	}

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
		builder.append(", shipDate=");
		builder.append(shipDate);
		builder.append(", orderDetails=");
		builder.append(orderDetails);
		builder.append(", user=");
		builder.append(user);
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
		result = prime * result + orderId;
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((shipDate == null) ? 0 : shipDate.hashCode());
		result = prime * result + ((shipments == null) ? 0 : shipments.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Orders other = (Orders) obj;
		if (dateOrdered == null) {
			if (other.dateOrdered != null)
				return false;
		} else if (!dateOrdered.equals(other.dateOrdered))
			return false;
		if (orderDetails == null) {
			if (other.orderDetails != null)
				return false;
		} else if (!orderDetails.equals(other.orderDetails))
			return false;
		if (orderId != other.orderId)
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (shipDate == null) {
			if (other.shipDate != null)
				return false;
		} else if (!shipDate.equals(other.shipDate))
			return false;
		if (shipments == null) {
			if (other.shipments != null)
				return false;
		} else if (!shipments.equals(other.shipments))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}