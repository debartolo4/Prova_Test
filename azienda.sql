-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Ott 03, 2017 alle 18:46
-- Versione del server: 10.1.25-MariaDB
-- Versione PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `azienda`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `dipendente`
--

CREATE TABLE `dipendente` (
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `Sesso` varchar(1) NOT NULL,
  `Data_di_Nascita` date NOT NULL,
  `Mail` varchar(50) NOT NULL,
  `Telefono` varchar(14) NOT NULL,
  `Domicilio` varchar(50) NOT NULL,
  `Mansione` tinyint(1) NOT NULL,
  `ID_Dipendente` int(20) NOT NULL,
  `CF` char(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `lista_utenti`
--

CREATE TABLE `lista_utenti` (
  `Matricola` int(10) UNSIGNED NOT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `mansione`
--

CREATE TABLE `mansione` (
  `ID_Dipendente` int(20) NOT NULL,
  `Direttore` tinyint(1) NOT NULL,
  `Dipendente` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `schedario`
--

CREATE TABLE `schedario` (
  `ID_Dipendente` int(20) NOT NULL,
  `ID_Spazio` int(20) NOT NULL,
  `ID_Strumento` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `spazio`
--

CREATE TABLE `spazio` (
  `ID_Spazio` int(20) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Descrizione` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `strumentazione`
--

CREATE TABLE `strumentazione` (
  `ID_Strumento` int(20) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Marca` varchar(20) NOT NULL,
  `Modello` varchar(20) NOT NULL,
  `Tipologia` varchar(20) NOT NULL,
  `Nr_Unita_Possedute` int(20) NOT NULL,
  `Anno_Acquisto` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `dipendente`
--
ALTER TABLE `dipendente`
  ADD PRIMARY KEY (`ID_Dipendente`),
  ADD UNIQUE KEY `CF` (`CF`),
  ADD KEY `Mansione` (`Mansione`);

--
-- Indici per le tabelle `lista_utenti`
--
ALTER TABLE `lista_utenti`
  ADD PRIMARY KEY (`Matricola`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- Indici per le tabelle `mansione`
--
ALTER TABLE `mansione`
  ADD PRIMARY KEY (`ID_Dipendente`),
  ADD UNIQUE KEY `Direttore` (`Direttore`),
  ADD UNIQUE KEY `Dipendente` (`Dipendente`);

--
-- Indici per le tabelle `schedario`
--
ALTER TABLE `schedario`
  ADD KEY `ID_Dipendente` (`ID_Dipendente`),
  ADD KEY `ID_Spazio` (`ID_Spazio`),
  ADD KEY `ID_Strumento` (`ID_Strumento`);

--
-- Indici per le tabelle `spazio`
--
ALTER TABLE `spazio`
  ADD PRIMARY KEY (`ID_Spazio`);

--
-- Indici per le tabelle `strumentazione`
--
ALTER TABLE `strumentazione`
  ADD PRIMARY KEY (`ID_Strumento`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `dipendente`
--
ALTER TABLE `dipendente`
  ADD CONSTRAINT `dipendente_ibfk_1` FOREIGN KEY (`Mansione`) REFERENCES `mansione` (`Direttore`),
  ADD CONSTRAINT `dipendente_ibfk_2` FOREIGN KEY (`Mansione`) REFERENCES `mansione` (`Dipendente`);

--
-- Limiti per la tabella `mansione`
--
ALTER TABLE `mansione`
  ADD CONSTRAINT `mansione_ibfk_1` FOREIGN KEY (`ID_Dipendente`) REFERENCES `dipendente` (`ID_Dipendente`);

--
-- Limiti per la tabella `schedario`
--
ALTER TABLE `schedario`
  ADD CONSTRAINT `schedario_ibfk_1` FOREIGN KEY (`ID_Dipendente`) REFERENCES `dipendente` (`ID_Dipendente`),
  ADD CONSTRAINT `schedario_ibfk_2` FOREIGN KEY (`ID_Spazio`) REFERENCES `spazio` (`ID_Spazio`),
  ADD CONSTRAINT `schedario_ibfk_3` FOREIGN KEY (`ID_Strumento`) REFERENCES `strumentazione` (`ID_Strumento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
