-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: ccrs
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('19abe144-3b2d-456c-acfa-9cbc17fff3f8','2022-03-26 00:00:00','Startup Inc.','456 Disney Ave','Palo Alto','CA','95014'),('7f016db9-d838-4955-ba1f-1b93eabd770e','2022-03-26 00:00:00','Foo Bar Inc.','123 Main St.','San Jose','CA','95129');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `business_user`
--

LOCK TABLES `business_user` WRITE;
/*!40000 ALTER TABLE `business_user` DISABLE KEYS */;
INSERT INTO `business_user` VALUES (2,'7f016db9-d838-4955-ba1f-1b93eabd770e','Jane','Doe','2022-03-26 00:00:00','2022-03-26 00:00:00');
/*!40000 ALTER TABLE `business_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `coffee_order`
--

LOCK TABLES `coffee_order` WRITE;
/*!40000 ALTER TABLE `coffee_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `coffee_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO customer(username, fname, lname, created_at, updated_at) VALUES ('jdoe', 'Jane', 'Doe', now(), now())
INSERT INTO customer(username, fname, lname, created_at, updated_at) VALUES ('rsmith', 'Robert', 'Smith', now(), now())
INSERT INTO customer(username, fname, lname, created_at, updated_at) VALUES ('spark', 'Slim', 'Park', now(), now())
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `robot`
--

LOCK TABLES `robot` WRITE;
/*!40000 ALTER TABLE `robot` DISABLE KEYS */;
/*!40000 ALTER TABLE `robot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `robot_usage`
--

LOCK TABLES `robot_usage` WRITE;
/*!40000 ALTER TABLE `robot_usage` DISABLE KEYS */;
/*!40000 ALTER TABLE `robot_usage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_CUSTOMER'),(2,'ROLE_BUSINESS'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,3),(2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'jmonsod@gmail.com','$2a$10$ju955fkRo2I7ON8IB9TOmuK.A/g7ziw6I7Y4j3xv8qHi0OTNcKoL.','jmonsod@gmail.com'),(2,'jdoe@email.com','$2a$10$0Bh6ztaBj1x4MqfASPJi5eDPoZ4n9CO5m7jzbx7VwyhnaMAtu3bty','jdoe@email.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-26 13:22:06
