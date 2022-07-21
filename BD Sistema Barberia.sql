-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-11-2021 a las 23:44:30
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mqw9x0qo2x`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sumaBonos` (IN `idEmpleado` INT, IN `periodo` VARCHAR(7))  SELECT SUM(Valor) FROM bonosempleadomensual WHERE bonosempleadomensual.IDEmpleado = idEmpleado AND bonosempleadomensual.Periodo = periodo$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sumaDeducciones` (IN `idEmpleado` INT, IN `periodo` VARCHAR(7))  SELECT SUM(Valor) FROM deduccionesempleadomensual WHERE deduccionesempleadomensual.IDEmpleado = idEmpleado AND deduccionesempleadomensual.Periodo = periodo$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bonosempleadomensual`
--

CREATE TABLE `bonosempleadomensual` (
  `numbono` int(11) NOT NULL,
  `IDEmpleado` int(11) NOT NULL,
  `IDTipoBono` int(11) NOT NULL,
  `Valor` double(7,2) UNSIGNED NOT NULL,
  `Periodo` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `bonosempleadomensual`
--

INSERT INTO `bonosempleadomensual` (`numbono`, `IDEmpleado`, `IDTipoBono`, `Valor`, `Periodo`, `Activo`) VALUES
(1, 9, 1, 1200.00, '202108', 1),
(2, 2, 1, 2000.00, '202110', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idcliente` int(11) NOT NULL,
  `IDTipoDocumento` int(11) NOT NULL,
  `NumDocumento` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `IDServicio` int(11) NOT NULL,
  `NomCliente` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `ApeCliente` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `NumTelefono` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idcliente`, `IDTipoDocumento`, `NumDocumento`, `IDServicio`, `NomCliente`, `ApeCliente`, `NumTelefono`, `FechaNacimiento`, `Activo`) VALUES
(0, 2, '9999999999999', 1, 'CONSUMIDOR', 'FINAL', '99999999', '0000-00-00', 0),
(1, 1, '0801200120793', 2, 'Jonathan Joels', 'Escobar Santamaria', '99102345', '2000-07-24', 1),
(3, 1, '0801200098765', 1, 'Luis Miguel', 'Sanchez Lopez', '99897867', '2000-08-02', 1),
(4, 1, '0801200009098', 2, 'Oscar Gabriel', 'Escobar Santamaria', '33456789', '2000-08-12', 0),
(5, 1, '0801199909876', 1, 'Hector Rafa', 'Marquez Cuello', '33456789', '1999-01-12', 1),
(6, 2, '0801200076544', 2, 'Mario Roberto', 'Perez Moreira', '34567890', '2000-10-10', 1),
(8, 2, '0801199098909', 2, 'Felix Andres', 'Sanchez Gomez', '99876534', '1990-10-10', 1),
(9, 1, '0801200023213', 2, 'Milton Josue', 'Hernandez Vega', '32435465', '2000-08-21', 1),
(10, 1, '0801200009292', 1, 'Marco Aurelio', 'Mendoza', '98976655', '2000-08-21', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datosempresa`
--

CREATE TABLE `datosempresa` (
  `iddato` int(11) NOT NULL,
  `Nombre` varchar(15) NOT NULL,
  `Valor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `datosempresa`
--

INSERT INTO `datosempresa` (`iddato`, `Nombre`, `Valor`) VALUES
(1, 'Nombre Empresa', 'Barbería Izcano'),
(2, 'RTN', '050120105455432'),
(3, 'Telefono', '22362145'),
(4, 'Direccion', 'Bellavista Av. Juan Pablo II'),
(5, 'NumFactura', '000-001-01-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deduccionesempleadomensual`
--

CREATE TABLE `deduccionesempleadomensual` (
  `numdeduccion` int(11) NOT NULL,
  `IDEmpleado` int(11) NOT NULL,
  `IDTipoDeduccion` int(11) NOT NULL,
  `Valor` double(6,2) NOT NULL,
  `Periodo` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `deduccionesempleadomensual`
--

INSERT INTO `deduccionesempleadomensual` (`numdeduccion`, `IDEmpleado`, `IDTipoDeduccion`, `Valor`, `Periodo`, `Activo`) VALUES
(43, 3, 1, 2000.00, '202108', 1),
(44, 6, 1, 3000.00, '202110', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuentofactura`
--

CREATE TABLE `descuentofactura` (
  `numdescuento` int(11) NOT NULL,
  `IDFactura` int(8) NOT NULL,
  `IDDescuento` int(11) NOT NULL,
  `Valor` double(3,2) NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuentos`
--

CREATE TABLE `descuentos` (
  `iddescuento` int(11) NOT NULL,
  `IDTipoDescuento` int(11) NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFinal` date DEFAULT NULL,
  `Valor` double(4,2) NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `descuentos`
--

INSERT INTO `descuentos` (`iddescuento`, `IDTipoDescuento`, `FechaInicio`, `FechaFinal`, `Valor`, `Activo`) VALUES
(1, 1, '2021-07-21', '2021-08-20', 0.12, 0),
(2, 2, '2021-07-21', NULL, 0.15, 1),
(3, 3, '2021-08-21', '2021-08-20', 0.15, 0),
(4, 3, '2021-08-21', NULL, 0.12, 1),
(5, 1, '2021-08-21', NULL, 0.15, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleproducto`
--

CREATE TABLE `detalleproducto` (
  `numdetalle` int(11) NOT NULL,
  `IDFacturaEncabezado` int(8) NOT NULL,
  `IDProducto` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Precio` double(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalleproducto`
--

INSERT INTO `detalleproducto` (`numdetalle`, `IDFacturaEncabezado`, `IDProducto`, `Cantidad`, `Precio`) VALUES
(2, 1, 4, 2, 150.35),
(3, 2, 2, 1, 24.00),
(4, 3, 4, 2, 150.35),
(5, 4, 4, 3, 150.35),
(6, 4, 3, 1, 20.00),
(7, 5, 1, 1, 120.00),
(8, 5, 4, 1, 150.35),
(9, 6, 1, 1, 120.00),
(10, 6, 4, 1, 150.35),
(11, 11, 4, 1, 150.35),
(12, 12, 4, 1, 150.35),
(13, 13, 4, 1, 150.35),
(14, 52, 4, 2, 150.35),
(15, 54, 1, 1, 120.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleservicio`
--

CREATE TABLE `detalleservicio` (
  `numdetalleservicio` int(11) NOT NULL,
  `IDFacturaEncabezado` int(8) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `IDServicio` int(11) NOT NULL,
  `Precio` double(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalleservicio`
--

INSERT INTO `detalleservicio` (`numdetalleservicio`, `IDFacturaEncabezado`, `Cantidad`, `IDServicio`, `Precio`) VALUES
(1, 51, 1, 3, 120.00),
(2, 52, 1, 1, 80.00),
(3, 53, 1, 2, 50.00),
(4, 101, 1, 1, 80.00),
(8, 1, 1, 1, 120.00),
(9, 1, 1, 1, 120.00),
(10, 1, 1, 1, 120.00),
(11, 1, 1, 1, 120.00),
(12, 1, 1, 1, 120.00),
(13, 1, 1, 1, 120.00),
(14, 1, 1, 1, 120.00),
(15, 1, 1, 1, 120.00),
(16, 1, 1, 1, 120.00),
(17, 1, 1, 1, 120.00),
(18, 1, 1, 1, 120.00),
(19, 1, 1, 1, 120.00),
(20, 1, 1, 1, 120.00),
(21, 1, 1, 1, 120.00),
(22, 1, 1, 1, 120.00),
(23, 1, 1, 1, 120.00),
(24, 1, 1, 1, 120.00),
(25, 1, 1, 1, 120.00),
(26, 1, 1, 1, 120.00),
(27, 1, 1, 1, 120.00),
(28, 1, 1, 1, 120.00),
(29, 1, 1, 1, 120.00),
(30, 1, 1, 1, 120.00),
(31, 1, 1, 1, 120.00),
(32, 1, 1, 1, 120.00),
(33, 1, 1, 1, 120.00),
(34, 1, 1, 1, 120.00),
(35, 1, 1, 1, 120.00),
(36, 1, 1, 1, 120.00),
(37, 1, 1, 1, 120.00),
(38, 1, 1, 1, 120.00),
(39, 1, 1, 1, 120.00),
(40, 1, 1, 1, 120.00),
(41, 1, 1, 1, 120.00),
(42, 1, 1, 1, 120.00),
(43, 1, 1, 1, 120.00),
(44, 1, 1, 1, 120.00),
(45, 1, 1, 1, 120.00),
(46, 1, 1, 1, 120.00),
(47, 1, 1, 1, 120.00),
(48, 1, 1, 1, 120.00),
(49, 1, 1, 1, 120.00),
(50, 1, 1, 1, 120.00),
(51, 1, 1, 1, 120.00),
(52, 1, 1, 1, 120.00),
(53, 1, 1, 1, 120.00),
(54, 1, 1, 1, 120.00),
(55, 1, 1, 1, 120.00),
(56, 1, 1, 1, 120.00),
(57, 1, 1, 1, 120.00),
(58, 1, 1, 1, 120.00),
(59, 1, 1, 1, 120.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idempleado` int(11) NOT NULL,
  `IDTipoDocumento` int(11) NOT NULL,
  `NumDoc` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `NomEmpleado` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `ApeEmpleado` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `GenEmpleado` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `NumCelular` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFinal` date DEFAULT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idempleado`, `IDTipoDocumento`, `NumDoc`, `NomEmpleado`, `ApeEmpleado`, `FechaNacimiento`, `GenEmpleado`, `Direccion`, `NumCelular`, `FechaInicio`, `FechaFinal`, `Activo`) VALUES
(1, 2, '0801200120793', 'Jonathan Joel', 'Laux Brizo', '2000-07-22', 'M', 'Colonia La Esperanza', '32041674', '2021-07-22', NULL, 1),
(2, 2, '0801200034567', 'Saroni Daniela', 'Laux Brizo', '2000-08-11', 'F', 'Colonia San Miguel', '32042654', '2021-07-22', NULL, 1),
(3, 2, '0801198023456', 'Milson Joel', 'Laux Messi', '1980-07-03', 'M', 'Colonia 23 de Marzo', '99107648', '2021-07-24', NULL, 1),
(4, 2, '0801198923445', 'Fatima Claudeth', 'Brizo Triminio', '1989-11-11', 'F', 'Colonia La travesia', '99897865', '2021-07-27', NULL, 1),
(5, 1, 'ZAB000254', 'Alex Steve', 'Smith Johnson', '1999-08-10', 'M', 'Colonia los almendros al frente de pollo chilenos, en el bulevar morazan.', '33456789', '2021-08-02', NULL, 1),
(6, 2, '0801200098765', 'Jonathan Javier', 'Laux', '2000-03-01', 'F', 'Colonia La esperanza', '33976544', '2021-08-19', NULL, 1),
(7, 2, '0801200034435', 'Susana Yanino', 'Lopez', '2000-02-22', 'M', 'Colonia San Miguel', '99876565', '2021-08-23', NULL, 1),
(8, 2, '0801200009876', 'Susana', 'Lopez', '2000-10-10', 'F', 'Direecionm de cassa', '33984567', '2021-10-20', NULL, 1),
(9, 3, '080120008787', 'Andrea ', 'Ramirez', '2000-10-19', 'F', 'Direccion de casa', '33456789', '2021-10-20', NULL, 1),
(44, 1, '123456789012', 'Nombre', 'apellido', '2021-10-12', 'M', 'Direccion', '12345678', '2021-10-12', NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadofactura`
--

CREATE TABLE `estadofactura` (
  `idestado` int(11) NOT NULL,
  `NombreEstado` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `estadofactura`
--

INSERT INTO `estadofactura` (`idestado`, `NombreEstado`, `Activo`) VALUES
(1, 'Pagada', 1),
(2, 'Anulada', 1),
(3, 'CAI vencido', 1),
(5, 'Estado', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturaencabezado`
--

CREATE TABLE `facturaencabezado` (
  `idfacturaencabezado` int(8) NOT NULL,
  `NumFactura` varchar(20) DEFAULT NULL,
  `IDCliente` int(11) NOT NULL,
  `IDVendedor` int(11) NOT NULL,
  `IDBarbero` int(11) DEFAULT NULL,
  `IDTipoPago` int(11) NOT NULL,
  `IDParametro` int(11) NOT NULL,
  `IDEstado` int(11) NOT NULL,
  `FechaFactura` datetime NOT NULL,
  `NumTarjeta` varchar(20) DEFAULT NULL,
  `MontoTarjeta` double DEFAULT NULL,
  `TotalFactura` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `facturaencabezado`
--

INSERT INTO `facturaencabezado` (`idfacturaencabezado`, `NumFactura`, `IDCliente`, `IDVendedor`, `IDBarbero`, `IDTipoPago`, `IDParametro`, `IDEstado`, `FechaFactura`, `NumTarjeta`, `MontoTarjeta`, `TotalFactura`) VALUES
(1, NULL, 0, 1, NULL, 1, 1, 1, '2021-09-17 18:02:59', NULL, 0, 345.81),
(2, NULL, 0, 1, NULL, 1, 1, 1, '2021-09-22 16:31:50', NULL, 0, 27.6),
(3, NULL, 0, 1, NULL, 1, 1, 1, '2021-09-23 14:15:16', NULL, 0, 345.81),
(4, NULL, 0, 1, NULL, 1, 1, 1, '2021-09-23 14:15:16', NULL, 0, 541.71),
(5, NULL, 0, 1, NULL, 1, 1, 1, '2021-09-23 14:32:38', NULL, 0, 310.9),
(6, NULL, 0, 1, NULL, 1, 1, 1, '2021-09-23 14:36:37', NULL, 0, 310.9),
(7, NULL, 0, 1, NULL, 1, 2, 3, '2021-09-23 23:00:36', NULL, 0, 0),
(8, NULL, 0, 1, NULL, 1, 2, 3, '2021-09-23 23:00:36', NULL, 0, 0),
(9, NULL, 0, 1, NULL, 1, 2, 3, '2021-09-23 23:00:36', NULL, 0, 0),
(10, NULL, 0, 1, NULL, 1, 2, 3, '2021-09-23 23:00:36', NULL, 0, 0),
(11, NULL, 0, 1, NULL, 1, 2, 1, '2021-09-24 10:06:23', NULL, 0, 172.9),
(12, NULL, 0, 1, NULL, 1, 2, 1, '2021-09-24 13:51:57', NULL, 0, 172.9),
(13, NULL, 0, 1, NULL, 1, 2, 1, '2021-09-27 15:10:56', NULL, 0, 172.9),
(14, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(15, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(16, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(17, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(18, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(19, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(20, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(21, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(22, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(23, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(24, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(25, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(26, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(27, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(28, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(29, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(30, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(31, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(32, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(33, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(34, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(35, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(36, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(37, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(38, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(39, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(40, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(41, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(42, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(43, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(44, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(45, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(46, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(47, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(48, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(49, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(50, NULL, 0, 1, NULL, 1, 3, 3, '2021-10-03 19:00:56', NULL, 0, 0),
(51, NULL, 1, 1, 5, 1, 3, 1, '2021-10-03 19:06:14', NULL, 0, 138),
(52, NULL, 3, 1, 6, 1, 3, 1, '2021-10-04 16:28:00', NULL, 0, 437.81),
(53, NULL, 4, 1, 5, 1, 3, 1, '2021-10-12 17:30:08', NULL, 0, 57.5),
(54, NULL, 0, 1, NULL, 2, 3, 1, '2021-10-12 17:30:08', '349729667802049', 138, 138),
(55, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(56, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(57, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(58, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(59, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(60, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(61, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(62, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(63, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(64, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(65, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(66, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(67, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(68, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(69, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(70, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(71, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(72, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(73, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(74, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(75, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(76, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(77, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(78, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(79, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(80, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(81, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(82, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(83, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(84, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(85, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(86, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(87, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(88, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(89, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(90, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(91, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(92, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(93, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(94, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(95, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(96, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(97, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(98, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(99, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(100, NULL, 0, 1, NULL, 1, 4, 3, '2021-10-12 17:34:20', NULL, 0, 0),
(101, NULL, 3, 1, 5, 2, 4, 1, '2021-10-12 20:49:23', '375987654321001', 92, 92),
(102, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(103, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(104, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(105, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(106, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(107, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(108, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(109, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(110, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(111, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(112, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(113, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(114, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(115, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(116, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(117, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(118, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(119, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(120, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(121, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(122, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(123, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(124, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(125, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(126, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(127, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(128, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(129, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(130, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(131, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(132, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(133, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(134, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(135, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(136, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(137, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(138, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(139, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(140, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(141, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(142, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(143, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(144, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(145, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(146, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(147, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(148, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(149, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(150, NULL, 0, 1, NULL, 1, 5, 3, '2021-10-12 20:55:41', NULL, 0, 0),
(203, 'numero', 0, 1, 1, 1, 5, 1, '2021-10-21 21:09:04', '1234567891234567', 12, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturasanuladas`
--

CREATE TABLE `facturasanuladas` (
  `idfacturaanulada` int(11) NOT NULL,
  `IDFacturaEncabezado` int(10) NOT NULL,
  `IDEmpleado` int(11) DEFAULT NULL,
  `Motivo` varchar(50) NOT NULL,
  `FechaAnulacion` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `facturasanuladas`
--

INSERT INTO `facturasanuladas` (`idfacturaanulada`, `IDFacturaEncabezado`, `IDEmpleado`, `Motivo`, `FechaAnulacion`) VALUES
(1, 7, 1, 'Anuladas por vencimiento de CAI', '2021-09-23'),
(2, 8, 1, 'Anuladas por vencimiento de CAI', '2021-09-23'),
(3, 9, 1, 'Anuladas por vencimiento de CAI', '2021-09-23'),
(4, 10, 1, 'Anuladas por vencimiento de CAI', '2021-09-23'),
(5, 14, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(6, 15, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(7, 16, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(8, 17, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(9, 18, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(10, 19, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(11, 20, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(12, 21, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(13, 22, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(14, 23, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(15, 24, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(16, 25, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(17, 26, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(18, 27, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(19, 28, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(20, 29, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(21, 30, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(22, 31, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(23, 32, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(24, 33, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(25, 34, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(26, 35, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(27, 36, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(28, 37, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(29, 38, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(30, 39, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(31, 40, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(32, 41, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(33, 42, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(34, 43, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(35, 44, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(36, 45, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(37, 46, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(38, 47, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(39, 48, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(40, 49, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(41, 50, 1, 'Anuladas por vencimiento de CAI', '2021-10-03'),
(42, 55, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(43, 56, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(44, 57, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(45, 58, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(46, 59, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(47, 60, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(48, 61, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(49, 62, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(50, 63, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(51, 64, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(52, 65, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(53, 66, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(54, 67, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(55, 68, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(56, 69, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(57, 70, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(58, 71, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(59, 72, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(60, 73, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(61, 74, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(62, 75, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(63, 76, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(64, 77, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(65, 78, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(66, 79, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(67, 80, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(68, 81, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(69, 82, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(70, 83, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(71, 84, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(72, 85, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(73, 86, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(74, 87, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(75, 88, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(76, 89, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(77, 90, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(78, 91, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(79, 92, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(80, 93, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(81, 94, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(82, 95, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(83, 96, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(84, 97, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(85, 98, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(86, 99, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(87, 100, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(88, 102, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(89, 103, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(90, 104, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(91, 105, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(92, 106, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(93, 107, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(94, 108, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(95, 109, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(96, 110, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(97, 111, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(98, 112, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(99, 113, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(100, 114, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(101, 115, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(102, 116, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(103, 117, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(104, 118, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(105, 119, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(106, 120, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(107, 121, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(108, 122, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(109, 123, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(110, 124, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(111, 125, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(112, 126, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(113, 127, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(114, 128, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(115, 129, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(116, 130, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(117, 131, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(118, 132, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(119, 133, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(120, 134, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(121, 135, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(122, 136, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(123, 137, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(124, 138, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(125, 139, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(126, 140, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(127, 141, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(128, 142, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(129, 143, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(130, 144, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(131, 145, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(132, 146, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(133, 147, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(134, 148, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(135, 149, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(136, 150, 1, 'Anuladas por vencimiento de CAI', '2021-10-12'),
(140, 1, 1, 'anulada', '2021-10-12'),
(141, 1, 1, 'anulada', '2021-10-12'),
(142, 1, 1, 'anulada', '2021-10-12'),
(143, 1, 1, 'anulada', '2021-10-12'),
(144, 1, 1, 'anulada', '2021-10-12'),
(145, 1, 1, 'anulada', '2021-10-12'),
(146, 1, 1, 'anulada', '2021-10-12'),
(147, 1, 1, 'anulada', '2021-10-12'),
(148, 1, 1, 'anulada', '2021-10-12'),
(149, 1, 1, 'anulada', '2021-10-12'),
(150, 1, 1, 'anulada', '2021-10-12'),
(151, 1, 1, 'anulada', '2021-10-12'),
(152, 1, 1, 'anulada', '2021-10-12'),
(153, 1, 1, 'anulada', '2021-10-12'),
(154, 1, 1, 'anulada', '2021-10-12'),
(155, 1, 1, 'anulada', '2021-10-12'),
(156, 1, 1, 'anulada', '2021-10-12'),
(157, 1, 1, 'anulada', '2021-10-12'),
(158, 1, 1, 'anulada', '2021-10-12'),
(159, 1, 1, 'anulada', '2021-10-12'),
(160, 1, 1, 'anulada', '2021-10-12'),
(161, 1, 1, 'anulada', '2021-10-12'),
(162, 1, 1, 'anulada', '2021-10-12'),
(163, 1, 1, 'anulada', '2021-10-12'),
(164, 1, 1, 'anulada', '2021-10-12'),
(165, 1, 1, 'anulada', '2021-10-12'),
(166, 1, 1, 'anulada', '2021-10-12'),
(167, 1, 1, 'anulada', '2021-10-12'),
(168, 1, 1, 'anulada', '2021-10-12'),
(169, 1, 1, 'anulada', '2021-10-12'),
(170, 1, 1, 'anulada', '2021-10-12'),
(171, 1, 1, 'anulada', '2021-10-12'),
(172, 1, 1, 'anulada', '2021-10-12'),
(173, 1, 1, 'anulada', '2021-10-12'),
(174, 1, 1, 'anulada', '2021-10-12'),
(175, 1, 1, 'anulada', '2021-10-12'),
(176, 1, 1, 'anulada', '2021-10-12'),
(177, 1, 1, 'anulada', '2021-10-12'),
(178, 1, 1, 'anulada', '2021-10-12'),
(179, 1, 1, 'anulada', '2021-10-12'),
(180, 1, 1, 'anulada', '2021-10-12'),
(181, 1, 1, 'anulada', '2021-10-12'),
(182, 1, 1, 'anulada', '2021-10-12'),
(183, 1, 1, 'anulada', '2021-10-12'),
(184, 1, 1, 'anulada', '2021-10-12'),
(185, 1, 1, 'anulada', '2021-10-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parametros`
--

CREATE TABLE `parametros` (
  `idparametro` int(11) NOT NULL,
  `Llave` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFinal` date NOT NULL,
  `RangoInicial` int(11) NOT NULL,
  `RangoFinal` int(11) NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='cai';

--
-- Volcado de datos para la tabla `parametros`
--

INSERT INTO `parametros` (`idparametro`, `Llave`, `FechaInicio`, `FechaFinal`, `RangoInicial`, `RangoFinal`, `Activo`) VALUES
(1, 'A4SFD6-DF6RTG-ER65TR-PO98IG-65', '2021-08-03', '2021-09-22', 1, 10, 0),
(2, 'A3SDF3-FEFT5Y-ERTGT6-RTY56R-78', '2021-09-23', '2021-09-30', 11, 50, 0),
(3, 'A3ESDS-DFERTG-56TYHG-TY56TR-56', '2021-10-03', '2021-10-11', 51, 100, 0),
(4, 'ASDEF6-RTGFT5-TGHYU6-TYHGH6-DFTER5-56', '2021-10-12', '2021-10-11', 101, 150, 0),
(5, 'ASDEF4-ERFD45-RTYHT6-TYHGTY-TYHTGT-56', '2021-10-12', '2021-10-30', 151, 200, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

CREATE TABLE `permisos` (
  `idpermiso` int(11) NOT NULL,
  `Descripcion` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `permisos`
--

INSERT INTO `permisos` (`idpermiso`, `Descripcion`) VALUES
(1, 'Planilla'),
(2, 'Bonos'),
(3, 'Deducciones'),
(4, 'Configuracion'),
(5, 'Productos'),
(6, 'Servicios'),
(7, 'Empleados'),
(8, 'Descuentos'),
(9, 'Usuarios'),
(10, 'Clientes'),
(11, 'Busqueda factura'),
(12, 'Seguridad'),
(13, 'Parametros'),
(14, 'Facturacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisosusuario`
--

CREATE TABLE `permisosusuario` (
  `idpermisousuario` int(11) NOT NULL,
  `IDUsuario` int(11) NOT NULL,
  `IDPermiso` int(11) NOT NULL,
  `Activo` tinyint(1) NOT NULL,
  `Nuevo` tinyint(1) NOT NULL,
  `Imprimir` tinyint(1) NOT NULL,
  `Modificar` tinyint(1) NOT NULL,
  `Lista` tinyint(1) NOT NULL,
  `Desactivar` tinyint(1) NOT NULL,
  `Puesto` tinyint(1) NOT NULL,
  `NuevoPrecio` tinyint(1) NOT NULL,
  `NuevoPuesto` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `permisosusuario`
--

INSERT INTO `permisosusuario` (`idpermisousuario`, `IDUsuario`, `IDPermiso`, `Activo`, `Nuevo`, `Imprimir`, `Modificar`, `Lista`, `Desactivar`, `Puesto`, `NuevoPrecio`, `NuevoPuesto`) VALUES
(2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0),
(3, 1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0),
(4, 1, 10, 1, 0, 0, 1, 0, 1, 0, 0, 0),
(5, 1, 3, 1, 0, 1, 0, 0, 0, 0, 0, 0),
(6, 1, 4, 1, 1, 1, 1, 1, 1, 0, 0, 0),
(7, 1, 5, 1, 1, 0, 0, 1, 1, 1, 1, 0),
(8, 1, 6, 1, 1, 0, 0, 1, 1, 0, 0, 0),
(9, 1, 7, 1, 0, 0, 0, 0, 1, 1, 0, 0),
(10, 1, 8, 1, 1, 0, 0, 0, 0, 0, 0, 0),
(11, 1, 9, 1, 1, 0, 0, 0, 1, 0, 0, 0),
(12, 1, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0),
(13, 1, 12, 1, 0, 0, 0, 0, 0, 0, 0, 0),
(14, 1, 13, 1, 1, 0, 0, 0, 0, 0, 0, 0),
(15, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0),
(16, 2, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0),
(17, 1, 14, 1, 1, 0, 1, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `planillas`
--

CREATE TABLE `planillas` (
  `idplanilla` int(11) NOT NULL,
  `IDEmpleado` int(11) NOT NULL,
  `Periodo` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `TotalPagar` double(8,2) NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precioshistoricoservicios`
--

CREATE TABLE `precioshistoricoservicios` (
  `numprecioservicio` int(11) NOT NULL,
  `IDServicio` int(11) NOT NULL,
  `FechaInicial` date NOT NULL,
  `FechaFinal` date DEFAULT NULL,
  `Precio` double(6,2) NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `precioshistoricoservicios`
--

INSERT INTO `precioshistoricoservicios` (`numprecioservicio`, `IDServicio`, `FechaInicial`, `FechaFinal`, `Precio`, `Activo`) VALUES
(1, 1, '2021-07-24', '2021-07-28', 60.00, 0),
(2, 1, '2021-07-29', NULL, 80.00, 1),
(3, 2, '2021-07-30', '2021-08-20', 120.00, 0),
(4, 3, '2021-08-19', '2021-08-19', 150.00, 0),
(5, 3, '2021-08-20', '2021-08-20', 123.12, 0),
(6, 2, '2021-08-21', NULL, 50.00, 1),
(7, 3, '2021-08-21', NULL, 120.00, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precioshistoricosproductos`
--

CREATE TABLE `precioshistoricosproductos` (
  `numprecio` int(11) NOT NULL,
  `IDProducto` int(11) NOT NULL,
  `FechaInicial` date NOT NULL,
  `FechaFinal` date DEFAULT NULL,
  `Precio` double(7,2) NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `precioshistoricosproductos`
--

INSERT INTO `precioshistoricosproductos` (`numprecio`, `IDProducto`, `FechaInicial`, `FechaFinal`, `Precio`, `Activo`) VALUES
(1, 1, '2021-07-24', '2021-07-27', 130.00, 0),
(2, 2, '2021-07-27', '2021-08-16', 20.00, 0),
(3, 3, '2021-07-28', NULL, 20.00, 1),
(4, 1, '2021-07-28', '2021-08-20', 150.00, 0),
(5, 4, '2021-08-14', '2021-08-20', 150.00, 0),
(6, 2, '2021-08-17', '2021-08-20', 22.00, 0),
(7, 1, '2021-08-21', NULL, 120.00, 1),
(8, 4, '2021-08-21', '2021-08-20', 100.00, 0),
(9, 4, '2021-08-21', NULL, 150.35, 1),
(10, 2, '2021-08-21', NULL, 24.00, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idproducto` int(11) NOT NULL,
  `NomProducto` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `StockActual` int(11) NOT NULL,
  `StockMinimo` int(11) NOT NULL,
  `StockMaximo` int(11) NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idproducto`, `NomProducto`, `StockActual`, `StockMinimo`, `StockMaximo`, `Activo`) VALUES
(1, 'Cera', 2, 10, 100, 1),
(2, 'Coca Cola', 4, 20, 150, 1),
(3, 'Sprite', 4, 20, 150, 1),
(4, 'Gelatina', 33, 25, 150, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puesto`
--

CREATE TABLE `puesto` (
  `idpuesto` int(11) NOT NULL,
  `NomPuesto` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `puesto`
--

INSERT INTO `puesto` (`idpuesto`, `NomPuesto`, `Activo`) VALUES
(1, 'Gerente', 1),
(2, 'Barbero', 1),
(3, 'Cajero', 1),
(4, 'Conserje', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puestohistoricoempleado`
--

CREATE TABLE `puestohistoricoempleado` (
  `numpuesto` int(11) NOT NULL,
  `IDEmpleado` int(11) NOT NULL,
  `IDPuesto` int(11) NOT NULL,
  `FechaInicial` date NOT NULL,
  `FechaFinal` date DEFAULT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `puestohistoricoempleado`
--

INSERT INTO `puestohistoricoempleado` (`numpuesto`, `IDEmpleado`, `IDPuesto`, `FechaInicial`, `FechaFinal`, `Activo`) VALUES
(1, 1, 1, '2021-07-22', '2021-09-21', 0),
(2, 2, 3, '2021-07-22', NULL, 1),
(3, 1, 2, '2021-09-22', '2021-11-29', 0),
(4, 3, 3, '2021-07-24', NULL, 1),
(5, 1, 1, '2021-11-30', NULL, 1),
(6, 4, 3, '2021-07-27', NULL, 1),
(7, 5, 2, '2021-08-02', NULL, 1),
(8, 6, 4, '2021-08-19', '2021-08-19', 0),
(9, 6, 3, '2021-08-20', '2021-08-19', 0),
(10, 6, 4, '2021-08-20', '2021-08-20', 0),
(11, 6, 2, '2021-08-21', NULL, 1),
(12, 7, 4, '2021-08-23', NULL, 1),
(14, 8, 3, '2021-10-20', NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salariohistoricoempleados`
--

CREATE TABLE `salariohistoricoempleados` (
  `idsalario` int(11) NOT NULL,
  `IDEmpleado` int(11) NOT NULL,
  `FechaInicial` date NOT NULL,
  `FechaFinal` date DEFAULT NULL,
  `Salario` double(7,2) NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `salariohistoricoempleados`
--

INSERT INTO `salariohistoricoempleados` (`idsalario`, `IDEmpleado`, `FechaInicial`, `FechaFinal`, `Salario`, `Activo`) VALUES
(1, 1, '2021-07-22', '2021-08-19', 12000.00, 0),
(2, 1, '2021-08-20', '2021-08-29', 13000.00, 0),
(3, 2, '2021-07-22', '2021-07-26', 12300.00, 0),
(4, 3, '2021-07-24', NULL, 12000.00, 1),
(5, 4, '2021-07-27', NULL, 12000.00, 1),
(6, 1, '2021-08-30', '2021-11-29', 12000.00, 0),
(7, 2, '2021-07-27', NULL, 12000.00, 1),
(8, 1, '2021-11-30', NULL, 12000.00, 1),
(9, 5, '2021-08-02', NULL, 13000.00, 1),
(10, 6, '2021-08-19', '2021-08-19', 10000.00, 0),
(11, 6, '2021-08-20', '2021-08-19', 15000.00, 0),
(12, 6, '2021-08-20', NULL, 13000.00, 1),
(13, 7, '2021-08-23', NULL, 10000.00, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `idservicio` int(11) NOT NULL,
  `NomServicio` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`idservicio`, `NomServicio`, `Activo`) VALUES
(1, 'Disminucion', 1),
(2, 'Mascarilla', 1),
(3, 'Fade', 1),
(48, 'Nombre', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodeduccion`
--

CREATE TABLE `tipodeduccion` (
  `idtipodeduccion` int(11) NOT NULL,
  `Nombre` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipodeduccion`
--

INSERT INTO `tipodeduccion` (`idtipodeduccion`, `Nombre`, `Activo`) VALUES
(1, 'Isr', 1),
(2, 'IHSS', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodescuento`
--

CREATE TABLE `tipodescuento` (
  `idtipodescuento` int(11) NOT NULL,
  `NomDescuento` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipodescuento`
--

INSERT INTO `tipodescuento` (`idtipodescuento`, `NomDescuento`, `Activo`) VALUES
(1, 'Dia del padre', 1),
(2, 'Dia del perro', 1),
(3, 'Dia de Brujas', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `idtipodocumento` int(11) NOT NULL,
  `TipoDocumento` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`idtipodocumento`, `TipoDocumento`, `Activo`) VALUES
(1, 'Pasaporte', 1),
(2, 'Identidad', 1),
(3, 'RTN', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipopago`
--

CREATE TABLE `tipopago` (
  `idtipopago` int(11) NOT NULL,
  `TipoPago` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipopago`
--

INSERT INTO `tipopago` (`idtipopago`, `TipoPago`, `Activo`) VALUES
(1, 'Efectivo', 1),
(2, 'Tarjeta', 1),
(3, 'Mixto', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiposbono`
--

CREATE TABLE `tiposbono` (
  `idtipobono` int(11) NOT NULL,
  `NomBono` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tiposbono`
--

INSERT INTO `tiposbono` (`idtipobono`, `NomBono`, `Activo`) VALUES
(1, 'Aguinaldo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL,
  `IDEmpleado` int(11) NOT NULL,
  `NomCuenta` varchar(17) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Contrasena` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Activo` tinyint(1) NOT NULL,
  `Intentos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `IDEmpleado`, `NomCuenta`, `Contrasena`, `Activo`, `Intentos`) VALUES
(1, 1, 'jbrizo123', 'fe796f993c4e61c2318d8b6e73fd160f', 1, 0),
(2, 2, 'saronil2000', 'fe796f993c4e61c2318d8b6e73fd160f', 1, 0),
(3, 3, 'mil2000', '85e06813c2e9163e52864fc4b7cc5112', 0, 0),
(5, 5, 'alex45_46', '1e393cb9de4431563f2de8d1ce24c8d0', 1, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bonosempleadomensual`
--
ALTER TABLE `bonosempleadomensual`
  ADD PRIMARY KEY (`numbono`,`IDEmpleado`),
  ADD KEY `FK_bonosempleado_empleado` (`IDEmpleado`),
  ADD KEY `FK_bonosempleadomensual_tiposbono` (`IDTipoBono`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idcliente`),
  ADD UNIQUE KEY `IX_NumDocumento` (`NumDocumento`),
  ADD KEY `FK_clientes_servicios` (`IDServicio`),
  ADD KEY `FK_clientes_tipodocumento` (`IDTipoDocumento`);

--
-- Indices de la tabla `datosempresa`
--
ALTER TABLE `datosempresa`
  ADD PRIMARY KEY (`iddato`);

--
-- Indices de la tabla `deduccionesempleadomensual`
--
ALTER TABLE `deduccionesempleadomensual`
  ADD PRIMARY KEY (`numdeduccion`,`IDEmpleado`),
  ADD KEY `FK_deduccionesempleado_empleado` (`IDEmpleado`),
  ADD KEY `FK_deduccionesempleadomensual_tipodeduccion` (`IDTipoDeduccion`);

--
-- Indices de la tabla `descuentofactura`
--
ALTER TABLE `descuentofactura`
  ADD PRIMARY KEY (`numdescuento`,`IDFactura`),
  ADD KEY `FK_descuentofactura_descuentos` (`IDDescuento`),
  ADD KEY `FK_descuentofactura_factura` (`IDFactura`);

--
-- Indices de la tabla `descuentos`
--
ALTER TABLE `descuentos`
  ADD PRIMARY KEY (`iddescuento`),
  ADD KEY `FK_descuentos_tipodescuento_02` (`IDTipoDescuento`);

--
-- Indices de la tabla `detalleproducto`
--
ALTER TABLE `detalleproducto`
  ADD PRIMARY KEY (`numdetalle`,`IDFacturaEncabezado`),
  ADD KEY `FK_detalleproducto_productos` (`IDProducto`),
  ADD KEY `FK_detalleproducto_facturaencabezado` (`IDFacturaEncabezado`);

--
-- Indices de la tabla `detalleservicio`
--
ALTER TABLE `detalleservicio`
  ADD PRIMARY KEY (`numdetalleservicio`,`IDFacturaEncabezado`),
  ADD KEY `FK_detalleservicio_facturaencabezado` (`IDFacturaEncabezado`),
  ADD KEY `FK_detalleservicio_servicios` (`IDServicio`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idempleado`),
  ADD UNIQUE KEY `NumDoc` (`NumDoc`),
  ADD KEY `FK_empleado_tipodocumento` (`IDTipoDocumento`);

--
-- Indices de la tabla `estadofactura`
--
ALTER TABLE `estadofactura`
  ADD PRIMARY KEY (`idestado`),
  ADD UNIQUE KEY `IX_NombreEstado` (`NombreEstado`);

--
-- Indices de la tabla `facturaencabezado`
--
ALTER TABLE `facturaencabezado`
  ADD PRIMARY KEY (`idfacturaencabezado`),
  ADD UNIQUE KEY `IX_NumFactura` (`NumFactura`),
  ADD KEY `FK_factura_clientes` (`IDCliente`),
  ADD KEY `FK_factura_parametros` (`IDParametro`),
  ADD KEY `FK_facturaencabezado_barbero` (`IDBarbero`),
  ADD KEY `FK_facturaencabezado_estadofactura` (`IDEstado`),
  ADD KEY `FK_facturaencabezado_tipopago` (`IDTipoPago`),
  ADD KEY `FK_facturaencabezado_vendedor` (`IDVendedor`);

--
-- Indices de la tabla `facturasanuladas`
--
ALTER TABLE `facturasanuladas`
  ADD PRIMARY KEY (`idfacturaanulada`),
  ADD KEY `FK_facturasanuladas_facturaencabezado` (`IDFacturaEncabezado`),
  ADD KEY `FK_facturasanuladas_empleado` (`IDEmpleado`);

--
-- Indices de la tabla `parametros`
--
ALTER TABLE `parametros`
  ADD PRIMARY KEY (`idparametro`),
  ADD UNIQUE KEY `Llave` (`Llave`);

--
-- Indices de la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD PRIMARY KEY (`idpermiso`);

--
-- Indices de la tabla `permisosusuario`
--
ALTER TABLE `permisosusuario`
  ADD PRIMARY KEY (`idpermisousuario`),
  ADD KEY `FK_permisousuario_usuarios` (`IDUsuario`),
  ADD KEY `FK_permisousuario_permisos` (`IDPermiso`);

--
-- Indices de la tabla `planillas`
--
ALTER TABLE `planillas`
  ADD PRIMARY KEY (`idplanilla`),
  ADD KEY `FK_planillas_empleado` (`IDEmpleado`);

--
-- Indices de la tabla `precioshistoricoservicios`
--
ALTER TABLE `precioshistoricoservicios`
  ADD PRIMARY KEY (`numprecioservicio`,`IDServicio`),
  ADD KEY `FK_precioshistoricoservicios_servicios` (`IDServicio`);

--
-- Indices de la tabla `precioshistoricosproductos`
--
ALTER TABLE `precioshistoricosproductos`
  ADD PRIMARY KEY (`numprecio`,`IDProducto`),
  ADD KEY `FK_precioshistoricosproductos_productos` (`IDProducto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idproducto`),
  ADD UNIQUE KEY `IX_NomProducto` (`NomProducto`);

--
-- Indices de la tabla `puesto`
--
ALTER TABLE `puesto`
  ADD PRIMARY KEY (`idpuesto`),
  ADD UNIQUE KEY `IX_NomPuesto` (`NomPuesto`);

--
-- Indices de la tabla `puestohistoricoempleado`
--
ALTER TABLE `puestohistoricoempleado`
  ADD PRIMARY KEY (`numpuesto`,`IDEmpleado`),
  ADD KEY `FK_puestohistoricoempleado_empleado` (`IDEmpleado`),
  ADD KEY `FK_puestohistoricoempleado_puesto` (`IDPuesto`);

--
-- Indices de la tabla `salariohistoricoempleados`
--
ALTER TABLE `salariohistoricoempleados`
  ADD PRIMARY KEY (`idsalario`,`IDEmpleado`),
  ADD KEY `FK_salariohistoricoempleados_empleado` (`IDEmpleado`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`idservicio`),
  ADD UNIQUE KEY `IX_NomServicio` (`NomServicio`);

--
-- Indices de la tabla `tipodeduccion`
--
ALTER TABLE `tipodeduccion`
  ADD PRIMARY KEY (`idtipodeduccion`),
  ADD UNIQUE KEY `IX_Nombre` (`Nombre`);

--
-- Indices de la tabla `tipodescuento`
--
ALTER TABLE `tipodescuento`
  ADD PRIMARY KEY (`idtipodescuento`),
  ADD UNIQUE KEY `IX_NomDescuento` (`NomDescuento`);

--
-- Indices de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`idtipodocumento`),
  ADD UNIQUE KEY `IX_TipoDocumento` (`TipoDocumento`);

--
-- Indices de la tabla `tipopago`
--
ALTER TABLE `tipopago`
  ADD PRIMARY KEY (`idtipopago`),
  ADD UNIQUE KEY `IX_TipoPago` (`TipoPago`);

--
-- Indices de la tabla `tiposbono`
--
ALTER TABLE `tiposbono`
  ADD PRIMARY KEY (`idtipobono`),
  ADD UNIQUE KEY `IX_NomBono` (`NomBono`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idusuario`),
  ADD UNIQUE KEY `IX_NomCuenta` (`NomCuenta`),
  ADD UNIQUE KEY `IDEmpleado` (`IDEmpleado`),
  ADD KEY `FK_usuarios_empleado` (`IDEmpleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bonosempleadomensual`
--
ALTER TABLE `bonosempleadomensual`
  MODIFY `numbono` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `datosempresa`
--
ALTER TABLE `datosempresa`
  MODIFY `iddato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `deduccionesempleadomensual`
--
ALTER TABLE `deduccionesempleadomensual`
  MODIFY `numdeduccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla `descuentofactura`
--
ALTER TABLE `descuentofactura`
  MODIFY `numdescuento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `descuentos`
--
ALTER TABLE `descuentos`
  MODIFY `iddescuento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `detalleproducto`
--
ALTER TABLE `detalleproducto`
  MODIFY `numdetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `detalleservicio`
--
ALTER TABLE `detalleservicio`
  MODIFY `numdetalleservicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idempleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla `estadofactura`
--
ALTER TABLE `estadofactura`
  MODIFY `idestado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `facturaencabezado`
--
ALTER TABLE `facturaencabezado`
  MODIFY `idfacturaencabezado` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=204;

--
-- AUTO_INCREMENT de la tabla `facturasanuladas`
--
ALTER TABLE `facturasanuladas`
  MODIFY `idfacturaanulada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=186;

--
-- AUTO_INCREMENT de la tabla `parametros`
--
ALTER TABLE `parametros`
  MODIFY `idparametro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `permisos`
--
ALTER TABLE `permisos`
  MODIFY `idpermiso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `permisosusuario`
--
ALTER TABLE `permisosusuario`
  MODIFY `idpermisousuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `planillas`
--
ALTER TABLE `planillas`
  MODIFY `idplanilla` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `precioshistoricoservicios`
--
ALTER TABLE `precioshistoricoservicios`
  MODIFY `numprecioservicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `precioshistoricosproductos`
--
ALTER TABLE `precioshistoricosproductos`
  MODIFY `numprecio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idproducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `puesto`
--
ALTER TABLE `puesto`
  MODIFY `idpuesto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `puestohistoricoempleado`
--
ALTER TABLE `puestohistoricoempleado`
  MODIFY `numpuesto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `salariohistoricoempleados`
--
ALTER TABLE `salariohistoricoempleados`
  MODIFY `idsalario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `servicios`
--
ALTER TABLE `servicios`
  MODIFY `idservicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT de la tabla `tipodeduccion`
--
ALTER TABLE `tipodeduccion`
  MODIFY `idtipodeduccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipodescuento`
--
ALTER TABLE `tipodescuento`
  MODIFY `idtipodescuento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `idtipodocumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipopago`
--
ALTER TABLE `tipopago`
  MODIFY `idtipopago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tiposbono`
--
ALTER TABLE `tiposbono`
  MODIFY `idtipobono` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bonosempleadomensual`
--
ALTER TABLE `bonosempleadomensual`
  ADD CONSTRAINT `FK_bonosempleado_empleado` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleado` (`idempleado`),
  ADD CONSTRAINT `FK_bonosempleadomensual_tiposbono` FOREIGN KEY (`IDTipoBono`) REFERENCES `tiposbono` (`idtipobono`);

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `FK_clientes_servicios` FOREIGN KEY (`IDServicio`) REFERENCES `servicios` (`idservicio`),
  ADD CONSTRAINT `FK_clientes_tipodocumento` FOREIGN KEY (`IDTipoDocumento`) REFERENCES `tipodocumento` (`idtipodocumento`);

--
-- Filtros para la tabla `deduccionesempleadomensual`
--
ALTER TABLE `deduccionesempleadomensual`
  ADD CONSTRAINT `FK_deduccionesempleado_empleado` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleado` (`idempleado`),
  ADD CONSTRAINT `FK_deduccionesempleadomensual_tipodeduccion` FOREIGN KEY (`IDTipoDeduccion`) REFERENCES `tipodeduccion` (`idtipodeduccion`);

--
-- Filtros para la tabla `descuentofactura`
--
ALTER TABLE `descuentofactura`
  ADD CONSTRAINT `FK_descuentofactura_descuentos` FOREIGN KEY (`IDDescuento`) REFERENCES `descuentos` (`iddescuento`),
  ADD CONSTRAINT `FK_descuentofactura_factura` FOREIGN KEY (`IDFactura`) REFERENCES `facturaencabezado` (`idfacturaencabezado`);

--
-- Filtros para la tabla `descuentos`
--
ALTER TABLE `descuentos`
  ADD CONSTRAINT `FK_descuentos_tipodescuento_02` FOREIGN KEY (`IDTipoDescuento`) REFERENCES `tipodescuento` (`idtipodescuento`);

--
-- Filtros para la tabla `detalleproducto`
--
ALTER TABLE `detalleproducto`
  ADD CONSTRAINT `FK_detalleproducto_facturaencabezado` FOREIGN KEY (`IDFacturaEncabezado`) REFERENCES `facturaencabezado` (`idfacturaencabezado`),
  ADD CONSTRAINT `FK_detalleproducto_productos` FOREIGN KEY (`IDProducto`) REFERENCES `productos` (`idproducto`);

--
-- Filtros para la tabla `detalleservicio`
--
ALTER TABLE `detalleservicio`
  ADD CONSTRAINT `FK_detalleservicio_facturaencabezado` FOREIGN KEY (`IDFacturaEncabezado`) REFERENCES `facturaencabezado` (`idfacturaencabezado`),
  ADD CONSTRAINT `FK_detalleservicio_servicios` FOREIGN KEY (`IDServicio`) REFERENCES `servicios` (`idservicio`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FK_empleado_tipodocumento` FOREIGN KEY (`IDTipoDocumento`) REFERENCES `tipodocumento` (`idtipodocumento`);

--
-- Filtros para la tabla `facturaencabezado`
--
ALTER TABLE `facturaencabezado`
  ADD CONSTRAINT `FK_factura_clientes` FOREIGN KEY (`IDCliente`) REFERENCES `clientes` (`idcliente`),
  ADD CONSTRAINT `FK_factura_parametros` FOREIGN KEY (`IDParametro`) REFERENCES `parametros` (`idparametro`),
  ADD CONSTRAINT `FK_facturaencabezado_barbero` FOREIGN KEY (`IDBarbero`) REFERENCES `empleado` (`idempleado`),
  ADD CONSTRAINT `FK_facturaencabezado_estadofactura` FOREIGN KEY (`IDEstado`) REFERENCES `estadofactura` (`idestado`),
  ADD CONSTRAINT `FK_facturaencabezado_tipopago` FOREIGN KEY (`IDTipoPago`) REFERENCES `tipopago` (`idtipopago`),
  ADD CONSTRAINT `FK_facturaencabezado_vendedor` FOREIGN KEY (`IDVendedor`) REFERENCES `empleado` (`idempleado`);

--
-- Filtros para la tabla `facturasanuladas`
--
ALTER TABLE `facturasanuladas`
  ADD CONSTRAINT `FK_facturasanuladas_empleado` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleado` (`idempleado`),
  ADD CONSTRAINT `FK_facturasanuladas_facturaencabezado` FOREIGN KEY (`IDFacturaEncabezado`) REFERENCES `facturaencabezado` (`idfacturaencabezado`);

--
-- Filtros para la tabla `permisosusuario`
--
ALTER TABLE `permisosusuario`
  ADD CONSTRAINT `FK_permisousuario_permisos` FOREIGN KEY (`IDPermiso`) REFERENCES `permisos` (`idpermiso`),
  ADD CONSTRAINT `FK_permisousuario_usuarios` FOREIGN KEY (`IDUsuario`) REFERENCES `usuarios` (`idusuario`);

--
-- Filtros para la tabla `planillas`
--
ALTER TABLE `planillas`
  ADD CONSTRAINT `FK_planillas_empleado` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleado` (`idempleado`);

--
-- Filtros para la tabla `precioshistoricoservicios`
--
ALTER TABLE `precioshistoricoservicios`
  ADD CONSTRAINT `FK_precioshistoricoservicios_servicios` FOREIGN KEY (`IDServicio`) REFERENCES `servicios` (`idservicio`);

--
-- Filtros para la tabla `precioshistoricosproductos`
--
ALTER TABLE `precioshistoricosproductos`
  ADD CONSTRAINT `FK_precioshistoricosproductos_productos` FOREIGN KEY (`IDProducto`) REFERENCES `productos` (`idproducto`);

--
-- Filtros para la tabla `puestohistoricoempleado`
--
ALTER TABLE `puestohistoricoempleado`
  ADD CONSTRAINT `FK_puestohistoricoempleado_empleado` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleado` (`idempleado`),
  ADD CONSTRAINT `FK_puestohistoricoempleado_puesto` FOREIGN KEY (`IDPuesto`) REFERENCES `puesto` (`idpuesto`);

--
-- Filtros para la tabla `salariohistoricoempleados`
--
ALTER TABLE `salariohistoricoempleados`
  ADD CONSTRAINT `FK_salariohistoricoempleados_empleado` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleado` (`idempleado`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FK_usuarios_empleado` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleado` (`idempleado`);

DELIMITER $$
--
-- Eventos
--
CREATE DEFINER=`root`@`localhost` EVENT `Reinicio` ON SCHEDULE EVERY 1 DAY STARTS '2021-10-04 11:00:00' ON COMPLETION NOT PRESERVE ENABLE DO UPDATE usuarios SET Intentos = 0$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
