-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 18, 2018 at 06:31 AM
-- Server version: 5.6.38
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ashkaran_w3database`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `CustomerID` int(11) NOT NULL,
  `CustomerName` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `ContactName` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `Address` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `City` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `PostalCode` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `Country` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `CustomerImage` varchar(200) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`CustomerID`, `CustomerName`, `ContactName`, `Address`, `City`, `PostalCode`, `Country`, `CustomerImage`) VALUES
(1, 'Alfreds Futterkiste', 'Maria Anders', 'Obere Str. 57', 'Berlin', '12209', 'Germany', '/images/image (16).jpg'),
(2, 'Ana Trujillo Emparedados y hel', 'Ana Trujillo', 'Avda. de la Constitución 2222', 'México D.F.', '05021', 'Mexico', '/images/image (18).jpg'),
(3, 'Antonio Moreno Taquería', 'Antonio Moreno', 'Mataderos 2312', 'México D.F.', '05023', 'Mexico', '/images/image (13).jpg'),
(4, 'Around the Horn', 'Thomas Hardy', '120 Hanover Sq.', 'London', 'WA1 1DP', 'UK', '/images/image (2).jpg'),
(5, 'Berglunds snabbköp', 'Christina Berglund', 'Berguvsvägen 8', 'Luleå', 'S-958 22', 'Sweden', '/images/image (10).jpg'),
(6, 'Blauer See Delikatessen', 'Hanna Moos', 'Forsterstr. 57', 'Mannheim', '68306', 'Germany', '/images/image (14).jpg'),
(7, 'Blondel père et fils', 'Frédérique Citeaux', '24, place Kléber', 'Strasbourg', '67000', 'France', '/images/image (17).jpg'),
(8, 'Bólido Comidas preparadas', 'Martín Sommer', 'C/ Araquil, 67', 'Madrid', '28023', 'Spain', '/images/image (4).jpg'),
(9, 'Bon app\'', 'Laurence Lebihans', '12, rue des Bouchers', 'Marseille', '13008', 'France', '/images/image (7).jpg'),
(10, 'Bottom-Dollar Marketse', 'Elizabeth Lincoln', '23 Tsawassen Blvd.', 'Tsawassen', 'T2F 8M4', 'Canada', '/images/image (8).jpg'),
(11, 'B\'s Beverages', 'Victoria Ashworth', 'Fauntleroy Circus', 'London', 'EC2 5NT', 'UK', '/images/image (9).jpg'),
(12, 'Cactus Comidas para llevar', 'Patricio Simpson', 'Cerrito 333', 'Buenos Aires', '1010', 'Argentina', '/images/image (10).jpg'),
(13, 'Centro comercial Moctezuma', 'Francisco Chang', 'Sierras de Granada 9993', 'México D.F.', '05022', 'Mexico', '/images/image (11).jpg'),
(14, 'Chop-suey Chinese', 'Yang Wang', 'Hauptstr. 29', 'Bern', '3012', 'Switzerland', '/images/image (12).jpg'),
(15, 'Comércio Mineiro', 'Pedro Afonso', 'Av. dos Lusíadas, 23', 'São Paulo', '05432-043', 'Brazil', '/images/image (13).jpg'),
(16, 'Consolidated Holdings', 'Elizabeth Brown', 'Berkeley Gardens 12 Brewery', 'London', 'WX1 6LT', 'UK', '/images/image (4).jpg'),
(17, 'Drachenblut Delikatessend', 'Sven Ottlieb', 'Walserweg 21', 'Aachen', '52066', 'Germany', '/images/image (15).jpg'),
(18, 'Du monde entier', 'Janine Labrune', '67, rue des Cinquante Otages', 'Nantes', '44000', 'France', '/images/image (1).jpg'),
(19, 'Eastern Connection', 'Ann Devon', '35 King George', 'London', 'WX3 6FW', 'UK', '/images/image (5).jpg'),
(20, 'Ernst Handel', 'Roland Mendel', 'Kirchgasse 6', 'Graz', '8010', 'Austria', '/images/image (3).jpg'),
(21, 'Familia Arquibaldo', 'Aria Cruz', 'Rua Orós, 92', 'São Paulo', '05442-030', 'Brazil', ''),
(22, 'FISSA Fabrica Inter. Salchicha', 'Diego Roel', 'C/ Moralzarzal, 86', 'Madrid', '28034', 'Spain', ''),
(23, 'Folies gourmandes', 'Martine Rancé', '184, chaussée de Tournai', 'Lille', '59000', 'France', ''),
(24, 'Folk och fä HB', 'Maria Larsson', 'Åkergatan 24', 'Bräcke', 'S-844 67', 'Sweden', ''),
(25, 'Frankenversand', 'Peter Franken', 'Berliner Platz 43', 'München', '80805', 'Germany', ''),
(26, 'France restauration', 'Carine Schmitt', '54, rue Royale', 'Nantes', '44000', 'France', ''),
(27, 'Franchi S.p.A.', 'Paolo Accorti', 'Via Monte Bianco 34', 'Torino', '10100', 'Italy', ''),
(28, 'Furia Bacalhau e Frutos do Mar', 'Lino Rodriguez', 'Jardim das rosas n. 32', 'Lisboa', '1675', 'Portugal', ''),
(29, 'Galería del gastrónomo', 'Eduardo Saavedra', 'Rambla de Cataluña, 23', 'Barcelona', '08022', 'Spain', ''),
(30, 'Godos Cocina Típica', 'José Pedro Freyre', 'C/ Romero, 33', 'Sevilla', '41101', 'Spain', ''),
(31, 'Gourmet Lanchonetes', 'André Fonseca', 'Av. Brasil, 442', 'Campinas', '04876-786', 'Brazil', ''),
(32, 'Great Lakes Food Market', 'Howard Snyder', '2732 Baker Blvd.', 'Eugene', '97403', 'USA', ''),
(33, 'GROSELLA-Restaurante', 'Manuel Pereira', '5ª Ave. Los Palos Grandes', 'Caracas', '1081', 'Venezuela', ''),
(34, 'Hanari Carnes', 'Mario Pontes', 'Rua do Paço, 67', 'Rio de Janeiro', '05454-876', 'Brazil', ''),
(35, 'HILARIÓN-Abastos', 'Carlos Hernández', 'Carrera 22 con Ave. Carlos Soublette #8-35', 'San Cristóbal', '5022', 'Venezuela', ''),
(36, 'Hungry Coyote Import Store', 'Yoshi Latimer', 'City Center Plaza 516 Main St.', 'Elgin', '97827', 'USA', ''),
(37, 'Hungry Owl All-Night Grocers', 'Patricia McKenna', '8 Johnstown Road', 'Cork', '', 'Ireland', ''),
(38, 'Island Trading', 'Helen Bennett', 'Garden House Crowther Way', 'Cowes', 'PO31 7PJ', 'UK', ''),
(39, 'Königlich Essen', 'Philip Cramer', 'Maubelstr. 90', 'Brandenburg', '14776', 'Germany', ''),
(40, 'La corne d\'abondance', 'Daniel Tonini', '67, avenue de l\'Europe', 'Versailles', '78000', 'France', ''),
(41, 'La maison d\'Asie', 'Annette Roulet', '1 rue Alsace-Lorraine', 'Toulouse', '31000', 'France', ''),
(42, 'Laughing Bacchus Wine Cellars', 'Yoshi Tannamuri', '1900 Oak St.', 'Vancouver', 'V3F 2K1', 'Canada', ''),
(43, 'Lazy K Kountry Store', 'John Steel', '12 Orchestra Terrace', 'Walla Walla', '99362', 'USA', ''),
(44, 'Lehmanns Marktstand', 'Renate Messner', 'Magazinweg 7', 'Frankfurt a.M.', '60528', 'Germany', ''),
(45, 'Let\'s Stop N Shop', 'Jaime Yorres', '87 Polk St. Suite 5', 'San Francisco', '94117', 'USA', ''),
(46, 'LILA-Supermercado', 'Carlos González', 'Carrera 52 con Ave. Bolívar #65-98 Llano Largo', 'Barquisimeto', '3508', 'Venezuela', ''),
(47, 'LINO-Delicateses', 'Felipe Izquierdo', 'Ave. 5 de Mayo Porlamar', 'I. de Margarita', '4980', 'Venezuela', ''),
(48, 'Lonesome Pine Restaurant', 'Fran Wilson', '89 Chiaroscuro Rd.', 'Portland', '97219', 'USA', ''),
(49, 'Magazzini Alimentari Riuniti', 'Giovanni Rovelli', 'Via Ludovico il Moro 22', 'Bergamo', '24100', 'Italy', ''),
(50, 'Maison Dewey', 'Catherine Dewey', 'Rue Joseph-Bens 532', 'Bruxelles', 'B-1180', 'Belgium', '');

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `id` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `text` varchar(2000) CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE `orderdetails` (
  `OrderDetailID` int(11) NOT NULL,
  `OrderID` int(11) DEFAULT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `orderdetails`
--

INSERT INTO `orderdetails` (`OrderDetailID`, `OrderID`, `ProductID`, `Quantity`) VALUES
(1, 10248, 11, 12),
(2, 10248, 42, 10),
(3, 10248, 72, 5),
(4, 10249, 14, 9),
(5, 10249, 51, 40),
(6, 10250, 41, 10),
(7, 10250, 51, 35),
(8, 10250, 65, 15),
(9, 10251, 22, 6),
(10, 10251, 57, 15),
(11, 10251, 65, 20),
(12, 10252, 20, 40),
(13, 10252, 33, 25),
(14, 10252, 60, 40),
(15, 10253, 31, 20),
(16, 10253, 39, 42),
(17, 10253, 49, 40),
(18, 10254, 24, 15),
(19, 10254, 55, 21),
(20, 10254, 74, 21),
(21, 10255, 2, 20),
(22, 10255, 16, 35),
(23, 10255, 36, 25),
(24, 10255, 59, 30),
(25, 10256, 53, 15),
(26, 10256, 77, 12),
(27, 10257, 27, 25),
(28, 10257, 39, 6),
(29, 10257, 77, 15),
(30, 10258, 2, 50),
(31, 10258, 5, 65),
(32, 10258, 32, 6),
(33, 10259, 21, 10),
(34, 10259, 37, 1),
(35, 10260, 41, 16),
(36, 10260, 57, 50),
(37, 10260, 62, 15),
(38, 10260, 70, 21),
(39, 10261, 21, 20),
(40, 10261, 35, 20),
(41, 10262, 5, 12),
(42, 10262, 7, 15),
(43, 10262, 56, 2),
(44, 10263, 16, 60),
(45, 10263, 24, 28),
(46, 10263, 30, 60),
(47, 10263, 74, 36),
(48, 10264, 2, 35),
(49, 10264, 41, 25),
(50, 10265, 17, 30);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `OrderID` int(11) NOT NULL,
  `CustomerID` int(11) DEFAULT NULL,
  `EmployeeID` int(11) DEFAULT NULL,
  `OrderDate` longtext CHARACTER SET utf8,
  `ShipperID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`OrderID`, `CustomerID`, `EmployeeID`, `OrderDate`, `ShipperID`) VALUES
