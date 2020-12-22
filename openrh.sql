-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 21 déc. 2020 à 15:57
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `openrh`
--

-- --------------------------------------------------------

--
-- Structure de la table `absence`
--

DROP TABLE IF EXISTS `absence`;
CREATE TABLE IF NOT EXISTS `absence` (
  `mat_emp` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `date_absence` varchar(50) NOT NULL,
  `duree` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `affectation`
--

DROP TABLE IF EXISTS `affectation`;
CREATE TABLE IF NOT EXISTS `affectation` (
  `mat_emp` varchar(50) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `structure_anterieur` varchar(50) NOT NULL,
  `nouvelle_structure` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `affectation`
--

INSERT INTO `affectation` (`mat_emp`, `nom`, `prenom`, `structure_anterieur`, `nouvelle_structure`) VALUES
('Cottet', 'vx', 'wc', 'FINANCE ET GESTION', 'RH'),
('Cottet', 'vx', 'wc', 'FINANCE ET GESTION', 'RH');

-- --------------------------------------------------------

--
-- Structure de la table `ajoutemploye`
--

DROP TABLE IF EXISTS `ajoutemploye`;
CREATE TABLE IF NOT EXISTS `ajoutemploye` (
  `mat_emp` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `genre` varchar(50) NOT NULL,
  `date_naiss` varchar(50) NOT NULL,
  `photo` varchar(50) NOT NULL,
  `lieu_naiss` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `numero` int(11) NOT NULL,
  `situationMatri` varchar(50) NOT NULL,
  `poste` varchar(50) NOT NULL,
  `salaire` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ajoutemploye`
--

INSERT INTO `ajoutemploye` (`mat_emp`, `nom`, `prenom`, `genre`, `date_naiss`, `photo`, `lieu_naiss`, `email`, `numero`, `situationMatri`, `poste`, `salaire`) VALUES
('MHGxp', 'ydy', 'dggs', '1', '2020-12-01', '', 'dhd', 'hsgd@gmail.com', 75475553, '2', 'sdddsg', 2332424),
('46eVy', 'Cottet', 'Julien', '2', '2020-12-01', 'calque1.PNG', 'bdk', 'julien.cottet@gmail.com', 4344352, '2', 'Secrétaire', 12232332),
('xxuM7', 'ndndd', 'sddd', '1', '2020-12-01', 'android-love.png', 'sdvs', '', 23452244, '2', 'dqgdf', 123323424);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id_cat` int(11) NOT NULL,
  `lib_cat` varchar(50) NOT NULL,
  PRIMARY KEY (`id_cat`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id_cat`, `lib_cat`) VALUES
(1, 'Agent de maitrise');

-- --------------------------------------------------------

--
-- Structure de la table `demandeconge`
--

DROP TABLE IF EXISTS `demandeconge`;
CREATE TABLE IF NOT EXISTS `demandeconge` (
  `mat_emp` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date_depart` varchar(50) NOT NULL,
  `date_retour` varchar(50) NOT NULL,
  `piece_jointe` varchar(50) DEFAULT NULL,
  `type_conge` varchar(50) DEFAULT NULL,
  `motif` varchar(50) NOT NULL,
  `approbation` tinyint(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `demandepermission`
--

DROP TABLE IF EXISTS `demandepermission`;
CREATE TABLE IF NOT EXISTS `demandepermission` (
  `mat_emp` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date_depart` varchar(50) NOT NULL,
  `date_retour` varchar(50) NOT NULL,
  `motif` varchar(50) NOT NULL,
  `approbation` tinyint(1) DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `demandepermission`
--

INSERT INTO `demandepermission` (`mat_emp`, `nom`, `prenom`, `date_depart`, `date_retour`, `motif`, `approbation`) VALUES
('emp01', 'JEAN', 'membre', '2020-11-27', '2020-11-29', '', NULL),
('emp02', 'kouassi', 'Oumar', '2020-11-26', '2020-11-28', 'mission', NULL),
('emp03', 'membre', 'membre', '2020-11-27', '2020-11-28', 'maladie', 0),
('emp01', 'JEAN', 'Oumar', '2020-12-11', '2020-12-16', '', 0),
('gfsd', 'ssjdj', 'hqshjdf', '2020-12-16', '2020-12-17', 'dggd', 0),
('emp02', 'cgcgfgd', 'edevde', '2020-12-19', '2020-12-24', 'mission', 0);

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

DROP TABLE IF EXISTS `entreprise`;
CREATE TABLE IF NOT EXISTS `entreprise` (
  `nom_entreprise` varchar(50) NOT NULL,
  `adresse_entreprise` varchar(50) NOT NULL,
  `email_entreprise` varchar(225) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `entreprise`
--

INSERT INTO `entreprise` (`nom_entreprise`, `adresse_entreprise`, `email_entreprise`) VALUES
('OpenRH', 'Abidjan', 'openrh@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `first`
--

DROP TABLE IF EXISTS `first`;
CREATE TABLE IF NOT EXISTS `first` (
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `poste` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

DROP TABLE IF EXISTS `genre`;
CREATE TABLE IF NOT EXISTS `genre` (
  `id_genre` int(11) NOT NULL,
  `lib_genre` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `genre`
--

INSERT INTO `genre` (`id_genre`, `lib_genre`) VALUES
(2, 'feminin'),
(1, 'masculin');

-- --------------------------------------------------------

--
-- Structure de la table `groupeutilisateur`
--

DROP TABLE IF EXISTS `groupeutilisateur`;
CREATE TABLE IF NOT EXISTS `groupeutilisateur` (
  `id_grpUt` int(11) NOT NULL,
  `lib_grpUt` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupeutilisateur`
--

INSERT INTO `groupeutilisateur` (`id_grpUt`, `lib_grpUt`) VALUES
(1, 'ADMIN'),
(2, 'WAH');

-- --------------------------------------------------------

--
-- Structure de la table `mois`
--

DROP TABLE IF EXISTS `mois`;
CREATE TABLE IF NOT EXISTS `mois` (
  `id_mois` int(11) NOT NULL,
  `lib_mois` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `mois`
--

INSERT INTO `mois` (`id_mois`, `lib_mois`) VALUES
(1, 'Janvier'),
(2, 'Février'),
(3, 'Mars'),
(4, 'Avril'),
(5, 'Mai'),
(6, 'Juin'),
(7, 'Juillet'),
(8, 'Aout'),
(9, 'Septembre'),
(10, 'Octobre'),
(11, 'Novembre'),
(12, 'Décembre');

-- --------------------------------------------------------

--
-- Structure de la table `paie`
--

DROP TABLE IF EXISTS `paie`;
CREATE TABLE IF NOT EXISTS `paie` (
  `mat_emp` varchar(50) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `poste` varchar(50) NOT NULL,
  `mois` varchar(50) NOT NULL,
  `net_payer` int(11) NOT NULL,
  `salaire_base` int(11) NOT NULL,
  `sursalaire` int(11) NOT NULL,
  `prime_anciennete` int(11) DEFAULT NULL,
  `contri_nationale` int(11) NOT NULL,
  `impot_salaire` int(11) NOT NULL,
  `impot_revenu` int(11) NOT NULL,
  `cnps` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `paie`
--

INSERT INTO `paie` (`mat_emp`, `nom`, `prenom`, `poste`, `mois`, `net_payer`, `salaire_base`, `sursalaire`, `prime_anciennete`, `contri_nationale`, `impot_salaire`, `impot_revenu`, `cnps`) VALUES
('ydy', 'ERD', 'FG', 'VG', '1', 6777, 7666, 877899, 8787, 66776, 34456, 6679, 988),
('ndndd', '', '', 'TERE', '1', 13242414, 133224, 1312412, 12412443, 1212, 132133, 1242, 31234);

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

DROP TABLE IF EXISTS `pays`;
CREATE TABLE IF NOT EXISTS `pays` (
  `id_pays` int(11) NOT NULL,
  `lib_pays` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `presence`
--

DROP TABLE IF EXISTS `presence`;
CREATE TABLE IF NOT EXISTS `presence` (
  `mat_emp` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `heure_arrive` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `presence`
--

INSERT INTO `presence` (`mat_emp`, `nom`, `prenom`, `date`, `heure_arrive`) VALUES
('gdsh', 'dsjhf', 'tdsgd', '2020-12-21', '08:30');

-- --------------------------------------------------------

--
-- Structure de la table `rubrique`
--

DROP TABLE IF EXISTS `rubrique`;
CREATE TABLE IF NOT EXISTS `rubrique` (
  `id_rub` int(11) NOT NULL,
  `lib_rub` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rubrique`
--

INSERT INTO `rubrique` (`id_rub`, `lib_rub`) VALUES
(1, 'salaire de base'),
(2, 'sursalaire'),
(3, 'contribution nationale'),
(4, 'NET A PAYER');

-- --------------------------------------------------------

--
-- Structure de la table `secteur`
--

DROP TABLE IF EXISTS `secteur`;
CREATE TABLE IF NOT EXISTS `secteur` (
  `id_sect` int(11) NOT NULL,
  `lib_sect` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `secteur`
--

INSERT INTO `secteur` (`id_sect`, `lib_sect`) VALUES
(1, 'comptabilité');

-- --------------------------------------------------------

--
-- Structure de la table `situationmatri`
--

DROP TABLE IF EXISTS `situationmatri`;
CREATE TABLE IF NOT EXISTS `situationmatri` (
  `id_sit` int(11) NOT NULL,
  `lib_sit` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `situationmatri`
--

INSERT INTO `situationmatri` (`id_sit`, `lib_sit`) VALUES
(2, 'célibataire');

-- --------------------------------------------------------

--
-- Structure de la table `structure`
--

DROP TABLE IF EXISTS `structure`;
CREATE TABLE IF NOT EXISTS `structure` (
  `cod_struct` int(11) NOT NULL,
  `lib_struct` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `structure`
--

INSERT INTO `structure` (`cod_struct`, `lib_struct`) VALUES
(1, 'RH'),
(2, 'FINANCE ET GESTION'),
(3, 'INFORMATION ET COMMUNICATION');

-- --------------------------------------------------------

--
-- Structure de la table `typecontrat`
--

DROP TABLE IF EXISTS `typecontrat`;
CREATE TABLE IF NOT EXISTS `typecontrat` (
  `id_type_contrat` int(11) NOT NULL,
  `lib_contrat` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typecontrat`
--

INSERT INTO `typecontrat` (`id_type_contrat`, `lib_contrat`) VALUES
(1, 'CDI');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `matricule` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`matricule`, `password`) VALUES
('MHGxp', 'user'),
('46eVy', 'user'),
('xxuM7', 'user'),
('Cy36u', 'user');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `groupe_util` varchar(50) NOT NULL,
  `matricule` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  KEY `clee` (`groupe_util`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`groupe_util`, `matricule`, `password`) VALUES
('admin', 'admin', 'admin');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
