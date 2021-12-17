
# Online Store
* Project Description
* Project Features
* Tools
* Application endpoints
## Project Description
* Online Clothing Store 
* Rest api 
## Project Functions
* View catalog
* View product list
* View product info
* Add product to cart (checking passed parameters)
* Delete product from cart (checking passed parameters)
* Checkout (checking passed parameters, if the goods are not available in that quantity, the order will not be created)
* View order history   
## Tools
* Java 13
* Spring 5
* Hibernate
* Maven
* MySQL
# Application endpoints
##### Request root `http://localhost:8080/Godel-Store/api`
* View catalog `/categories` (Method Get)
* View subcatalog `/categories/{categoryId}` (Method Get)
* View product list `/subcategories/{subcategoryId}`(Method Get)
* View product info `/products/{productId}` (Method Get)
* add product to cart `/products/add_product_to_cart/{productId}/{quantityProduct}/{productSize}` (Method Post)
* delete product from cart `/cart/delete_product_from_cart/{productId}/{productSize}/{quantityProduct}` (Method Delete)
* View cart `/cart` (Method Get)
* checkout `/cart/checkout`, example : 
`{
     "typePayment" : "Card",
	    "address": {
      "country":"Belarus",
      "city": "Brest",
      "street" : "Bvr",
      "numberHouse" : "5b"
    }
}` (Method Post)
* View order history `/order_history` (Method Get)