(10247, 99, 1, '1111', 1),
(10248, 90, 5, '1996-07-04', 3),
(10249, 81, 6, '1996-07-05', 1),
(10250, 34, 4, '1996-07-08', 2),
(10251, 84, 3, '1996-07-08', 1),
(10252, 76, 4, '1996-07-09', 2),
(10253, 34, 3, '1996-07-10', 2),
(10254, 14, 5, '1996-07-11', 2),
(10255, 68, 9, '1996-07-12', 3),
(10256, 88, 3, '1996-07-15', 2),
(10257, 35, 4, '1996-07-16', 3),
(10258, 20, 1, '1996-07-17', 1),
(10259, 13, 4, '1996-07-18', 3),
(10260, 55, 4, '1996-07-19', 1),
(10261, 61, 4, '1996-07-19', 2),
(10262, 65, 8, '1996-07-22', 3),
(10263, 20, 9, '1996-07-23', 3),
(10264, 24, 6, '1996-07-24', 3),
(10265, 7, 2, '1996-07-25', 1),
(10266, 87, 3, '1996-07-26', 3),
(10267, 25, 4, '1996-07-29', 1),
(10268, 33, 8, '1996-07-30', 3),
(10269, 89, 5, '1996-07-31', 1),
(10270, 87, 1, '1996-08-01', 1),
(10271, 75, 6, '1996-08-01', 2),
(10272, 65, 6, '1996-08-02', 2),
(10273, 63, 3, '1996-08-05', 3),
(10274, 85, 6, '1996-08-06', 1),
(10275, 49, 1, '1996-08-07', 1),
(10276, 80, 8, '1996-08-08', 3),
(10277, 52, 2, '1996-08-09', 3),
(10278, 5, 8, '1996-08-12', 2),
(10279, 44, 8, '1996-08-13', 2),
(10280, 5, 2, '1996-08-14', 1),
(10281, 69, 4, '1996-08-14', 1),
(10282, 69, 4, '1996-08-15', 1),
(10283, 46, 3, '1996-08-16', 3),
(10284, 44, 4, '1996-08-19', 1),
(10285, 63, 1, '1996-08-20', 2),
(10286, 63, 8, '1996-08-21', 3),
(10287, 67, 8, '1996-08-22', 3),
(10288, 66, 4, '1996-08-23', 1),
(10289, 11, 7, '1996-08-26', 3),
(10290, 15, 8, '1996-08-27', 1),
(10291, 61, 6, '1996-08-27', 2),
(10292, 81, 1, '1996-08-28', 2),
(10293, 80, 1, '1996-08-29', 3),
(10294, 65, 4, '1996-08-30', 2),
(10295, 85, 2, '1996-09-02', 2),
(10296, 46, 6, '1996-09-03', 1);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ProductID` int(11) NOT NULL,
  `ProductName` longtext CHARACTER SET utf8,
  `SupplierID` int(11) DEFAULT NULL,
  `CategoryID` int(11) DEFAULT NULL,
  `Unit` longtext CHARACTER SET utf8,
  `Price` longtext CHARACTER SET utf8
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ProductID`, `ProductName`, `SupplierID`, `CategoryID`, `Unit`, `Price`) VALUES
(1, 'Chais', 1, 1, '10 boxes x 20 bags', '18'),
(2, 'Chang', 1, 1, '24 - 12 oz bottles', '19'),
(3, 'Aniseed Syrup', 1, 2, '12 - 550 ml bottles', '10'),
(4, 'Chef Anton\'s Cajun Seasoning', 2, 2, '48 - 6 oz jars', '22'),
(5, 'Chef Anton\'s Gumbo Mix', 2, 2, '36 boxes', '21.35'),
(6, 'Grandma\'s Boysenberry Spread', 3, 2, '12 - 8 oz jars', '25'),
(7, 'Uncle Bob\'s Organic Dried Pears', 3, 7, '12 - 1 lb pkgs.', '30'),
(8, 'Northwoods Cranberry Sauce', 3, 2, '12 - 12 oz jars', '40'),
(9, 'Mishi Kobe Niku', 4, 6, '18 - 500 g pkgs.', '97'),
(10, 'Ikura', 4, 8, '12 - 200 ml jars', '31'),
(11, 'Queso Cabrales', 5, 4, '1 kg pkg.', '21'),
(12, 'Queso Manchego La Pastora', 5, 4, '10 - 500 g pkgs.', '38'),
(13, 'Konbu', 6, 8, '2 kg box', '6'),
(14, 'Tofu', 6, 7, '40 - 100 g pkgs.', '23.25'),
(15, 'Genen Shouyu', 6, 2, '24 - 250 ml bottles', '15.5'),
(16, 'Pavlova', 7, 3, '32 - 500 g boxes', '17.45'),
(17, 'Alice Mutton', 7, 6, '20 - 1 kg tins', '39'),
(18, 'Carnarvon Tigers', 7, 8, '16 kg pkg.', '62.5'),
(19, 'Teatime Chocolate Biscuits', 8, 3, '10 boxes x 12 pieces', '9.2'),
(20, 'Sir Rodney\'s Marmalade', 8, 3, '30 gift boxes', '81'),
(21, 'Sir Rodney\'s Scones', 8, 3, '24 pkgs. x 4 pieces', '10'),
(22, 'Gustaf\'s Knäckebröd', 9, 5, '24 - 500 g pkgs.', '21'),
(23, 'Tunnbröd', 9, 5, '12 - 250 g pkgs.', '9'),
(24, 'Guaraná Fantástica', 10, 1, '12 - 355 ml cans', '4.5'),
(25, 'NuNuCa Nuß-Nougat-Creme', 11, 3, '20 - 450 g glasses', '14'),
(26, 'Gumbär Gummibärchen', 11, 3, '100 - 250 g bags', '31.23'),
(27, 'Schoggi Schokolade', 11, 3, '100 - 100 g pieces', '43.9'),
(28, 'Rössle Sauerkraut', 12, 7, '25 - 825 g cans', '45.6'),
(29, 'Thüringer Rostbratwurst', 12, 6, '50 bags x 30 sausgs.', '123.79'),
(30, 'Nord-Ost Matjeshering', 13, 8, '10 - 200 g glasses', '25.89'),
(31, 'Gorgonzola Telino', 14, 4, '12 - 100 g pkgs', '12.5'),
(32, 'Mascarpone Fabioli', 14, 4, '24 - 200 g pkgs.', '32'),
(33, 'Geitost', 15, 4, '500 g', '2.5'),
(34, 'Sasquatch Ale', 16, 1, '24 - 12 oz bottles', '14'),
(35, 'Steeleye Stout', 16, 1, '24 - 12 oz bottles', '18'),
(36, 'Inlagd Sill', 17, 8, '24 - 250 g jars', '19'),
(37, 'Gravad lax', 17, 8, '12 - 500 g pkgs.', '26'),
(38, 'Côte de Blaye', 18, 1, '12 - 75 cl bottles', '263.5'),
(39, 'Chartreuse verte', 18, 1, '750 cc per bottle', '18'),
(40, 'Boston Crab Meat', 19, 8, '24 - 4 oz tins', '18.4'),
(41, 'Jack\'s New England Clam Chowder', 19, 8, '12 - 12 oz cans', '9.65'),
(42, 'Singaporean Hokkien Fried Mee', 20, 5, '32 - 1 kg pkgs.', '14'),
(43, 'Ipoh Coffee', 20, 1, '16 - 500 g tins', '46'),
(44, 'Gula Malacca', 20, 2, '20 - 2 kg bags', '19.45'),
(45, 'Røgede sild', 21, 8, '1k pkg.', '9.5'),
(46, 'Spegesild', 21, 8, '4 - 450 g glasses', '12'),
(47, 'Zaanse koeken', 22, 3, '10 - 4 oz boxes', '9.5'),
(48, 'Chocolade', 22, 3, '10 pkgs.', '12.75'),
(49, 'Maxilaku', 23, 3, '24 - 50 g pkgs.', '20'),
(50, 'Valkoinen suklaa', 23, 3, '12 - 100 g bars', '16.25');

