-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.24 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para db_agenda
CREATE DATABASE IF NOT EXISTS `db_agenda` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_agenda`;

-- Volcando estructura para tabla db_agenda.contactos
CREATE TABLE IF NOT EXISTS `contactos` (
  `idContacto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `edad` int DEFAULT NULL,
  `fechaNacimiento` date NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` int NOT NULL,
  PRIMARY KEY (`idContacto`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla db_agenda.contactos: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` (`idContacto`, `nombre`, `apellido`, `edad`, `fechaNacimiento`, `email`, `telefono`) VALUES
	(1, 'matias', 'perez', 46, '1995-06-07', 'contacto1@gmail.com', 45698740),
	(4, 'paula', 'torres', 67, '1995-07-06', 'analiat@gmail.com', 65347890),
	(6, 'matias', 'pereira', 32, '1992-06-28', 'contactos@gmail.com', 85476312),
	(7, 'natalia', 'diaz', 45, '2000-10-26', 'diaz@gmail.com', 20169034),
	(9, 'pablo', 'sarmiento', 14, '1976-06-24', 'juan@gmail.com', 1578420390),
	(11, 'lautaro', 'romano', 23, '2000-02-06', 'lautaror@gmail.com', 1547963210),
	(12, 'samanta', 'ceballos', 56, '1925-03-31', 'samantac@gmail.com', 32479651),
	(13, 'laura', 'moron', 32, '2005-09-13', 'laurai�igez@gmail.com', 1520221450);
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
