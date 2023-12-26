-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-12-2023 a las 07:00:34
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bana_corp`
--
CREATE DATABASE IF NOT EXISTS `bana_corp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bana_corp`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id` int(11) NOT NULL,
  `job` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id`, `job`) VALUES
(1, 'TI manager');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `candidato`
--

CREATE TABLE `candidato` (
  `id` int(11) NOT NULL,
  `id_partido` int(11) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `candidato`
--

INSERT INTO `candidato` (`id`, `id_partido`, `job`) VALUES
(2, 2, 'Presidente'),
(6, 1, 'Presidente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `electores`
--

CREATE TABLE `electores` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `electores`
--

INSERT INTO `electores` (`id`, `email`) VALUES
(2, 'alitomartinez@unsa.edu.pe'),
(3, 'ldavis@unsa.edu.pe'),
(4, 'hroque@unsa.edu.pe'),
(5, 'alupo@unsa.edu.pe'),
(6, 'jcerpa@unsa.edu.pe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido_politico`
--

CREATE TABLE `partido_politico` (
  `id` int(11) NOT NULL,
  `num_votes` int(11) DEFAULT NULL,
  `name_political_party` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `partido_politico`
--

INSERT INTO `partido_politico` (`id`, `num_votes`, `name_political_party`) VALUES
(1, 1, 'Los Chamos FC'),
(2, 0, 'Bananas Party');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `last_name`, `name`, `password`, `user_name`) VALUES
(1, 'Ccama', 'Gustavo', '$2a$10$PssbUJsp1db9atpC6fNbRup6gKBsNcEv2T349B.wAX0PZ3ljaXuJq', 'gustav'),
(2, 'Martinez', 'Aldo', '$2a$10$DrAbCTBItU/c98zXcEkdq.sy8n/ePS/lDPz5ZXU6AI4h4Rf/F.ahO', 'aldito'),
(3, 'Davis', 'Leon', '$2a$10$nBd7Jfq461IVt37MJCGmv.msx4I6aPtjEEowJnf0zKTwa3Si1NvH.', 'lyon'),
(4, 'Roque', 'Owen', '$2a$10$az9LYgAPLFV/WIPGhvy7e.Z6I9xxUkrIY4vvVVJnMJ1RUTxLi9dA2', 'hazi'),
(5, 'Lupo', 'Avelino', '$2a$10$r1ldNwyTqX.LgdFllWeFEuYEvJ5b2Bv45z4Dn9Ty01W0U/E050SOm', 'avegod'),
(6, 'Cerpa', 'Jean Franco', '$2a$10$rue3j5dipaC6gUsfnJieOOXKIgnk0bTlErjyagjQUy2TptbHbLI3e', 'chamo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name_role` enum('ROLE_ADMIN','ROLE_USER') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `name_role`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'ROLE_USER'),
(4, 'ROLE_USER'),
(5, 'ROLE_USER'),
(6, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_roles`
--

CREATE TABLE `user_roles` (
  `person_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user_roles`
--

INSERT INTO `user_roles` (`person_id`, `role_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `votos`
--

CREATE TABLE `votos` (
  `id` int(11) NOT NULL,
  `id_elector` int(11) DEFAULT NULL,
  `id_partido` int(11) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `votos`
--

INSERT INTO `votos` (`id`, `id_elector`, `id_partido`, `date`) VALUES
(4, 2, 1, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `candidato`
--
ALTER TABLE `candidato`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqy9f788m8cgacm309layn5w4l` (`id_partido`);

--
-- Indices de la tabla `electores`
--
ALTER TABLE `electores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `partido_politico`
--
ALTER TABLE `partido_politico`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`person_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- Indices de la tabla `votos`
--
ALTER TABLE `votos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_oyiw7pctsy4368uvjirv83k3y` (`id_elector`),
  ADD KEY `FK38okeyk6drqfd91jpx5v75u3v` (`id_partido`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `partido_politico`
--
ALTER TABLE `partido_politico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `votos`
--
ALTER TABLE `votos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `FKm0c8div4rq6bf39928ryqfy2i` FOREIGN KEY (`id`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `candidato`
--
ALTER TABLE `candidato`
  ADD CONSTRAINT `FK1xh7jiry5gqfd67hpspudajki` FOREIGN KEY (`id`) REFERENCES `electores` (`id`),
  ADD CONSTRAINT `FKqy9f788m8cgacm309layn5w4l` FOREIGN KEY (`id_partido`) REFERENCES `partido_politico` (`id`);

--
-- Filtros para la tabla `electores`
--
ALTER TABLE `electores`
  ADD CONSTRAINT `FKq15lg3l628rle4li4mipielt1` FOREIGN KEY (`id`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKd4559t2581n0vp2t09e0xd32c` FOREIGN KEY (`person_id`) REFERENCES `persona` (`id`),
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

--
-- Filtros para la tabla `votos`
--
ALTER TABLE `votos`
  ADD CONSTRAINT `FK38okeyk6drqfd91jpx5v75u3v` FOREIGN KEY (`id_partido`) REFERENCES `partido_politico` (`id`),
  ADD CONSTRAINT `FKnyrdxcvoigubmbeocvtcermde` FOREIGN KEY (`id_elector`) REFERENCES `electores` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;