-- --------------------------------------------------------

--
-- Table structure for table `shippers`
--

CREATE TABLE `shippers` (
  `ShipperID` int(11) NOT NULL,
  `ShipperName` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `Phone` varchar(20) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `shippers`
--

INSERT INTO `shippers` (`ShipperID`, `ShipperName`, `Phone`) VALUES
(1, 'Speedy Express', '(503) 555-9831'),
(2, 'United Package', '(503) 555-3199'),
(3, 'Federal Shipping', '(503) 555-9931');

-- --------------------------------------------------------

--
-- Table structure for table `shippersbackup`
--

CREATE TABLE `shippersbackup` (
  `ShipperID` longtext CHARACTER SET utf8,
  `ShipperName` longtext CHARACTER SET utf8,
  `Phone` longtext CHARACTER SET utf8
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `shippersbackup`
--

INSERT INTO `shippersbackup` (`ShipperID`, `ShipperName`, `Phone`) VALUES
('1', 'Speedy Express', '(503) 555-9831'),
('2', 'United Package', '(503) 555-3199'),
('3', 'Federal Shipping', '(503) 555-9931');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `SupplierID` int(11) NOT NULL,
  `SupplierName` longtext CHARACTER SET utf8,
  `ContactName` longtext CHARACTER SET utf8,
  `Address` longtext CHARACTER SET utf8,
  `City` longtext CHARACTER SET utf8,
  `PostalCode` longtext CHARACTER SET utf8,
  `Country` longtext CHARACTER SET utf8,
  `Phone` longtext CHARACTER SET utf8
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`SupplierID`, `SupplierName`, `ContactName`, `Address`, `City`, `PostalCode`, `Country`, `Phone`) VALUES
(1, 'Exotic Liquid', 'Charlotte Cooper', '49 Gilbert St.', 'Londona', 'EC1 4SD', 'UK', '(171) 555-2222'),
(2, 'New Orleans Cajun Delights', 'Shelley Burke', 'P.O. Box 78934', 'New Orleans', '70117', 'USA', '(100) 555-4822'),
(3, 'Grandma Kelly\'s Homestead', 'Regina Murphy', '707 Oxford Rd.', 'Ann Arbor', '48104', 'USA', '(313) 555-5735'),
(4, 'Tokyo Traders', 'Yoshi Nagase', '9-8 Sekimai Musashino-shi', 'Tokyo', '100', 'Japan', '(03) 3555-5011'),
(5, 'Cooperativa de Quesos \'Las Cabras\'', 'Antonio del Valle Saavedra', 'Calle del Rosal 4', 'Oviedo', '33007', 'Spain', '(98) 598 76 54'),
(6, 'Mayumi\'s', 'Mayumi Ohno', '92 Setsuko Chuo-ku', 'Osaka', '545', 'Japan', '(06) 431-7877'),
(7, 'Pavlova, Ltd.', 'Ian Devling', '74 Rose St. Moonie Ponds', 'Melbourne', '3058', 'Australia', '(03) 444-2343'),
(8, 'Specialty Biscuits, Ltd.', 'Peter Wilson', '29 King\'s Way', 'Manchester', 'M14 GSD', 'UK', '(161) 555-4448'),
(9, 'PB Knäckebröd AB', 'Lars Peterson', 'Kaloadagatan 13', 'Göteborg', 'S-345 67', 'Sweden', '031-987 65 43'),
(10, 'Refrescos Americanas LTDA', 'Carlos Diaz', 'Av. das Americanas 12.890', 'São Paulo', '5442', 'Brazil', '(11) 555 4640'),
(11, 'Heli Süßwaren GmbH & Co. KG', 'Petra Winkler', 'Tiergartenstraße 5', 'Berlin', '10785', 'Germany', '(010) 9984510'),
(12, 'Plutzer Lebensmittelgroßmärkte AG', 'Martin Bein', 'Bogenallee 51', 'Frankfurt', '60439', 'Germany', '(069) 992755'),
(13, 'Nord-Ost-Fisch Handelsgesellschaft mbH', 'Sven Petersen', 'Frahmredder 112a', 'Cuxhaven', '27478', 'Germany', '(04721) 8713'),
(14, 'Formaggi Fortini s.r.l.', 'Elio Rossi', 'Viale Dante, 75', 'Ravenna', '48100', 'Italy', '(0544) 60323'),
(15, 'Norske Meierier', 'Beate Vileid', 'Hatlevegen 5', 'Sandvika', '1320', 'Norway', '(0)2-953010'),
(16, 'Bigfoot Breweries', 'Cheryl Saylor', '3400 - 8th Avenue Suite 210', 'Bend', '97101', 'USA', '(503) 555-9931'),
(17, 'Svensk Sjöföda AB', 'Michael Björn', 'Brovallavägen 231', 'Stockholm', 'S-123 45', 'Sweden', '08-123 45 67'),
(18, 'Aux joyeux ecclésiastiques', 'Guylène Nodier', '203, Rue des Francs-Bourgeois', 'Paris', '75004', 'France', '(1) 03.83.00.68'),
(19, 'New England Seafood Cannery', 'Robb Merchant', 'Order Processing Dept. 2100 Paul Revere Blvd.', 'Boston', '02134', 'USA', '(617) 555-3267'),
(20, 'Leka Trading', 'Chandra Leka', '471 Serangoon Loop, Suite #402', 'Singapore', '0512', 'Singapore', '555-8787'),
(21, 'Lyngbysild', 'Niels Petersen', 'Lyngbysild Fiskebakken 10', 'Lyngby', '2800', 'Denmark', '43844108'),
(22, 'Zaanse Snoepfabriek', 'Dirk Luchte', 'Verkoop Rijnweg 22', 'Zaandam', '9999 ZZ', 'Netherlands', '(12345) 1212'),
(23, 'Karkki Oy', 'Anne Heikkonen', 'Valtakatu 12', 'Lappeenranta', '53120', 'Finland', '(953) 10956'),
(24, 'G\'day, Mate', 'Wendy Mackenzie', '170 Prince Edward Parade Hunter\'s Hill', 'Sydney', '2042', 'Australia', '(02) 555-5914'),
(25, 'Ma Maison', 'Jean-Guy Lauzon', '2960 Rue St. Laurent', 'Montréal', 'H1J 1C3', 'Canada', '(514) 555-9022'),
(26, 'Pasta Buttini s.r.l.', 'Giovanni Giudici', 'Via dei Gelsomini, 153', 'Salerno', '84100', 'Italy', '(089) 6547665'),
(27, 'Escargots Nouveaux', 'Marie Delamare', '22, rue H. Voiron', 'Montceau', '71300', 'France', '85.57.00.07'),
(28, 'Gai pâturage', 'Eliane Noz', 'Bat. B 3, rue des Alpes', 'Annecy', '74000', 'France', '38.76.98.06'),
(29, 'Forêts d\'érables', 'Chantal Goulet', '148 rue Chasseur', 'Ste-Hyacinthe', 'J2S 7S8', 'Canada', '(514) 555-2955');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `fname` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `lname` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `city` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_persian_ci NOT NULL,
  `longer_pass` varchar(100) COLLATE utf8_persian_ci NOT NULL,
  `session` varchar(100) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `fname`, `lname`, `city`, `password`, `longer_pass`, `session`) VALUES
