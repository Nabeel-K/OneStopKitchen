package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the reviews database table.
 * 
 */
@Embeddable
public class ReviewPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int userId;

	@Column(name="product_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int productId;

	/**
	 * @param userId
	 * @param productId
	 */
	public ReviewPK(int userId, int productId) {
		this.setUserId(userId);
		this.setProductId(productId);
	}
	
	public ReviewPK() {
	}
	
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReviewPK)) {
			return false;
		}
		ReviewPK castOther = (ReviewPK)other;
		return 
			(this.userId == castOther.userId)
			&& (this.productId == castOther.productId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId;
		hash = hash * prime + this.productId;
		
		return hash;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReviewPK [userId=");
		builder.append(userId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append("]");
		return builder.toString();
	}
}