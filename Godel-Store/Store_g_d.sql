-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: store_g
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
  `id_addresses` int NOT NULL AUTO_INCREMENT,
  `country_addresses` varchar(45) DEFAULT NULL,
  `city_addresses` varchar(45) DEFAULT NULL,
  `street_addresses` varchar(45) DEFAULT NULL,
  `numberHouse_addresses` varchar(45) DEFAULT NULL,
  `users_id_users` int NOT NULL,
  PRIMARY KEY (`id_addresses`),
  KEY `fk_addresses_users1_idx` (`users_id_users`),
  CONSTRAINT `fk_addresses_users1` FOREIGN KEY (`users_id_users`) REFERENCES `users` (`id_users`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (7,'BELARUS','MINSK','KARL','21A',1),(12,'$schema','Brest','Bvr','5b',1),(13,'Belarus','Brest','Bvr','5b',1);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id_categories` int NOT NULL AUTO_INCREMENT,
  `title_categories` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_categories`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Женщинам'),(2,'Мужчинам');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery` (
  `id_delivery` int NOT NULL AUTO_INCREMENT,
  `date_delivery` datetime DEFAULT NULL,
  `type_delivery` varchar(45) DEFAULT NULL,
  `addresses_id_addresses` int NOT NULL,
  `status_delivery_id_status_delivery` int NOT NULL,
  PRIMARY KEY (`id_delivery`),
  KEY `fk_delivery_addresses1_idx` (`addresses_id_addresses`),
  KEY `fk_delivery_status_delivery1_idx` (`status_delivery_id_status_delivery`),
  CONSTRAINT `fk_delivery_addresses1` FOREIGN KEY (`addresses_id_addresses`) REFERENCES `addresses` (`id_addresses`),
  CONSTRAINT `fk_delivery_status_delivery1` FOREIGN KEY (`status_delivery_id_status_delivery`) REFERENCES `status_delivery` (`id_status_delivery`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` VALUES (7,'2021-12-15 16:42:06','TO THE DOOR',7,1),(11,NULL,'До Двери',12,1),(12,NULL,'До двери',13,1);
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorites` (
  `id_favorites` int NOT NULL AUTO_INCREMENT,
  `users_id_users` int NOT NULL,
  `products_id_products` int NOT NULL,
  PRIMARY KEY (`id_favorites`),
  KEY `fk_favorites_users1_idx` (`users_id_users`),
  KEY `fk_favorites_products1_idx` (`products_id_products`),
  CONSTRAINT `fk_favorites_products1` FOREIGN KEY (`products_id_products`) REFERENCES `products` (`id_products`),
  CONSTRAINT `fk_favorites_users1` FOREIGN KEY (`users_id_users`) REFERENCES `users` (`id_users`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manufacturer` (
  `id_manufacturer` int NOT NULL AUTO_INCREMENT,
  `title_manufacturer` varchar(45) DEFAULT NULL,
  `description_manufacturer` text,
  `country_manufacturer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_manufacturer`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES (1,'Topshop','Topshop','Соединенное Королевство'),(2,'Mango','Mango','Испания'),(3,'Marks & Spencer','Marks & Spencer','Соединенное Королевство'),(4,'Bikkembergs','Bikkembergs','Италия');
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
  `id_order_details` int NOT NULL AUTO_INCREMENT,
  `quantity_order_details` int DEFAULT NULL,
  `product_size_order_details` varchar(45) DEFAULT NULL,
  `total_order_details` decimal(10,2) DEFAULT NULL,
  `order_id_order` int NOT NULL,
  `products_id_products` int NOT NULL,
  PRIMARY KEY (`id_order_details`),
  KEY `fk_order_details_order1_idx` (`order_id_order`),
  KEY `fk_order_details_products1_idx` (`products_id_products`),
  CONSTRAINT `fk_order_details_order1` FOREIGN KEY (`order_id_order`) REFERENCES `orders` (`id_orders`),
  CONSTRAINT `fk_order_details_products1` FOREIGN KEY (`products_id_products`) REFERENCES `products` (`id_products`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` VALUES (1,22,'XS',650.00,1,1),(6,3,'XS',105.00,1,2),(7,3,'L',105.00,1,2),(8,2,'XS',200.00,2,1),(9,4,'L',140.00,2,2),(10,14,'M',490.00,2,2),(11,6,'S',210.00,2,2),(12,2,'XS',70.00,3,2);
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id_orders` int NOT NULL AUTO_INCREMENT,
  `date_orders` datetime DEFAULT NULL,
  `order_price_orders` decimal(10,2) unsigned DEFAULT NULL,
  `status_order` varchar(45) DEFAULT NULL,
  `users_id_users` int NOT NULL,
  `delivery_id_delivery` int DEFAULT NULL,
  PRIMARY KEY (`id_orders`),
  KEY `fk_order_users1_idx` (`users_id_users`),
  KEY `fk_orders_delivery1_idx` (`delivery_id_delivery`),
  CONSTRAINT `fk_order_users1` FOREIGN KEY (`users_id_users`) REFERENCES `users` (`id_users`),
  CONSTRAINT `fk_orders_delivery1` FOREIGN KEY (`delivery_id_delivery`) REFERENCES `delivery` (`id_delivery`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,NULL,20.00,'ORDER',1,7),(2,'2021-12-16 23:09:49',0.00,'ORDER',1,11),(3,'2021-12-17 14:06:57',140.00,'ORDER',1,12),(4,NULL,0.00,'CART',1,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `id_payment` int NOT NULL AUTO_INCREMENT,
  `type_payment` varchar(45) DEFAULT NULL,
  `date_payment` datetime DEFAULT CURRENT_TIMESTAMP,
  `status_payment` varchar(45) DEFAULT NULL,
  `orders_id_orders` int NOT NULL,
  PRIMARY KEY (`id_payment`),
  KEY `fk_payment_orders1_idx` (`orders_id_orders`),
  CONSTRAINT `fk_payment_orders1` FOREIGN KEY (`orders_id_orders`) REFERENCES `orders` (`id_orders`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (7,'CASH','2021-12-15 16:42:06','NOT PAID',1),(11,'Card','2021-12-16 23:09:49','Оплата наличными',2),(12,'Card','2021-12-17 14:06:57','Не оплачено',3);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_image` (
  `id_product_image` int NOT NULL AUTO_INCREMENT,
  `image_product_image` varchar(255) DEFAULT NULL,
  `products_id_products` int NOT NULL,
  PRIMARY KEY (`id_product_image`),
  KEY `fk_product_image_products1_idx` (`products_id_products`),
  CONSTRAINT `fk_product_image_products1` FOREIGN KEY (`products_id_products`) REFERENCES `products` (`id_products`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_sizes`
--

DROP TABLE IF EXISTS `product_sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_sizes` (
  `id_product_sizes` int NOT NULL AUTO_INCREMENT,
  `size_product_sizes` varchar(45) DEFAULT NULL,
  `quantity_product_sizes` int DEFAULT NULL,
  `products_id_products` int NOT NULL,
  PRIMARY KEY (`id_product_sizes`),
  KEY `fk_product_sizes_products1_idx` (`products_id_products`),
  CONSTRAINT `fk_product_sizes_products1` FOREIGN KEY (`products_id_products`) REFERENCES `products` (`id_products`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_sizes`
--

LOCK TABLES `product_sizes` WRITE;
/*!40000 ALTER TABLE `product_sizes` DISABLE KEYS */;
INSERT INTO `product_sizes` VALUES (1,'XS',4,1),(2,'S',30,1),(3,'M',30,1),(4,'L',30,1),(5,'XS',25,2),(6,'S',24,2),(7,'M',16,2),(8,'L',18,2),(9,'XS',15,3),(10,'M',20,5),(11,'L',20,5);
/*!40000 ALTER TABLE `product_sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id_products` int NOT NULL AUTO_INCREMENT,
  `title_products` varchar(45) DEFAULT NULL,
  `description_products` text,
  `year_products` int DEFAULT NULL,
  `price_products` decimal(10,2) DEFAULT NULL,
  `color_products` varchar(45) DEFAULT NULL,
  `date_add_products` datetime DEFAULT NULL,
  `manufacturer_id_manufacturer` int NOT NULL,
  `subcategories_id_subcategories` int NOT NULL,
  PRIMARY KEY (`id_products`),
  KEY `fk_products_manufacturer1_idx` (`manufacturer_id_manufacturer`),
  KEY `fk_products_subcategories1_idx` (`subcategories_id_subcategories`),
  CONSTRAINT `fk_products_manufacturer1` FOREIGN KEY (`manufacturer_id_manufacturer`) REFERENCES `manufacturer` (`id_manufacturer`),
  CONSTRAINT `fk_products_subcategories1` FOREIGN KEY (`subcategories_id_subcategories`) REFERENCES `subcategories` (`id_subcategories`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Topshop кардиган','Состав: Акрил - 100%',2020,20.00,'серый','2021-04-20 17:10:12',1,11),(2,'Mango джемпер - CIRCLE','Состав: Хлопок - 73%, Полиэстер - 27%',2021,35.00,'зеленый','2021-01-04 12:05:54',2,11),(3,'Marks & Spencer пуловер','Состав: Вискоза - 48%, Полиэстер - 30%, Полиамид - 22%',2020,15.14,'серый','2021-06-30 11:11:19',3,11),(5,'Bikkembergs рубашка','Состав: Хлопок - 99%, Эластан - 1%',2021,54.10,'красный','2021-01-04 12:05:54',4,16);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `id_reviews` int NOT NULL AUTO_INCREMENT,
  `text_reviews` text,
  `rating_reviews` int DEFAULT NULL,
  `date_reviews` datetime DEFAULT NULL,
  `status_reviews` varchar(45) DEFAULT NULL,
  `users_id_users` int NOT NULL,
  `products_id_products` int NOT NULL,
  PRIMARY KEY (`id_reviews`),
  KEY `fk_review_users1_idx` (`users_id_users`),
  KEY `fk_review_products1_idx` (`products_id_products`),
  CONSTRAINT `fk_review_products1` FOREIGN KEY (`products_id_products`) REFERENCES `products` (`id_products`),
  CONSTRAINT `fk_review_users1` FOREIGN KEY (`users_id_users`) REFERENCES `users` (`id_users`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_roles` int NOT NULL AUTO_INCREMENT,
  `role_roles` varchar(45) NOT NULL,
  PRIMARY KEY (`id_roles`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles_has_users`
--

DROP TABLE IF EXISTS `roles_has_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles_has_users` (
  `roles_id_roles` int NOT NULL,
  `users_id_users` int NOT NULL,
  PRIMARY KEY (`roles_id_roles`,`users_id_users`),
  KEY `fk_roles_has_users_users1_idx` (`users_id_users`),
  KEY `fk_roles_has_users_roles1_idx` (`roles_id_roles`),
  CONSTRAINT `fk_roles_has_users_roles1` FOREIGN KEY (`roles_id_roles`) REFERENCES `roles` (`id_roles`),
  CONSTRAINT `fk_roles_has_users_users1` FOREIGN KEY (`users_id_users`) REFERENCES `users` (`id_users`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles_has_users`
--

LOCK TABLES `roles_has_users` WRITE;
/*!40000 ALTER TABLE `roles_has_users` DISABLE KEYS */;
INSERT INTO `roles_has_users` VALUES (2,1);
/*!40000 ALTER TABLE `roles_has_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_delivery`
--

DROP TABLE IF EXISTS `status_delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status_delivery` (
  `id_status_delivery` int NOT NULL AUTO_INCREMENT,
  `status_delivery` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_status_delivery`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_delivery`
--

LOCK TABLES `status_delivery` WRITE;
/*!40000 ALTER TABLE `status_delivery` DISABLE KEYS */;
INSERT INTO `status_delivery` VALUES (1,'Оформлен'),(2,'В пути'),(3,'Доставлен');
/*!40000 ALTER TABLE `status_delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcategories`
--

DROP TABLE IF EXISTS `subcategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subcategories` (
  `id_subcategories` int NOT NULL AUTO_INCREMENT,
  `title_subcategories` varchar(45) DEFAULT NULL,
  `image_subcategories` varchar(100) DEFAULT NULL,
  `categories_id_categories` int NOT NULL,
  PRIMARY KEY (`id_subcategories`),
  KEY `fk_subcategories_categories1_idx` (`categories_id_categories`),
  CONSTRAINT `fk_subcategories_categories1` FOREIGN KEY (`categories_id_categories`) REFERENCES `categories` (`id_categories`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategories`
--

LOCK TABLES `subcategories` WRITE;
/*!40000 ALTER TABLE `subcategories` DISABLE KEYS */;
INSERT INTO `subcategories` VALUES (11,'Джемперы и кардиганы',NULL,1),(12,'Блузы и рубашки ',NULL,1),(13,'Футболки и майки',NULL,1),(14,'Худи',NULL,1),(15,'Джинсы',NULL,1),(16,'Рубашки',NULL,2);
/*!40000 ALTER TABLE `subcategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_users` int NOT NULL AUTO_INCREMENT,
  `name_users` varchar(45) NOT NULL,
  `email_users` varchar(45) NOT NULL,
  `password_users` varchar(1000) NOT NULL,
  `status_users` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_users`),
  UNIQUE KEY `password_users_UNIQUE` (`password_users`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Felix','felix@gmail.com','test','ACTIVE');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'store_g'
--
/*!50003 DROP PROCEDURE IF EXISTS `add_product_to_cart` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_product_to_cart`(
IN orderId int,
IN productId int,
IN quantityProduct int,
IN productSize varchar(45),
IN userId int)
proc_label:BEGIN

DECLARE quantity INT;
DECLARE id INT;
DECLARE sum decimal(10,2);
DECLARE price_prod decimal(10,2);

SELECT price_products into price_prod FROM products P INNER JOIN product_sizes Ps ON P.id_products = Ps.products_id_products WHERE P.id_products=productId AND Ps.size_product_sizes = productSize AND Ps.quantity_product_sizes >= quantityProduct;

IF price_prod != 0
THEN 
	SELECT id_order_details into id FROM order_details WHERE order_details.order_id_order=orderId 
	AND order_details.products_id_products=productId 
	AND order_details.product_size_order_details=productSize;
  
  IF id != 0 
    THEN
    
        SET quantity = quantity + quantityProduct;
        SET sum = price_prod * quantityProduct;
      	update order_details ord_det set ord_det.quantity_order_details = ord_det.quantity_order_details + quantityProduct , ord_det.total_order_details=ord_det.total_order_details + sum
		where ord_det.id_order_details = id;
        update orders ord set ord.order_price_orders = ord.order_price_orders + sum where ord.id_orders = orderId;
        
        ELSE
            SET sum = price_prod * quantityProduct;
           	insert into order_details(quantity_order_details,product_size_order_details,total_order_details,order_id_order,products_id_products) values(quantityProduct, productSize,sum,orderId,productId);
            update orders ord set ord.order_price_orders = ord.order_price_orders + sum where ord.id_orders = orderId;

      END IF;

   ELSE 
        leave proc_label;
   END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkout` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkout`(
IN orderId int,
IN country varchar(45),
IN city varchar(45),
IN street varchar(45),
IN numberHouse varchar(45),
IN typePayment varchar(45),
IN statusPayment varchar(45),
IN typeDelivery varchar(45),
IN userId int)
BEGIN

    DECLARE exit_loop BOOLEAN DEFAULT FALSE;
    DECLARE i, c  INT;
    DECLARE s varchar(45);
    
    DECLARE addressId INT;
    DECLARE deliveryId INT;
    DECLARE paymentId INT;
    DECLARE quantityProductSize INT;
    DECLARE  statusDeliveryId INT  DEFAULT 1;
    
    DECLARE employee_cursor CURSOR FOR SELECT od.products_id_products, od.quantity_order_details,od.product_size_order_details 
    FROM order_details od where od.order_id_order = orderId;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET exit_loop = TRUE;

   START TRANSACTION;
   
   	insert into addresses(country_addresses,city_addresses,street_addresses,numberHouse_addresses,users_id_users) values(country,city,street,numberHouse,userId);

    SET addressId = LAST_INSERT_ID();

    insert into delivery(type_delivery,addresses_id_addresses,status_delivery_id_status_delivery) values(typeDelivery,addressId,statusDeliveryId);
   
    SET deliveryId = LAST_INSERT_ID();
   
   	insert into payment(type_payment,status_payment,orders_id_orders) values(typePayment,statusPayment,orderId);

    SET paymentId = LAST_INSERT_ID();
    
	update orders ord set ord.date_orders = now(), ord.delivery_id_delivery = deliveryId,ord.status_order = 'ORDER'
		where ord.id_orders = orderId AND ord.status_order = 'CART';
		
    SET exit_loop = false;
    OPEN employee_cursor;

	employee_loop: LOOP
     FETCH NEXT FROM employee_cursor INTO i, c,s;
		
     IF exit_loop THEN
         CLOSE employee_cursor;
         LEAVE employee_loop;
     END IF;
     
         SELECT quantity_product_sizes into quantityProductSize FROM product_sizes ps WHERE ps.products_id_products = i 
       AND ps.size_product_sizes = s;
        
        IF quantityProductSize > c 
			THEN
			   update product_sizes ps set ps.quantity_product_sizes = (ps.quantity_product_sizes - c) where ps.products_id_products = i 
			   AND ps.size_product_sizes = s;
       ELSE
			 rollback;
       END IF;
       
   END LOOP employee_loop;
   
   COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_product_from_cart` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_product_from_cart`(
IN productId int,
IN productSize varchar(45),
IN quantity int,
IN orderId int
)
BEGIN

DECLARE id INT;
DECLARE sum decimal(10,2);
DECLARE price_prod decimal(10,2);

	SELECT id_order_details into id FROM order_details WHERE order_details.order_id_order=orderId 
	AND order_details.products_id_products=productId 
	AND order_details.product_size_order_details=productSize AND order_details.quantity_order_details >= quantity ;
    
    IF id !=0 
		THEN

			SELECT price_products into price_prod FROM products P INNER JOIN product_sizes Ps ON P.id_products = Ps.products_id_products 
            WHERE P.id_products=productId AND Ps.size_product_sizes = productSize;
        
			SET sum = price_prod * quantity;
			update order_details ord_det set ord_det.quantity_order_details = ord_det.quantity_order_details - quantity ,
            ord_det.total_order_details=ord_det.total_order_details - sum
			where ord_det.id_order_details = id;
            
     END IF;       

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-17 14:30:31
