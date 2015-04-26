CREATE DATABASE  IF NOT EXISTS `equilibrium_spsweng` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `equilibrium_spsweng`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: equilibrium_spsweng
-- ------------------------------------------------------
-- Server version	5.6.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `branchID` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`branchID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'Luzon','Luzon'),(2,'Palawan','Palawan'),(3,'Cebu','Cebu'),(4,'Cagayan De Oro','Cagayan De Oro'),(5,'Davao','Davao'),(6,'Naga','Naga'),(7,'Pampanga','Pampanga');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criminal_offense_history`
--

DROP TABLE IF EXISTS `criminal_offense_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `criminal_offense_history` (
  `criminalOffenseHistoryID` int(11) NOT NULL,
  `empEntryNum` int(11) NOT NULL,
  `criminalOffense` varchar(45) NOT NULL,
  `dateOfOffense` date NOT NULL,
  `placeOfOffense` varchar(100) NOT NULL,
  PRIMARY KEY (`criminalOffenseHistoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criminal_offense_history`
--

LOCK TABLES `criminal_offense_history` WRITE;
/*!40000 ALTER TABLE `criminal_offense_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `criminal_offense_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `departmentID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `branchID` int(11) NOT NULL,
  PRIMARY KEY (`departmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Sales',1),(2,'Finance',1),(3,'Accounting',1),(4,'Logistics',1),(5,'Warehousing',1),(6,'Purchasing',1),(7,'Human Resource',1),(8,'Sales',2),(9,'Finance',2),(10,'Accounting',2),(11,'Logistics',2),(12,'Warehousing',2),(13,'Purchasing',2),(14,'Human Resource',2),(15,'Sales',3),(16,'Finance',3),(17,'Accounting',3),(18,'Logistics',3),(19,'Warehousing',3),(20,'Purchasing',3),(21,'Human Resource',3),(22,'Sales',4),(23,'Finance',4),(24,'Accounting',4),(25,'Logistics',4),(26,'Warehousing',4),(27,'Purchasing',4),(28,'Human Resource',4),(29,'Sales',5),(30,'Finance',5),(31,'Accounting',5),(32,'Logistics',5),(33,'Warehousing',5),(34,'Purchasing',5),(35,'Human Resource',5),(36,'Sales',6),(37,'Finance',6),(38,'Accounting',6),(39,'Logistics',6),(40,'Warehousing',6),(41,'Purchasing',6),(42,'Human Resource',6),(43,'Sales',7),(44,'Finance',7),(45,'Accounting',7),(46,'Logistics',7),(47,'Warehousing',7),(48,'Purchasing',7),(49,'Human Resource',7);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_history`
--

DROP TABLE IF EXISTS `education_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education_history` (
  `educationHistoryID` int(11) NOT NULL,
  `empEntryNum` int(11) NOT NULL,
  `level` varchar(20) NOT NULL,
  `schoolName` varchar(45) NOT NULL,
  `yearFrom` int(4) NOT NULL,
  `yearTo` int(4) NOT NULL,
  `award` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`educationHistoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_history`
--

LOCK TABLES `education_history` WRITE;
/*!40000 ALTER TABLE `education_history` DISABLE KEYS */;
INSERT INTO `education_history` VALUES (1,1,'High School','Dominican College',2009,2013,'Top 1');
/*!40000 ALTER TABLE `education_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `entryNum` int(11) NOT NULL,
  `employeeID` int(11) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `lastName` varchar(20) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `middleName` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `birthday` date NOT NULL,
  `birthplace` varchar(20) NOT NULL,
  `homePhone` int(9) DEFAULT NULL,
  `mobileNumber` bigint(11) NOT NULL,
  `SSSNumber` varchar(12) NOT NULL,
  `TINNumber` varchar(16) NOT NULL,
  `PHICNumber` varchar(14) NOT NULL,
  `PAGIBIGNumber` varchar(14) NOT NULL,
  `civilStatus` varchar(15) NOT NULL,
  `citizenship` varchar(20) NOT NULL,
  `religion` varchar(20) NOT NULL,
  `hireDate` date DEFAULT NULL,
  `band` varchar(20) DEFAULT NULL,
  `salary` int(7) NOT NULL,
  `departmentID` int(11) DEFAULT NULL,
  `positionName` varchar(30) DEFAULT NULL,
  `isDeleted` binary(1) NOT NULL DEFAULT '0',
  `emailAddress` varchar(45) NOT NULL,
  `employeeType` varchar(20) DEFAULT NULL,
  `managerEntryNum` int(11) DEFAULT NULL,
  `empPicture` mediumblob,
  `empPictureFileName` tinytext,
  PRIMARY KEY (`entryNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1234,'password','Arca','Ramon','Teodoro','City of Santa Rosa, Laguna','1997-04-03','City of Santa Rosa',5343250,9278871577,'11-1234567-1','444-444-444-444','01-123123123-2','1234-1234-1234','Single','Filipino','Roman Catholic','2015-01-01','1',100000,7,'HR Head','0','ramonarca@gmail.com','Hr Head',0,NULL,NULL),(2,1235,'password','Virtusio','Jet','Corpuz','City of Calamba','1997-10-10','City of Calamba',5343251,9278871577,'11-1234567-2','444-444-444-445','01-123123123-3','1234-1234-1235','Single','Filipino','Roman Catholic','2015-01-01','1',10000,7,'HR Employee','0','jetvirtusio@hotmail.com','Hr Employee',1,NULL,NULL),(3,1236,'password','Talavera','Arces','Adique','City of Binan','1997-12-28','City of Binan',5343256,9278871567,'11-1234567-3','444-444-444-446','01-123123123-4','1234-1234-1236','Single','Filipino','Roman Catholic','2015-01-01','1',10000,1,'Manager','0','arcestalavera@gmail.com','Manager',3,NULL,NULL),(4,1237,'password','Sibayan','Hannah','Lojico','Las Pinas City','1996-10-05','Las Pinas City',5343257,9278891029,'11-1234567-4','444-444-444-440','01-123123123-5','1234-1234-1237','Single','Filipino','Christian','2015-01-01','1',10000,2,'Senior Manager','0','hannahsibayan@gmail.com','Senior Manager',0,NULL,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_audit_trail`
--

DROP TABLE IF EXISTS `employee_audit_trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_audit_trail` (
  `empAuditTrailID` int(11) NOT NULL,
  `tableName` varchar(45) NOT NULL,
  `tableReferenceNum` int(11) NOT NULL,
  `fieldChanged` varchar(45) NOT NULL,
  `editFrom` varchar(100) NOT NULL,
  `editTo` varchar(100) NOT NULL,
  `editorEntryNum` int(11) NOT NULL,
  `editedEntryNum` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isApproved` varchar(10) DEFAULT 'Pending',
  `approverEntryNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`empAuditTrailID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_audit_trail`
--

LOCK TABLES `employee_audit_trail` WRITE;
/*!40000 ALTER TABLE `employee_audit_trail` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_audit_trail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employment_history`
--

DROP TABLE IF EXISTS `employment_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employment_history` (
  `employmentHistoryID` int(11) NOT NULL,
  `empEntryNum` int(11) NOT NULL,
  `jobTitle` varchar(20) NOT NULL,
  `dateOfEmployment` date NOT NULL,
  `startingSalary` int(7) NOT NULL,
  `endingSalary` int(7) NOT NULL,
  `employerName` varchar(45) NOT NULL,
  `employerAddress` varchar(100) NOT NULL,
  `employerContactNum` bigint(11) NOT NULL,
  `supervisorName` varchar(45) DEFAULT NULL,
  `supervisorContactNum` bigint(11) DEFAULT NULL,
  `reasonForLeaving` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`employmentHistoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employment_history`
--

LOCK TABLES `employment_history` WRITE;
/*!40000 ALTER TABLE `employment_history` DISABLE KEYS */;
INSERT INTO `employment_history` VALUES (1,1,'Professor','2014-12-10',100,10,'Party Place','Manila',9278871577,'Napoleon Borntoparty',9278871567,'Not Enough Salary');
/*!40000 ALTER TABLE `employment_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_form`
--

DROP TABLE IF EXISTS `leave_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave_form` (
  `leaveID` int(11) NOT NULL,
  `leaveType` varchar(20) NOT NULL,
  `empEntryNum` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `duration` float NOT NULL,
  `isApproved` varchar(10) DEFAULT 'Pending',
  `approverEntryNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`leaveID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_form`
--

LOCK TABLES `leave_form` WRITE;
/*!40000 ALTER TABLE `leave_form` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `license`
--

DROP TABLE IF EXISTS `license`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `license` (
  `licenseID` int(11) NOT NULL,
  `licenseName` varchar(45) NOT NULL,
  `empEntryNum` int(11) NOT NULL,
  `percentage` int(11) NOT NULL,
  PRIMARY KEY (`licenseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `license`
--

LOCK TABLES `license` WRITE;
/*!40000 ALTER TABLE `license` DISABLE KEYS */;
INSERT INTO `license` VALUES (1,'Law Licensure Exam',1,100);
/*!40000 ALTER TABLE `license` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `recordID` int(11) NOT NULL AUTO_INCREMENT,
  `recordType` varchar(20) NOT NULL,
  `empEntryNum` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `awardName` varchar(45) DEFAULT NULL,
  `awardComment` varchar(3000) DEFAULT NULL,
  `evaluationScore` varchar(45) DEFAULT NULL,
  `evaluationName` varchar(45) DEFAULT NULL,
  `disciplinaryRecordType` varchar(45) DEFAULT NULL,
  `disciplinaryComment` varchar(3000) DEFAULT NULL,
  `disciplinaryDuration` int(11) DEFAULT NULL,
  `file` mediumblob,
  `filename` tinytext,
  PRIMARY KEY (`recordID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relative`
--

DROP TABLE IF EXISTS `relative`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relative` (
  `relativeID` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `relation` varchar(20) NOT NULL,
  `empEntryNum` int(11) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `occupation` varchar(20) DEFAULT NULL,
  `occupationLocation` varchar(100) DEFAULT NULL,
  `contactNum` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`relativeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relative`
--

LOCK TABLES `relative` WRITE;
/*!40000 ALTER TABLE `relative` DISABLE KEYS */;
INSERT INTO `relative` VALUES (1,'Mother Arca','Mother',1,40,'Businesswoman','City of Santa Rosa',9278871589);
/*!40000 ALTER TABLE `relative` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-27  3:11:00
