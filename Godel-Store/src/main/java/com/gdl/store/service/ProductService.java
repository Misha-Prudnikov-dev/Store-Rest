package com.gdl.store.service;

import java.util.List;

import com.gdl.store.entity.Category;
import com.gdl.store.entity.Favorites;
import com.gdl.store.entity.Manufacturer;
import com.gdl.store.entity.Product;
import com.gdl.store.entity.ProductImage;
import com.gdl.store.entity.ProductInfo;
import com.gdl.store.entity.ProductSize;
import com.gdl.store.entity.Review;
import com.gdl.store.entity.Subcategory;

public interface ProductService {

	List<Category> getAllCategory();

	List<Subcategory> getSubcategoryByIdCategory(int idCategory);

	List<Product> getGroupProductByIdSubcategory(int idSubcategory);

	ProductInfo getProductById(int idProduct);

	List<ProductImage> getGroupProductImageByIdProduct(int idProduct);

	List<ProductSize> getGroupProductSize(int idProduct);

	List<Review> getReviewByIdProduct(int idProduct);

	boolean addReviewProduct(Review review);

	void addProductFavorites(Favorites favorites);

	boolean checkProductFavorites(int userId, int productId);

	void deleteProductFavorites(int userId, int productId);

	List<Favorites> getProductFavorites(int userId);

	List<ProductInfo> getProductByManufacturerId(int manufacturerId);

	Manufacturer getManufacturerById(int manufacturerId);

	int checkProductQuantiyInStock(int productId, String productSize);

	void updateProductQuantity(int productId, int quantityProduct, String productSize);

	void deleteReviewProduct(int userId, int productId, String statusReview);

}
