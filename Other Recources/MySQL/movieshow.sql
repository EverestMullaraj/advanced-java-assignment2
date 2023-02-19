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
-- Table structure for table `movieshow`
--

CREATE TABLE `movieshow` (
  `ShowId` int(11) NOT NULL,
  `RoomId` int(11) DEFAULT NULL,
  `MovieId` int(11) DEFAULT NULL,
  `MovieName` varchar(30) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `StartTime` date DEFAULT NULL,
  `EndTime` date DEFAULT NULL,
  `BookingFee` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movieshow`
--

INSERT INTO `movieshow` (`ShowId`, `RoomId`, `MovieId`, `MovieName`, `Date`, `StartTime`, `EndTime`, `BookingFee`) VALUES
(19, 5, 548, '8558', '2023-02-18', '2023-02-18', '2023-02-18', 4356),
(25, 1, 543, 'Movie 2', '2023-02-18', '2023-02-18', '2023-02-18', 7000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movieshow`
--
ALTER TABLE `movieshow`
  ADD PRIMARY KEY (`ShowId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `movieshow`
--
ALTER TABLE `movieshow`
  MODIFY `ShowId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
