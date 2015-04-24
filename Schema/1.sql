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
INSERT INTO `employee` VALUES (1,1234,'password','Employee','Arren','Arren','arren','1997-05-14','Binan',NULL,9278871577,'2981','2931','19281','2198','Single','Fil','Roman Catholic','2015-05-15','Band1',100000,10,'10','0','jetvirtusio@hotmail.com','Employee',4,NULL,NULL),(2,1235,'password','Hr Head','Arren','Arren','arren','1997-05-14','Binan',NULL,9278871577,'2981','2931','19281','2198','Single','Fil','Roman Catholic','2015-05-15','Band1',100000,10,'10','?','jetvirtusio@hotmail.com','Hr Head',4,NULL,NULL),(3,1236,'password','Hr Employee','Arren','Arren','arren','1997-05-14','Binan',NULL,9278871577,'2981','2931','19281','2198','Single','Fil','Roman Catholic','2015-05-15','Band1',100000,10,'10','?','jetvirtusio@hotmail.com','Hr Employee',10,NULL,NULL),(4,1237,'password','Manager','Arren','Arren','arren','1997-05-14','Binan',NULL,9278871577,'2981','2931','19281','2198','Single','Fil','Roman Catholic','2015-05-15','Band1',100000,10,'10','?','jetvirtusio@hotmail.com','Manager',10,NULL,NULL),(5,1238,'n2klel','Lastname','Arren','Arren','arren','1997-05-14','Binan',NULL,9278871577,'2981','2931','19281','2198','Single','Fil','Roman Catholic','2015-05-15','Band1',100000,10,'10','?','jetvirtusio@hotmail.com','Employee',10,NULL,NULL),(6,1239,'mlllj7','Lastname','Arren ','Arren','arren','1997-05-14','Binan',NULL,9278871577,'281','91','91','917','Single','Fil','Roman Catholic','2015-12-19','bAN1',1000,10,'10','0','jetvirtusio@hotmail.com','HR Employee',10,NULL,NULL),(7,4321,'nbo1dm','Lastname','Arren ','Arren','arren','1997-05-14','Binan',NULL,9278871577,'281','91','91','917','Single','Fil','Roman Catholic','2015-12-19','bAN1',1000,10,'10','?','jetvirtusio@hotmail.com','Employee',4,NULL,NULL),(8,113,'k6kgjl','Lastname','jet','','','2015-04-14','',NULL,0,'','','','','','','',NULL,NULL,0,NULL,NULL,'\0','jetvirtusio@hotmail.com','Manager',NULL,NULL,NULL);
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
INSERT INTO `leave_form` VALUES (1,'Sick',1,'2015-03-23',3,'Approved',4),(2,'Sick',1234,'2015-03-24',3,'0',0),(3,'Sick',1234,'2015-03-24',3,'0',0),(4,'Sick',1,'2015-03-24',4,'Approved',4),(5,'Sick',1,'2015-03-24',2,'Approved',4),(6,'Sick',1,'2015-03-24',1.5,'Approved',4),(7,'Sick',1,'2015-03-24',1,'Approved',4),(8,'Sick',1,'2015-03-24',6,'Rejected',4),(9,'Sick',1,'2015-03-24',1,'0',0),(10,'Sick',1,'2015-03-24',1,'0',0),(11,'Sick',1,'2015-03-26',4.5,'0',NULL),(12,'Sick',1,'2015-03-26',5.5,'0',NULL),(13,'Sick',1,'2015-03-26',0.5,'0',NULL),(14,'Sick',1,'2015-03-26',1.5,'0',NULL),(15,'Bereavement',1,'2015-03-26',0.5,'0',NULL),(16,'Bereavement',1,'2015-03-26',0.5,'0',NULL),(17,'Sick',1,'2015-03-26',4.5,'0',NULL),(18,'Sick',1,'2015-03-26',3.5,'0',NULL),(19,'Sick',1,'2015-03-26',3.5,'0',NULL),(20,'Emergency',1,'2015-03-26',2.5,'0',NULL);
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
  `recordID` int(11) NOT NULL AUTO_INCREMENT,
  `recordType` varchar(20) NOT NULL,
  `empEntryNum` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `awardName` varchar(45) DEFAULT NULL,
  `evaluationScore` int(4) DEFAULT NULL,
  `evaluatorEntryNum` int(11) DEFAULT NULL,
  `disciplinaryRecordType` varchar(45) DEFAULT NULL,
  `disciplinaryComment` varchar(3000) DEFAULT NULL,
  `disciplinaryDuration` int(11) DEFAULT NULL,
  `file` mediumblob,
  `filename` tinytext,
  PRIMARY KEY (`recordID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1,'memo',1234,'2015-03-23 06:13:21',NULL,NULL,NULL,NULL,'Heheheh',NULL,NULL,NULL),(2,'memo',1234,'2015-04-14 15:55:07',NULL,NULL,NULL,NULL,'123',NULL,NULL,NULL),(3,'memo',1,'2015-04-14 18:38:14',NULL,NULL,NULL,'Verbal Reprimand','U ded bro',NULL,NULL,NULL),(4,'memo',1,'2015-04-14 19:04:16',NULL,NULL,NULL,'Verbal Reprimand','Noob',NULL,NULL,NULL),(5,'memo',1,'2015-04-14 19:08:18',NULL,NULL,NULL,'Verbal Reprimand','Lol',NULL,NULL,NULL),(6,'memo',1,'2015-04-14 19:10:25',NULL,NULL,NULL,'Verbal Reprimand','123',NULL,NULL,NULL),(7,'memo',1,'2015-04-14 19:13:33',NULL,NULL,NULL,'Verbal Reprimand','dedz',NULL,NULL,NULL),(8,'memo',1,'2015-04-21 10:59:28',NULL,NULL,NULL,'Verbal Reprimand','Ur ded man lol',NULL,NULL,NULL),(9,'memo',1,'2015-04-21 11:05:26',NULL,NULL,NULL,'Verbal Reprimand','Hereeeeeeee',NULL,NULL,NULL),(10,'memo',1,'2015-04-21 11:13:03',NULL,NULL,NULL,'Verbal Reprimand','bakit ayaw',NULL,NULL,NULL),(11,'memo',1,'2015-04-21 11:15:59',NULL,NULL,NULL,'Verbal Reprimand','Hehehe',NULL,NULL,NULL),(12,'memo',1,'2015-04-21 11:46:22',NULL,NULL,NULL,'Verbal Reprimand','Stuff',NULL,'ÿØÿà\0JFIF\0\0\0\0\0\0ÿþ\0*\0ÿâICC_PROFILE\0\0\0lcms\0\0mntrRGB XYZ Ü\0\0\0\0)\09acspAPPL\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÖ\0\0\0\0\0Ó-lcms\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\ndesc\0\0\0ü\0\0\0^cprt\0\0\\\0\0\0wtpt\0\0h\0\0\0bkpt\0\0|\0\0\0rXYZ\0\0\0\0\0gXYZ\0\0¤\0\0\0bXYZ\0\0¸\0\0\0rTRC\0\0Ì\0\0\0@gTRC\0\0Ì\0\0\0@bTRC\0\0Ì\0\0\0@desc\0\0\0\0\0\0\0c2\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0text\0\0\0\0FB\0\0XYZ \0\0\0\0\0\0öÖ\0\0\0\0\0Ó-XYZ \0\0\0\0\0\0\0\03\0\0¤XYZ \0\0\0\0\0\0o¢\0\08õ\0\0XYZ \0\0\0\0\0\0b™\0\0·…\0\0ÚXYZ \0\0\0\0\0\0$ \0\0„\0\0¶Ïcurv\0\0\0\0\0\0\0\Z\0\0\0ËÉc’kö?Q4!ñ)2;’FQw]íkpz‰±š|¬i¿}ÓÃé0ÿÿÿÛ\0C\0		\n\n	\r\r\"##!  %*5-%\'2(  .?/279<<<$-BFA:F5;<9ÿÛ\0C\n\n\n9& &99999999999999999999999999999999999999999999999999ÿÂ\0¸Ð\0\"\0ÿÄ\0\Z\0\0\0\0\0\0\0\0\0\0\0\0\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0\0ÿÚ\0\0\0\0\0ðÞÏ¿Ÿ+ C\0\0\0I‘<ýY“jÀ©*h!´Ô©f—]zpR÷×\rGkä³sn¯lcQdÐ®Fa©“4I€ŠˆË 9c¯$æžŒÓ¤ÌsB¦!ë6nð+ ÆËMÄ­™¢%’Q4Uæ<nÚ4Q‘hÌÑFe‰¥J™šÔ1z†F¡ŠÝñÕ)Êº3²AKPL*\\]à5ÊÎ—ÌÎ“™/QÌÓ¥ò‡ZækÐ°gA…¼*µ3fÕÄP£I¬óÝGvçg-\\²%Z%¢Ë%Ž¥­ÖJMÎqzVm0\rÈZ„zÈ%B)Ùnj“”nY™VfF‹ Ñf&RTI IX$\r d‘JfË™QDƒ$(–S†^¸QÐð¥ÝãK«†ixUòioRÏX• b·UÏ=HâÏ¾cÏ]ðœk¦+hTˆb\0\n\ZQHb\Z	j½5.¦A©“,€¥ ÉCFa\r \0Ü2‰c©`˜LÚ¨VÌ™š#2Ù‘£1z³°bºœég)ÒŒjÂ[vªC!„ÀzsÑ×¯–ô¾{5!Å	¥„Û0Ž¤qgßœ+²ci2.RU² rWX@\0h\0P\\KA Ä©¤1Sdº©’S3Z†SÐïvsW@¸=„Åê½\Zäôt¬ °ÈÕ–$´g:é“=&MÞnÏ7\Z™º¹L\r§LÎu\'¥W*è˜ç7+ìŒg LÊ`ÐÊÆ©™ÎÈÉè’J	V­ƒ; (k-²[b`\0\0\0\Z)¸e@\0	‘*¤H7,·EZM³*´\0ÙjŠ `ˆ\0cD©Ô-9ÙNâù“‰&‹143e9-«É\re¦˜È4Ý„‰, °–À\0\Z\0\0\0\0bb\0\0¶X\0¦ÊÍjI“Ð!±@`ÑWYQ¨ªTPfí@DÐŒ\0aMË¦!K<ÑdZ$ štMV‹61:k4Á0d”,± \"\Z\0\00‰€¤QQRR`˜4Y³RÌÖ³.kQ2[£\'¤Óy£u•m*”ó\rŒ\\º<è§ŒD‰Äj.KTfhhšf4KšÐLÍ‰`¤HÄ\0\0\0\0BÞlÑCVªŒž‰!lF&ŒÄØ¬KDŒ‚œ3GKdÐ˜:Iº¬^’ˆÚjÚr±1\r€1 P°YPZ ´BÑP’Æ¥M†”HQ!Br€\0\0\0\0)²ØV™‘¡˜\0˜Øâ‰Ø‰°–Å‘”†B4à`Ä4 Á‰¢h¦Ke)¢Nš´IBfC1@Ä4\0\0\nšmahˆT\r\nÚE¼Ú[Š•‚F‰¤)\rÄXKeq-ˆ\0\0¢A€	)§RP\"‚\r3R²5Q› ’•¢JZ+\0	PÒ	ÒÀÐP\'\0T*\Z\00’Ù™ AbI@.Š’™B ·fWL–À\0Ð€\06`”[È­–LÔ‚¬·d	¡d± Ð†€@\0²fómÃ(–	³5 fhˆ-	0–	ÀÐ0¢VŒÍèYÙŒÍÚ$PhaK±Ì/”N£›SQlbi™+UfkB\\¢\n@\"\Z\0\0JŠ’*Â›”hó,ÔÌ4RHQ Ä/1™5¢’)Àhf†ÆEš¼„ÔÎ¢ˆ&Ù.™Á0 (\\ýpç¾žIî8÷½f¸#ÓÉ2Ë¯Í²ý?èeñº±Ñp½´³‹gªqú^/©5Äfúr²(RÙ#€\0	©¡ L@4¬\Z<¨ÑäÎ0R°Õ(6M2›’ë;VÑ%êœ†A¢€²¢Ä52\rj]{|Åw_œ/~|­;(½<Ô“OŠlž¾pêÛÏ%éÛ€S§™Ø\\ §e9 ‹ «3%Ã¤À\0 nÉE’\r\0V\"9EÍÛ2z‘™¨dõ+\' fh’2)’©²“VRH(š¡T0HÂâfnË\"›„\0›)0\0\0†Rˆ¢XCPÉlŒÖ!­™­2…šNiÒ&ÄØçƒœ^‡…&¦l´ÝB²!Z%PKN¦œŠV \0\0V°\0\0‚„\rÀY(zÎ˜¾ÝgO9{x§k†¸±7,hE*³i ˜Ü±¸uND¢XÀ¦BÑXAh’“\0@Ü…<Ã4ÌêKBÒ]TX‘C˜®S\0Õg ŠfK`ÅlŒVÈÈÔ\\TfS¨)	Q\0×;ÏL½‹ŸÐîËƒÙ¼Ëíæepú;§/ù4S]<lDº¢BÞlÐÌ5x‘»çuÐ`Óg€tæ²ÉÖŠQj\\4À›*\"¥dh\rŠJ!©-ÆÉYŠÜ07¡+Bl„\0\0\0­™#bl’À~ƒå×ã¾ƒ~löò>‹åûsô:•Í|þß\'Œ9ú}~?¿ÓÏ%8ÈÈC	T‰\Z@²C ÕäÍa£Íš¯\"µx³W‹LÃJÄ6YÆ!±ˆu,K5œ‰t2F¦n±£S\'ZËy•±ˆh¡”CŠ ­ÃWlð$Ýó•Òùƒ¤çƒ{™yœœ{tcçqêD`rïIA×ô?/õydk;ç™¢\\Ö„f´U™dfXd¶f`ÄÔ1z†F¤@Ä0I¡’”Z)LšLIÎ—s63²„+r%¼ÃEhf\Z¬ˆÙfò\rLUtªºÎB:×-l³¢Ü2Þlæ½±Î¸Ý,ïÏ~†ó^AëÒø÷ë*ó>›£|tHß6†)±ft˜ƒFbhˆV,€	¥ŠP%)!¡™-@RÍ¥‹P\r`%ò\rŒCcjfËp-FÏÝT©,’©\"˜ˆbAlŠm[H§¡›-æÍt[Îªœ²„àh‚‰c$€UD\"¥(	\Z$h&JH\0\0\01\04@¤¹Bh\0ˆ(·›5yÓT\'\nhbmÒtâ*6Õ\r‰ŒT˜6ÄQH`À´JK ,¡\0Ð	‚%Z¡ah¤ÍjŒ–¨ÅnŽuÐŒ\rŠÄÕIÅ…³2zfˆãL’U«%R ’‚K4Ý‰4\nÄ‹pÊ©vÝK•€Q@›ÓKŠb„1(d¢ÞhÔÈ52\rÃG“4 (AD¼ÃS\'Z²‰\"\Z@ÄŠ$) `	PIHL#G›†&Å`lŒZdj­™ƒØ1{ìç:Ît#\nÐ¡¢Z&¢œo0ÕfËR\r	“S›¾`é9•½G+Ž…ˆš¬ØÐ	 \Z\n¬Ãgƒ7x5ØÊ‹\0\0†\0Á\r\0˜’‹3“G£—\'£34D–´,ÈÔ2z™a•™ djˆ,ŒËU%„4\0RY¦‹4Z¢J PÁˆ\0@Ü2‰c¦€	°Nê£Í­Ë!”@[È5Y2ÌƒI‰K™E$€LJÊ§dÆHQ!I¬•H4„i\0…B&%a %R\"¥)(„[€·›5yZÙ5(\00L DºnHb)‰\r §\n5y¦a¤À9`†€\0L;*^Œº¸–”\"È“U›Ôzgšs‡Cæ£uˆlaU©–IóeŠJHAIÍ41j\Zb©µfkTÎNÐ©4MR\0*Ó¡R\0L(NF\0R\ZHD\0L\0\0¦ÿÄ\0*\0\0\0\0\0\0\0 0@!P\"#42`$1ÿÚ\0\0\0ÄÄÄ\\SÌÌŒÈ¬ÈÈÈÈcMˆBãcÚ„!U£<“è³#!Œ{Æ1Fdd1ŒcØ‰\\/VeÂö1ˆBäB1111111ãcÇ£Æ1Œ{ö½È˜\'…ìcÆ=¬cáB„.9r1ŒcÌ†1ŒcÆ>M&\"Ø·®7ðÞŒcÆ1ŒcÈ¨c¬È‰Ø´BÕA‰ŽÅ½uXÆ1ŒcÀ{™Qµ˜ˆFÐb.‹Æ1Œ{¦{B„!\\¬ŠŒ†>bbM&&\"à}ßZ!]µj„b!j´\\¬}!B„#B„!B„-¨[#c×¹F&\"„bcñ„!uPŒucçB…Ì…ªØ¾SÄ.ªˆ¸\"w¡D/ªúLŒŒ†1ì9s!]Øû}ø|ô!Bæ=¬Èc\"„#„ºcàB¬z/¸„!B\nµcåBÑBIBè¾$!tP…¢¹ü²ÿ\0•[qŒcù+D!ç¿š…ÑB…ÿ\0l„-P…ÿ\0´Z¡BØ…ñŸ+ø„!tñ&˜\nLkÅHD#ÿ\0‘M»ÕÑvÙïP»¬g£Ö¾Ç#ÚôcÇÂ¹Y‘5ÄÓŠ¼»ÕÚˆš¦ªj¦«_Ó¢Ýw+‚m]¦\"¨’ìÿ\0ùÕSäÅê‹?Ôeq]¸š‘øï(‹—bÿ\0‹\\Tû¬cÆ?‡ãDWåU\\×rkˆ*ªlxÑUW<?ßæñü•kÅñ)«\n?òÖÊçöy¾]Û7îù7oSgú^=_‡ÇðîW]ïbÝŸºçÍ‰“Ì®¹#ÐÇÖ[WyŒcö²+ªŠª«Ã¹Uë–ê·Mv®Ù¹]ª-Eê#ÃñïSn|{ÔÚˆµâRW„×T~ß>¨¯Ë-Ü¦ŸÅËqE5Xñ\Z»tZ±>?zâŠïÝ¦º_MnB„.£æ}åÂô|Œcö¡Bá\\Lcè­Å¹á¡B¾{Ç½B„!E¢*Mõ¯U=&1÷™—ÃŠ*\"Ùiøô”Ï$Ç‰YrÜÛ«â1ŒcÏfCÕbFšY7i¤±.Qê¢}Ús7i¹zÍÜ)ª\"nÅ8èö½ŒcÇ±…ï[}ê¸´ö9àõ¢ä-Qv¢Å1ù<¿\"íË–ÿ\0}ŠÅúÚª™«Ã›v-ÚW+ª?CãØäõ½êÆ1Œz=Æ1™@ BƒÐÆ1Œõ¢“ÙïF=VžÏ{½G¡Bêí7nY^GƒsÎW¬Q\\Á]ªü×3vjñîy6àüÕÝ+¼ë·ÇÐcÆ1ŒcÆ1ŠD!ÄÄZzÚôôz=¶{=žÏg³ÙïX‰=žõ¦Ì×nôù_1‡øúS²b&‚íÌå™JµNw»¬cÆ1ŒcÆ1ŒcÆ1Œ{XÆ1ícÇ»Á¼èœ<{´ÜÎ¯6æ>>r«®k–&\"÷2…ÎÆ1Œz±F1ŒcúŒz=Y3ê+véÊüS9DÕ–ê?ÛT-ˆ[„!]l†1ñ±Œz±ŒcÆ1ŒcÆ1•ÅTæÖ\\ò2¯È‡n\"$ÅÁ„¼$À·Gòï]‡µíÈÈcÜÆ1ccÆ1ñUj‰?Oî»7$£Æ?\'éé?¿Â~ŸÕ6¢.uæ=Ï•™côz3!ô#F1Œ{XÆ1êùØö±öÆ=úk…B×ßAžô\\Oë!Z{è®5Ê„!}V1ôµZ!Búìc#=Œcu£>ë‘‘Æ1õXûÄÄÄÄ\\ìcÆ1ŒÈÈÈÈcâc2ûhB„!B„-Ô!{â}vd1õÅ¢„!B„-…¢é1ŒŒcâ]5ôØÆ1ð1ŒAŒcÆ>‹ÞÇ«ø,cÆ1ŒcÇóXø²2)‰®Æ3##!•eDäddddddd1ŒcIBËÿÄ\0\'\0\0\0\0\0\0\0\0\0\0!1@P` #A02€ÿÚ\0?ù•/…„!Bå·Ú—ü?	î“#ðë…OíÔK“o&X£‚êmBÅ~Ä”\'ƒNÆáä^á¸Ü_ŠAidÿ\0Bôìzž#Õš[u8Åþ7¨¨µ8=Báeü0„\'y\r,öæ¡ê2Åòe¨º!æjçxðp„\'¾/‘æß¾|v·³¢j4oFôj;ÜRürxˆOº„ù=ñ«µÿÄ\0#\0\0\0\0\0\0\0\0\0\0!1P@ 0A`p€ÿÚ\0?þê‚>‡$êÜºw»ƒŽö,c“2ä|eŸÀÛŸ\n|&¤©R¢Dn5%J‘õYE‹u-™8ä`ý™Ö|É\"QŽ¸t“éË‚5Ã¨h†T©S§Gà_ÿÄ\0<\0\0	\0\0\0\0\0\0!1\"AQ 2B`aq#03PRpr‘¡±4@CS€’°ÑÿÚ\0\0\0?ÿ\0‡^³Y™ž/õ=,áwS¼{7™P©úK½ž±˜ª‹±òp$Úœ}È%Jn1âKL*›˜]YÍ³î˜)ŒMúAëÂ\\Ñ©oixÐ\'Zê0e2Â½\\ø6Ï² \Z“ õ)²Žfg/ÔT·´n¥KØp”úª>5¹ù<ï*9Ô´×9EÙêŒnÃY\\;4ìÊLÚ—‘Ÿ(ƒg?ýç3+U¤˜ª.âSm¡Þ¯ôÐÞþð“•Íò†ui€nƒr&\n…pß€›aö•¶ß¾ôUG5¢›â•vƒ¼Ô÷Rñ1Ôf$çÃÆùƒi³ï¶tï‘ò:ºw”Þ/V“òZuTiá§{–nñ‰JµN®¥<•í‘Ð¢Æ¦#z•%j?Ìw‘’¯ÈTïzzÊ´Ø¿Tþ5×Þ~÷uú*™Âi®à:©a\Ztm‰ßr0‰R…{ŠnnxL-N¯_\\‹.Y,©F©\"OàbÔm£¬#LúÊ‚›bKœ&lá\rðSÞôþØtò¿zo>Ñ™ÔüÑ¼6p¦Xþ>Q¿	¥æ<!éºKúè&uûNë4°AHòi‰ë§®rÔéŠœË	N­<©¿‡‘ùï?á}gÊa\Zˆ•mÄä(ã_€—kžáR¿\'š˜QŽ\",ÀûÂBÜªâ¹‰Pcñ7¸€ÞkóŽŸ¯cI¤ÒiÓ¯oÜÆZ\"ìb³)_ÐÊ[Jû`u€)\r½y…rÞ¹1É!KŸÈ@·Ä8Æ¶X²öaî\"ØEöùÿ\0Y¯GÎ“I§imÌÄ9$ß¶±WÂÅ‡Œ‡€˜T\\Ëc\\_”8§ ÈŒ< [ûùAÕ”‹OÚ1œøZ-whWžP‹Ìû+}<ŸxùÆÖñý^ Ê/mAœ ÅÃNØ÷ò†%\'/ÊoqôNËªçëæ¶é·FyE^7òŽŸ„Éòšå7Ý5šÅÌe™B1k1ñúýÓ±¤Òi4úÁ×üO±sñ–e*}|ŸÿÄ\0(\0\0\0\0\0\0\0 !01QaAq@‘¡±ÁðÑáÿÚ\0\0\0?!M‚L!7}°ø>11ÉJ\\&\\&Bq`\"³\'5)ÁÁL]\"!DD5e—ƒaãœ\\ð‰£ŒMˆÂauÔÆ•‰£úÌÝ<PAfR—Q’0º	Ð!rë°ÇµÃ†r\"‚kXC‘¡i„&óñ„A$Œ4N…Áh`FjT\\”¸O†44<ƒ(Ñ”8dðV‹¾§eÑM\ZY›	¤Ä ÒÂÄÒmp½?ÜûŸcî}Ï¿N¼µˆ5ÀÜnŽQNÄÊx˜rQ6VR”¥.„!Ît‹4¥(Øö¥.S²ÊÉE\'ò{V\nRÐ°S&eˆ4<å#”}‘aØZMS„)J][)KÒ\0]¯ðÒºr,HAYx\rÆè¥)FË«Åzè.(ðÂ¼¢—gÉBšÂ¶}–V	bB[¬\'¢hÆ®^	˜A¢½T¹¸¸¥.Á½î˜„!31B„Âgúá‘™ª™D..ã.yS&°Œç{š0Ø{B+¤5e¼>¿†b„ÈÖ¥KˆrQt˜</b_Hn\rïw„&ð„Ø„&\'àlFŠÄâ4§ÊÌ\"\Zk„\'GÅÊa	RMá?â—¥x!qÍ×Jbµ£xeÁs‰ ˜AðŸ’Ñ	ÐZBAsÕ„Â\r1¼k\nQ1ÓÌ!B„!OÍ˜B„ÕINYÑä¹„Òër„váugçÂ„Öˆ.ª”¨ºRâl²,c&ð„&)~2„\'oB…Fá¡Õ…fB­©K†²òW‚„$ÒŸ•0„éÒ—‚éL®0˜ŒB<”¢ÅÌ!Bd-aBm6„Òb—3¢		­ÉwhašG%ÉVxÌÅÅ.I°!BH-¦ˆFs‰Ó¸\'”L1<‘„g\"èÂ(A7D\"\ZÂ„!	¬&\'Z\rfàààãZ]·‹<cŒsÕ«ã„Âtf!	­)JR—«:“+XBi<÷Ú—XDBlRþ&´¸VKÓ„!Bh¶¥)zi¨FFLÃ‚HIˆOÃd&ô¸^¼!	µÖ„\'B$!	˜B„Ï[2n±J^„!Má6„éA-oB”¥)v¥)Kø¬›Ât&‚A=iÏàR²±2”¥.ô¥Ì\'Q¢2š¼½¦BúCé’{\'²{>ØDppODDD!:ð„&RÞáVŽy8òqä„! ¨O¦	´!3	…–½†ïæ%lF½\"ùnìmä~á9á±*v§°¿–Of\'€Úsp—,KýÄ¿ÈYô²ðs‹¤dÿ\0Î!2OÙ?\"”¹wDz\'ÑÀôŠRáv.¼DEãDˆM9ð6_µ¦>à£žåüƒÍ%O~ŽÕ…kìWpò‰ßèH¾üÿ\0©Ù®ð“ÛNæÚ$U·áy!y~aÿ\0B4û4#ôPâ®¿üdJ]þDJ\n$•üèO€…l^sñ?ø#öO±®ÿ\0Ù™§%I{\rÎ9C%ÀUÝ4ìiü=!	™èŒ„\'B—¥+)E-\n—ZR—4¥Ú\npTvÞMüW|µúK„†§/#ûºþ‰ý4½Þ½S¶¯+à“\"»l¸ßoÙÅ_	Ÿv2^Éÿ\0=PLéìUö.±‹ìàû/¿I?¢\ZMÕÏþyþˆ[5çÈ¥§óþg$.n±›MÝŠ*êªøäà‹¶KˆBu¡	„!	„!0–iv‚B&RÞ—p)J\\fG	{?Cs­GÏ×fX“•ƒ¿æ\nð	“&|!ˆ´!Ãáÿ\0ŒPW‰;Ði#çegø#ô§(Ûe]³˜þ÷K­WÉðCºàaßô?C|£ØÈŽ+îccÛŠü„W8#³O’šöqÇõ‡|R”¥.ð„&„!7˜™„ÄÊÑ¥.íáYJ]¡	˜°”Q$¾‰™¬&&zQH*)JR”¥)vÅ)K¨ABÁÑó†ô¥$±Ê#Â„„&HB™§ä&9Íè¹¥ëÒ—JUŠRŸcíš—j/of$!	¤dd!2DDDBXG­¸¥/Ekp¥Â”^Wð}”¥e.JQ2”¸º¤!:0„&g²\"û)N}	z\'†ÑKæ“àNæ„ÑÓ°ÿ\0éÀÃíü•î—Âîvÿ\0Žò“WÄÞä˜öø8°×Â>iKºÒiÉKë<¥#bL¯±_#¾GÇƒèP˜¾E	~„Ó&F4L°x©ÁnSÃì=ÅúQêžý€ýªßÁŠGŸeØ‹Žûà[íþ;œxŠÒ¿¯„\"§µuÁ;àýa}”¬¸R—PX)K’¢¢­n§#ÄÂ‘œ¯ìýíÿ\0XHHC“ôppOyÚ~Kä$ÅŠù\",„\'¢d˜B„Çˆ«yì—–si¾?Ñ…\Zûù…8ì}ûüöø.îªí¼ò˜“@.0|ò2Šï¿¡)©Gv;HÇIq §™#ÑæB*4g>êÃ¥Å8.»#ìRŠÊÂ‹Åì¥BÏ\Z¬T`~ãEÛ/Æü¯cÐpó…~„y?†ODy#cô+ðŠÇ&û•yØûâžGÛ/Sô~Ð«||!^•ÍïÌ\nÑ’Ó·h¿ØÑ6tv8!Ûá/¥$É^ÿ\0Ñ ÐÍ-¿ùì!Gå{}’C„ÄÍ)JR”¥Ôl½±KŠR—cI÷\r<±?¦W„W„Yö+Ê>Èž`ãÂ?‚•UàúÄ†y?ä‹É#ì°ý1ú—Äö–›ñ~Eöù,_Gh¼Møù)ìÂâúZVdþOÙÇ«OØ©°ßl–Ôàþþx>!_’$Q~’\\suðvÜ˜mÔ1ëJQkJRáEôæÊ>øÞ6VQY)QK¶)DË³¯²¢ãû8J<øû*\"’9e_¿D¿b¾DÐåÂR“ï>JÏéðWšH5œ$!B„!Bj„!	Ð»J<‹¡²‹ÃÜ¥/V”¥ÉD)^1orCwà†zÍIóôÎç»Ò\ZCp›»¿Bb<„É	ÑBbH4BiJ]’—[äú)VO±ö)^£÷>çÜûŸ}ý¢±‘¶>øôøÅ!ñ•c†Î1þÁÊ·Àœ­ýŸËíì^_bbù£møK¬&ˆBt®8Ö—\n]ayþE1J]BŠQ~p§ì¬¬Õ‚àR”MiNEËóÀl¯ö;œBWðM’?C‰®Æ§c›„úÊ²‚ÂÓ{á99Ü®\"ŠìEèO·X(pp!ìÚCK’”£|”b—£Jü•ä¢ÊÐQ1DÇÐ’¬r_CwäçÉ_‚œ„99/¡ŠV¡JTTA$d¥ö}ŠR—ÑJR”ºÀÅ)K’æõ!5¹?–7%Þ—<ù9/¬OdöL&óGãÙ‚x\"?–pqã©FÃ1üå	†¶?Ãà˜àýâ”¸«^Nr„ý\n¼x8ðÎ<Ž0A=\"½äû3èÏÒÃŸ/^:3ÎOÙ	ˆFBa4B™„êµ{ò&]ÿ\0}b¬ppDDOD!=]8säçÉX_‚õ!	ƒB	±¡7˜›Â„!ÈÉŠ\\\"˜™þàŸXþ6¥.Ž‹ìýáÁÆÏ’¿\'>JÊ(¬ ‚ç‚”¸ãhBšÍ&HB„!1Æ.—qtX™™à¥)JRœ£õ¥ÙGœ—ZR—¥)JR”¹)sÆaBbmB2ÊÂŠ,EŠR—4º\nÐA>2ýÈòOœ..)sX›20U§?…qI°~‡ÐúB<d¬ÓB\"kÓÑ	Š\\++Ù‡êWçZR”¥éÜPF´!O]\n<Buñ4Bb„Ö¢”¯À×¬·¥Ô.[(ÙJ\\&!4„!Mf„!ˆB-˜ðïéKµ.)z”ºÂæféØ½zpppCŽ¬ÙëK³Óæ½:R”¸])rRáqzw¥EEE*)W’”¥EEEEêœ#ÀÞ­\r\r^HÄ˜“ðL^¤\'F•—%é©U¯FDí¤å¾É|‹é`‘Ÿsî}ú’‚”¹lzÌ²\r\rä‚x]I¥üÿÚ\0\0\0\0\0bPÇµôqOBlÿ\0³tëªß)n¾èôË»\"SMÕ´²ÓàÙ(›½šZï¸ÝVH\"/ëÜlÇIæˆföÑŠ*™HÍeAÁ\0‡œ‚»Š˜‘c5È5èïì(›^¸ÐOqqë~L—ëo4N:ú“lH%E\'ˆãëª®X§®#Õu=³)Þ¶ûß]@•Í(øhõuÝ’UV˜‡¼©®j)‹N½Ãö]8ïFj$7lÊÅ5ç}MQß(¥ÎÊ\nÆ\0œìºÛ±‰ÁF#ú7ç]\0¯.“Œc\Z%éFÏ=óâ°p(	Æã Z­ŽÎð÷¡[×ÿ\0úý¶	·w%¹ëžL©„)3<—·|Mp—JŠ´Ÿ­÷ƒ9Ïº€” Ðò0Õ:ät‘q8ˆ£T•`èëÑqz°ƒM	à’Aå®¸çµÂ\0÷°§Ž/\rzÄS½6á.Ü°‚8àã\rR!œ$¡Ô\\’ãH2çœ½á\\m›¯–»#Îý£(>|Ã\00À_œC6”ÇÞ°óLå|A\0õ^}^ðZ°ëú!Ž¢©Ži\\ß(G“b¥Å»‚ôöç4Ó±×ûùÄ®ye-ï³j»`5Î’aj¶Ó„@ú…E$VÏ~0A—@],1õ!ïÇEÚÈ×I>˜¶@x¶^|à‘4óÁìˆÄÜAÇÀÕ2a¤![n0 QñI|òTŠ·³à”¢¼ö,¿m³Õå*\n\'6JRãŠì•ƒÎ@ÇÄ/åŸBI¢EeN=Å’aåé¬4!‰ƒ\\0D‹9Y\'&ÓaJ€vOþ;¨.ÂÌÊ4\Zr‡€sÿ\0!î«óèEhk¯5Ãƒ,Šá&ðîHd±*Û5\rg¯@;EF˜¼¾¹Ô§€¾¬âª¬¢¢ÁÜIƒæTÄM\\zÜr¦4\0ÖØ!¾áßVp\Z¼p%N	w	8¦ÓU\0Ì(þtúaÁG]Éö©¼bÂÉõ<òlþó¤é\"JM¶E7sæÛKs;A•¶¾7MÔÃImôP<°È…FAéŸÇFÐ\0MVÿ\0Böuf DR1çþøË4óf™j{D‡Ýab>,öÏ·“åµ¦€„2ØºÄ:ÞA·ÜyËì<A I\\Øª¶ÜcüúõRí”Z¥ƒ#4vË¯¾]Öpÿ\0	¦8 ‹p‡8õ§ÓG\"h“™rHiž<q/8ËEB!¶Ød.0FA`JžD!šYÌ.	òõfÖ8y»}ñGÇaWotÌñãD)ÿÄ\0#\0\0\0\0\0\0\0\0\0 !01AQ@aqÁÑÿÚ\0?èè¥ÖNt¥ËÎë\Z\'—•ØBqˆˆ„Ë¨¥)JRåÚ\\ƒGÎ3/‹CÚRð¥)JËƒ(Z°O‹Dd&±2ð¥ô„\'ºÕÂ&RøÒùB\'ðˆ„ ÖÜ„ÈL„ÈBr¢/ŒØMyJñV‰”Ofuâ¼¡8-C\'L„!¸Í~3&Ü\\!6Ÿu„\')ÅìD\'\nRˆž_¯æ11±2—W%èøR”¥)G”¥/½pL¸Ñ\n\\„×ïJR”¥E)VR±Šá”¥ÊR”¥ñ‚Y2•qB&\\¼(ÙK—c}?„ ÇÄ?Ô%”¾p›N0i‡Â—Ÿùa^ß(Z¥ña|7gèbù?¬I%ôÄY·[|º:ÈˆRðzÑ¶Hƒz~TNŠu}‘GÓóþü»;;;;;;6R”¥ó¥)yöR²—nÝ¥×„þ ™ü>Pgè¢©1²q„&Ìb\"!8vvFFRå:)ÖÒ”¥+)JQQÆ¡Z–_¶ÅKvÛþ˜ŸõßöQ“ÿ\0Ê/ö>ŒÉ¥Bm)K°“)KÆp…Ï¤5á%Ÿ×ý>$!|!BxÒ—„!B	hèˆˆ„!BpA´’_“íyµ‹H¥ç	èL»JR”l¥)J]]ˆNˆ¾…~†õÛêì¬¥;þ.•^t¥Åè„!NÍòLL¥ã<.4BmØLœa6\r„ÄJ\'ëFÊ^4¥.ÞsHBœBe/*R—Úò™	Î—Ùp¥)JRì!Bƒàø4ÊÊÊP›~w)yþ6Ÿ‚”¥)J_=-|¯ÿÄ\0\0\0\0\0\0\0\0\0\0 !01@AaQÿÚ\0?!	†,,½î„&èxºwÊK¼!4¥)s32Éù×«)uƒeÌ&!êÉšR”¥)J_9á<.×xB„.×Z\\OùàH„#!	¼!	í1Ó¤&³TRâ”¥a5d!BbyR—y‹£!4_‹¾4¹š,ÏYø8BöBiJ\\O(B„ÉM´ÖÊ”¥üP„ ‘B	Ñ}(˜£•§Ó‡OR‰ìñM!2´oò\r|ÿ\0cœ?©‰åú7?Ê£_Ýß„bôd!	á3Jò¥X¥)J%©óô‰Œiý°\Z?èïã?ŸðîiXž¼8\\ðàæ`—àšÁ8p„!B™éÒ=n­f›ÒŒš“z.íKëQíK‰žÏNŒø†\'YÆ–tÎ“fRáK…Å)BmÂ\"yÁðÇe/â+]bmˆíó¸¥)JR”¥)JQ=.ip¥)ÖÎ!\nzžn!BžP›²‹0™˜ªàáßÑ¸œ‘—„ü¯)þ)JS¹~syªÒæ{Â˜»R”º]ŒÒ—4º_tÑQQQQNì×½/´ ‘L ²ø]V—Æå3Áb”¥)JQ1â”£n³÷¼!êü–‹/oÿÄ\0(\0\0\0\0\0\0\0\0!1AQaq ‘¡ð0±ÑáñÁÿÚ\0\0\0?åyàH¸BÐŸ\n7ø.BGNBx”6Ê0\'Ñ|62à½6‡˜låSÈy´Ä%!¬žmô¤lËr	ëM	Å¥=\"<K^-ÀñâB¡Ã¨k¡è`i6+O‘Vù*}Š®h™ŽVãFF=\rFXj2£rq “[\nrÊ¡:-ˆº1Ö•í¥e/Á¡†¬£27à³‡Ô\"d	.>MB—ÐÁíòXAy!¸Ž<è2äaæ\Z1¡+ƒÐ]“¸ q±ê%¸$ì¦±\"ŸQ™˜-U\rQ©ÁZX)‹cèzÀ‡¸Ðš!2Ý\r!À!hœ!•Kèôcq–[¢5¤ÕäÈh÷ÒOBê<ëC jÉº#F6äº·¢†!æ^bGÉ¿B{È‰\'hú“Úp—³è&\"FTDJKä¤Ý+[-ª	:\rî›éF,	ûFÜ´Ë¸{OdF$_btÇå©<t4¦Ç@Šà—q èÏ˜PÜM£ßD!4AÐã‘Ð©‚Ì\nòVÑØšäMöRB»òÊìY	Áâ{‰Ø›±:r%|Á_‘WÑv±ª0i>20çX¦Ù;!=Ì“Î‡FËÎ‰Íœ\Z\'FŒ®ã‚´/ã8ÐÔ2ÈÖ™èk6ˆË¦ÃIº>ŽLha®”h2ó<šö¤æÐß‘·Ù]é±yãòc/¥vy†ÎGÜÊí•Û<Ì]Ì]âa¡/‘‘P‚q0yòÄðÅ2t;ÜGW>/‚•£¬ÇØ&5ÀmØ|‘drž4jÊBÁ†DANÇç§3f„ÆÍ†×b¹kÕ€ð,f{C^ÇÔo‡CoH`4<ûŒ•E«Ñ¦4Æñ£øÁ!!*ñ©NBv&R\'ÉPz;Š­ôhÕÜŽ†â›6+À§ÁÒ…¸Ò!ÁgzÑTbãJièÆÆÆ\nÏ0Ø™r^“~ÆÝèlÆÆ½”D>Â¾ôh÷#²;¥›˜cX›‰Åv7HxÊÒ2>Œôe½ŠjCÔ_‚¼Ùcqõ\"\\15>$¼ˆ$èD¸<Ö›™CW0óäNäHù)5„\"å6Ï\0OG8ÞÝpbBC£˜‘áá•2icfVRŠ{rHË9ÜBMîÆï‚ŒÝ“I¥Ü[	×³´K¢x\Z¤-é$žÂñ=EàzðGcµ)íF÷b¨n¸<CnÆA&Ä´DaF4(ócb†­Êó¡:¨çu’E(Òj	gXK¸Bz3r†èn6L”¦eyà“•Ñj¦3…%…¤ÉÑ\r(#h”|ˆŸè¥ºeôÏ]160\'9Kt/&•^Ié‹Äž…à@†|ðOHk×ð5|Ñet]ÛY‡­²*‰®ö$bA„\n ÒcdTÏfV6Ñ¾ÿ\0èjÆ:yÐ~ž!KƒÕ‘Ð‡Àã_äZ7¢XÐ\\¬M%ªN`I§¡å—%0Ä£7SçD ‘4‚ÜÐµ0J#ú„‡4BpQ¿\Z¸?†Ÿ2»\\$v-¾J{16R…ÜÈ†%~µ†0Œ¶èoÊ$‰¢HÜZQ´&˜Óài†\\\"WBSCIè|é —AD Éi	©„—ø***Ò•]!Ez¥	´“‚Q4ÆÏ#WÄ0àµÀªb»“\"LÃq!!)ñ„ÂFöc\rÑ\rˆì@Úð\'By¾J9q’ˆjþZH5Ñì„%2)KáÅoÍ«¤þbtYC(&Dû\Z0-öQ\nåÙ„Dø¦($LhÒ¤øÑb1ýŽ’›Ë2›DO)Ê‰ðiþ=ùöYb	Ah–‹ã>ü”—Ka¾º‘-„–˜r4¾N”é‚14kèI¡5ÑG„)‘6]‰A˜ß£=ÅZ%HˆBhˆA/\Z Ë‚—[¥ÿ\0ÒkôDUëàóÁ<ÀŽˆëRcà †\'ðû!¹	§\"sDèA¹’´\'0ÜŒ²12–ÏÉH*Ñaah&hM‰‰‰¢&{|G¦¯C!ÎiB{+ÉCFËa=F9Ð¡üžâ\"`Ôè8àoÖ›	“¹ÉmÄ¯‘äÀ;0Yè/J¹Ò¦åÒéZTOzQ}2úbfÁtCµÑ/¡„…ZžÉ¢~D¾kç‰¤Ñ\"($…et__õ«H“àÛ±0Ÿ±2äa,HT}Kê_ßeœöKrƒL s¢ˆü™í‰ö-P_z(GC^¢	{$+Bf“À°,¢º+¢>‡¤\"Cè‹¡$ÈEÖ¦\nÏaD·Ð—±;É04cAœ¾A§Bˆˆ~\nRa ‘èœ‹¿<	\Z0TqˆØ…™Wbk²v‚KBÆŠ-TtOBzf<2W©êa£¢‡^ˆE¤\'‚: ‚fãÜð\rt#ó¡9\"\"Ò/ë!\nÐ¥–¡¤–N’EÐ‰¦Å8„×èñË<BH3wâ÷Ñ£àlãâ‘\nãFE¦Dh%ì@×¢zøO®†‡èãb^„¨‚ãà‹ò›ü–„\ZO‚: 4A;2\"ìQ=Ä¢x-äFÄ‹:ÂkFUµÉHs\rÊÊQ1=/ãÜº}	g+P‡\"mò7eìc½Ð‘J\'ð«¢\".·‚#G:R#ãÙMõ¿tc¢\"††‡tBEBÏK¡!¼é»Eà!	•VˆßáÃ\"b#ˆ‹´T¹ð?ËÕÔÐöÓ]‰4ÊÊ,„Z„ÿ\0šM\"!CÌ¢\r´Wtª_baî*ÑE¢Œ„P„i“\'®„++‰-i~%½*o(%P‘*NŒŒJðz‘ê(K´DA5Ã&“Æä#(­)J}ŸzdÉ“&KØžE«TA«ìÃã¡PHù*	YMV…\r»a¢iÆ”’§®”÷?\ZPit$4$A!#èKãRË+£ìBxÑZžˆž‰àž¹\rˆ‘¡ì{Ž9G·Å¬“ÉÈo:ñEoF«!$ú+¡¦–ºÝM´JF$\'-Èµ´Àš§äMx×\ZÒ´-9#O³m+CmÙ]”[­)PÄ-†ÇFÝ(ôLnD¡¸b‘‘‘ô%xÖžB2xâOLõ×Ì–%è…±=	ý†HÉà\\A—å·Á¹ÿ\0Ehy†‹êcÐ¬þð}uN++’Šè¥Oˆ4fd!•ü]áà)èb\ZQ¨™DbXÖ211]ÎÒQ7cÁ´,W‚¼!<	éúGFB!Ñ<?HÝ<{\rû\Z\ZdddÒü?H<Š(¡XFBäûÓ\"¢lLQÐ‚ð\n>ˆˆ Ë†‹ØŸPë‡é\ZÄL„Åø¶­\Z¶Öæü‘ø=£HhóOq›,l¸!ô_ð,ðd&Áù£è%8Æ¬|Žª$R<+Ëévü­¬‘In&ÍD¯\"6Ä8UôHÃ\"¯d[½Õê—sì–Ôö%î½LÆöÆÓ=:Ec&¦4ü²Ðj´_q»‹ÉZt@¥´i~±ÀÆŒ’°‘ØÔaÇcèÃ‚!ËçÂ—N?ÁB¢•\nˆ¾ãl,\\U‰·´ZÙ}	±FèÛ«ø*ïà}…æ&	àžäHK#³íÉžwG¡nâ„é	MÈúÐ»¤ˆ&”oŠ3v‡²¹Jô0¿K„²ÞÉ/-á§\Z¤ÐÇmÌBH¦b¶sÉLñäQ\\£D;à—±q­ÁJÞ•N{ýÃ•òƒllmÖ>Âä±orh$ìp;*•£	vÑÑ\\Šä&Œ	åâ ¹h†Þç²;Yàt¥ÇådE):\\$Ã—\Z°o¤–XÛ,‘xodÚo/\"\ZÛ¢$«g²Kvü\"*bØh½þïjEQò{áãˆ+st)RÞµ^ùäj8&E\ZiùM=7\ZLgÚá>ŒôPðÎyZ¦ŸšX]6Äñ¡1G˜OÙO!äØŸ¶\'3è÷r_#zYÉ}”+v&Sí¡1“c-p`Ë|¡\"]°+äJODH_\nUØÐoÄþðSÉ¹¦·vþM?¡ˆ7¿ò\Z_Ë&æˆéIx\'kHL°á½¶+Â^Gàœ-÷ìÙ¯L·ªëBi?à¥á‹8I¿¥(ªJ\"y0¥_JrO%uû;¼/X/\"²#o,qáRî’þP€¸À.ÛQe)‚½Ñu[Ušæz)¾¿Ôû «QUÄÜöÍ÷Þ§ÐŠÆÅMl9è-ã8û;—KÉU_uô¤³X(5™›ç³ïWäÝä„¢\'\Z$*dA¾Ç`›è¾\Z·ã,²º)Ëè²º(¢†°3¸O%}”PžDÊ\"‰›Ê‚	Q<›\"ÝÄ’0&Š…æOd<tû–ù”6ìkÙŒDÞÞ\Zm¼)4ù¶L³ÚyWm1”O¿g™„ÉŠºáåÅ‰&›[Taq)\'bùÙm„®[c„tÑÞêîÑd¤¶FÚ‡¬$áá9áŽ‹\ZûÌqg[dP·ú™öÚO>b$$â(Û.=Ðƒ›ÆÉ5IC))ZUÌhòö²ââ7vŠ:-EÛTË‹\"{ow\Z¢[Iï/9®D„š6L2xÕ¤ïk$ò)HÝœG·û+ÂÝ€Ÿ1¶¾…y{.H®žX2á‰ðsq:ÒœL·Î”…*0`‰!£\'O«Õ’©Á.¡ô,rAìMôGÑ]	†‰Bßn.åiÁìl5\nÆÔ1ÙO¦ŠVd„ìÂØY²6H÷öV1ß?£¾Iq‘ÞP™lIìˆð!0ñ\"Ð”Søþ£cTJYÈ”%á‘¥°ÃlÑ»Æ7&\n¡ëz+ì©¹c•$RIõÑ(’I$ÄMwz=ë:\'ÇéîŒtåÑõ\'³Ø~BzÑ}ÑæXÒ¥¾•!\'›Bb8¢žÅSàŽä‘Ñc6Ç°ØßÊRÆ¤ll\'h\"±ä”{O“Á:þ†éƒèzS¡¥ÆþOíEWOG&ËªqŽ³\r=2_%3«ßsnJQ²àL²Êì^GØ‘*|ÔL‘+N‹à´¨}MÃÐµi¿•7˜¢!4òUÙWgÙ\n¼A=è-&}4Bö\Zì[”{–_ø—A@ó(R>D5(×¶{¹=ÚlF·#ðF[Ix±ºàOèX‘è—\'‘~‹µ~‰z\'­)\Z\ZÑª;<ÈÛàÔfÛ\rß%º/³\"”°¥ødw¢/¢û+¿ŽÃ\\·ÐÒ©è564ü˜Ùê-ò´,¡¢±‰‹ÓAaÀ‚nÄïBe¦ŽÒÝsHˆ\Zù0ïðšÂD¼uº\'¤O_È „^»±iOwýõ’¸H^Y<>‡ìžÀ™¾^­ZO1õ®\nOIŒž‹,\"\\°nÒá_•.‹yÑ3?jú\rt­pÑœìˆ_Ã&\'×wûhz—¹Æ:ÚJªN¼2ÓyUM=¨7© ‘-ÆÓ[é†GÝÒtô%I:%ä¡)¾E¢|ýQDv_#jn_øÀô ~0oÚ=Æ½³’\\’GdWù!±4ü\rÔ}‹?ý	Õø;âßF3g¦.+ú0í£VoìJÝ&ÇÛ£diÁ«¡â!Æ\n?#Ør÷E\rŸä¡ÒË3“…°òÙÌŒå<®ZCÉ¿ìÙÀäªæóûƒRgDq?…ÍèN‚Ê$û±DUê#qÒÿ\0àV¥.‹xŸóPãÏ#×†\'þcmnËéŠú‰lÄüäU½ˆ_zhÙ¦„v% H„‹†OE¼h>²\räl–ëF\\‰›ào¡Uca3ð?\"ÇÑ¡“\ný†ü?ep}“{ß¡®?‚|½1:ÎRö%¿¡NUú#î„¸ãìð\rÎHíˆ6’O#Åþ¬xÿ\0û‘ÿ\0ð	Üµí	Ë,4<XÝcÐ‘/d4ëJ·º†otàÜ¯%Ñ‘&¡6“D7ð/äd·­Õè?‰B°ø1íÇBšg×ÑŸ†Ü	ðF­¹Ø¨\\ªòaò°Œÿ\0äß,ò5ÃZmš{¢mâ©%´”á6¬èO¥\n.Þ8MÏÁhßÇJ1C`e˜f.7¹	î­Úc—Ð·\"y/FOÓWEú+à^â¾DØ»5Šíé@ö(·ßø\nú\Z8C&°D²}}\ZÔ6¸<¯Ñ#oövÿ\0²=~ˆ»¿Ó\ZîKš÷Bc˜‡ƒèiÉc¯Ø®vý¢i[ôÄ·#è¼¿”Aî\n[©ECi¥Ÿ	lÈJÙý1.§íðäÿ\0ç8?²ö~˜v~#VéW¢ö/hËM—ôÏd+³\'‘=›\'ñW\"=Ù6ÉgÎ^²;Ã\0·I§*ýB I“ÈžÌvU	NUåô,a¤G˜“}×hÎg³…œ÷‚x.ßl!âLlHRwMþE€v•Kˆ’Wÿ\0$‹(šÙ#û65“0É›žäö$×8!l´Ïev8Ø¢¾+îWbrÄÞNƒ1e¼$+v_²‹ìLÅ+#Y0$×žO\0ÞìGìà(OŸfýÿ\0`n{¯ÓÉØ•Åô%_ð	nMèIÕ¿–BUÄÉaû>†ÿ\0ú¯ðláøju 5sý=‡Šþw±ö_ýÆ~—ÿ\0c.ïÔ7Ìƒv2Ìo!»	<Ó%PýT8øyhn=Ÿáìü0y©6G¹ý©æ\r ¶7Ëè\\MÈriº{lP{¤KeW¦ÏOþô¼ÁÇ2*6º)c–%™Õ[FÚ\\¥Î˜U2 Ñ½Ù}›#ejðÆÀ·–Ê,Á\"K…Ñ†ðm/$oy\ZCTz«FØ›m6tÀ´ÃBd{‰×\'›B—CwÑ~d{-9rŠí0í¸ÜZåžf_e†w<‡“Jù‰[ßù#»!ì9Ô¾Ì¹=ÌùÓDcÜ½™K­9	\"QNQt_(m¥Ï „Ëq:XUå9ô5|l¶þKøO7‡Kþ…ÓŸíþ/öl´;Héøð,:´¢I¢3å·ìnîÊ…\rL3|/{3‹8‡6-ðRíåÂº=§†Ì²Ë)E¡´ÙFÊ_&#B\ZšÙCS”¯nÇ<¡¢Úiq Ü$	·[”ù\nöQitÛU­}•Ù]•Ù}žÇ²+´1r7g˜WÉ—ªsc×.ªÊxW k¢½R¼Ø¶lÆUOwô+«q\"Q%Jû+\Z##-tÿ\0ØEt‡ˆòZÀ~NˆàÚ8Ø—{øe²>¦\Zõ>¤ôz‘çði©æ´Bt0ÑÏ#\Zà6…4R·£gÐë’	bÀO[ä\\BKÝp[9Löd7»),QžìŒ¶d¹/–_eöÄË‘y48qôÐÐö,Mä^a+‘ahÝ3ý_Ÿô$›Ñ\r‰oÎÃwÏÖäñCSÇþ¡o?±<…1—LK–XCZdì¨•\"¥Ëô,Yù}4!J1qF­¸”*}\"yG²–¼\Zéø)–5>KäLl~F7© ÝØšT4C^F†c\rÑ¼Q¨éÒëèWB^Ï±lqW„I=‘§ðZò&o‚Ìmö‹[Ýå£©\Z:44{8V5\r»/ºy‹ì¦çDíåàö¢Ò“Ml„ˆWö\Z´™É_ÀšÒ¬Çû4ÝctÈcå~U²Ûq96ÀNG’§\\æef÷Wxô)]ILãéD’}²¥\Zs±;4¥E NCeààÉ›†”1­7£llû,\Z¡á¡›z Üì\"(fWeøß(¾Kçù+µô%Ø÷žFÎYäl¢»*îÆÞD:cÏ1\'Ø—‘nåÙW¢¦Î‹<þåT½‚äG(ËÁ—:Ñ;	ÃÙ¡0\\ÎŸ¹EäGbêB5å;¸fí˜½v…<?Jâ‹/Oˆ²Ç¡é\n+ìþtÛq£”Æ±·c‚ŠCŸ#fPÛ+nVÂ±·£ùÒÆ\Zk²¢·É‰BžÐŸ†‚Nj&nG“ØÍîŠ&m¦{+ì®Î†:=8N†N‡“yBFµTâ—IèûZe‰¾ÄÏ’„Ï±wñ¡..ûQìHØGÙ‰Ü|I-‘tÉžŒò%Hqäà(3mQ^Fx>‹‚!#J9~45øBk¶„eeCj‘?N)é	ÔôÄý§ïJõbbfí	Á5ÑtÁé‰t=ôÏÑ±Á—fƒúäIy>ÈŸÑx¿Dÿ\0ö˜8‹¢½#=ÝèŽÏbMlb}’ô†˜$îùbž4O½DBÏ‘ŒwcMò=èài±·\Z‡Ó#aÎÉ«ÆäxÑz ‚BI°ðØð‹ÃS¸7YFÄÌkfy\nSÐé“=‰§p`™‰Ýíòzæ¡´Ö¾—´$Ÿa1€”Bg,ÃäQÊ\'ˆºQâ_¢[³ôŽA/þˆëùK×á?°„^H¼“­>ˆ5ô6í“„}•^ïÃ°¾˜¾!t¿9àžDCÝ±‚|ÐÇFeés¥x.—D]Fˆ Ðjhæy\"BÌ¸ÑK‚º³÷	–åÃ‚/\"ÞWà™x]ý	Ë\"S¿Âzü>¿Oþ‚@—¡NBôüþ‘WŸÁ?º6ËäcÞ}Ì÷7nÿ\0‹À[àŠÞê8÷£Øû¡ŸrÐP’Ý³Ù¥ÚÐ•nî’ò	<•2¢è5ìu©˜èmtR\'ÀÑðN–[šFVŒjŒ½,²Ê†{ãN$DÑ•y/¡XU³|êŒIùÑA_È—±4%l¿ƒ>êgÆ¼ºqGà»àdÏ%†3ýF{¿à!NDî£1ä£Ûr¾Ì9-ùŠº^]|èQEÀ9pJE¢ô_€¡\"&‰;%å¢	)¡ŸQ;eüá·Eö‡Þˆ%Ãü#\\1_\"o–Ç«†QâñMvÈíë7ð6ò{Ý˜òG—èñ6K£1èöH†‡„Ñò4ì«²;/’»+¶WÙ_bîäN*÷bg\'«‚•žÆ{/–VVWþ	¥)t])ØêÑcñG¢=  ^\"~\nrŠ¾I ’t\Z³Øn¹Á^ðR+‘ztzQâVõ{Q¿g¾úð ú‡&t¾EWg±å’«ò¢zV„èA½#´N!£}pne¯aŸ?\nQ¿#žGû,Pô~bŸÉëüŸÖt³ö/ÉèÅ†ÌûèÙ«EôWL¢>™Ñ#­ÑDðdh†ƒnŽR\ZwO¨ëzUÒ.˜\"dÌ™6àºÏør{LÙ`¨\'Øš*ïTÚ/Ùù/µ¢èô(Ü5Ñeéa»ÓB]„ù±ä‹±«äŽÏcßKó\Zw¡$ŽkF1T^§ÿ\0Ñž^˜ð]#J­iöl6(¯¢´\'ç&K¬ –12P‘\'bH%\\é$|éli¾Ý™ì¯ÈÞ³döÉò[b‡¥7Å}\n.\n„Ña‘FD5Ð‹F$Cð_Cß¯¤DDÇæHr?C£dâLƒCY8¿.µ,Ç“ú¼DŒ†T(Èˆˆ„§Â‰—%v\'Ò Ž‡L¾ØÞw=„T-\nÖíèË‚¡¤6+3ØÍÇ£sEÑ£¹Œ¼GØó2{,‚Né¢;Ô9†¨jA\r?«L2O ü×±û/à½!dde9ìhØiZN†\rŠ6g”!-	ÝoÇ$!Bce§#_\rŒ4¯´Rä­|)˜!ªOhö\"mÝÉIc·Zö4£Ëv?6{\nŸò)–ÔÈmáª¶øzdt\'¡#ÜÏf‡æeú*äžôª#È‘àp©÷$tZX[až#+íò™<hàZ•C{-v(‹xC%8*7¤bi\rä´É4¤Ñ5p]982\"z`Á)ö_4¥¢Z(-?ÿÙ','154863_211548749050430_2144071069_n.jpg');
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

-- Dump completed on 2015-04-24 13:59:39
