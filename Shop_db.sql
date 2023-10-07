-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.32 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for shop_db
CREATE DATABASE IF NOT EXISTS `shop_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shop_db`;

-- Dumping structure for table shop_db.brand
CREATE TABLE IF NOT EXISTS `brand` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.brand: ~4 rows (approximately)
INSERT INTO `brand` (`id`, `name`) VALUES
	(1, 'dell'),
	(2, 'apple'),
	(3, 'hp'),
	(4, '1'),
	(5, 'samsung');

-- Dumping structure for table shop_db.city
CREATE TABLE IF NOT EXISTS `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.city: ~2 rows (approximately)
INSERT INTO `city` (`id`, `name`) VALUES
	(1, 'Kandy'),
	(2, 'Colombo');

-- Dumping structure for table shop_db.companies
CREATE TABLE IF NOT EXISTS `companies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `hotline` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.companies: ~2 rows (approximately)
INSERT INTO `companies` (`id`, `name`, `hotline`) VALUES
	(1, 'eversoft', '0112488575'),
	(2, 'meta', '0112488683'),
	(3, 'kk', '0112875473');

-- Dumping structure for table shop_db.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `mobile` varchar(10) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `points` int NOT NULL,
  PRIMARY KEY (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.customer: ~2 rows (approximately)
INSERT INTO `customer` (`mobile`, `first_name`, `last_name`, `email`, `points`) VALUES
	('0705321516', 'Chathura', 'Sudaraka', 'Chathura@gmail.com', 0),
	('0716457896', 'aaddd', 'ddd', 'ddd@gmail.com', 0);

-- Dumping structure for table shop_db.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `email` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `nic` varchar(20) NOT NULL,
  `password` varchar(45) NOT NULL,
  `date_of_registered` date NOT NULL,
  `mobile` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `employee_type_id` int NOT NULL,
  `gender_id` int NOT NULL,
  PRIMARY KEY (`email`),
  KEY `fk_employees_employee_types1_idx` (`employee_type_id`),
  KEY `fk_employees_genders1_idx` (`gender_id`),
  CONSTRAINT `fk_employees_employee_types1` FOREIGN KEY (`employee_type_id`) REFERENCES `employee_type` (`id`),
  CONSTRAINT `fk_employees_genders1` FOREIGN KEY (`gender_id`) REFERENCES `genders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.employee: ~2 rows (approximately)
INSERT INTO `employee` (`email`, `first_name`, `last_name`, `nic`, `password`, `date_of_registered`, `mobile`, `employee_type_id`, `gender_id`) VALUES
	('Chathura@gmail.com', 'Chathura', 'Sudaraka', '200505903342', 'Chathura123', '2023-07-13', '0705321516', 1, 1),
	('Chathuraoriginal2005@gmail.com', 'Chathura', 'Sudaraka', '200505903349', '0718457935', '2023-07-17', '123', 2, 1);

-- Dumping structure for table shop_db.employee_address
CREATE TABLE IF NOT EXISTS `employee_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `line_1` varchar(45) NOT NULL,
  `line_2` varchar(45) NOT NULL,
  `citie_id` int NOT NULL,
  `employee_email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_addresses_cities1_idx` (`citie_id`),
  KEY `fk_employee_addresses_employees1_idx` (`employee_email`),
  CONSTRAINT `fk_employee_addresses_cities1` FOREIGN KEY (`citie_id`) REFERENCES `city` (`id`),
  CONSTRAINT `fk_employee_addresses_employees1` FOREIGN KEY (`employee_email`) REFERENCES `employee` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.employee_address: ~0 rows (approximately)

-- Dumping structure for table shop_db.employee_type
CREATE TABLE IF NOT EXISTS `employee_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.employee_type: ~2 rows (approximately)
INSERT INTO `employee_type` (`id`, `name`) VALUES
	(1, 'Admin'),
	(2, 'Cashier');

-- Dumping structure for table shop_db.genders
CREATE TABLE IF NOT EXISTS `genders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.genders: ~2 rows (approximately)
INSERT INTO `genders` (`id`, `name`) VALUES
	(1, 'Male'),
	(2, 'Female');

-- Dumping structure for table shop_db.grn
CREATE TABLE IF NOT EXISTS `grn` (
  `id` bigint NOT NULL DEFAULT '0',
  `supplier_mobile` varchar(10) NOT NULL,
  `date_time` datetime NOT NULL,
  `employee_email` varchar(45) NOT NULL,
  `paid_amount` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_supplier1_idx` (`supplier_mobile`),
  KEY `fk_grn_employee1_idx` (`employee_email`),
  CONSTRAINT `fk_grn_employee1` FOREIGN KEY (`employee_email`) REFERENCES `employee` (`email`),
  CONSTRAINT `fk_grn_supplier1` FOREIGN KEY (`supplier_mobile`) REFERENCES `supplier` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.grn: ~0 rows (approximately)

-- Dumping structure for table shop_db.grn_item
CREATE TABLE IF NOT EXISTS `grn_item` (
  `id` int NOT NULL DEFAULT '0',
  `qty` double NOT NULL,
  `stock_id` int NOT NULL,
  `grn_id` bigint NOT NULL DEFAULT '0',
  `buying_price` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_item_stock1_idx` (`stock_id`),
  KEY `fk_grn_item_grn1_idx` (`grn_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.grn_item: ~0 rows (approximately)

-- Dumping structure for table shop_db.invoice
CREATE TABLE IF NOT EXISTS `invoice` (
  `id` bigint NOT NULL DEFAULT '0',
  `customer_mobile` varchar(10) NOT NULL,
  `employee_email` varchar(45) NOT NULL,
  `date_time` datetime NOT NULL,
  `paid_amount` double NOT NULL,
  `payment_method_id` int NOT NULL,
  `discount` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_customer1_idx` (`customer_mobile`),
  KEY `fk_invoice_employee1_idx` (`employee_email`),
  KEY `fk_invoice_payment_method1_idx` (`payment_method_id`),
  CONSTRAINT `fk_invoice_customer1` FOREIGN KEY (`customer_mobile`) REFERENCES `customer` (`mobile`),
  CONSTRAINT `fk_invoice_employee1` FOREIGN KEY (`employee_email`) REFERENCES `employee` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.invoice: ~0 rows (approximately)

-- Dumping structure for table shop_db.invoice_item
CREATE TABLE IF NOT EXISTS `invoice_item` (
  `id` int NOT NULL DEFAULT '0',
  `qty` double NOT NULL,
  `stock_id` int NOT NULL,
  `invoice_id` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_invoice_item_stock1_idx` (`stock_id`),
  KEY `fk_invoice_item_invoice1_idx` (`invoice_id`),
  CONSTRAINT `FK_invoice_item_shop_db.invoice` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_invoice_item_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.invoice_item: ~0 rows (approximately)

-- Dumping structure for table shop_db.payment_method
CREATE TABLE IF NOT EXISTS `payment_method` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.payment_method: ~2 rows (approximately)
INSERT INTO `payment_method` (`id`, `name`) VALUES
	(1, 'Cash'),
	(2, 'Card');

-- Dumping structure for table shop_db.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `brands_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_products_brands1_idx` (`brands_id`),
  CONSTRAINT `fk_products_brands1` FOREIGN KEY (`brands_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.product: ~2 rows (approximately)
INSERT INTO `product` (`id`, `name`, `brands_id`) VALUES
	(1, 'G5', 3),
	(2, 'G45', 5),
	(3, 'M21', 3);

-- Dumping structure for table shop_db.stock
CREATE TABLE IF NOT EXISTS `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `selling_price` double NOT NULL,
  `qty` double NOT NULL,
  `mfd` date NOT NULL,
  `exp` date NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stocks_products1_idx` (`product_id`),
  CONSTRAINT `fk_stocks_products1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.stock: ~1 rows (approximately)
INSERT INTO `stock` (`id`, `selling_price`, `qty`, `mfd`, `exp`, `product_id`) VALUES
	(1, 1000, 10, '2023-07-28', '2023-07-30', 2);

-- Dumping structure for table shop_db.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `mobile` varchar(10) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`mobile`),
  KEY `fk_suppliers_companies_idx` (`company_id`),
  CONSTRAINT `fk_suppliers_companies` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shop_db.supplier: ~0 rows (approximately)
INSERT INTO `supplier` (`mobile`, `first_name`, `last_name`, `email`, `company_id`) VALUES
	('0112578463', 'jjgg', 'kkgg', 'jjkhfbk@gmail.com', 1),
	('0718457935', 'fs', 'ss', 'fs@gmail.com', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
