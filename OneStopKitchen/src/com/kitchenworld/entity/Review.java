package com.kitchenworld.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reviews database table.
 * 
 */
@Entity
@Table(name="reviews")
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReviewPK id;

	@Column(nullable=false)
	private byte rating;

	@Column(nullable=false)
	private boolean recommended;

	@Lob
	@Column(name="review_content")
	private String reviewContent;

	@Column(name="review_title", nullable=false, length=100)
	private String reviewTitle;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false, updatable=false)
	private Product product;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false, updatable=false)
	private User user;

	/**
	 * @param id
	 * @param rating
	 * @param recommended
	 * @param reviewContent
	 * @param reviewTitle
	 * @param product
	 * @param user
	 */
	public Review(ReviewPK id, byte rating, boolean recommended, String reviewContent, String reviewTitle, Product product,
			User user) {
		this.setId(id);
		this.setRating(rating);
		this.setRecommended(recommended);
		this.setReviewContent(reviewContent);
		this.setReviewTitle(reviewTitle);
		this.setProduct(product);
		this.setUser(user);
	}

	public Review() {
	}

	public ReviewPK getId() {
		return this.id;
	}

	public void setId(ReviewPK id) {
		this.id = id;
	}

	public byte getRating() {
		return this.rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	public boolean getRecommended() {
		return this.recommended;
	}

	public void setRecommended(boolean recommended) {
		this.recommended = recommended;
	}

	public String getReviewContent() {
		return this.reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewTitle() {
		return this.reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [id=");
		builder.append(id);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", recommended=");
		builder.append(recommended);
		builder.append(", reviewContent=");
		builder.append(reviewContent);
		builder.append(", reviewTitle=");
		builder.append(reviewTitle);
		builder.append(", product=");
		builder.append(product);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + rating;
		result = prime * result + (recommended ? 1231 : 1237);
		result = prime * result + ((reviewContent == null) ? 0 : reviewContent.hashCode());
		result = prime * result + ((reviewTitle == null) ? 0 : reviewTitle.hashCode());
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
		Review other = (Review) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (rating != other.rating)
			return false;
		if (recommended != other.recommended)
			return false;
		if (reviewContent == null) {
			if (other.reviewContent != null)
				return false;
		} else if (!reviewContent.equals(other.reviewContent))
			return false;
		if (reviewTitle == null) {
			if (other.reviewTitle != null)
				return false;
		} else if (!reviewTitle.equals(other.reviewTitle))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}