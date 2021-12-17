package com.gdl.store.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "reviews")
public class Review implements Serializable {

	private static final long serialVersionUID = -739781258745088138L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reviews")
	private int id;

	@Column(name = "text_reviews")
	private String text;



	@Column(name = "status_reviews")
	private String status;

	@Column(name = "rating_reviews")
	private byte rating;

	@Column(name = "date_reviews")
	private Date dateAddReview;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "users_id_users")
	private User userShort;

	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "products_id_products")
	private Product product;

	public Review() {

	}

	public Review(int id, String text,  byte rating, Date dateAddReview, User userShort,
			Product product,String status) {
		this.id = id;
		this.text = text;
 		this.rating = rating;
		this.dateAddReview = dateAddReview;
		this.userShort = userShort;
		this.product = product;
		this.status = status;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

 
	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	public Date getDateAddReview() {
		return dateAddReview;
	}

	public void setDateAddReview(Date dateAddReview) {
		this.dateAddReview = dateAddReview;
	}

	public User getUserShort() {
		return userShort;
	}

	public void setUserShort(User userShort) {
		this.userShort = userShort;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateAddReview == null) ? 0 : dateAddReview.hashCode());
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + rating;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((userShort == null) ? 0 : userShort.hashCode());
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
		if (dateAddReview == null) {
			if (other.dateAddReview != null)
				return false;
		} else if (!dateAddReview.equals(other.dateAddReview))
			return false;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (rating != other.rating)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (userShort == null) {
			if (other.userShort != null)
				return false;
		} else if (!userShort.equals(other.userShort))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", text=" + text + ", status=" + status + ", rating=" + rating + ", dateAddReview="
				+ dateAddReview + ", userShort=" + userShort + ", product=" + product + "]";
	}
	

}
