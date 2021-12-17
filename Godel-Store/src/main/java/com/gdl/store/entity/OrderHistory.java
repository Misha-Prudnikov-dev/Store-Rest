package com.gdl.store.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class OrderHistory implements Serializable {

	private static final long serialVersionUID = 31454707771117255L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_orders")
	private int id;

	@Column(name = "status_order")
	private String status;

	@Column(name = "order_price_orders")
	private BigDecimal orderPrice;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_orders")
	private Date dateOrder;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "delivery_id_delivery")
	private Delivery delivery;

	@OneToMany(mappedBy = "order", cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH },fetch = FetchType.LAZY)
	private List<Payment> payments;

	@OneToMany(mappedBy = "order", cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	private List<OrderDetail> orderDetails;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "users_id_users")
	private UserShort userShort;

	public OrderHistory() {

	}

	public OrderHistory(int id, String status, BigDecimal orderPrice, Date dateOrder, Delivery delivery, List<Payment> payments,
			List<OrderDetail> orderDetails, UserShort userShort) {
		this.id = id;
		this.status = status;
		this.orderPrice = orderPrice;
		this.dateOrder = dateOrder;
		this.delivery = delivery;
		this.payments = payments;
		this.orderDetails = orderDetails;
		this.userShort = userShort;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public UserShort getUserShort() {
		return userShort;
	}

	public void setUserShort(UserShort userShort) {
		this.userShort = userShort;
	}

}
