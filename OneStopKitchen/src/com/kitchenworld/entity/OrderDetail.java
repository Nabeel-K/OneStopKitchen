/*
 * Filename: OrderDetail.java
 * Author: Nabeel Khan
 * Creation Date: 2-19-20 Original Creation
 * Maint Date: 
 * 
 * 
 * */
package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order_details database table.
 * 
 */
@Entity
@Table(name="order_details")
@NamedQueries(value= {
		@NamedQuery(name="OrderDetail.findById", query="SELECT o FROM OrderDetail o WHERE o.id = :selectId"),
		@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o"),
		@NamedQuery(name="OrderDetail.deleteById", query="DELETE FROM OrderDetail o WHERE o.id = :deleteId")
})
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="line_id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="line_number", nullable=false)
	private Integer lineNumber;

	@Column(name="price_each", nullable=false, precision=10, scale=2)
	private double priceEach;

	@Column(name="quantity_ordered", nullable=false)
	private int quantityOrdered;
	
	@Column(name = "sku_number", nullable = false)
	private String skuNumber;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="order_id", nullable=false, updatable=false)
	private Orders order;


	public OrderDetail() {
	}


	/**
	 * @param id
	 * @param lineNumber
	 * @param priceEach
	 * @param quantityOrdered
	 * @param skuNumber
	 * @param order
	 */
	public OrderDetail(Long id, Integer lineNumber, double priceEach, int quantityOrdered, String skuNumber,
			Orders order) {
		this.setId(id);
		this.setLineNumber(lineNumber);
		this.setPriceEach(priceEach);
		this.setQuantityOrdered(quantityOrdered);
		this.setSkuNumber(skuNumber);
		this.setOrder(order);
	}
	/**
	 * @param lineNumber
	 * @param priceEach
	 * @param quantityOrdered
	 * @param skuNumber
	 * @param order
	 */
	public OrderDetail(Integer lineNumber, double priceEach, int quantityOrdered, String skuNumber,
			Orders order) {
		this.setLineNumber(lineNumber);
		this.setPriceEach(priceEach);
		this.setQuantityOrdered(quantityOrdered);
		this.setSkuNumber(skuNumber);
		this.setOrder(order);
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPriceEach() {
		return this.priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public int getQuantityOrdered() {
		return this.quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	/**
	 * @return the lineNumber
	 */
	public Integer getLineNumber() {
		return lineNumber;
	}



	/**
	 * @param lineNumber the lineNumber to set
	 */
	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}



	/**
	 * @return the skuNumber
	 */
	public String getSkuNumber() {
		return skuNumber;
	}



	/**
	 * @param skuNumber the skuNumber to set
	 */
	public void setSkuNumber(String skuNumber) {
		this.skuNumber = skuNumber;
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
		builder.append("OrderDetail [id=");
		builder.append(id);
		builder.append(", lineNumber=");
		builder.append(lineNumber);
		builder.append(", priceEach=");
		builder.append(priceEach);
		builder.append(", quantityOrdered=");
		builder.append(quantityOrdered);
		builder.append(", skuNumber=");
		builder.append(skuNumber);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lineNumber == null) ? 0 : lineNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(priceEach);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantityOrdered;
		result = prime * result + ((skuNumber == null) ? 0 : skuNumber.hashCode());
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
		OrderDetail other = (OrderDetail) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lineNumber == null) {
			if (other.lineNumber != null) {
				return false;
			}
		} else if (!lineNumber.equals(other.lineNumber)) {
			return false;
		}
		if (order == null) {
			if (other.order != null) {
				return false;
			}
		} else if (!order.equals(other.order)) {
			return false;
		}
		if (Double.doubleToLongBits(priceEach) != Double.doubleToLongBits(other.priceEach)) {
			return false;
		}
		if (quantityOrdered != other.quantityOrdered) {
			return false;
		}
		if (skuNumber == null) {
			if (other.skuNumber != null) {
				return false;
			}
		} else if (!skuNumber.equals(other.skuNumber)) {
			return false;
		}
		return true;
	}


	
}