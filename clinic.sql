-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Окт 16 2024 г., 20:31
-- Версия сервера: 8.0.30
-- Версия PHP: 8.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `clinic`
--

-- --------------------------------------------------------

--
-- Структура таблицы `appointments`
--

CREATE TABLE `appointments` (
  `id` bigint NOT NULL,
  `analysis` varchar(255) DEFAULT NULL,
  `appointment_end` datetime(6) DEFAULT NULL,
  `appointment_start` datetime(6) DEFAULT NULL,
  `diagnosis` varchar(255) DEFAULT NULL,
  `doctor_id` bigint NOT NULL,
  `patient_id` bigint NOT NULL,
  `patient_info` varchar(255) DEFAULT NULL,
  `recommendations` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `appointments`
--

INSERT INTO `appointments` (`id`, `analysis`, `appointment_end`, `appointment_start`, `diagnosis`, `doctor_id`, `patient_id`, `patient_info`, `recommendations`) VALUES
(1, NULL, NULL, '2024-11-27 22:00:00.000000', NULL, 3, 1, NULL, NULL),
(3, NULL, NULL, '2024-03-21 15:41:00.000000', NULL, 206, 102, NULL, NULL),
(853, NULL, NULL, '2024-03-20 14:52:00.000000', NULL, 206, 253, NULL, NULL),
(1153, NULL, NULL, '2024-05-07 18:53:00.000000', NULL, 3, 102, NULL, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `appointments_seq`
--

CREATE TABLE `appointments_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `appointments_seq`
--

INSERT INTO `appointments_seq` (`next_val`) VALUES
(1252);

-- --------------------------------------------------------

--
-- Структура таблицы `category`
--

CREATE TABLE `category` (
  `id` bigint NOT NULL,
  `category` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `category`
--

INSERT INTO `category` (`id`, `category`) VALUES
(1, 'высшая'),
(2, 'первая'),
(3, 'вторая'),
(53, 'третья');

-- --------------------------------------------------------

--
-- Структура таблицы `category_seq`
--

CREATE TABLE `category_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `category_seq`
--

INSERT INTO `category_seq` (`next_val`) VALUES
(301);

-- --------------------------------------------------------

--
-- Структура таблицы `category_sequence`
--

CREATE TABLE `category_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `category_sequence`
--

INSERT INTO `category_sequence` (`next_val`) VALUES
(0);

-- --------------------------------------------------------

--
-- Структура таблицы `clinic`
--

CREATE TABLE `clinic` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `clinic_sequence`
--

CREATE TABLE `clinic_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `clinic_sequence`
--

INSERT INTO `clinic_sequence` (`next_val`) VALUES
(0);

-- --------------------------------------------------------

--
-- Структура таблицы `doctors`
--

CREATE TABLE `doctors` (
  `id` bigint NOT NULL,
  `birth` date DEFAULT NULL,
  `category` bigint DEFAULT NULL,
  `fio` varchar(255) DEFAULT NULL,
  `speciality` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `doctors`
--

INSERT INTO `doctors` (`id`, `birth`, `category`, `fio`, `speciality`) VALUES
(3, '1965-03-31', 1, 'Матюшкин Игорь Иваныч', 2),
(8, '2023-05-03', 3, 'Борисов Павел Михайлович', 2),
(206, '2024-02-06', 1, 'Баранов Виктор Иванович', 2),
(802, '1996-06-17', 2, 'Козлов Юрий Юрьевич', 5);

-- --------------------------------------------------------

--
-- Структура таблицы `doctors_seq`
--

CREATE TABLE `doctors_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `doctors_seq`
--

INSERT INTO `doctors_seq` (`next_val`) VALUES
(1051);

-- --------------------------------------------------------

--
-- Структура таблицы `doctor_cat`
--

CREATE TABLE `doctor_cat` (
  `id` bigint NOT NULL,
  `category_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `doctor_cat_sequence`
--

CREATE TABLE `doctor_cat_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `doctor_cat_sequence`
--

INSERT INTO `doctor_cat_sequence` (`next_val`) VALUES
(0);

-- --------------------------------------------------------

--
-- Структура таблицы `doctor_sequence`
--

CREATE TABLE `doctor_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `doctor_sequence`
--

INSERT INTO `doctor_sequence` (`next_val`) VALUES
(13);

-- --------------------------------------------------------

--
-- Структура таблицы `doctor_spec`
--

CREATE TABLE `doctor_spec` (
  `id` bigint NOT NULL,
  `doctor_id` int DEFAULT NULL,
  `speciality_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `doctor_spec_sequence`
--

CREATE TABLE `doctor_spec_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `doctor_spec_sequence`
--

INSERT INTO `doctor_spec_sequence` (`next_val`) VALUES
(0);

-- --------------------------------------------------------

--
-- Структура таблицы `employee`
--

CREATE TABLE `employee` (
  `id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `issues_seq`
--

CREATE TABLE `issues_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `issues_seq`
--

INSERT INTO `issues_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Структура таблицы `patients`
--

CREATE TABLE `patients` (
  `id` bigint NOT NULL,
  `allergy` varchar(255) DEFAULT NULL,
  `birth` datetime(6) DEFAULT NULL,
  `deseases` varchar(255) DEFAULT NULL,
  `family` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `operations` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `policy` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `patients`
--

INSERT INTO `patients` (`id`, `allergy`, `birth`, `deseases`, `family`, `middle_name`, `name`, `operations`, `phone`, `policy`, `email`) VALUES
(1, NULL, '1983-05-02 04:00:00.000000', NULL, 'Зингельшухер', 'Сергеевич', 'Сергей', NULL, NULL, NULL, NULL),
(102, NULL, NULL, NULL, 'Иванов', 'Ивпныч', 'Иван', NULL, NULL, NULL, NULL),
(252, NULL, NULL, NULL, 'Сергеев', 'Иванович', 'Иван', NULL, NULL, NULL, NULL),
(253, NULL, NULL, NULL, 'Петров', 'Петрович', 'Пётр', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `patients_seq`
--

CREATE TABLE `patients_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `patients_seq`
--

INSERT INTO `patients_seq` (`next_val`) VALUES
(501);

-- --------------------------------------------------------

--
-- Структура таблицы `patient_sequence`
--

CREATE TABLE `patient_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `patient_sequence`
--

INSERT INTO `patient_sequence` (`next_val`) VALUES
(0);

-- --------------------------------------------------------

--
-- Структура таблицы `records`
--

CREATE TABLE `records` (
  `id` bigint NOT NULL,
  `analisis` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `diagnosis` varchar(255) DEFAULT NULL,
  `patient_info` varchar(255) DEFAULT NULL,
  `recomendations` varchar(255) DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `patient_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `record_sequence`
--

CREATE TABLE `record_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `record_sequence`
--

INSERT INTO `record_sequence` (`next_val`) VALUES
(0);

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `id` bigint NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`id`, `role`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Структура таблицы `services`
--

CREATE TABLE `services` (
  `id` bigint NOT NULL,
  `clinic_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `price` float DEFAULT NULL,
  `price_spec` varchar(255) DEFAULT NULL,
  `specification` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `service_sequence`
--

CREATE TABLE `service_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `service_sequence`
--

INSERT INTO `service_sequence` (`next_val`) VALUES
(0);

-- --------------------------------------------------------

--
-- Структура таблицы `speciality`
--

CREATE TABLE `speciality` (
  `id` bigint NOT NULL,
  `speciality` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `speciality`
--

INSERT INTO `speciality` (`id`, `speciality`) VALUES
(1, 'офтальмолог'),
(2, 'терапевт'),
(3, 'физиотерапевт'),
(4, 'психиатр'),
(5, 'хирург'),
(6, 'пульманолог');

-- --------------------------------------------------------

--
-- Структура таблицы `speciality_seq`
--

CREATE TABLE `speciality_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `speciality_seq`
--

INSERT INTO `speciality_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Структура таблицы `speciality_sequence`
--

CREATE TABLE `speciality_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `speciality_sequence`
--

INSERT INTO `speciality_sequence` (`next_val`) VALUES
(0);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `login`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `clinic`
--
ALTER TABLE `clinic`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `doctor_cat`
--
ALTER TABLE `doctor_cat`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `doctor_spec`
--
ALTER TABLE `doctor_spec`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `records`
--
ALTER TABLE `records`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `speciality`
--
ALTER TABLE `speciality`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id`),
  ADD KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `doctors`
--
ALTER TABLE `doctors`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=953;

--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `speciality`
--
ALTER TABLE `speciality`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKt7e7djp752sqn6w22i6ocqy6q` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
