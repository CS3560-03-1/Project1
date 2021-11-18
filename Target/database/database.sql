CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `cartitem`
--

DROP TABLE IF EXISTS `cartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartitem` (
  `cartID` int NOT NULL,
  `inventoryItemID` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `currentPrice` double DEFAULT NULL,
  PRIMARY KEY (`cartID`,`inventoryItemID`),
  KEY `inventoryItemID` (`inventoryItemID`),
  CONSTRAINT `cartID` FOREIGN KEY (`cartID`) REFERENCES `shoppingcart` (`cartID`),
  CONSTRAINT `inventoryItemID` FOREIGN KEY (`inventoryItemID`) REFERENCES `inventoryitem` (`inventoryItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartitem`
--

LOCK TABLES `cartitem` WRITE;
/*!40000 ALTER TABLE `cartitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `custName` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `billAddress` varchar(45) DEFAULT NULL,
  `phoneNum` varchar(45) DEFAULT NULL,
  `creditCard` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`custName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('Abby Gail','123 Avenue','123 Avenue','1234567890','1234123412341234','abbyg2','abc1234'),('Kevin Nguyen','245 Street','245 Street','9091234567','1234567812345678','kevdude','koolkevin7');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventoryitem`
--

DROP TABLE IF EXISTS `inventoryitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventoryitem` (
  `inventoryItemID` int NOT NULL,
  `productID` int NOT NULL,
  `item name` varchar(45) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `cost` double(10,2) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `weight` double(10,2) DEFAULT NULL,
  `size` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`inventoryItemID`,`productID`),
  KEY `productID` (`productID`),
  CONSTRAINT `productID` FOREIGN KEY (`productID`) REFERENCES `productitem` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventoryitem`
--

LOCK TABLES `inventoryitem` WRITE;
/*!40000 ALTER TABLE `inventoryitem` DISABLE KEYS */;
INSERT INTO `inventoryitem` VALUES (1,1001,'Sports Shoe',21,69.99,'red',1.75,'12 in','Shoe used for sports and running'),(2,1002,'Tennis Shoes',29,59.99,'red',2.00,'11 in','Casual shoes for walking'),(3,1003,'Slacks',50,30.00,'red',2.00,'30 x 30','Regular slacks'),(4,1004,'T Shirt',51,15.00,'red',2.00,'Medium','Normal baic t shirt'),(5,1005,'Hat',169,8.99,'red',2.00,'Medium','Casual fitting hat'),(6,1006,'Cake',98,12.00,'red',2.00,'N/A','Delicious cake with frosting'),(7,1007,'Twinkies',324,3.50,'red',2.00,'N/A','Pack of twinkies'),(8,1008,'Hot dogs',132,4.99,'red',2.00,'N/A','Hot dog sausages for cooking'),(9,1009,'Instant ramen',68,2.50,'red',2.00,'N/A','Fast and easy noodles'),(10,1010,'Grapes',19,3.00,'red',2.00,'N/A','Delicious healthy grapes'),(11,1011,'Candle',90,10.00,'red',2.00,'5 in','Fragrant and nice candle'),(12,1012,'Chair',85,35.00,'red',2.00,'3.5 ft','Comfortable wooden chair'),(13,1013,'Pencils',15,5.00,'red',2.00,'8 in','Pack of sharpened pencils'),(14,1014,'Crayons',321,3.00,'red',2.00,'4 in','Pack of colorful crayons'),(15,1015,'Ring',56,200.00,'gold',2.00,'2 in','Basic gold ring'),(16,1016,'Necklace',98,150.00,'silver',2.00,'N/A','Blingy silver necklace');
/*!40000 ALTER TABLE `inventoryitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `orderID` int NOT NULL,
  `confirmation` tinyint DEFAULT NULL,
  `deliveryMethod` varchar(45) DEFAULT NULL,
  `date` int DEFAULT NULL,
  `deliveryType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,0,'Pick-up',NULL,NULL),(2,0,'Pick-up',NULL,NULL),(3,0,'Pick-up',NULL,NULL),(4,0,'Pick-up',NULL,NULL);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productitem`
--

DROP TABLE IF EXISTS `productitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productitem` (
  `productID` int NOT NULL,
  `perishable` tinyint DEFAULT NULL,
  `photo` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productitem`
--

LOCK TABLES `productitem` WRITE;
/*!40000 ALTER TABLE `productitem` DISABLE KEYS */;
INSERT INTO `productitem` VALUES (1001,0,'shoes1','Sports Shoe'),(1002,0,'shoes2','Tennis Shoe'),(1003,0,'slacks','Slacks'),(1004,0,'tshirt','T Shirt'),(1005,0,'hat','Hat'),(1006,1,'cake','Cake'),(1007,1,'twinkies','Twinkies'),(1008,1,'hotdogs','Hot Dogs'),(1009,1,'ramen','Instant Ramen'),(1010,1,'grape','Grapes'),(1011,0,'candle','Candle'),(1012,0,'chair','Chair'),(1013,0,'pencil','Pencils'),(1014,0,'crayons','Crayons'),(1015,0,'ring','Ring'),(1016,0,'necklace','Necklace');
/*!40000 ALTER TABLE `productitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcart`
--

DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shoppingcart` (
  `cartID` int NOT NULL,
  `custName` varchar(45) NOT NULL,
  `productQuantity` int DEFAULT NULL,
  `totalCost` double DEFAULT NULL,
  PRIMARY KEY (`cartID`,`custName`),
  KEY `custName` (`custName`),
  CONSTRAINT `custName` FOREIGN KEY (`custName`) REFERENCES `customer` (`custName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcart`
--

LOCK TABLES `shoppingcart` WRITE;
/*!40000 ALTER TABLE `shoppingcart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transactionID` int NOT NULL,
  `custName` varchar(45) NOT NULL,
  `orderID` int NOT NULL,
  `date` int DEFAULT NULL,
  `transType` varchar(45) DEFAULT NULL,
  `transAmount` double DEFAULT NULL,
  PRIMARY KEY (`transactionID`,`custName`,`orderID`),
  KEY `t.custName` (`custName`),
  KEY `orderID` (`orderID`),
  CONSTRAINT `orderID` FOREIGN KEY (`orderID`) REFERENCES `order` (`orderID`),
  CONSTRAINT `t.custName` FOREIGN KEY (`custName`) REFERENCES `customer` (`custName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-18  7:34:02
