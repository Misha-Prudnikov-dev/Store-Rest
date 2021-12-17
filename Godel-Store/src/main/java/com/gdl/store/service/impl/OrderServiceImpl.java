package com.gdl.store.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdl.store.dao.OrderDAO;
import com.gdl.store.entity.Address;
import com.gdl.store.entity.Delivery;
import com.gdl.store.entity.Order;
import com.gdl.store.entity.OrderDetail;
import com.gdl.store.entity.OrderHistory;
import com.gdl.store.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	@Transactional
	public int createOrder(int userId) {

		orderDAO.createOrder(userId);

		return 0;
	}

	@Override
	@Transactional
	public boolean addProductToOrder(int orderId, int productId, int quantityProduct, String productSize) {

		return orderDAO.addProductToOrder(orderId, productId, quantityProduct, productSize);

	}

	@Override
	@Transactional
	public Order getProductInOrder(int userId) {

		return orderDAO.getProductInOrder(userId);

	}

	@Override
	@Transactional
	public int getOrderId(int userId) {

		int orderId;

		orderId = orderDAO.getOrderId(userId);

		return orderId;
	}

	@Override
	@Transactional
	public void removeProductFromOrder(int productId, String productSize, int quantityProduct, int orderId) {

		orderDAO.removeProductFromOrder(productId, productSize, quantityProduct, orderId);
	}

	@Override
	public int addAddressOrder(Address address, int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public void checkout(int orderId, Address address, String typePayment, String statusPayment, String typeDelivery,
			int userId) {
		orderDAO.checkout(orderId, address, typePayment, statusPayment, typeDelivery, userId);
		;

	}

	@Override
	public void addPaymentOrder(String typePayment, String statusPayment, int orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int addDeliveryOrder(Delivery delivery, int addressId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public List<OrderHistory> getOrderHistory(int userId, String statusOrder) {

		List<OrderHistory> groupOrderHistory = orderDAO.getOrderHistory(userId, statusOrder);

		for (OrderHistory oh : groupOrderHistory) {

			Hibernate.initialize(oh.getPayments());

		}

		return groupOrderHistory;
	}

	@Override
	public Order getOrderInfo(int orderId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
