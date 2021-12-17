package com.gdl.store.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdl.store.dao.OrderDAO;
import com.gdl.store.entity.Address;
import com.gdl.store.entity.Delivery;
import com.gdl.store.entity.Order;
import com.gdl.store.entity.OrderDetail;
import com.gdl.store.entity.OrderHistory;
import com.gdl.store.entity.ProductInfo;
import com.gdl.store.entity.User;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private static final String STATUS_ORDER_CART = "CART";


	private static final String ORDER_ID = "orderId";

	private static final String PRODUCT_QUANTITY_PARAM = "quantityProduct";
	private static final String ORDER_ID_PARAM = "orderId";
	private static final String USER_ID_PARAM = "userId";
	private static final String PRODUCT_ID_PARAM = "productId";
	private static final String PRODUCT_SIZE_PARAM = "productSize";

	private static final String GET_ORDER_ID = "from Order where users_id_users = :userId and status_order =  'CART'";

	private static final String GET_PRODUCT_IN_ORDER = " from Order where user.id = :userId and status = 'CART'";

	private static final String CHECK_PRODUCT = "from ProductInfo as p  where p.id = :productIdParam and productSize.size = :productSizeParam";

	private static final String ADD_PRODUCT_TO_CART = "add_product_to_cart";

	private static final String CHECKOUT = "checkout";
	private static final String COUNTRY_ADDRESS_PARAM = "country";
	private static final String CITY_ADDRESS_PARAM = "city";
	private static final String STREET_ADDRESS_PARAM = "street";
	private static final String NUMBER_HOUSE_ADDRESS_PARAM = "numberHouse";
	private static final String TYPE_PAYMENT_PARAM = "typePayment";
	private static final String STATUS_PAYMENT_PARAM = "statusPayment";
	private static final String TYPE_DELIVERY_PARAM = "typeDelivery";
	
	private static final String DELETE_PRODUCT_FROM_CART = "delete_product_from_cart";
	
	private static final String GET_ORDER_HISTORY = "from OrderHistory where userShort.id = :userId and status = :statusOrder";
	private static final String STATUS_ORDER = "statusOrder";

	@Override
	public int createOrder(int userId) {

		Session currentSession = sessionFactory.getCurrentSession();

		User user = currentSession.get(User.class, userId);

		Order order = new Order();

		order.setStatus(STATUS_ORDER_CART);
		order.setOrderPrice(BigDecimal.ZERO);
		order.setUser(user);

		currentSession.save(order);

		return 0;
	}

	@Override
	public boolean addProductToOrder(int orderId, int productId, int quantityProduct, String productSize) {

		Session currentSession = sessionFactory.getCurrentSession();

		StoredProcedureQuery query = currentSession.createStoredProcedureQuery(ADD_PRODUCT_TO_CART);

		query.registerStoredProcedureParameter(ORDER_ID_PARAM, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(PRODUCT_ID_PARAM, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(PRODUCT_QUANTITY_PARAM, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(PRODUCT_SIZE_PARAM, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(USER_ID_PARAM, Integer.class, ParameterMode.IN);

		query.setParameter(ORDER_ID_PARAM, orderId);
		query.setParameter(PRODUCT_ID_PARAM, productId);
		query.setParameter(PRODUCT_QUANTITY_PARAM, quantityProduct);
		query.setParameter(PRODUCT_SIZE_PARAM, productSize);
		query.setParameter(USER_ID_PARAM, 1);

		

		return query.execute();

	}

	@Override
	public Order getProductInOrder(int userId) {

		Session currentSession = sessionFactory.getCurrentSession();

		 Order order = currentSession.createQuery(GET_PRODUCT_IN_ORDER, Order.class).setParameter(USER_ID_PARAM, userId).getSingleResult();



		return order;

	}

	@Override
	public int getOrderId(int userId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Order order = (Order) currentSession.createQuery(GET_ORDER_ID, Order.class).setParameter(USER_ID_PARAM, userId)
				.getSingleResult();

		return order.getId();
	}

	@Override
	public void removeProductFromOrder(int productId, String productSize,int quantityProduct, int orderId) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		StoredProcedureQuery query = currentSession.createStoredProcedureQuery(DELETE_PRODUCT_FROM_CART);

		query.registerStoredProcedureParameter(PRODUCT_ID_PARAM, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(PRODUCT_SIZE_PARAM, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(PRODUCT_QUANTITY_PARAM, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(ORDER_ID_PARAM, Integer.class, ParameterMode.IN);

		query.setParameter(PRODUCT_ID_PARAM, productId);
		query.setParameter(PRODUCT_SIZE_PARAM, productSize);
		query.setParameter(PRODUCT_QUANTITY_PARAM, quantityProduct);
		query.setParameter(ORDER_ID_PARAM, orderId);

		query.execute();

	}

	@Override
	public int addAddressOrder(Address address, int userId) {
		// TODO Auto-generated method stub
		return 0;
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
	public void checkout(int orderId,   Address address,
			String typePayment, String statusPayment, String typeDelivery, int userId) {

		Session currentSession = sessionFactory.getCurrentSession();

		StoredProcedureQuery query = currentSession.createStoredProcedureQuery(CHECKOUT);

		query.registerStoredProcedureParameter(ORDER_ID_PARAM, Integer.class, ParameterMode.IN);

		query.registerStoredProcedureParameter(COUNTRY_ADDRESS_PARAM, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(CITY_ADDRESS_PARAM, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(STREET_ADDRESS_PARAM, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(NUMBER_HOUSE_ADDRESS_PARAM, String.class, ParameterMode.IN);

		query.registerStoredProcedureParameter(TYPE_PAYMENT_PARAM, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(STATUS_PAYMENT_PARAM, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(TYPE_DELIVERY_PARAM, String.class, ParameterMode.IN);

		query.registerStoredProcedureParameter(USER_ID_PARAM, Integer.class, ParameterMode.IN);

		query.setParameter(ORDER_ID_PARAM, orderId);
		query.setParameter(COUNTRY_ADDRESS_PARAM, address.getCountry());
		query.setParameter(CITY_ADDRESS_PARAM, address.getCity());
		query.setParameter(STREET_ADDRESS_PARAM, address.getStreet());
		query.setParameter(NUMBER_HOUSE_ADDRESS_PARAM, address.getNumberHouse());
		query.setParameter(TYPE_PAYMENT_PARAM, typePayment);
		query.setParameter(STATUS_PAYMENT_PARAM, statusPayment);
		query.setParameter(TYPE_DELIVERY_PARAM, typeDelivery);
		query.setParameter(USER_ID_PARAM, userId);

		query.execute();

	}

	@Override
	public List<OrderHistory> getOrderHistory(int userId,String statusOrder) {


		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<OrderHistory> theQuery = currentSession.createQuery(GET_ORDER_HISTORY, OrderHistory.class);

		List<OrderHistory> groupOrderHistory = theQuery.setParameter(USER_ID_PARAM, userId).setParameter(STATUS_ORDER, statusOrder).getResultList();

		
		
		return groupOrderHistory;
	}

	@Override
	public Order getOrderInfo(int orderId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
