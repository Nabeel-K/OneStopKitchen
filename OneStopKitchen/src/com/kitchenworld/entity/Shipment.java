package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the shipments database table.
 * 
 */
@Entity
@Table(name = "shipments")
@NamedQueries(value = { @NamedQuery(name = "Shipment.findAll", query = "SELECT s FROM Shipment s"),
		@NamedQuery(name = "Shipment.findById", query = "SELECT s FROM Shipment s WHERE s.shipmentId = :selectId"),
		@NamedQuery(name = "Shipment.deleteById", query = "DELETE FROM Shipment s WHERE s.shipmentId = :deleteId") })
public class Shipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "shipment_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shipmentId;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_delivered")
	private Date dateDelivered;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_shipped", nullable = false)
	private Date dateShipped;

	// bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Orders order;

	/**
	 * @param shipmentId
	 * @param dateDelivered
	 * @param dateShipped
	 * @param order
	 */
	public Shipment(Long shipmentId, Date dateDelivered, Date dateShipped, Orders order) {
		this.setShipmentId(shipmentId);
		this.setDateDelivered(dateDelivered);
		this.setDateShipped(dateShipped);
		this.setOrder(order);
	}

	/**
	 * @param dateDelivered
	 * @param dateShipped
	 * @param order
	 */
	public Shipment(Date dateDelivered, Date dateShipped, Orders order) {
		this.setDateDelivered(dateDelivered);
		this.setDateShipped(dateShipped);
		this.setOrder(order);
	}

	public Shipment() {
	}

	public Long getShipmentId() {
		return this.shipmentId;
	}

	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
	}

	public Date getDateDelivered() {
		return this.dateDelivered;
	}

	public void setDateDelivered(Date dateDelivered) {
		this.dateDelivered = dateDelivered;
	}

	public Date getDateShipped() {
		return this.dateShipped;
	}

	public void setDateShipped(Date dateShipped) {
		this.dateShipped = dateShipped;
	}

	public Orders getOrder() {
		return this.order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Shipment [shipmentId=");
		builder.append(shipmentId);
		builder.append(", dateDelivered=");
		builder.append(dateDelivered);
		builder.append(", dateShipped=");
		builder.append(dateShipped);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDelivered == null) ? 0 : dateDelivered.hashCode());
		result = prime * result + ((dateShipped == null) ? 0 : dateShipped.hashCode());
		result = prime * result + ((shipmentId == null) ? 0 : shipmentId.hashCode());
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
		Shipment other = (Shipment) obj;
		if (dateDelivered == null) {
			if (other.dateDelivered != null) {
				return false;
			}
		} else if (!dateDelivered.equals(other.dateDelivered)) {
			return false;
		}
		if (dateShipped == null) {
			if (other.dateShipped != null) {
				return false;
			}
		} else if (!dateShipped.equals(other.dateShipped)) {
			return false;
		}
		if (order == null) {
			if (other.order != null) {
				return false;
			}
		} else if (!order.equals(other.order)) {
			return false;
		}
		if (shipmentId == null) {
			if (other.shipmentId != null) {
				return false;
			}
		} else if (!shipmentId.equals(other.shipmentId)) {
			return false;
		}
		return true;
	}

}