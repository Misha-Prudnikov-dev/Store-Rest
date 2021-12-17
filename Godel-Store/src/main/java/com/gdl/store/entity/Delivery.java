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

@Entity
@Table(name = "delivery")
public class Delivery implements Serializable {

	private static final long serialVersionUID = 1763245031719424001L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_delivery")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_delivery")
	private Date dateDelivery;

	@Column(name = "type_delivery")
	private String typeDelivery;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "status_delivery_id_status_delivery")
	private DeliveryStatus statusDelivery;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "addresses_id_addresses")
	private Address address;

	public Delivery() {

	}

	public Delivery(int id, Date dateDelivery, String typeDelivery, DeliveryStatus statusDelivery, Address address) {

		this.id = id;
		this.dateDelivery = dateDelivery;
		this.typeDelivery = typeDelivery;
		this.statusDelivery = statusDelivery;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public String getTypeDelivery() {
		return typeDelivery;
	}

	public void setTypeDelivery(String typeDelivery) {
		this.typeDelivery = typeDelivery;
	}

	public DeliveryStatus getStatusDelivery() {
		return statusDelivery;
	}

	public void setStatusDelivery(DeliveryStatus statusDelivery) {
		this.statusDelivery = statusDelivery;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dateDelivery == null) ? 0 : dateDelivery.hashCode());
		result = prime * result + id;
		result = prime * result + ((statusDelivery == null) ? 0 : statusDelivery.hashCode());
		result = prime * result + ((typeDelivery == null) ? 0 : typeDelivery.hashCode());
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
		Delivery other = (Delivery) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateDelivery == null) {
			if (other.dateDelivery != null)
				return false;
		} else if (!dateDelivery.equals(other.dateDelivery))
			return false;
		if (id != other.id)
			return false;
		if (statusDelivery == null) {
			if (other.statusDelivery != null)
				return false;
		} else if (!statusDelivery.equals(other.statusDelivery))
			return false;
		if (typeDelivery == null) {
			if (other.typeDelivery != null)
				return false;
		} else if (!typeDelivery.equals(other.typeDelivery))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", dateDelivery=" + dateDelivery + ", typeDelivery=" + typeDelivery
				+ ", statusDelivery=" + statusDelivery + ", address=" + address + "]";
	}

}
