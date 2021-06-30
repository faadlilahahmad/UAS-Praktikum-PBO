-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.6-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for oop_game
CREATE DATABASE IF NOT EXISTS `oop_game` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `oop_game`;

-- Dumping structure for table oop_game.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table oop_game.admin: ~0 rows (approximately)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
REPLACE INTO `admin` (`username`, `password`) VALUES
	('admin', 'admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Dumping structure for table oop_game.game
CREATE TABLE IF NOT EXISTS `game` (
  `id_game` int(11) NOT NULL AUTO_INCREMENT,
  `judul` varchar(30) DEFAULT NULL,
  `genre` varchar(15) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_game`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Dumping data for table oop_game.game: ~13 rows (approximately)
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
REPLACE INTO `game` (`id_game`, `judul`, `genre`, `harga`) VALUES
	(1, 'Need For Speed Heat', 'Racing', 400000),
	(2, 'God Of War', 'Adventure', 350000),
	(3, 'GTA V', 'Open World', 300000),
	(4, 'Horizon Zero Dawn', 'RPG', 300000),
	(5, 'The Witcher 3', 'RPG', 350000),
	(6, 'Sword Art Online', 'RPG', 200000),
	(7, 'The Witcher 3 GOTY', 'RPG', 450000),
	(8, 'Final Fantasy 7', 'RPG', 650000),
	(10, 'Spiderman', 'Adventure', 250000),
	(11, 'Red Dead Redemption 2', 'Open World', 350000),
	(12, 'Resident Evil 3', 'Horror', 450000),
	(13, 'Death Stranding', 'Open World', 450000),
	(14, 'The Last Of Us', 'Adventure', 750000),
	(15, 'FIFA 20', 'Sport', 550000);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;

-- Dumping structure for table oop_game.pembeli
CREATE TABLE IF NOT EXISTS `pembeli` (
  `id_pembeli` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(8) DEFAULT NULL,
  `password` varchar(8) DEFAULT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `no_hp` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id_pembeli`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Dumping data for table oop_game.pembeli: ~5 rows (approximately)
/*!40000 ALTER TABLE `pembeli` DISABLE KEYS */;
REPLACE INTO `pembeli` (`id_pembeli`, `username`, `password`, `nama`, `alamat`, `email`, `no_hp`) VALUES
	(1, 'Swizzle', '123', 'Rangga', 'Karawang', 'xrd027@gmail.com', '081299732900'),
	(2, 'Llen', '124', 'Raehan', 'Tokyo', 'raehandoko@gmail.com', '081299734224'),
	(3, 'xrd', '123', 'Sasuke', 'Konoha', 'saske@yahoo.com', '085281920395'),
	(7, 'tifa', '123', 'Tifa Lockhart', 'Midgar', 'tf@gmail.com', '082929392334'),
	(10, 'aerith', '123', 'Aerith', 'Planet', 'aer@gmail.com', '08291992033');
/*!40000 ALTER TABLE `pembeli` ENABLE KEYS */;

-- Dumping structure for table oop_game.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id_supplier` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(30) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `no_hp` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id_supplier`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table oop_game.supplier: ~1 rows (approximately)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
REPLACE INTO `supplier` (`id_supplier`, `nama`, `alamat`, `email`, `no_hp`) VALUES
	(1, 'Playstation', 'ASIA', 'psn@gmail.co.id', '082291028494');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;

-- Dumping structure for table oop_game.transaksi
CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `tgl_transaksi` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_game` int(11) DEFAULT NULL,
  `id_pembeli` int(11) DEFAULT NULL,
  `id_supplier` int(11) DEFAULT 1,
  PRIMARY KEY (`id_transaksi`),
  KEY `FK_transaksi_game` (`id_game`),
  KEY `FK_transaksi_pembeli` (`id_pembeli`),
  KEY `FK_transaksi_supplier` (`id_supplier`),
  CONSTRAINT `FK_transaksi_game` FOREIGN KEY (`id_game`) REFERENCES `game` (`id_game`),
  CONSTRAINT `FK_transaksi_pembeli` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id_pembeli`),
  CONSTRAINT `FK_transaksi_supplier` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table oop_game.transaksi: ~5 rows (approximately)
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
REPLACE INTO `transaksi` (`id_transaksi`, `tgl_transaksi`, `id_game`, `id_pembeli`, `id_supplier`) VALUES
	(1, '2020-07-08', 4, 7, 1),
	(2, '2020-07-02', 2, 1, 1),
	(3, '2020-07-09', 3, 2, 1),
	(5, '2020-07-09', 8, 10, 1),
	(6, '2020-07-09', 1, 3, 1),
	(7, '2020-07-10', 2, 10, 1);
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
