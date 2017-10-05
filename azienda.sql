-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Ott 05, 2017 alle 13:29
-- Versione del server: 10.1.26-MariaDB
-- Versione PHP: 7.1.9

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
  `Sesso` char(1) NOT NULL,
  `Data_di_Nascita` date NOT NULL,
  `Mail` varchar(50) NOT NULL,
  `Telefono` varchar(14) NOT NULL,
  `Domicilio` varchar(50) NOT NULL,
  `Mansione` tinyint(4) NOT NULL,
  `ID_Dipendente` int(20) NOT NULL,
  `CF` char(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `dipendente`
--

INSERT INTO `dipendente` (`Nome`, `Cognome`, `Sesso`, `Data_di_Nascita`, `Mail`, `Telefono`, `Domicilio`, `Mansione`, `ID_Dipendente`, `CF`) VALUES
('Gianluca', 'de Bartolo', 'M', '1996-07-03', 'laraza37@hotmail.it', '3314545355', 'Contrada Rossi, 4', 4, 630999, 'DBRGLC95L03H926G'),
('Davide', 'De Pasquale', 'M', '1994-07-08', 'dav@gmail.com', '+393314545455', 'Piazza Aldo Moro, 2/B', 1, 634444, 'DPSDVD94L09H926B');

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

--
-- Dump dei dati per la tabella `lista_utenti`
--

INSERT INTO `lista_utenti` (`Matricola`, `Username`, `Password`, `Admin`) VALUES
(123456, 'Username1', 'Password1', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `mansione`
--

CREATE TABLE `mansione` (
  `Cod_Mansione` tinyint(4) NOT NULL,
  `Direttore` tinyint(1) NOT NULL,
  `Dipendente` tinyint(1) NOT NULL,
  `Collaboratore` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `mansione`
--

INSERT INTO `mansione` (`Cod_Mansione`, `Direttore`, `Dipendente`, `Collaboratore`) VALUES
(1, 0, 0, 1),
(2, 0, 1, 0),
(3, 0, 1, 1),
(4, 1, 0, 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `schedario`
--

CREATE TABLE `schedario` (
  `ID_Dipendente` int(20) NOT NULL,
  `ID_Spazio` int(20) NOT NULL,
  `ID_Strumento` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `schedario`
--

INSERT INTO `schedario` (`ID_Dipendente`, `ID_Spazio`, `ID_Strumento`) VALUES
(634444, 987676, 123000),
(630999, 987676, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `spazio`
--

CREATE TABLE `spazio` (
  `ID_Spazio` int(20) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Descrizione` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `spazio`
--

INSERT INTO `spazio` (`ID_Spazio`, `Nome`, `Descrizione`) VALUES
(656700, 'Ufficio 1', 'Uno spazio in cui un dipendente lavora.'),
(987676, 'Area Relax', 'Uno spazio in cui un dipendente può rifocillarsi.');

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
-- Dump dei dati per la tabella `strumentazione`
--

INSERT INTO `strumentazione` (`ID_Strumento`, `Nome`, `Marca`, `Modello`, `Tipologia`, `Nr_Unita_Possedute`, `Anno_Acquisto`) VALUES
(2, 'Smartphone', 'Nokia', 'Lumia0009', 'Telefonia', 10, '2012-05-04'),
(100001, 'Smartphone', 'Samsung', 'J5 2012', 'Telefonia', 5, '2012-05-03'),
(123000, 'Computer', 'Acer', 'X9980', 'Informatica', 19, '2017-12-31');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `dipendente`
--
ALTER TABLE `dipendente`
  ADD PRIMARY KEY (`ID_Dipendente`),
  ADD UNIQUE KEY `CF` (`CF`),
  ADD KEY `foreign_task` (`Mansione`);

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
  ADD PRIMARY KEY (`Cod_Mansione`),
  ADD UNIQUE KEY `Cod_Mansione` (`Cod_Mansione`);

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
  ADD CONSTRAINT `foreign_task` FOREIGN KEY (`Mansione`) REFERENCES `mansione` (`Cod_Mansione`);

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
