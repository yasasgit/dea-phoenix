CREATE DATABASE phoenix_airlines_db;

USE phoenix_airlines_db;

CREATE TABLE `aircraft` (
  `id` varchar(5) NOT NULL,
  `manufacturer` varchar(20) NOT NULL,
  `model` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `class` (
  `id` varchar(4) NOT NULL,
  `type` varchar(15) NOT NULL,
  `additional_cost` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `flight` (
  `id` int(11) NOT NULL,
  `takeoff_airport` varchar(50) NOT NULL,
  `takeoff_time` varchar(50) NOT NULL,
  `takeoff_date` varchar(50) NOT NULL,
  `landing_airport` varchar(50) NOT NULL,
  `landing_time` varchar(50) NOT NULL,
  `landing_date` varchar(50) NOT NULL,
  `gate` varchar(3) NOT NULL,
  `cost` float NOT NULL,
  `aircraft_flight` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `seat` (
  `id` int(11) NOT NULL,
  `seat_name` varchar(5) NOT NULL,
  `aircraft_seat` varchar(5) NOT NULL,
  `class_seat` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `session` (
  `id` int(11) NOT NULL,
  `login_time` varchar(100) NOT NULL,
  `ip_address` varchar(100) NOT NULL,
  `user_session` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ticket` (
  `id` int(11) NOT NULL,
  `price` float NOT NULL,
  `user_ticket` int(11) NOT NULL,
  `flight_ticket` int(11) NOT NULL,
  `seat_ticket` int(11) NOT NULL,
  `class_ticket` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(64) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `role` varchar(7) NOT NULL,
  `is_active` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `aircraft` (`id`, `manufacturer`, `model`) VALUES
('AC101', 'Comac', 'A222'),
('AC151', 'Bombardier', '732'),
('AC201', 'Comac', 'A302'),
('AC251', 'Bombardier', '742'),
('AC301', 'Comac', 'A382'),
('AC351', 'Bombardier', '772'),
('F111', 'Comac', 'Global7502'),
('N331', 'Embraer', 'E192'),
('P501', 'Airbus', 'MRJ90E2'),
('P601', 'Airbus', 'MRJ70ST2');

INSERT INTO `class` (`id`, `type`, `additional_cost`) VALUES
('1000', 'First Class', 1.8),
('2000', 'Business Class', 1.4),
('3000', 'Economy Class', 1);

INSERT INTO `flight` (`id`, `takeoff_airport`, `takeoff_time`, `takeoff_date`, `landing_airport`, `landing_time`, `landing_date`, `gate`, `cost`, `aircraft_flight`) VALUES
(900, 'Malaysia', '12:23 AM', '2022-05-21', 'Iran', '1:27 AM', '2022-05-21', 'A4', 56701, 'AC101'),
(901, 'China', '11:48 PM', '2022-05-22', 'Nigeria', '2:16 AM', '2022-05-22', 'B6', 176991, 'AC151'),
(902, 'US', '10:00PM', '2022-05-23', 'Mexico', '3:00AM', '2022-05-23', 'B3', 15001, 'AC201'),
(903, 'Netherlands', '9:00AM', '2022-05-24', 'Japan', '4:00PM', '2022-05-24', 'B1', 10001, 'AC251'),
(904, 'Turkey', '8:00AM', '2022-05-25', 'Iran', '5:00PM', '2022-05-25', 'B1', 56701, 'AC301'),
(905, 'India', '7:00AM', '2022-05-26', 'Nigeria', '6:00PM', '2022-05-26', 'A1', 176991, 'AC351'),
(906, 'Malaysia', '6:00AM', '2022-05-27', 'Mexico', '7:00PM', '2022-05-27', 'B1', 15001, 'F111'),
(907, 'China', '5:00AM', '2022-05-28', 'Japan', '8:00PM', '2022-05-28', 'B1', 10001, 'N331'),
(908, 'US', '4:00AM', '2022-05-29', 'Iran', '9:00PM', '2022-05-29', 'C1', 56701, 'P501'),
(909, 'Netherlandsa', '3:00AM', '2022-05-30', 'Nigeria', '10:00PM', '2022-05-30', 'B1', 176991, 'P601'),
(910, 'Turkey', '2:00AM', '2022-05-31', 'Japan', '11:00PM', '2022-05-31', 'B1',  15001, 'AC101'),
(911, 'AAL', '1:23 AM', '2022-05-31', 'ABV', '8:27 AM', '2022-05-31', 'C3', 56700, 'AC151'),
(912, 'CMB', '5:48 PM', '2022-05-31', 'CWL', '7:16 AM', '2022-05-31', 'C5', 176999, 'N331'),
(913, 'London', '1:00PM', '2022-05-31', 'Colombo', '10:00AM', '2022-05-31', 'B4', 15000, 'AC201'),
(914, 'CMB', '10:00AM', '2022-05-31', 'London', '11:00PM', '2022-05-31', 'B2', 10000, 'F111');

INSERT INTO `seat` (`id`, `seat_name`, `aircraft_seat`, `class_seat`) VALUES
(1, '1A', 'AC101', '1000'),
(2, '1B', 'AC101', '1000'),
(3, '1C', 'AC101', '1000'),
(4, '1D', 'AC101', '1000'),
(5, '1E', 'AC101', '1000'),
(6, '2A', 'AC151', '1000'),
(7, '2B', 'AC151', '1000'),
(8, '2C', 'AC151', '1000'),
(9, '2D', 'AC151', '1000'),
(10, '2E', 'AC151', '1000'),
(11, '3A', 'AC201', '1000'),
(12, '3B', 'AC201', '1000'),
(13, '3C', 'AC201', '1000'),
(14, '3D', 'AC201', '1000'),
(15, '3E', 'AC201', '1000'),
(16, '4A', 'AC251', '2000'),
(17, '4B', 'AC251', '2000'),
(18, '4C', 'AC251', '2000'),
(19, '4D', 'AC251', '2000'),
(20, '4E', 'AC251', '2000'),
(21, '5A', 'AC301', '2000'),
(22, '5B', 'AC301', '2000'),
(23, '5C', 'AC301', '2000'),
(24, '5D', 'AC301', '2000'),
(25, '5E', 'AC301', '2000'),
(26, '6A', 'AC351', '2000'),
(27, '6B', 'AC351', '2000'),
(28, '6C', 'AC351', '2000'),
(29, '6D', 'AC351', '2000'),
(30, '6E', 'AC351', '2000'),
(31, '7A', 'F111', '3000'),
(32, '7B', 'F111', '3000'),
(33, '7C', 'F111', '3000'),
(34, '7D', 'F111', '3000'),
(35, '7E', 'F111', '3000'),
(36, '8A', 'N331', '3000'),
(37, '8B', 'N331', '3000'),
(38, '8C', 'N331', '3000'),
(39, '8D', 'N331', '3000'),
(40, '8E', 'N331', '3000'),
(41, '9A', 'P501', '3000'),
(42, '9B', 'P501', '3000'),
(43, '9C', 'P501', '3000'),
(44, '9D', 'P501', '3000'),
(45, '9E', 'P501', '3000'),
(46, '0A', 'P601', '3000'),
(47, '0B', 'P601', '3000'),
(48, '0C', 'P601', '3000'),
(49, '0D', 'P601', '3000'),
(50, '0E', 'P601', '3000');

INSERT INTO `user` (id, first_name, last_name, email, username, password, phone, address, `role`, is_active) VALUES 
(1000,'Chamal', 'Rashmika', 'lkrashmika@gmail.com', 'rashmika', '123', '0094710726910', 'Galle', 'client', 1),
(1001,'Yasas', 'Harshana', 'yasas99@outlook.com', 'yasas', '123', '0094762345645', 'Nugegoda', 'admin', 1),
(1002,'Uditha', 'Sampath', 'udithasampath@gmail.com', 'uditha', '123', '0094752584925', 'Galle,Pilana', 'staffg1', 1),
(1004,'Navoda', 'Nikethi', 'navodadesilva@gmail.com', 'navoda', '123', '0094716756347', 'Galle,Matara', 'staffg2', 1),
(1005,'Oshan', 'Dinaksha', 'oshandinakshas@gmail.com', 'oshan', '123', '0094754736005', 'Colombo', 'staffg1', 0),
(1006,'Sanduni', 'Jayakody', 'sandunijay@gmail.com', 'sanduni', '123', '0094711476109', 'Ganemulla', 'staffg2', 0);

ALTER TABLE `aircraft`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `class`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `flight`
  ADD PRIMARY KEY (`id`),
  ADD KEY `aircraft_flight` (`aircraft_flight`);

ALTER TABLE `seat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `aircraft_seat` (`aircraft_seat`),
  ADD KEY `class_seat` (`class_seat`);

ALTER TABLE `session`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_session` (`user_session`);

ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `flight_ticket` (`flight_ticket`),
  ADD KEY `seat_ticket` (`seat_ticket`),
  ADD KEY `class_ticket` (`class_ticket`),
  ADD KEY `user_ticket` (`user_ticket`);

ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`);

ALTER TABLE `flight`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=914;

ALTER TABLE `seat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

ALTER TABLE `session`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

ALTER TABLE `ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1007;

ALTER TABLE `flight`
  ADD CONSTRAINT `aircraft_flight` FOREIGN KEY (`aircraft_flight`) REFERENCES `aircraft` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `seat`
  ADD CONSTRAINT `aircraft_seat` FOREIGN KEY (`aircraft_seat`) REFERENCES `aircraft` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `class_seat` FOREIGN KEY (`class_seat`) REFERENCES `class` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `session`
  ADD CONSTRAINT `user_session` FOREIGN KEY (`user_session`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `ticket`
  ADD CONSTRAINT `class_ticket` FOREIGN KEY (`class_ticket`) REFERENCES `class` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `flight_ticket` FOREIGN KEY (`flight_ticket`) REFERENCES `flight` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seat_ticket` FOREIGN KEY (`seat_ticket`) REFERENCES `seat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_ticket` FOREIGN KEY (`user_ticket`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

