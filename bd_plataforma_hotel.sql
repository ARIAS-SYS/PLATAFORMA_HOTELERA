-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-06-2024 a las 23:15:43
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_plataforma_hotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comodidad`
--

CREATE TABLE `comodidad` (
  `id` int(11) NOT NULL,
  `comodidad` varchar(30) DEFAULT NULL,
  `icono` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `comodidad`
--

INSERT INTO `comodidad` (`id`, `comodidad`, `icono`) VALUES
(1, 'Aire Acondicionado', 'aire_acondicionado.png'),
(2, 'Alquilar Vehiculo', 'alquilar_vehiculo.png'),
(3, 'Baños', 'baños.png'),
(4, 'Bebidas', 'bebidas.png'),
(5, '1 Cama Individual', 'cama.png'),
(6, 'Cama Doble', 'cama1.png'),
(7, 'Cama Matrimonial', 'cama_matrimonial.png'),
(8, 'Campo de Golf', 'campo_de_golf.png'),
(9, 'Cancha de Tenis', 'cancha_de_tenis.png'),
(17, 'Gimnasio', 'gym.png'),
(26, 'Minibar', 'minibar.png'),
(27, 'Musica en Vivo', 'musica_en_vivo.png'),
(30, 'Sin Wifi', 'no_wifi.png'),
(32, 'Parqueo', 'parqueo.png'),
(33, 'Piscina', 'piscina.png'),
(36, 'Restaurante', 'restaurante.png'),
(37, 'Servicio a la Habitacion', 'room_service.png'),
(38, 'Servicio de Niñeras', 'servicio_de_niñeras.png'),
(39, 'Servicio Medico', 'servicio_medico.png'),
(40, 'Desayuno', 'taza.png'),
(42, 'Tienda de Regalo', 'tienda_de_regalo.png'),
(43, 'TV', 'tv.png'),
(46, 'Wifi', 'wifi.png'),
(47, '2 Camas Individuales', 'cama1.png'),
(48, '3 Camas Individuales', 'cama.png'),
(49, '4 Camas Individuales', 'cama.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comodidad_habitacion`
--

