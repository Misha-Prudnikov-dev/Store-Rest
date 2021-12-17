package com.gdl.store.service.impl;


import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdl.store.dao.ProductDAO;
import com.gdl.store.entity.Category;
import com.gdl.store.entity.Favorites;
import com.gdl.store.entity.Manufacturer;
import com.gdl.store.entity.Product;
import com.gdl.store.entity.ProductImage;
import com.gdl.store.entity.ProductInfo;
import com.gdl.store.entity.ProductSize;
import com.gdl.store.entity.Review;
import com.gdl.store.entity.Subcategory;
import com.gdl.store.service.ProductService;

 
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public List<Category> getAllCategory() {

		List<Category> categories;

		categories = productDAO.getAllCategory();

		return categories;
	}

	@Override
	@Transactional
	public List<Subcategory> getSubcategoryByIdCategory(int idCategory) {

		List<Subcategory> subcategories;

		subcategories = productDAO.getSubcategoryByIdCategory(idCategory);

		return subcategories;
	}

	@Override
	@Transactional
	public List<Product> getGroupProductByIdSubcategory(int idSubcategory) {

		List<Product> products;

		products = productDAO.getGroupProductByIdSubcategory(idSubcategory);

		return products;
	}

	@Override
	@Transactional
	public ProductInfo getProductById(int idProduct) {

		ProductInfo product;

		product = productDAO.getProductById(idProduct);

		Hibernate.initialize(product.getProductSize());
		Hibernate.initialize(product.getProductImages());
		Hibernate.initialize(product.getReview());

		return product;
	}

	@Override
	@Transactional
	public List<ProductImage> getGroupProductImageByIdProduct(int idProduct) {

		List<ProductImage> productImages;

		productImages = productDAO.getGroupProductImageByIdProduct(idProduct);

		return productImages;
	}

	@Override
	@Transactional
	public List<ProductSize> getGroupProductSize(int idProduct) {

		List<ProductSize> productSizes;

		productSizes = productDAO.getGroupProductSize(idProduct);

		return productSizes;
	}

	@Override
	@Transactional
	public List<Review> getReviewByIdProduct(int idProduct) {

		List<Review> reviews;

		reviews = productDAO.getReviewByIdProduct(idProduct);

		return reviews;
	}

	@Override
	@Transactional
	public boolean addReviewProduct(Review review) {

		productDAO.addReviewProduct(review);

		return true;
	}

	@Override
	@Transactional
	public void addProductFavorites(Favorites favorites) {

		productDAO.addProductFavorites(favorites);

	}

	@Override
	@Transactional
	public boolean checkProductFavorites(int userId, int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public void deleteProductFavorites(int userId, int productId) {

		productDAO.deleteProductFavorites(userId, productId);

	}

	@Override
	@Transactional
	public List<Favorites> getProductFavorites(int userId) {

		List<Favorites> favorites;

		favorites = productDAO.getProductFavorites(userId);

		return favorites;
	}

	@Override
	@Transactional
	public List<ProductInfo> getProductByManufacturerId(int manufacturerId) {

		List<ProductInfo> products;

		products = productDAO.getProductByManufacturerId(manufacturerId);

		return products;
	}

	@Override
	@Transactional
	public Manufacturer getManufacturerById(int manufacturerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public int checkProductQuantiyInStock(int productId, String productSize) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public void updateProductQuantity(int productId, int quantityProduct, String productSize) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void deleteReviewProduct(int userId, int productId, String statusReview) {
		// TODO Auto-generated method stub

	}

  

}
