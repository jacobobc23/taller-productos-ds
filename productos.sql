-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-08-2023 a las 15:49:36
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `taller1_ds`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `distribuidor` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `distribuidor`, `categoria`, `precio`) VALUES
('AH8050-100', 'Nike Air Max 270', 'Nike', 'Zapatos', 160),
('CW2288-111', 'Nike Air Force', 'Nike', 'Zapatos', 180),
('DC4244-838', 'Nike Heritage', 'Nike', 'Accesorios', 37),
('DJ3644-491', 'Nike ACG', 'Nike', 'Ropa', 50),
('DN2555-381', 'Nike Elemental Premium', 'Nike', 'Accesorios', 47),
('DR2615-002', 'Nike Invincible 3', 'Nike', 'Zapatos', 180),
('DR2665-100', 'Nike InfinityRN 4', 'Nike', 'Zapatos', 160),
('DV9831-655', 'Nike Primary', 'Nike', 'Ropa', 55),
('DX0989-492', 'Nike Dri-FIT Legend', 'Nike', 'Ropa', 30),
('FB5378-010', 'Nike Rise Cap', 'Nike', 'Accesorios', 28),
('FB7540-655', 'Nike Windrunner', 'Nike', 'Ropa', 125),
('FN0303-390', 'Nike NV07', 'Nike', 'Accesorios', 100);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `nombre` (`nombre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
