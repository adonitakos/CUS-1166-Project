CREATE DATABASE  IF NOT EXISTS `vehicle_vortex` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `vehicle_vortex`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: vehicle_vortex
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `carID` int NOT NULL,
  `plateNum` varchar(45) NOT NULL,
  `carOwnerID` int NOT NULL,
  `make` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `inUse` tinyint NOT NULL,
  `currentJobID` int DEFAULT NULL,
  `Timestamp` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`carID`,`plateNum`),
  KEY `jobID_idx` (`currentJobID`),
  KEY `carOwner_idx` (`carOwnerID`),
  CONSTRAINT `carOwner` FOREIGN KEY (`carOwnerID`) REFERENCES `users` (`ID`),
  CONSTRAINT `currentJobID` FOREIGN KEY (`currentJobID`) REFERENCES `jobs` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (875,'76hr5',2345,'Nah','Nah','5',0,NULL,'2023-04-17 18:28:22'),(1234,'2fwes',2345,'Ford','Ford','3',0,NULL,'2023-04-17 05:37:31'),(41111,'234ewf',2345,'Tesla','E','7',0,NULL,'2023-04-17 19:07:20');
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobs` (
  `ID` int NOT NULL,
  `duration` tinyint NOT NULL,
  `deadline` varchar(45) NOT NULL,
  `status` tinyint NOT NULL,
  `redundancy` tinyint NOT NULL,
  `completionTime` int NOT NULL,
  `description` text NOT NULL,
  `jobOwnerID` int NOT NULL,
  `carsUsingNum` int NOT NULL,
  `Timestamp` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `jobID_UNIQUE` (`ID`),
  KEY `ownerID_idx` (`jobOwnerID`),
  CONSTRAINT `jobOwner` FOREIGN KEY (`jobOwnerID`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (11,31,'122/11',0,5,52,'QWERTY',2345,0,'2023-04-17 04:31:25'),(12,21,'22.2',0,5,21,'Ta',2345,0,'2023-04-17 04:23:09'),(64,45,'7yt',0,5,174,'67u',2345,0,'2023-04-17 19:06:36'),(98,2,'4wed',0,5,176,'54r',2345,0,'2023-04-17 19:27:10'),(143,2,'12wef',0,5,55,'ew4r',2345,0,'2023-04-17 04:41:26'),(654,45,'f4wr',0,5,127,'45gte',2345,0,'2023-04-17 18:21:37'),(776,2,'13e53r',0,5,129,'75y',2345,0,'2023-04-17 19:05:14'),(1011,3,'2ws',0,5,82,'342ew',2345,0,'2023-04-17 18:21:02'),(1111,1,'12/1',0,5,53,'No',2345,0,'2023-04-17 04:34:12'),(2442,24,'24ew',0,5,79,'24e',2345,0,'2023-04-17 04:58:31'),(6535,7,'6uth',0,5,183,'qewrsf',2345,0,'2023-04-17 19:27:26');
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logins`
--

DROP TABLE IF EXISTS `logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logins` (
  `userID` int NOT NULL,
  `time` timestamp NOT NULL,
  PRIMARY KEY (`userID`,`time`),
  CONSTRAINT `userID` FOREIGN KEY (`userID`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logins`
--

LOCK TABLES `logins` WRITE;
/*!40000 ALTER TABLE `logins` DISABLE KEYS */;
INSERT INTO `logins` VALUES (1234,'2023-04-16 21:38:10'),(1234,'2023-04-16 21:38:27'),(1234,'2023-04-16 21:42:20'),(1234,'2023-04-16 21:43:42'),(1234,'2023-04-16 21:45:11'),(1234,'2023-04-16 21:49:00'),(1234,'2023-04-17 01:15:53'),(1234,'2023-04-17 01:17:49'),(1234,'2023-04-17 01:23:52'),(1234,'2023-04-17 01:24:21'),(1234,'2023-04-17 01:34:53'),(1234,'2023-04-17 01:39:44'),(1234,'2023-04-17 02:14:05'),(1234,'2023-04-17 03:38:44'),(1234,'2023-04-17 03:55:14'),(1234,'2023-04-17 04:01:32'),(1234,'2023-04-17 04:10:55'),(1234,'2023-04-17 04:16:50'),(1234,'2023-04-17 04:22:02'),(1234,'2023-04-17 04:26:29'),(1234,'2023-04-17 04:30:28'),(1234,'2023-04-17 04:33:15'),(1234,'2023-04-17 04:40:20'),(1234,'2023-04-17 04:56:09'),(1234,'2023-04-17 04:57:39'),(1234,'2023-04-17 05:36:04'),(1234,'2023-04-17 18:03:03'),(1234,'2023-04-17 18:04:57'),(1234,'2023-04-17 18:08:51'),(1234,'2023-04-17 18:12:12'),(1234,'2023-04-17 18:19:45'),(1234,'2023-04-17 18:27:22'),(1234,'2023-04-17 19:02:34'),(1234,'2023-04-17 19:21:06'),(1234,'2023-04-17 19:26:17'),(2345,'2023-04-17 01:25:08'),(2345,'2023-04-17 01:35:07'),(2345,'2023-04-17 01:40:00'),(2345,'2023-04-17 02:14:38'),(2345,'2023-04-17 03:39:07'),(2345,'2023-04-17 03:55:35'),(2345,'2023-04-17 04:02:11'),(2345,'2023-04-17 04:11:20'),(2345,'2023-04-17 04:13:42'),(2345,'2023-04-17 04:14:32'),(2345,'2023-04-17 04:17:11'),(2345,'2023-04-17 04:22:27'),(2345,'2023-04-17 04:26:53'),(2345,'2023-04-17 04:30:53'),(2345,'2023-04-17 04:33:41'),(2345,'2023-04-17 04:40:51'),(2345,'2023-04-17 04:56:30'),(2345,'2023-04-17 04:58:11'),(2345,'2023-04-17 05:36:43'),(2345,'2023-04-17 18:09:58'),(2345,'2023-04-17 18:12:52'),(2345,'2023-04-17 18:20:37'),(2345,'2023-04-17 18:27:47'),(2345,'2023-04-17 19:03:09'),(2345,'2023-04-17 19:26:42');
/*!40000 ALTER TABLE `logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `ID` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `Type` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `users_chk_1` CHECK (((`Type` = _utf8mb4'Admin') or (`Type` = _utf8mb4'User')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1234,'username!','password!','Admin'),(2345,'TestPerson!','testpassword!','User'),(3456,'testmonkey2!','testmonkey!','User'),(4567,'testmonkey3!','test!','User'),(5678,'testmonkey!','test!','User'),(226872204,'tahir2022','tahir2022!','User'),(354495603,'tahir20!','tahir20!','User'),(979025803,'tahir2001','tahir2001!','User');
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

-- Dump completed on 2023-04-24 22:50:27
