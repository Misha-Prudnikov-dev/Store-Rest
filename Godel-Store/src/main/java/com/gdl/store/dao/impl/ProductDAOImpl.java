package com.gdl.store.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final String SUBCATEGORY_ID = "subcategoryId";
	private static final String CATEGORY_ID = "categoryId";
	private static final String REVIEW_ID = "reviewId";

	private static final String PRODUCT_ID = "productId";
	private static final String USER_ID = "userId";
	private static final String MANUFACTURER_ID = "manufacturerId";

	private static final String GET_ALL_CATEGORY = "from Category";
	private static final String GET_ALL_SUBCATEGORY = "from Subcategory where categories_id_categories = :categoryId";

	private static final String GROUP_PRODUCT_BY_SUBCATEGORY = "from Product where subcategories_id_subcategories = :subcategoryId";

	private static final String GROUP_REVIEW_BY_PRODUCT_ID = "from Review where products_id_products = :productId";
	private static final String GROUP_PRODUCT_IMAGE_BY_PRODUCT_ID = "from ProductImage where products_id_products = :productId";

	private static final String GROUP_PRODUCT_SIZE_PRODUCT_ID = "from ProductSize where products_id_products = :productId";
	private static final String FAVORITES_BY_USER_ID = "from Favorites where users_id_users = :userId and products_id_products = :productId";
	private static final String PRODUCT_BY_MANUFACTURER = "from Product where manufacturer_id_manufacturer = :manufacturerId";

	private static final String DELETE_PRODUCT_FROM_FAVORITES = "delete  from Favorites where users_id_users = :userId and products_id_products = :productsId";

	@Override
	public List<Category> getAllCategory() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Category> theQuery = currentSession.createQuery(GET_ALL_CATEGORY, Category.class);

		List<Category> categories = theQuery.getResultList();

		return categories;
	}

	@Override
	public List<Subcategory> getSubcategoryByIdCategory(int idCategory) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Subcategory> theQuery = currentSession.createQuery(GET_ALL_SUBCATEGORY, Subcategory.class);

		List<Subcategory> subcategories = theQuery.setParameter(CATEGORY_ID, idCategory).getResultList();

		return subcategories;
	}

	@Override
	public List<Product> getGroupProductByIdSubcategory(int idSubcategory) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Product> theQuery = currentSession.createQuery(GROUP_PRODUCT_BY_SUBCATEGORY, Product.class);

		List<Product> products = theQuery.setParameter(SUBCATEGORY_ID, idSubcategory).getResultList();

		return products;
	}

	@Override
	public ProductInfo getProductById(int idProduct) {

		Session currentSession = sessionFactory.getCurrentSession();

		ProductInfo productInfo = currentSession.get(ProductInfo.class, idProduct);

		return productInfo;
	}

	@Override
	public boolean checkProductFavorites(int userId, int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Review> getReviewByIdProduct(int idProduct) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Review> theQuery = currentSession.createQuery(GROUP_REVIEW_BY_PRODUCT_ID, Review.class);

		List<Review> reviews = theQuery.setParameter(PRODUCT_ID, idProduct).getResultList();

		return reviews;

	}

	@Override
	public List<ProductImage> getGroupProductImageByIdProduct(int idProduct) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<ProductImage> theQuery = currentSession.createQuery(GROUP_PRODUCT_IMAGE_BY_PRODUCT_ID,
				ProductImage.class);

		List<ProductImage> productImages = theQuery.setParameter(PRODUCT_ID, idProduct).getResultList();

		return productImages;
	}

	@Override
	public List<ProductSize> getGroupProductSize(int idProduct) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<ProductSize> theQuery = currentSession.createQuery(GROUP_PRODUCT_SIZE_PRODUCT_ID, ProductSize.class);

		List<ProductSize> productSizes = theQuery.setParameter(PRODUCT_ID, idProduct).getResultList();

		return productSizes;
	}

	@Override
	public void addReviewProduct(Review review) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(review);

	}

	@Override
	public void addProductFavorites(Favorites favorites) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(favorites);

	}

	@Override
	public void deleteProductFavorites(int userId, int productId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery(DELETE_PRODUCT_FROM_FAVORITES).setParameter(USER_ID, userId)
				.setParameter(PRODUCT_ID, productId);

		theQuery.executeUpdate();

	}

	@Override
	public List<Favorites> getProductFavorites(int userId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Favorites> theQuery = currentSession.createQuery(FAVORITES_BY_USER_ID, Favorites.class);

		List<Favorites> favorites = theQuery.setParameter(USER_ID, userId).getResultList();

		return favorites;
	}

	@Override
	public List<ProductInfo> getProductByManufacturerId(int manufacturerId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<ProductInfo> theQuery = currentSession.createQuery(PRODUCT_BY_MANUFACTURER, ProductInfo.class);

		List<ProductInfo> products = theQuery.setParameter(MANUFACTURER_ID, manufacturerId).getResultList();

		return products;
	}

	@Override
	public Manufacturer getManufacturerById(int manufacturerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkProductQuantiyInStock(int productId, String productSize) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateProductQuantity(int productId, int quantityProduct, String productSize) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteReviewProduct(int userId, int productId, String statusReview) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> searchProduct(String searchLine) {
		// TODO Auto-generated method stub
		return null;
	}

}
