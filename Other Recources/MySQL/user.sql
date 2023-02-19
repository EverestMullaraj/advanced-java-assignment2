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
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
