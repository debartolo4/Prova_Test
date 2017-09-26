-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Apr 10, 2017 alle 11:59
-- Versione del server: 10.1.21-MariaDB
-- Versione PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Struttura della tabella `listautenti`
--

CREATE TABLE `listautenti` (
  `matricola` int(10) UNSIGNED NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `listautenti`
--

INSERT INTO `listautenti` (`matricola`, `username`, `password`, `admin`) VALUES
(640154, 'utente1', 'password1', 1),
(640254, 'utente2', 'password2', 0),
(640354, 'user3', 'password3', 1),
(640454, 'user4', 'password4', 0),
(640554, 'user5', 'password5', 1),
(640654, 'user6', 'password6', 1),
(640754, 'user7', 'password7', 0),
(640854, 'user8', 'password8', 1),
(640954, 'user9', 'password9', 1),
(641054, 'user10', 'password10', 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `mydipendente`
--

CREATE TABLE `mydipendente` (
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `Sesso` char(1) NOT NULL,
  `Data_di_nascita` date NOT NULL,
  `Mail` varchar(50) NOT NULL,
  `Telefono` varchar(14) NOT NULL,
  `Domicilio` varchar(50) NOT NULL,
  `Mansione` varchar(20) NOT NULL,
  `ID_Dipendente` int(20) NOT NULL,
  `CF` char(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dump dei dati per la tabella `mydipendente`
--

INSERT INTO `mydipendente` (`Nome`, `Cognome`, `Sesso`, `Data_di_nascita`, `Mail`, `Telefono`, `Domicilio`, `Mansione`, `ID_Dipendente`, `CF`) VALUES
('utente', '2', 'M', '2017-03-01', 'utente2@gmail.com', '+39 080530001', 'via le mani dagli occhi 2', 'impiegato', 2, 'tnt2'),
('utente', '3', 'M', '2017-04-20', 'utente3@gmail.com', '+39 0805300002', 'via le mani dagli occhi 3', 'spazzino', 3, 'tnt3'),
('utente', '5', 'M', '2017-02-27', 'utente5@gmail.com', '+39 0805300005', 'via le mani dagli occhi 5', 'tecnico', 5, 'tnt5'),
('utente ', '6', 'M', '2017-01-24', 'utente6@gmail.com', '+39 0805300006', 'via le mani dagli occhi 6', 'amministratore', 6, 'tnt6'),
('utente', '7', 'M', '2017-02-20', 'utente7@gmail.com', '+39 0805300007', 'via le mani dagli occhi 7', 'socio', 7, 'tnt7'),
('utente', '8', 'M', '2017-03-17', 'utente8@gmail.com', '+39 0805300008', 'via le mani dagli occhi 8', 'tecnico ', 8, 'tnt8'),
('utente', '9', 'M', '2017-03-01', 'utente9@gmail.com', '+39 0805300009', 'via le mani dagli occhi 9', 'sviluppatore', 9, 'tnt9'),
('utente', '10', 'F', '2017-03-01', 'utente10@gmail.com', '+39 0805300010', 'via le mani dagli occhi 10 ', 'segretaria', 10, 'tnt10'),
('Michele', 'Di Pede', 'M', '1993-09-05', 'michele@gmail.com', '+39 0803758501', 'Bitonto', 'Amministratore', 64, 'tnt64'),
('Preso', 'Malissimo', 'M', '1995-08-28', 'presomale@gmail.com', '+39 telefon', 'Bitonto', 'cantante', 116645, 'CFpreso'),
('prova', 'prova', 'M', '1990-09-09', 'prova@gmail.com', 'prova', 'prova', 'prova', 123456, 'prova');

-- --------------------------------------------------------

--
-- Struttura della tabella `myschedario`
--

CREATE TABLE `myschedario` (
  `ID_Dipendente` int(20) NOT NULL,
  `ID_Spazio` int(20) NOT NULL,
  `ID_Strumento` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `myschedario`
--

INSERT INTO `myschedario` (`ID_Dipendente`, `ID_Spazio`, `ID_Strumento`) VALUES
(2, 1, 2),
(3, 1, 2),
(5, 1, 2),
(6, 1, 2),
(10, 1, 2),
(64, 1, 2),
(116645, 1, 2),
(123456, 1, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `myspazio`
--

CREATE TABLE `myspazio` (
  `ID_Spazio` int(20) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Descrizione` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dump dei dati per la tabella `myspazio`
--

INSERT INTO `myspazio` (`ID_Spazio`, `Nome`, `Descrizione`) VALUES
(1, 'Reception', 'Spazio dedicato all\'accoglienza del cliente\r\n'),
(3, 'Area Relax 12', 'Area dove i dipendenti posso svagarsi qualche minuto,dire alla patty che è un cesso e prendere un caffè'),
(4, 'Ufficio 1', 'Ufficio per il dipendente 1,organizzato per il suo lavoro.'),
(5, 'Ufficio 2', 'Ufficio per il dipendente 2,organizzato per il suo lavoro.'),
(6, 'Ufficio 3', 'Ufficio per il dipendente 3,organizzato per il suo lavoro.'),
(7, 'Ufficio 4', 'Ufficio per il dipendente 4,organizzato per il suo lavoro.'),
(8, 'Bagno Donne', 'bagno per  il personale donna\r\n'),
(9, 'Bagno Uomini', 'Bagno per il personale uomo'),
(10, 'Bagno Handicap', 'Bagno per portatori di Handicap');

-- --------------------------------------------------------

--
-- Struttura della tabella `mystrumentazione`
--

CREATE TABLE `mystrumentazione` (
  `ID_Strumento` int(20) NOT NULL,
  `Marca` varchar(30) NOT NULL,
  `Modello` varchar(30) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Tipologia` varchar(30) NOT NULL,
  `NrUnitaPossedute` int(20) NOT NULL,
  `AnnoAcquisto` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dump dei dati per la tabella `mystrumentazione`
--

INSERT INTO `mystrumentazione` (`ID_Strumento`, `Marca`, `Modello`, `Nome`, `Tipologia`, `NrUnitaPossedute`, `AnnoAcquisto`) VALUES
(2, 'Samsung', 'S7', 'Samsung Galaxy S7', 'Telefono', 10, '2017-03-01'),
(3, 'HP', 'Deskjet 3720', 'All-in-One', 'Stampante', 5, '2017-01-12'),
(4, 'Ikea', '745638', 'OfficeDesk', 'Scrivania', 25, '2017-03-01'),
(5, 'Ikea', '777', 'DarkPoloChair', 'Sedia', 25, '2017-03-01'),
(6, 'Infostrada', 'zz-x50', 'Modemxx50', 'Modem/Router', 5, '2017-03-10'),
(7, 'Volkswagen', 'Polo', 'Volkswagen Polo', 'Auto Aziendale', 15, '2017-03-15'),
(8, 'Breakline', 'Necta Brio 3', 'Breakline Brio 3', 'Distributore automa', 2, '2017-03-01'),
(121212, 'GGD', 'sdsd', 'dfdf', 'sdsd', 20, '1990-02-02');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `listautenti`
--
ALTER TABLE `listautenti`
  ADD PRIMARY KEY (`matricola`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indici per le tabelle `mydipendente`
--
ALTER TABLE `mydipendente`
  ADD PRIMARY KEY (`ID_Dipendente`),
  ADD UNIQUE KEY `CF` (`CF`);

--
-- Indici per le tabelle `myspazio`
--
ALTER TABLE `myspazio`
  ADD PRIMARY KEY (`ID_Spazio`),
  ADD UNIQUE KEY `ID` (`ID_Spazio`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