CREATE TABLE `comodidad_habitacion` (
  `id` int(11) NOT NULL,
  `id_habitacion` int(11) DEFAULT NULL,
  `id_comodidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `comodidad_habitacion`
--

INSERT INTO `comodidad_habitacion` (`id`, `id_habitacion`, `id_comodidad`) VALUES
(1, 1, 5),
(2, 1, 3),
(3, 1, 37),
(4, 1, 40),
(5, 1, 43),
(6, 1, 46),
(7, 2, 7),
(8, 2, 3),
(9, 2, 4),
(10, 2, 37),
(11, 2, 40),
(12, 2, 43),
(13, 2, 46),
(14, 3, 6),
(15, 3, 3),
(16, 3, 37),
(17, 3, 40),
(18, 3, 43),
(19, 3, 46),
(20, 4, 6),
(21, 4, 3),
(22, 4, 37),
(23, 4, 32),
(24, 4, 40),
(25, 4, 43),
(26, 4, 46),
(27, 5, 6),
(28, 5, 3),
(29, 5, 37),
(30, 5, 32),
(31, 5, 40),
(32, 5, 43),
(33, 5, 46),
(34, NULL, 3),
(35, NULL, 26),
(36, NULL, 43),
(37, NULL, 40),
(38, NULL, 37),
(39, NULL, 46),
(40, 7, 3),
(41, 7, 3),
(42, 7, 3),
(43, 7, 3),
(44, 7, 3),
(45, 7, 3),
(46, 8, 7),
(47, 8, 37),
(48, 8, 38),
(49, 8, 46),
(50, 8, 40),
(51, 8, 43),
(52, 9, 4),
(53, 9, 46),
(54, 9, 43),
(55, 9, 26),
(56, 9, 1),
(57, 9, 3),
(58, 10, 37),
(59, 10, 43),
(60, 10, 46),
(61, 10, 1),
(62, 10, 5),
(63, 10, 3),
(64, NULL, 5),
(65, NULL, 46),
(66, NULL, 33),
(67, NULL, 5),
(68, NULL, 6),
(69, NULL, 43),
(70, NULL, 3),
(71, NULL, 40),
(72, NULL, 5),
(73, NULL, 33),
(74, NULL, 32),
(75, NULL, 5),
(76, NULL, 43),
(77, NULL, 3),
(78, NULL, 3),
(79, NULL, 4),
(80, NULL, 3),
(81, NULL, 9),
(82, NULL, 6),
(83, NULL, 3),
(84, NULL, 6),
(85, NULL, 5),
(86, NULL, 46),
(87, NULL, 6),
(88, NULL, 5),
(89, NULL, 46),
(90, NULL, 40),
(91, NULL, 6),
(92, NULL, 46),
(93, NULL, 40),
(94, 14, 6),
(95, 14, 46),
(96, 14, 40),
(97, 14, 33),
(98, 15, 3),
(99, 15, 1),
(100, 15, 5),
(101, 15, 26),
(102, 15, 32),
(103, 15, 33),
(104, 15, 37),
(105, 15, 43),
(106, 15, 46),
(107, NULL, 6),
(108, NULL, 5),
(109, NULL, 1),
(110, NULL, 3),
(111, NULL, 26),
(112, NULL, 8),
(113, NULL, 32),
(114, NULL, 6),
(115, NULL, 5),
(116, NULL, 1),
(117, NULL, 3),
(118, NULL, 32),
(119, NULL, 46),
(120, 16, 6),
(121, 16, 5),
(122, 16, 1),
(123, 16, 3),
(124, 16, 32),
(125, 16, 46),
(126, NULL, 3),
(127, NULL, 26),
(128, NULL, 43),
(129, NULL, 40),
(130, NULL, 37),
(131, NULL, 46),
(132, NULL, 5),
(133, NULL, 6),
(134, 6, 3),
(135, 6, 26),
(136, 6, 43),
(137, 6, 40),
(138, 6, 37),
(139, 6, 46),
(140, 6, 6),
(141, 17, 5),
(142, 17, 46),
(143, 17, 43);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorito`
--

CREATE TABLE `favorito` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_hotel` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `favorito`
--

INSERT INTO `favorito` (`id`, `id_usuario`, `id_hotel`) VALUES
(111, 12, 5),
(122, 11, 1),
(123, 11, 2),
(125, 12, 2),
(130, 6, 2),
(131, 6, 3),
(132, 8, 3),
(133, 8, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `id_hotel_hab` int(11) DEFAULT NULL,
  `id_tipo_hab` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`id`, `codigo`, `estado`, `descripcion`, `capacidad`, `precio`, `id_hotel_hab`, `id_tipo_hab`) VALUES
(1, 'HAB-1', 'Libre', 'Habitación estándar para una persona', 1, 50, 5, 13),
(2, 'HAB-2', 'Ocupado', 'Habitación matrimonial acogedora', 2, 75, 1, 2),
(3, 'HAB-3', 'Libre', 'Habitación doble con camas individuales', 2, 70, 4, 3),
(4, 'HAB-4', 'Libre', 'Habitación triple confortable', 3, 90, 3, 4),
(5, 'HAB-5', 'Libre', 'Habitación familiar para cuatro', 4, 120, 2, 5),
(6, 'HAB-6', 'Ocupado', '', 2, 150, 1, 6),
(7, 'HAB-7', 'Libre', 'Habitación ejecutiva con escritorio', 2, 110, 5, 7),
(8, 'HAB-8', 'Libre', 'Habitación familiar con dos dormitorios', 5, 130, 4, 8),
(9, 'HAB-9', 'Libre', 'Habitación con cocina equipada', 3, 140, 3, 9),
(10, 'HAB-10', 'Libre', 'Habitación con vista al mar', 2, 160, 3, 1),
(14, 'HAB-01', 'Libre', '', 2, 150, 11, 10),
(15, 'HAB-2', 'Libre', '', 1, 500, 11, 14),
(16, 'HAB-1', 'Libre', '', 3, 200, 12, 19),
(17, 'HAB-2', 'Libre', '', 1, 50, 12, 18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hotel`
--

CREATE TABLE `hotel` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `celular` int(11) DEFAULT NULL,
  `facebook` varchar(100) DEFAULT NULL,
  `instagram` varchar(100) DEFAULT NULL,
  `foto` varchar(30) DEFAULT NULL,
  `link_ubicacion` varchar(100) DEFAULT NULL,
  `calificacion` decimal(10,0) DEFAULT NULL,
  `pais` varchar(30) NOT NULL,
  `departamento` varchar(30) NOT NULL,
  `ciudad` varchar(30) NOT NULL,
  `descripcion_ubi` varchar(200) NOT NULL,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `hotel`
--

INSERT INTO `hotel` (`id`, `nombre`, `descripcion`, `celular`, `facebook`, `instagram`, `foto`, `link_ubicacion`, `calificacion`, `pais`, `departamento`, `ciudad`, `descripcion_ubi`, `id_user`) VALUES
(1, 'Palacio de Sal', 'Hotel remoto y extravagante está hecho completamente de sal', 71790464, 'https://www.facebook.com/HotelPalacioDeSalBolivia/?locale=es_LA', 'https://www.instagram.com/palaciodesal/?hl=es', 'PalacioSal.jpg', 'https://maps.app.goo.gl/DDEGDY7DoGPy9VBD7', 4, 'Bolivia', 'Potosí', 'Uyuni', 'Salar de Uyuni', 2),
(2, 'Marriott', 'Hotel moderno de lujo cuenta con vista a la ciudad', 33424848, 'https://www.facebook.com/MarriottSantaCruz/about', 'https://www.instagram.com/MarriottSantaCruz/', 'Marriott.jpg', 'https://maps.app.goo.gl/tTDpkVqoU7az7b3R8', 3, 'Bolivia', 'Santa Cruz', 'Santa Cruz de la Sierra', '4to Anillo', 5),
(3, 'Suites Camino Real', 'Hotel moderno de suites con vista a la montaña y a la ciudad', 22792323, 'https://www.facebook.com/HotelCaminoRealLaPaz/', 'https://www.instagram.com/suitescaminoreal.lpb/', 'SuitesCaminoReal.jpg', 'https://maps.app.goo.gl/X3V5RNMCiECsUEdF9', 3, 'Bolivia', 'La Paz', 'La Paz', 'Av. Ballivian, Calle 10 De Calacoto', 3),
(4, 'Gran Hotel Cochabamba', 'Hotel con gran comodidad con 2 restaurantes y 3 albercas al aire libre y un spa de servicio completo.', 78352808, 'https://www.facebook.com/granhotelcochabamba/', 'https://www.instagram.com/granhotelcochabamba_bolivia/', 'GranHotelCochabamba.jpg', 'https://maps.app.goo.gl/X3V5RNMCiECsUEdF9', 4, 'Bolivia', 'Cochabamba', 'Cochabamba', 'Plaza de la Recoleta', 13),
(5, 'Hotel Granny', 'El establecimiento alberga instalaciones para reuniones y proporciona servicio de lavandería y de información turística.', 60276817, 'https://www.facebook.com/GrannyTarija/?locale=es_LA', 'https://www.instagram.com/explore/locations/920023123/hotel-granny/', 'HotelGranny.jpg', 'https://maps.app.goo.gl/Zz53fGrRd91p35co6', 4, 'Bolivia', 'Tarija', 'Tarija', 'Plaza principal', 11),
(11, 'Hotel Presidencial', 'lind hotel', 6542345, 'fgdfgfdgdf', 'dfgfdg', 'fondo3.png', 'fdgdg', 5, 'Bolivia', 'Sucre', 'Sucre', 'plaza princial', 14),
(12, 'Hotel Oasis', 'fddfhghgfhfgh', 65423455, 'fgdfgfdgdf', 'dfgfdg', 'fondo2.png', 'fdgdg', 5, 'Bolivia', 'La Paz', 'El Alto', 'Ceja, Calle 2', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

CREATE TABLE `oferta` (
  `id` int(11) NOT NULL,
  `titulo` varchar(50) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `foto` varchar(100) DEFAULT NULL,
  `descuento` int(11) DEFAULT NULL,
  `id_tipo_habitacion` int(11) DEFAULT NULL,
  `id_hotel` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `oferta`
--

INSERT INTO `oferta` (`id`, `titulo`, `fecha_inicio`, `fecha_fin`, `descripcion`, `estado`, `foto`, `descuento`, `id_tipo_habitacion`, `id_hotel`) VALUES
(1, 'Plan Familia', '2024-06-01', '2024-06-30', 'Incluye alojamiento para 2 adultos y 2 niños, desayuno buffet y acceso a todas las instalaciones del hotel.', 'En Curso', 'https://cdn.jalan.jp/jalan/images/pict3L/Y0/Y303560/Y303560275.jpg', 20, 13, 5),
(2, 'Descuento Temporada', '2024-07-01', '2024-07-31', 'ObtÃ©n un 25% de descuento en nuestras habitaciones estÃ¡ndar. Incluye desayuno diario', 'En Curso', 'https://i.pinimg.com/564x/4a/79/bc/4a79bc0c43888bc32cf9746ed433b9b1.jpg', 30, 6, 1),
(3, 'Oferta Especial', '2024-06-15', '2024-07-15', 'Disfruta de un descuento exclusivo del 15% en suites seleccionadas. Incluye acceso gratuito al spa y desayuno gourmet.', 'En Curso', 'https://i.pinimg.com/564x/c8/df/3b/c8df3bf77b5465f7d95fc9364d54c2fa.jpg', 15, 9, 3),
(4, 'Plan Negocio', '2024-06-20', '2024-07-20', 'Incluye alojamiento en habitación ejecutiva, desayuno continental y acceso a la sala de conferencias.', 'En Curso', 'https://i.pinimg.com/736x/c3/52/40/c35240b69a74559adcc2a651bcfa3ba5.jpg', 30, 3, 4),
(6, 'Fin de Semana', '2024-08-01', '2024-08-31', 'Disfruta de un 10% de descuento en estancias de fin de semana. Incluye desayuno y cena para dos personas.', 'Terminado', 'https://i.pinimg.com/564x/f8/ac/a9/f8aca90fbf52c3192075d17e6a7df62d.jpg', 10, 4, 3),
(8, 'la odisea', '2024-06-25', '2024-06-26', 'lind hotel', 'En Curso', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyZ4DfQIR37uYvDpiOu8s86Ep1HIRh2_goag&s', 12, 11, 11),
(9, 'Las mil y una noches  5', '2024-06-28', '2024-07-06', 'Literatura', 'En Curso', 'https://images.milled.com/2019-08-28/vbUQEGKML_X8vG5v/Cvw-bIGo3quk.png', 35, 10, 11),
(11, 'Plan Familiar', '2024-06-28', '2024-07-06', 'dfdfdfgdf', 'En Curso', 'https://cazaofertas.com.mx/wp-content/uploads/2015/05/preventa-de-verano-despegar-com.jpg', 25, 18, 12),
(14, 'Plan Vacacion', '2024-06-25', '2024-06-25', 'dfdfdfgdf', 'En Curso', 'https://cazaofertas.com.mx/wp-content/uploads/2015/05/preventa-de-verano-despegar-com.jpg', 30, 18, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id` int(11) NOT NULL,
  `fecha_reserva` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `total_precio` decimal(10,0) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_habit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id`, `fecha_reserva`, `fecha_inicio`, `fecha_fin`, `total_precio`, `estado`, `id_usuario`, `id_habit`) VALUES
(1, '2024-04-01', '2024-04-01', '2024-04-03', 75, 'Completado', 1, 2),
(2, '2024-04-04', '2024-04-04', '2024-04-07', 120, 'En Estancia', 3, 5),
(3, '2024-04-08', '2024-04-08', '2024-04-10', 90, 'Completado', 4, 4),
(4, '2024-04-11', '2024-04-11', '2024-04-13', 50, 'En Estancia', 5, 1),
(5, '2024-04-14', '2024-04-14', '2024-04-17', 90, 'En Estancia', 6, 4),
(6, '2024-04-18', '2024-04-18', '2024-04-20', 70, 'Reservado', 7, 3),
(7, '2024-04-21', '2024-04-21', '2024-04-23', 50, 'Reservado', 8, 1),
(8, '2024-04-24', '2024-04-24', '2024-04-27', 75, 'Reservado', 9, 2),
(9, '2024-06-23', '2024-06-23', '2024-06-24', 120, 'Reservado', 1, 5),
(10, '2024-06-23', '2024-06-23', '2024-06-24', 130, 'Reservado', 1, 8),
(11, '2024-06-23', '2024-06-23', '2024-06-26', 120, 'Reservado', 1, 5),
(12, '2024-06-23', '2024-06-23', '2024-06-28', 600, 'Reservado', 1, 5),
(13, '2024-06-23', '2024-06-23', '2024-06-24', 112, 'Reservado', 1, NULL),
(14, '2024-06-23', '2024-06-23', '2024-06-24', 112, 'Reservado', 1, NULL),
(15, '2024-06-23', '2024-06-23', '2024-06-24', 81, 'Reservado', 11, 4),
(16, '2024-06-23', '2024-06-23', '2024-06-24', 81, 'Reservado', 12, 4),
(17, '2024-06-23', '2024-06-23', '2024-06-29', 714, 'Reservado', 12, 9),
(18, '2024-06-23', '2024-06-23', '2024-06-24', 75, 'En Estancia', 12, 2),
(19, '2024-06-24', '2024-06-24', '2024-06-28', 196, 'Reservado', 1, 3),
(20, '2024-06-25', '2024-06-25', '2024-06-26', 105, 'Reservado', 1, 6),
(21, '2024-06-25', '2024-06-25', '2024-06-26', 105, 'En Estancia', 6, 6),
(22, '2024-06-25', '2024-06-25', '2024-06-26', 75, 'Reservado', 8, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `rol` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `rol`) VALUES
(1, 'Cliente'),
(2, 'Propietario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_habitacion`
--

CREATE TABLE `tipo_habitacion` (
  `id` int(11) NOT NULL,
  `tipo` varchar(30) DEFAULT NULL,
  `foto` varchar(100) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `tipo_habitacion`
--

INSERT INTO `tipo_habitacion` (`id`, `tipo`, `foto`, `id_usuario`) VALUES
(1, 'Para una Persona', 'https://i.pinimg.com/564x/56/ba/18/56ba18898662a3282133223cb5740e8f.jpg', 3),
(2, 'Para dos Personas Matrimonial', 'https://i.pinimg.com/564x/6a/10/dd/6a10dd65dfc05648033d3de269adb995.jpg', 2),
(3, 'Para dos Personas Individuales', 'https://i.pinimg.com/564x/b9/f2/53/b9f2531177b9f3741e1d3fb97f439723.jpg', 13),
(4, 'Para tres Personas', 'https://i.pinimg.com/564x/c9/0d/67/c90d6776a0aba2bfa75c3427238f5ba9.jpg', 3),
(5, 'Para cuatro Personas', 'https://i.pinimg.com/564x/48/47/e0/4847e0a48071f962f090f4a4f5559afa.jpg', 5),
(6, 'Suite Junior', 'https://i.pinimg.com/564x/fb/84/14/fb841412fdaa2a50e16854edd949fcfa.jpg', 2),
(7, 'Habitacion Ejecutiva', 'https://i.pinimg.com/564x/c9/12/d7/c912d7cee69858dbb2a6270ce85fd8dc.jpg', 14),
(8, 'Habitacion Familiar', 'https://i.pinimg.com/564x/0b/2c/d5/0b2cd5c8b577d2638b8811615042d418.jpg', 13),
(9, 'Habitacion con Cocina', 'https://i.pinimg.com/564x/50/56/6c/50566cbcb1f8efecea7c6e0a3b6f6a6d.jpg', 3),
(10, 'Habitacion con Vista', 'https://i.pinimg.com/564x/98/1b/ef/981befdc08965f3743e5e825d254f37b.jpg', 14),
(11, 'Habitacion Accesible', 'https://i.pinimg.com/564x/dc/aa/d7/dcaad78d35165fc7001e21ca63979a46.jpg', 14),
(12, 'Habitacion Conectada', 'https://i.pinimg.com/564x/5f/43/f5/5f43f5fd66a55190d51eecfc52c0b7c1.jpg', 14),
(13, 'Para una Persona', 'https://i.pinimg.com/564x/56/ba/18/56ba18898662a3282133223cb5740e8f.jpg', 11),
(14, 'Suite Junior', 'https://i.pinimg.com/564x/fb/84/14/fb841412fdaa2a50e16854edd949fcfa.jpg', 14),
(18, 'Habitacion Individual', 'https://cdn.pixabay.com/photo/2016/11/30/08/48/bedroom-1872196_640.jpg', 15),
(19, 'Habitacion Matrimonial', 'https://cdn.pixabay.com/photo/2024/05/15/07/59/flowers-8763039_640.jpg', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `activo` int(11) DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `email`, `password`, `activo`, `id_rol`) VALUES
(1, 'Carola Apaza', 'carola@mail.com', 'Apaza', 1, 1),
(2, 'Ronaldo Arias', 'ronaldo@mail.com', 'Arias', 1, 2),
(3, 'Maribel Choque', 'maribel@mail.com', 'Choque', 1, 2),
(4, 'Jose Hernandez', 'jose@mail.com', 'Hernandez', 1, 1),
(5, 'Betty Gomes', 'betty@mail.com', 'Gomes', 1, 2),
(6, 'Carlos Ochoa', 'carlos@mail.com', 'Ochoa', 1, 1),
(7, 'Diego Mamani', 'diego@mail.com', 'Mamani', 1, 1),
(8, 'Elmer Calla', 'elmer@mail.com', 'Calla', 1, 1),
(9, 'Fernando Condori', 'fernando@mail.com', 'Condori', 1, 1),
(11, 'Luis Poma', 'poma@mail.com', 'poma123', 1, 2),
(12, 'Alicia Perez', 'ali@mail.com', 'ali123', 1, 1),
(13, 'Luna Huanca', 'luna@mail.com', 'luna123', 1, 2),
(14, 'Sergio Ramos', 'ramos@mail.com', 'ramos123', 1, 2),
(15, 'Tonny Acero', 'tonny@mail.com', 'tonny', 1, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comodidad`
--
ALTER TABLE `comodidad`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indices de la tabla `comodidad_habitacion`
--
ALTER TABLE `comodidad_habitacion`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `id_habitacion` (`id_habitacion`) USING BTREE,
  ADD KEY `id_comodidad` (`id_comodidad`) USING BTREE;

--
-- Indices de la tabla `favorito`
--
ALTER TABLE `favorito`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `id_usuario` (`id_usuario`) USING BTREE,
  ADD KEY `id_hotel` (`id_hotel`) USING BTREE;

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `id_hotel_hab` (`id_hotel_hab`) USING BTREE,
  ADD KEY `id_tipo_hab` (`id_tipo_hab`) USING BTREE;

--
-- Indices de la tabla `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `id_user` (`id_user`) USING BTREE;

--
-- Indices de la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `id_tipo_habitacion` (`id_tipo_habitacion`) USING BTREE,
  ADD KEY `fk_usuario_pedidos` (`id_hotel`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `id_usuario` (`id_usuario`) USING BTREE,
  ADD KEY `id_habit` (`id_habit`) USING BTREE;

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indices de la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `fk_usuario` (`id_usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `id_rol` (`id_rol`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comodidad`
--
ALTER TABLE `comodidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de la tabla `comodidad_habitacion`
--
ALTER TABLE `comodidad_habitacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=144;

--
-- AUTO_INCREMENT de la tabla `favorito`
--
ALTER TABLE `favorito`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=134;

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `oferta`
--
ALTER TABLE `oferta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comodidad_habitacion`
--
ALTER TABLE `comodidad_habitacion`
  ADD CONSTRAINT `comodidad_habitacion_ibfk_1` FOREIGN KEY (`id_habitacion`) REFERENCES `habitacion` (`id`),
  ADD CONSTRAINT `comodidad_habitacion_ibfk_2` FOREIGN KEY (`id_comodidad`) REFERENCES `comodidad` (`id`);

--
-- Filtros para la tabla `favorito`
--
ALTER TABLE `favorito`
  ADD CONSTRAINT `favorito_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `favorito_ibfk_2` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id`);

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`id_hotel_hab`) REFERENCES `hotel` (`id`),
  ADD CONSTRAINT `habitacion_ibfk_2` FOREIGN KEY (`id_tipo_hab`) REFERENCES `tipo_habitacion` (`id`);

--
-- Filtros para la tabla `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `hotel_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD CONSTRAINT `fk_usuario_pedidos` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id`),
  ADD CONSTRAINT `oferta_ibfk_1` FOREIGN KEY (`id_tipo_habitacion`) REFERENCES `tipo_habitacion` (`id`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_habit`) REFERENCES `habitacion` (`id`);

--
-- Filtros para la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
