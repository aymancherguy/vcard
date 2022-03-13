-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/


-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetjava2`
--

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `idperson` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `address` varchar(50) NOT NULL,
  `email_address` varchar(50) DEFAULT NULL,
  `birth_date` varchar(50) NOT NULL,
  PRIMARY KEY (`idperson`)
) ENGINE=MyISAM AUTO_INCREMENT=120 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`idperson`, `lastname`, `firstname`, `nickname`, `phone_number`, `address`, `email_address`, `birth_date`) VALUES
(1, 'JOBS', 'Kenza', '2021', '0654847956', '178th New York', 'jobs_jobs@steve.com', '1955-02-24'),
(2, 'Asaad', 'KOUACH', 'franko', '0654497956', '178th Detroit', 'frank@gmail.com', '1987-12-23'),
(4, 'cherguy', 'Ayman', 'Elo', '0654841356', 'Lille Vauban', 'ayman@outlook.com', '1997-12-26'),
(119, 'Ait taleb', 'Yassine', 'ok', '0661947885', 'dqknqdkj', 'ait_yassine@hotmail.com', '2001-12-26');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
