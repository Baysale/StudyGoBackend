CREATE DATABASE IF NOT EXISTS studygo;
USE studygo;

INSERT INTO Role (id, name) VALUES (1, 'Admin') ON DUPLICATE KEY UPDATE name = name;
INSERT INTO Role (id, name) VALUES (2, 'USER') ON DUPLICATE KEY UPDATE name = name;