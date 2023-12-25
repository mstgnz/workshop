-- -------------------------------------------------------------
-- TablePlus 4.5.0(396)
--
-- https://tableplus.com/
--
-- Database: PatikaClone
-- Generation Time: 2021-10-24 00:00:20.6920
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


CREATE TABLE `contents` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `course_id` int NOT NULL,
  `title` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `contents_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE,
  CONSTRAINT `contents_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `patika_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `language` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `patika_id` (`patika_id`),
  CONSTRAINT `courses_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `courses_ibfk_4` FOREIGN KEY (`patika_id`) REFERENCES `patika` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `patika` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `quiz` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content_id` int NOT NULL,
  `question` varchar(255) NOT NULL,
  `a` varchar(255) NOT NULL,
  `b` varchar(255) NOT NULL,
  `c` varchar(255) NOT NULL,
  `d` varchar(255) NOT NULL,
  `answer` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `content_id` (`content_id`),
  CONSTRAINT `quiz_ibfk_1` FOREIGN KEY (`content_id`) REFERENCES `contents` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lastname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` enum('moderator','educator','student') NOT NULL DEFAULT 'student',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

INSERT INTO `contents` (`id`, `user_id`, `course_id`, `title`, `content`, `link`) VALUES
(6, 2, 1, '1.ders', '1.ders içerik', 'youtube link');

INSERT INTO `courses` (`id`, `user_id`, `patika_id`, `name`, `language`) VALUES
(1, 2, 1, 'Javaya Giriş', 'javaya`asas'),
(7, 2, 2, 'bu nedir', 'sdsds');

INSERT INTO `patika` (`id`, `name`) VALUES
(1, 'java Patikası'),
(2, 'Node JS Patikası'),
(5, 'Golang Patikası');

INSERT INTO `quiz` (`id`, `content_id`, `question`, `a`, `b`, `c`, `d`, `answer`) VALUES
(2, 6, 'iki sıfır iki dört', '0044', '2044', '0024', '2024', 'D');

INSERT INTO `users` (`id`, `firstname`, `lastname`, `email`, `password`, `type`, `create_date`, `update_date`) VALUES
(1, 'Mesut', 'GENEZ', 'mesutgenez@hotmail.com', 'asdf1234', 'moderator', '2021-10-18 22:47:38', '2021-10-18 22:47:38'),
(2, 'Burak', 'GENEZ', 'burakgenez@hotmail.com', 'asdf1234', 'educator', '2021-10-18 23:09:11', '2021-10-22 11:04:13'),
(3, 'Ahmet', 'GENEZ', 'ahmetgenez@hotmail.com', 'asdf1234', 'student', '2021-10-18 23:09:28', '2021-10-22 16:56:39'),
(4, 'Muhammet', 'GENEZ', 'muhammetgenez@hotmail.com', 'asdf1234', 'student', '2021-10-22 16:56:39', '2021-10-22 16:56:43');



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;