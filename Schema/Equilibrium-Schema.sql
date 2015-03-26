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
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`branchID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
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
  `departmentID` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `branchID` int(11) NOT NULL,
  PRIMARY KEY (`departmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
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
INSERT INTO `education_history` VALUES (1,1234,'Elementary','1',3,5,''),(2,1234,'Elementary','1.2',4,6,''),(3,1234,'High School','2',2,2,'2'),(4,1234,'College','3',3,3,'3'),(5,1234,'Elementary','1',3,5,''),(6,1234,'High School','2',2,2,'2'),(7,1234,'College','3',3,3,'3'),(8,1234,'Elementary','a',1,1,''),(9,1234,'Elementary','a',1,1,'');
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
  `isDeleted` binary(1) NOT NULL,
  `emailAddress` varchar(45) NOT NULL,
  `employeeType` varchar(12) DEFAULT NULL,
  `managerEntryNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`entryNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1234,'password','Employee','Arren','Arren','arren','1997-05-14','Binan',NULL,9278871577,'2981','2931','19281','2198','Single','Fil','Roman Catholic','2015-05-15','Band1',100000,10,'10','0','arrenmatthew@gmail.com','Employee',4),(2,1235,'password','Hr Head','Arren','Arren','arren','1997-05-14','Binan',NULL,9278871577,'2981','2931','19281','2198','Single','Fil','Roman Catholic','2015-05-15','Band1',100000,10,'10','?','arrenmatthew@gmail.com','Hr Head',4),(3,1236,'password','Hr Employee','Arren','Arren','arren','1997-05-14','Binan',NULL,9278871577,'2981','2931','19281','2198','Single','Fil','Roman Catholic','2015-05-15','Band1',100000,10,'10','?','arrenmatthew@gmail.com','Hr Employee',10),(4,1237,'password','Manager','Arren','Arren','arren','1997-05-14','Binan',NULL,9278871577,'2981','2931','19281','2198','Single','Fil','Roman Catholic','2015-05-15','Band1',100000,10,'10','?','arrenmatthew@gmail.com','Manager',10),(5,1238,'n2klel','Lastname','Arren','Arren','arren','1997-05-14','Binan',NULL,9278871577,'2981','2931','19281','2198','Single','Fil','Roman Catholic','2015-05-15','Band1',100000,10,'10','?','arrenmatthew@gmail.com','Employee',10),(6,1239,'mlllj7','Lastname','Arren ','Arren','arren','1997-05-14','Binan',NULL,9278871577,'281','91','91','917','Single','Fil','Roman Catholic','2015-12-19','bAN1',1000,10,'10','0','arrenmatthew@gmail.com','HR Employee',10),(7,4321,'nbo1dm','Lastname','Arren ','Arren','arren','1997-05-14','Binan',NULL,9278871577,'281','91','91','917','Single','Fil','Roman Catholic','2015-12-19','bAN1',1000,10,'10','?','arrenmatthew@gmail.com','Employee',4);
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
  `fieldChanged` varchar(45) NOT NULL,
  `editFrom` varchar(100) NOT NULL,
  `editTo` varchar(100) NOT NULL,
  `editorEntryNum` int(11) NOT NULL,
  `editedEntryNum` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isApproved` binary(1) DEFAULT '0',
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
INSERT INTO `employment_history` VALUES (1,1234,'qwer','1234-02-22',12,13,'hehe','hehe world',12345678910,'haha',12345678910,'huhu'),(2,1234,'2','3123-03-12',14,14,'wer','qwe',985321523412,'wer2',12345678901,'huhu');
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
  `isApproved` binary(1) DEFAULT '0',
  `approverEntryNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`leaveID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_form`
--

LOCK TABLES `leave_form` WRITE;
/*!40000 ALTER TABLE `leave_form` DISABLE KEYS */;
INSERT INTO `leave_form` VALUES (1,'Sick',1,'2015-03-23',3,'0',0),(2,'Sick',1234,'2015-03-24',3,'0',0),(3,'Sick',1234,'2015-03-24',3,'0',0),(4,'Sick',1,'2015-03-24',4,'0',0),(5,'Sick',1,'2015-03-24',2,'0',0),(6,'Sick',1,'2015-03-24',1.5,'0',0),(7,'Sick',1,'2015-03-24',1,'0',0),(8,'Sick',1,'2015-03-24',6,'0',0),(9,'Sick',1,'2015-03-24',1,'0',0),(10,'Sick',1,'2015-03-24',1,'0',0),(11,'Sick',1,'2015-03-26',4.5,'0',NULL),(12,'Sick',1,'2015-03-26',5.5,'0',NULL),(13,'Sick',1,'2015-03-26',0.5,'0',NULL),(14,'Sick',1,'2015-03-26',1.5,'0',NULL),(15,'Bereavement',1,'2015-03-26',0.5,'0',NULL),(16,'Bereavement',1,'2015-03-26',0.5,'0',NULL),(17,'Sick',1,'2015-03-26',4.5,'0',NULL),(18,'Sick',1,'2015-03-26',3.5,'0',NULL),(19,'Sick',1,'2015-03-26',3.5,'0',NULL),(20,'Emergency',1,'2015-03-26',2.5,'0',NULL);
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
/*!40000 ALTER TABLE `license` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `recordID` int(11) NOT NULL DEFAULT '1',
  `recordType` varchar(20) NOT NULL,
  `empEntryNum` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `awardName` varchar(45) DEFAULT NULL,
  `evaluationScore` int(4) DEFAULT NULL,
  `evaluatorEntryNum` int(11) DEFAULT NULL,
  `disciplinaryRecordType` varchar(45) DEFAULT NULL,
  `disciplinaryComment` varchar(3000) DEFAULT NULL,
  `disciplinaryDuration` int(11) DEFAULT NULL,
  PRIMARY KEY (`recordID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1,'memo',1234,'2015-03-23 06:13:21',NULL,NULL,NULL,NULL,'Heheheh',NULL);
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record_audit_trail`
--

DROP TABLE IF EXISTS `record_audit_trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record_audit_trail` (
  `recAuditTrailID` int(11) NOT NULL,
  `recordID` int(11) NOT NULL,
  `editorEntryNum` int(11) NOT NULL,
  `editedEntryNum` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isApproved` binary(1) DEFAULT '0',
  `approverEntryNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`recAuditTrailID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record_audit_trail`
--

LOCK TABLES `record_audit_trail` WRITE;
/*!40000 ALTER TABLE `record_audit_trail` DISABLE KEYS */;
/*!40000 ALTER TABLE `record_audit_trail` ENABLE KEYS */;
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
INSERT INTO `relative` VALUES (1,'father','father',1234,123,'mother',NULL,NULL),(2,'mother','mother',1234,12,'father',NULL,NULL);
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

-- Dump completed on 2015-03-26 18:52:57
