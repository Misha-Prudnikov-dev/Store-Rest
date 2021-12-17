package com.gdl.store.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdl.store.dto.CheckoutRequestDto;
import com.gdl.store.entity.Address;
import com.gdl.store.entity.Category;
import com.gdl.store.entity.Order;
import com.gdl.store.entity.OrderDetail;
import com.gdl.store.entity.OrderHistory;
import com.gdl.store.entity.Product;
import com.gdl.store.entity.ProductInfo;
import com.gdl.store.entity.Subcategory;
import com.gdl.store.rest.exception.OrderNotFoundException;
import com.gdl.store.rest.exception.ProductNotFoundException;
import com.gdl.store.service.OrderService;
import com.gdl.store.service.ProductService;

@RestController
@RequestMapping("/api")
public class StoreRestController {

	private static final String STATUS_ORDER = "ORDER";

	private static final Object MESSANGE_CART_EMTY = "Cart empty";

	private static final int USER_ID = 1;

	private static final String NOT_PAID = "Не оплачено";

	private static final String TO_THE_DOOR = "До двери";

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@GetMapping("/categories")
	public List<Category> getAllCategory() {

		return productService.getAllCategory();
	}

	@GetMapping("/categories/{categoryId}")
	public List<Subcategory> getSubcategoriesByIdCategory(@PathVariable int categoryId) {

		List<Subcategory> subcategories = null;

		if (categoryId <= 0) {
			throw new ProductNotFoundException("Category id not found - " + categoryId);

		}

		subcategories = productService.getSubcategoryByIdCategory(categoryId);

		if (subcategories.isEmpty()) {
			throw new ProductNotFoundException("Category id not found - " + categoryId);
		}

		return subcategories;
	}

	@GetMapping("/subcategories/{subcategoryId}")
	public List<Product> getAllProductByIdSubcategory(@PathVariable int subcategoryId) {

		List<Product> products = null;

		products = productService.getGroupProductByIdSubcategory(subcategoryId);


		return products;
	}

	@GetMapping("/products/{productId}")
	public ProductInfo getProductInfoById(@PathVariable int productId) {

 
			ProductInfo	productInfo = productService.getProductById(productId);

		if (productInfo == null) {
			throw new ProductNotFoundException("Product id not found - " + productId);

		}

		return productInfo;
	}

	@PostMapping("/products/add_product_to_cart/{productId}/{quantityProduct}/{productSize}")
	public void addProductToCart(@PathVariable int productId,
			@PathVariable int quantityProduct, @PathVariable String productSize) {

		productSize = productSize.trim().toUpperCase();

		if (productId <= 0 || quantityProduct <= 0 || productSize.equals("")) {
			throw new ProductNotFoundException("Incorrect data entered");

		}

		if (orderService.addProductToOrder(orderService.getOrderId(USER_ID), productId, quantityProduct, productSize)) {

			throw new ProductNotFoundException("Incorrect data entered");

		}

	}

	@DeleteMapping("/cart/delete_product_from_cart/{productId}/{productSize}/{quantityProduct}")
	public void deleteProductFromCart(@PathVariable int productId,
			@PathVariable String productSize, @PathVariable int quantityProduct) {

		productSize = productSize.trim().toUpperCase();

		if (productId <= 0 || quantityProduct <= 0 || productSize.equals("")) {
			throw new ProductNotFoundException("Incorrect data entered");

		}
		int orderId = orderService.getOrderId(USER_ID);

		orderService.removeProductFromOrder(productId, productSize, quantityProduct, orderId);

	}

	@GetMapping("/cart")
	public ResponseEntity getProductInCart() {

		Order order = orderService.getProductInOrder(USER_ID);

		

		if (order==null) {
			return ResponseEntity.ok(MESSANGE_CART_EMTY);

		}

		return ResponseEntity.ok(order);
	}

	@PostMapping("/cart/checkout")
	public void checkout(@RequestBody CheckoutRequestDto checkoutRequestDto) {

		
		
		
		orderService.checkout(orderService.getOrderId(USER_ID), 
				checkoutRequestDto.getAddress(), checkoutRequestDto.getTypePayment(),
				NOT_PAID, TO_THE_DOOR, USER_ID);
		
		orderService.createOrder(USER_ID);
	}

	@GetMapping("/order_history")
	public ResponseEntity getOrderHistory() {

		List<OrderHistory> groupOrderHistory;

		groupOrderHistory = orderService.getOrderHistory(USER_ID, STATUS_ORDER);

		if (groupOrderHistory.isEmpty()) {
			ResponseEntity.ok(MESSANGE_CART_EMTY);
		}

		return ResponseEntity.ok(groupOrderHistory);
	}
}
