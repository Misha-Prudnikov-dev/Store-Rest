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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {

	private static final long serialVersionUID = -5498767556978561828L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_payment")
	private int id;

	@Column(name = "type_payment")
	private String typePayment;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_payment")
	private Date datePayment;

	@Column(name = "status_payment")
	private String statusPayment;

	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "orders_id_orders")
	private Order order;

	public Payment() {

	}

	public Payment(int id, String typePayment, Date datePayment, String statusPayment, Order order) {
		this.id = id;
		this.typePayment = typePayment;
		this.datePayment = datePayment;
		this.statusPayment = statusPayment;
		this.order = order;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypePayment() {
		return typePayment;
	}

	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public String getStatusPayment() {
		return statusPayment;
	}

	public void setStatusPayment(String statusPayment) {
		this.statusPayment = statusPayment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datePayment == null) ? 0 : datePayment.hashCode());
		result = prime * result + id;
		result = prime * result + ((statusPayment == null) ? 0 : statusPayment.hashCode());
		result = prime * result + ((typePayment == null) ? 0 : typePayment.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		Payment other = (Payment) obj;
		if (datePayment == null) {
			if (other.datePayment != null)
				return false;
		} else if (!datePayment.equals(other.datePayment))
			return false;
		if (id != other.id)
			return false;
		if (statusPayment == null) {
			if (other.statusPayment != null)
				return false;
		} else if (!statusPayment.equals(other.statusPayment))
			return false;
		if (typePayment == null) {
			if (other.typePayment != null)
				return false;
		} else if (!typePayment.equals(other.typePayment))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", typePayment=" + typePayment + ", datePayment=" + datePayment
				+ ", statusPayment=" + statusPayment + ", order=" + order + "]";
	}

}
