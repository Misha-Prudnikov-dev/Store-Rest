package com.gdl.store.dao;

import java.util.Date;
import java.util.List;

import com.gdl.store.entity.Address;
import com.gdl.store.entity.Delivery;
import com.gdl.store.entity.Order;
import com.gdl.store.entity.OrderDetail;
import com.gdl.store.entity.OrderHistory;

public interface OrderDAO {

	int createOrder(int userId);

	boolean addProductToOrder(int orderId, int productId, int quantityProduct, String productSize);

	Order getProductInOrder(int userId);

	int getOrderId(int userId);

	void removeProductFromOrder(int productId, String productSize,int quantityProduct, int orderId);

	int addAddressOrder(Address address, int userId);

	void addPaymentOrder(String typePayment, String statusPayment, int orderId);

	int addDeliveryOrder(Delivery delivery, int addressId);


	void checkout(int orderId,  Address address,
			String typePayment, String statusPayment, String typeDelivery, int userId);

	List<OrderHistory> getOrderHistory(int userId,String statusOrder);

	Order getOrderInfo(int orderId, int userId);

}
