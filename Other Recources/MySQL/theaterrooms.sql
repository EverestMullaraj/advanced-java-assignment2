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
-- Table structure for table `theaterrooms`
--

CREATE TABLE `theaterrooms` (
  `RoomId` int(11) NOT NULL,
  `MovieID` int(11) DEFAULT NULL,
  `MovieName` int(11) DEFAULT NULL,
  `OpeningTime` date DEFAULT NULL,
  `ClosingTime` date DEFAULT NULL,
  `Manager` date DEFAULT NULL,
  `TotalMovies` int(11) DEFAULT NULL,
  `TotalEarn` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `theaterrooms`
--

INSERT INTO `theaterrooms` (`RoomId`, `MovieID`, `MovieName`, `OpeningTime`, `ClosingTime`, `Manager`, `TotalMovies`, `TotalEarn`) VALUES
(1, 785, 456, '2023-02-18', '2023-02-18', '2023-02-18', 65, 12000),
(2, 567, 56756, '2023-02-18', '2023-02-18', '2023-02-18', 6578, 555555555),
(3, 232, 321, '2023-02-18', '2023-02-18', '2023-02-18', 1, 33),
(4, 342, 23, '2023-02-18', '2023-02-18', '2023-02-18', 32, 4324),
(5, 798, 365, '2023-02-18', '2023-02-18', '2023-02-18', 453, 3456);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `theaterrooms`
--
ALTER TABLE `theaterrooms`
  ADD PRIMARY KEY (`RoomId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `theaterrooms`
--
ALTER TABLE `theaterrooms`
  MODIFY `RoomId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
