DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id INT ( 11 ) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR ( 250 ) NOT NULL,
	first_name VARCHAR ( 250 ) DEFAULT NULL,
    last_name VARCHAR ( 250 ) DEFAULT NULL,
    email VARCHAR ( 250 ) DEFAULT NULL,
	password VARCHAR ( 250 ) NOT NULL
);