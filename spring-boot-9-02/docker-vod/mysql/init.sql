CREATE TABLE `manga_store`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `logo` text         NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `mangaka`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `firstname` varchar(255) NOT NULL,
    `lastname`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `manga`
(
    `id`         int          NOT NULL AUTO_INCREMENT,
    `poster`     varchar(255) NOT NULL,
    `rating`     float DEFAULT NULL,
    `title`      varchar(255) NOT NULL,
    `mangaka_id` int   DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `manga_manga_store`
(
    `manga_id`       int NOT NULL,
    `manga_store_id` int NOT NULL,
    PRIMARY KEY (`manga_id`, `manga_store_id`)
);

INSERT INTO `mangaka` (`id`, `firstname`, `lastname`)
VALUES (1, 'Eiichiro', 'Oda'),
       (2, 'Masashi', 'Kishimoto'),
       (3, 'Akira', 'Toriyama'),
       (4, 'Hajime', 'Isayama');

INSERT INTO `manga` (`id`, `title`, `poster`, `rating`, `mangaka_id`)
VALUES (1, 'One Piece', 'https://upload.wikimedia.org/wikipedia/en/2/2c/OnePiece61Cover.png', 4.9, 1),
       (2, 'Naruto', 'https://upload.wikimedia.org/wikipedia/en/9/94/NarutoCoverTankobon1.jpg', 4.8, 2),
       (3, 'Boruto', 'https://upload.wikimedia.org/wikipedia/en/9/94/Boruto_manga_vol_1.jpg', 3.9, 2),
       (4, 'Dragon Ball', 'https://upload.wikimedia.org/wikipedia/en/c/c9/DB_Tankobon.png', 4.7, 3),
       (5, 'Dragon Ball Super', 'https://upload.wikimedia.org/wikipedia/en/7/72/Dragon_Ball_Super_Volume_1.png', 4.5, 3),
       (6, 'Attack on Titan', 'https://upload.wikimedia.org/wikipedia/en/7/70/Attack_on_Titan_cover.jpg', 4.9, 4),
       (7, 'Attack on Titan Final Season', 'https://upload.wikimedia.org/wikipedia/en/7/7a/Attack_on_Titan_volume_34_cover.jpg', 4.8, 4),
       (8, 'Wanted!', 'https://upload.wikimedia.org/wikipedia/en/7/7d/Wanted_Eiichiro_Oda.png', 4.2, 1);

INSERT INTO `manga_store` (`id`, `name`, `logo`)
VALUES (1, 'Yatta.pl', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3uyuOw9Mhm4R1khCPlGHWfOscPIxsBZOYnQ&s'),
       (2, 'Animate Ikebukuro', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAACo...'),
       (3, 'Mandarake Complex', 'data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD...'),
       (4, 'Kinokuniya Shinjuku', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAATYAAACj...');

INSERT INTO `manga_manga_store` (`manga_id`, `manga_store_id`)
VALUES (1, 1), -- One Piece w Yatta.pl
       (1, 2), -- One Piece w Animate Ikebukuro
       (2, 2), -- Naruto w Animate Ikebukuro
       (3, 2), -- Boruto w Animate Ikebukuro
       (5, 1), -- Dragon Ball Super w Yatta.pl
       (5, 3), -- Dragon Ball Super w Mandarake Complex
       (6, 3), -- Attack on Titan w Mandarake Complex
       (6, 4), -- Attack on Titan w Kinokuniya Shinjuku
       (3, 4); -- Boruto w Kinokuniya Shinjuku

CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser2', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser3', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS');

INSERT INTO role(username, role)
VALUES ('dbuser1', 'USER_ADMIN'),
       ('dbuser2', 'MANGAKA_ADMIN'),
       ('dbuser3', 'MANGA_ADMIN');