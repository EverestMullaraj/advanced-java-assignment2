-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2023 at 12:35 PM
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
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `MovieId` int(11) NOT NULL,
  `MovieName` varchar(30) DEFAULT NULL,
  `Author` varchar(30) DEFAULT NULL,
  `PublishedDate` date DEFAULT NULL,
  `ManagerName` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`MovieId`, `MovieName`, `Author`, `PublishedDate`, `ManagerName`) VALUES
(543, '5345', '534', '0000-00-00', '543'),
(544, 'rewq', 'rwqe', '2023-02-17', 'wrqe'),
(546, '232', '324', '2023-02-17', '42134'),
(547, '43', '432', '2023-02-18', '4324'),
(548, 'ty', '2453', '2023-02-18', '4567');

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

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `Id` int(11) NOT NULL,
  `ShowId` int(11) DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL,
  `MovieName` varchar(30) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `TotalPrice` double DEFAULT NULL,
  `TotalSeats` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`Id`, `ShowId`, `UserId`, `MovieName`, `Date`, `TotalPrice`, `TotalSeats`) VALUES
(1, 19, 0, '8558', '2023-02-19', 4356, 5),
(6, 19, 65, '786', '2023-02-19', 67, 3),
(7, 5, 6, '4', '2023-02-19', 2, NULL),
(8, 5, 3, '2', '2023-02-19', 3, NULL),
(9, 2, 3, 'Movie 1', '2023-02-19', 4500, NULL);

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

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Id` int(11) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `PhoneNumber` varchar(30) DEFAULT NULL,
  `Gender` varchar(30) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `JoinedDate` date DEFAULT NULL,
  `UserName` varchar(30) DEFAULT NULL,
  `Passwrd` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Id`, `Name`, `Email`, `PhoneNumber`, `Gender`, `Address`, `JoinedDate`, `UserName`, `Passwrd`) VALUES
(20, 'admin', '3424', NULL, 'M', '4324', '2023-02-18', 'user1', '12345'),
(21, 'user1', '432', NULL, 'M', 'Columbia', '2023-02-18', 'user', '123'),
(22, '534', '523', NULL, 'M', '5235', '2023-02-19', 'user', '123'),
(24, 'user1', '432', NULL, 'M', 'Columbia', '2023-02-18', 'user', '123'),
(25, 'user1', '432', NULL, 'M', 'Columbia ABC', '2023-02-18', 'user', '123'),
(26, 'user1', '432', NULL, 'M', 'Columbia ABC', '2023-02-18', 'user', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`MovieId`);

--
-- Indexes for table `movieshow`
--
ALTER TABLE `movieshow`
  ADD PRIMARY KEY (`ShowId`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`PaymentId`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `theaterrooms`
--
ALTER TABLE `theaterrooms`
  ADD PRIMARY KEY (`RoomId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `movies`
--
ALTER TABLE `movies`
  MODIFY `MovieId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=549;

--
-- AUTO_INCREMENT for table `movieshow`
--
ALTER TABLE `movieshow`
  MODIFY `ShowId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `PaymentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `theaterrooms`
--
ALTER TABLE `theaterrooms`
  MODIFY `RoomId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
