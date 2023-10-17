-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: localhost    Database: ccrs
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu4

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
INSERT INTO `business_user` VALUES (2,'7f016db9-d838-4955-ba1f-1b93eabd770e','Jane','Doe','2022-03-26 00:00:00','2022-03-26 00:00:00'),(4,'7f016db9-d838-4955-ba1f-1b93eabd770e','Skip','Step','2022-03-26 00:00:00','2022-03-26 00:00:00'),(6,'7f016db9-d838-4955-ba1f-1b93eabd770e','Jerry','Gao','2022-03-28 00:00:00','2022-03-28 00:00:00');
/*!40000 ALTER TABLE `business_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `coffee_order`
--

LOCK TABLES `coffee_order` WRITE;
/*!40000 ALTER TABLE `coffee_order` DISABLE KEYS */;
INSERT INTO `coffee_order` VALUES (19,1,'6ca84ab0-aa6a-4f50-a292-91a9a2c2b226','19abe144-3b2d-456c-acfa-9cbc17fff3f8','AMERICANO','S','2022-04-30 00:00:00','DONE'),(20,1,'6ca84ab0-aa6a-4f50-a292-91a9a2c2b226','19abe144-3b2d-456c-acfa-9cbc17fff3f8','CAPPUCCINO','L','2022-04-30 00:00:00','DONE'),(21,1,'19abe144-3b2d-456c-acfa-9cbc17fff3bb','7f016db9-d838-4955-ba1f-1b93eabd770e','AMERICANO','M','2022-04-30 00:00:00','DONE');
/*!40000 ALTER TABLE `coffee_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'roger11','Roger','Gee','2022-04-18 12:09:35','2022-04-18 12:09:35');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (3,'7f016db9-d838-4955-ba1f-1b93eabd770e','2022-04-19 00:00:00','2022-05-28 00:00:00',10.71,'OPEN');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `robot`
--

LOCK TABLES `robot` WRITE;
/*!40000 ALTER TABLE `robot` DISABLE KEYS */;
INSERT INTO `robot` VALUES ('19abe144-3b2d-456c-acfa-9cbc17fff3bb','7f016db9-d838-4955-ba1f-1b93eabd770e','ENABLED','2022-03-26 00:00:00','2022-04-30 00:00:00'),('19abe144-3b2d-456c-acfa-9cbc17fff3cc','7f016db9-d838-4955-ba1f-1b93eabd770e','ENABLED','2022-03-26 00:00:00','2022-04-30 00:00:00'),('4e889c87-577f-4fac-95d3-92f9fc2eee10','7f016db9-d838-4955-ba1f-1b93eabd770e','ENABLED','2022-04-26 00:00:00','2022-04-26 00:00:00'),('5a5d73a2-02fd-4f66-87fb-22d99c80e222','7f016db9-d838-4955-ba1f-1b93eabd770e','ENABLED','2022-04-24 00:00:00','2022-04-24 00:00:00'),('6ca84ab0-aa6a-4f50-a292-91a9a2c2b226','19abe144-3b2d-456c-acfa-9cbc17fff3f8','ENABLED','2022-04-30 00:00:00','2022-04-30 00:00:00'),('7082f94b-223f-4dbb-a88c-d207fda332f7','7f016db9-d838-4955-ba1f-1b93eabd770e','ENABLED','2022-04-24 00:00:00','2022-04-24 00:00:00'),('746f9e22-ebf5-4b6a-a75c-b88ad2e522ca','7f016db9-d838-4955-ba1f-1b93eabd770e','ENABLED','2022-04-24 00:00:00','2022-04-24 00:00:00'),('8152032d-5b6c-4bcd-a31e-84e03f8d9047','7f016db9-d838-4955-ba1f-1b93eabd770e','ENABLED','2022-04-24 00:00:00','2022-04-24 00:00:00'),('8a38238f-8fe6-4f21-891c-27921fcfb181','19abe144-3b2d-456c-acfa-9cbc17fff3f8','ENABLED','2022-04-30 00:00:00','2022-04-30 00:00:00'),('eeb6a6ee-0add-44a0-9ab2-0d8aff5eb4dd','19abe144-3b2d-456c-acfa-9cbc17fff3f8','ENABLED','2022-04-30 00:00:00','2022-04-30 00:00:00'),('fd14f217-e259-468e-b5aa-b40a535644b4','7f016db9-d838-4955-ba1f-1b93eabd770e','ENABLED','2022-04-24 00:00:00','2022-04-24 00:00:00');
/*!40000 ALTER TABLE `robot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `robot_config`
--

LOCK TABLES `robot_config` WRITE;
/*!40000 ALTER TABLE `robot_config` DISABLE KEYS */;
INSERT INTO `robot_config` VALUES ('19abe144-3b2d-456c-acfa-9cbc17fff3bb','account.robot.admins','[jmon, foobar]','2022-04-22 00:00:00'),('19abe144-3b2d-456c-acfa-9cbc17fff3bb','robot.coffee.sizes','[1,2,3]','2022-04-22 00:00:00'),('19abe144-3b2d-456c-acfa-9cbc17fff3bb','robot.coffee.type','1','2022-04-22 00:00:00'),('19abe144-3b2d-456c-acfa-9cbc17fff3bb','robot.end_time','17','2022-04-22 00:00:00'),('19abe144-3b2d-456c-acfa-9cbc17fff3bb','robot.start_time','6','2022-04-24 00:00:00');
/*!40000 ALTER TABLE `robot_config` ENABLE KEYS */;
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
INSERT INTO `user_role` VALUES (1,3),(2,2),(3,3),(4,2),(5,3),(6,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'jmonsod@gmail.com','$2a$10$ju955fkRo2I7ON8IB9TOmuK.A/g7ziw6I7Y4j3xv8qHi0OTNcKoL.','jmonsod@gmail.com'),(2,'jdoe@email.com','$2a$10$0Bh6ztaBj1x4MqfASPJi5eDPoZ4n9CO5m7jzbx7VwyhnaMAtu3bty','jdoe@email.com'),(3,'foo@bar.com','$2a$10$x4hTDfWwxNYwh9fErfoQceQZ9ZvGGPh./81758RNIXlCOBMQy3GiC','foobar'),(4,'bar@bar.com','$2a$10$jE35Gp9ycUYlXlesHRtLbu.bUeQFDdRpQIvr/KEPFLw3r2BGjITLW','bar@bar.com'),(5,'john@mail.com','$2a$10$8p83/p2PLzIPl1SS85Fi6eFCfK1txm5BS9nkAhRqhxE4maVzBoGr2','jmon'),(6,'jgao@sjsu.edu','$2a$10$twuhQPqCyB0iTunZgI5SqO6Rt0/KfTfE3nt8H2U5V6358GN1X1cs6','jgao@sjsu.edu');
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

-- Dump completed on 2022-05-01  3:58:06
