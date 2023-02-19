-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2023 at 12:36 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `theater`
--

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `PaymentId` int(11) NOT NULL,
  `CustomerId` int(11) DEFAULT NULL,
  `CustomerName` varchar(30) DEFAULT NULL,
  `PaymentDate` date DEFAULT NULL,
  `ReservationNumber` int(11) DEFAULT NULL,
  `TotalAmount` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`PaymentId`, `CustomerId`, `CustomerName`, `PaymentDate`, `ReservationNumber`, `TotalAmount`) VALUES
(19, 324, '24', '2023-02-18', 54379, 567),
(20, 0, '345', '2023-02-18', 54380, 4535),
(21, 678, '879', '2023-02-18', 54383, 890),
(22, 456, '5678', '2023-02-18', 54384, 7678),
(23, 0, '5678', '2023-02-18', 54386, 32456),
(26, 21, 'user1', '2023-02-19', 54393, 4356),
(27, 21, 'user1', '2023-02-19', 54393, 4356),
(28, 21, 'user1', '2023-02-19', 54394, 4356),
(29, 21, 'user1', '2023-02-19', 54395, 4356),
(31, 21, 'user1', '2023-02-19', 54401, 4356),
(32, 21, 'user1', '2023-02-19', 54402, 4356),
(33, 21, 'user1', '2023-02-19', 54403, 4356),
(34, 21, 'user1', '2023-02-19', 54404, 4356),
(36, 0, '345', '2023-02-19', 2, 4356),
(37, 21, 'user1', '2023-02-19', 3, 4356),
(38, 6567, '432', '2023-02-19', 425, 67);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`PaymentId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `PaymentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