(1, 'alix', 'Dariush', 'Ashkaran', 'behshahr', '', '', '1'),
(2, 'mehdi', 'Mehdi', 'Kazemi', 'Behshahr', '', '', ''),
(3, 'ali1', 'Ali', 'Pordel', 'Behshahr', '', '', ''),
(4, 'ehsan', 'Ehsan', 'CharmPishe', 'behshahr', '', '', ''),
(5, 'alireza', 'Alireza', 'Riyahi', 'behshahr', '', '', ''),
(6, 'Hassan', 'Hassan', 'Farahani', 'behshahr', '', '', ''),
(7, 'aliakbar', '', '', '', 'bcb9bd8684181c244b6ca1d26a02d942', '00FoxRM*ANaahPj*DjKbcYF%UK%*rWFrXbQl#sis6sCn8WlM5&XiUtcF37Cu%7WRiD3b&l', 'V5Ui%15^UrafN8jnkoCAmFBq^f(((%rT)b2%c7Z*z)cc8wAtU2$7IvyDKwCJr$tq4vkhDa'),
(8, 'ali', '', '', '', '1d931726372c8bcb98a9665680011c37', 'F8Rp0M%Hwxk$E)#j$f4hpWzjSLhrlQq!Z8gZUaxgIRacR2wKhA#GnrZ627xoXYeN&uCQE0', 'Agh276rmxYfz48aivfj1yaP4AF3JebjPsASz6jkDHYCawMt2qb3nliskXw4c6MryLjxR2h'),
(9, 'alireza3', '', '', '', 'b851d2ca09aed7e025be1596eebd37cb', 'i$6Il7VoJtvTI^DX7TBLqvQN@#lpveiN7pltw7S6Ad!99t&gcy#D$IgVBBa&QsJYR^he2)', 'DEpnZIDn5J&v8P0$NGqH1gX6lts6Kqgd%GATe47kO3PWTPQwl64nn#uIlWO^c^97BK@QP('),
(10, 'alireza5', '', '', '', 'f0962b495e7952343a3ba1209d956181', 't!#)tIghfcJBTjqnCxsDNxZN8)tf8g#C6UCzsSRI^qaPKA2c(vQL#Gp0FTgO)8h6$TGmCo', '%yO5dpFgCELigEYFFuoV9o%quXa19Np4b49ptPF^jhezV34qytcHR6(c$9d3WC7(Ghn0&$'),
(11, 'razie', '', '', '', 'a2cdbd100426957d7055a4093e3ad25d', 'w@&EB$voiX4ZLOPVYDV3p9Jn)WJg&z#trY*#Sth0hmZ#0FOY8z#xJBUIouZl%ROlFMeo6w', 'pnSegST%H#uAp32aMqECLzjqUZ3)d9vCweRN*BHFt25T67$Tyyla*EASuDRINdb9s$Xpuv'),
(12, 'sali', '', '', '', '2acd7a223a342ab5e897e751d4b6f1fb', 'n5x63uZTondBurAMAtyLoxJjCK7CpqaNvIjzBiSZ450zwALvsjhgfpARa6uzw4MrM5pnMG', 'MgaMf5m0BeIivYHufhA9gwd2mZwaLjgxzrJdwue8Jmqekx7zO7742kvpk2ZuKfrJ5bWC5A');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`OrderDetailID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrderID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ProductID`);

--
-- Indexes for table `shippers`
--
ALTER TABLE `shippers`
  ADD PRIMARY KEY (`ShipperID`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`SupplierID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
