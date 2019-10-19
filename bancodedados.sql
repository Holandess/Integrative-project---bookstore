-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: lojainformatica
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.16.04.1

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `sexo` varchar(9) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `numero` int(5) DEFAULT NULL,
  `complemento` varchar(9) DEFAULT NULL,
  `bairro` varchar(20) DEFAULT NULL,
  `cep` int(10) DEFAULT NULL,
  `cidade` varchar(14) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `telefone` int(16) DEFAULT NULL,
  `celular` int(16) DEFAULT NULL,
  `date_entered` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (4,'Pedro','pedro@hotmail.com','-1592937450','Masculino','Oscar de Barros',888,'1','Jardim Itapura',4433050,'Sao Paulo','SP',124123312,154123141,'2018-12-05 13:28:43'),(5,'Valdir Pereira','valdir.pereira@bol.net','-1592937450','Masculino','Avenida Paulista',21413,'123','Jardins',4433002,'Sao Paulo','SP',-920436723,-1639778765,'2018-12-05 13:30:21');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_pedido`
--

DROP TABLE IF EXISTS `item_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_pedido` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `idvenda` int(6) unsigned NOT NULL,
  `idproduto` int(6) unsigned NOT NULL,
  `qtd` int(3) unsigned NOT NULL,
  `valor` float unsigned NOT NULL,
  `date_entered` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idvenda` (`idvenda`),
  KEY `idproduto` (`idproduto`),
  CONSTRAINT `item_pedido_ibfk_1` FOREIGN KEY (`idvenda`) REFERENCES `vendas` (`id`),
  CONSTRAINT `item_pedido_ibfk_2` FOREIGN KEY (`idproduto`) REFERENCES `produtos` (`codproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_pedido`
--

LOCK TABLES `item_pedido` WRITE;
/*!40000 ALTER TABLE `item_pedido` DISABLE KEYS */;
INSERT INTO `item_pedido` VALUES (23,20,4,19,12350,'2018-12-05 13:32:30'),(24,20,5,14,4200,'2018-12-05 13:32:30');
/*!40000 ALTER TABLE `item_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtos` (
  `codproduto` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `categoria` varchar(20) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `description` text,
  `qtd` int(5) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `date_entered` datetime DEFAULT NULL,
  PRIMARY KEY (`codproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (4,'Computador','Computador Positivo','Computador Poisitivo com 4GB de Ram e 200GB de HD',40,650,'2018-12-05 13:31:19'),(5,'Peças','Mouse Razer','Mouse Gamer com 6900dpi para jogos fps',120,300,'2018-12-05 13:31:53');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendas`
--

DROP TABLE IF EXISTS `vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendas` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `valor` float NOT NULL,
  `meiodepagamento` varchar(20) NOT NULL,
  `idcliente` int(6) unsigned NOT NULL,
  `date_entered` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idcliente` (`idcliente`),
  CONSTRAINT `vendas_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendas`
--

LOCK TABLES `vendas` WRITE;
/*!40000 ALTER TABLE `vendas` DISABLE KEYS */;
INSERT INTO `vendas` VALUES (20,16550,'Dinheiro',4,'2018-12-05 13:32:30');
/*!40000 ALTER TABLE `vendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-05 13:34:27
