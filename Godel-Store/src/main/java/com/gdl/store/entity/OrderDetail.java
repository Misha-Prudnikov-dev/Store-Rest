package com.gdl.store.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "order_details")
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = -7680159041588165214L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order_details")	
	private int id;
	
	@Column(name = "quantity_order_details")
	private int quantity;
	
	@Column(name = "total_order_details")
	private BigDecimal totalPriceForQuantityProduct;
	
	@Column(name = "product_size_order_details")
	private String productSize;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "order_id_order")
	private Order order;
	
	 
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "products_id_products")
	private ProductShortOrder productShortOrder;

	public OrderDetail() {

	}

	public OrderDetail(int id, int quantity,BigDecimal totalPriceForQuantityProduct, String productSize, Order order,ProductShortOrder productShortOrder) {
		this.id = id;
		this.quantity = quantity;
		this.totalPriceForQuantityProduct = totalPriceForQuantityProduct;
		this.productSize = productSize;
		this.order = order;
		this.productShortOrder = productShortOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPriceForQuantityProduct() {
		return totalPriceForQuantityProduct;
	}

	public void setTotalPriceForQuantityProduct(BigDecimal totalPriceForQuantityProduct) {
		this.totalPriceForQuantityProduct = totalPriceForQuantityProduct;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ProductShortOrder getProductShortOrder() {
		return productShortOrder;
	}

	public void setProductShortOrder(ProductShortOrder productShortOrder) {
		this.productShortOrder = productShortOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((productShortOrder == null) ? 0 : productShortOrder.hashCode());
		result = prime * result + ((productSize == null) ? 0 : productSize.hashCode());
		result = prime * result + quantity;
		result = prime * result
				+ ((totalPriceForQuantityProduct == null) ? 0 : totalPriceForQuantityProduct.hashCode());
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
		OrderDetail other = (OrderDetail) obj;
		if (id != other.id)
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (productShortOrder == null) {
			if (other.productShortOrder != null)
				return false;
		} else if (!productShortOrder.equals(other.productShortOrder))
			return false;
		if (productSize == null) {
			if (other.productSize != null)
				return false;
		} else if (!productSize.equals(other.productSize))
			return false;
		if (quantity != other.quantity)
			return false;
		if (totalPriceForQuantityProduct == null) {
			if (other.totalPriceForQuantityProduct != null)
				return false;
		} else if (!totalPriceForQuantityProduct.equals(other.totalPriceForQuantityProduct))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", quantity=" + quantity + ", totalPriceForQuantityProduct="
				+ totalPriceForQuantityProduct + ", productSize=" + productSize + ", order=" + order
				+ ", productShortOrder=" + productShortOrder + "]";
	}




}
