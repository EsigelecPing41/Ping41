-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le : Sam 15 Décembre 2012 à 04:38
-- Version du serveur: 5.5.20
-- Version de PHP: 5.3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `skftraceability`
--

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

CREATE TABLE IF NOT EXISTS `lieu` (
  `L_ID` int(11) NOT NULL AUTO_INCREMENT,
  `L_Nom` varchar(100) NOT NULL,
  PRIMARY KEY (`L_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `localisationpiece`
--

CREATE TABLE IF NOT EXISTS `localisationpiece` (
  `LocP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LocP_Date` date NOT NULL,
  `O_ID` int(11) NOT NULL,
  `L_ID` int(11) NOT NULL,
  PRIMARY KEY (`LocP_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `localisationpiece`
--

INSERT INTO `localisationpiece` (`LocP_ID`, `LocP_Date`, `O_ID`, `L_ID`) VALUES
(1, '0000-00-00', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `operateur`
--

CREATE TABLE IF NOT EXISTS `operateur` (
  `O_ID` int(11) NOT NULL AUTO_INCREMENT,
  `O_Login` varchar(100) NOT NULL,
  `O_Password` varchar(100) NOT NULL,
  `O_Nom` varchar(100) NOT NULL,
  `O_Prenom` varchar(100) NOT NULL,
  PRIMARY KEY (`O_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `operateur`
--

INSERT INTO `operateur` (`O_ID`, `O_Login`, `O_Password`, `O_Nom`, `O_Prenom`) VALUES
(1, 'login', 'password', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `piece`
--

CREATE TABLE IF NOT EXISTS `piece` (
  `P_ID` int(11) NOT NULL AUTO_INCREMENT,
  `P_Nom` varchar(100) NOT NULL,
  `P_CodeBarre` varchar(100) NOT NULL,
  `P_Statut` tinyint(1) NOT NULL,
  PRIMARY KEY (`P_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `piece`
--

INSERT INTO `piece` (`P_ID`, `P_Nom`, `P_CodeBarre`, `P_Statut`) VALUES
(1, '1', '', 0),
(2, '2', 'code de barre 2', 0),
(3, '3', '', 0),
(4, '4', '', 0),
(5, '5', '', 0),
(6, '6', '', 0),
(7, '7', '', 0),
(8, '8', '', 0),
(9, '9', '', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
