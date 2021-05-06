DROP DATABASE IF EXISTS hsdb;

CREATE DATABASE hsdb;

USE hsdb;

CREATE TABLE highscore (
    highscore_id INT AUTO_INCREMENT PRIMARY KEY,
    score INT NOT NULL,
    name VARCHAR(100)
);

INSERT INTO highscore (score, name) VALUES (1234, "Nisse");
INSERT INTO highscore (score, name) VALUES (123, "Bosse");
INSERT INTO highscore (score, name) VALUES (12, "Nisse");
INSERT INTO highscore (score, name) VALUES (345, "Lena");
INSERT INTO highscore (score, name) VALUES (5678, "Jane");
