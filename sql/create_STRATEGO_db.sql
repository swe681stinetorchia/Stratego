CREATE DATABASE 
  IF NOT EXISTS stratego;

DROP TABLE IF EXISTS stratego.movesHistory;
DROP TABLE IF EXISTS stratego.piece; 
DROP TABLE IF EXISTS stratego.piece_lookup;
DROP TABLE IF EXISTS stratego.board; 
DROP TABLE IF EXISTS stratego.game; 
DROP TABLE IF EXISTS stratego.player; 
DROP TABLE IF EXISTS stratego.users; 

CREATE TABLE stratego.users (
    id int NOT NULL auto_increment,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    isActive TINYINT NOT NULL,
    dateAdded datetime NOT NULL,
    session_id VARCHAR(255) NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;


CREATE TABLE stratego.player (
    id int NOT NULL auto_increment,
    user_id int NOT NULL,
    lastLogin datetime NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES stratego.users(id)
)  ENGINE=INNODB;

CREATE TABLE stratego.game (
    id VARCHAR(36) NOT NULL,
    player_one int NOT NULL,
	player_two int NOT NULL,
    startTime datetime NOT NULL,
    winner int null,
    loser int NULL,
    nextTurn int NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (player_one) REFERENCES stratego.users(id),
	FOREIGN KEY (player_two) REFERENCES stratego.users(id)
)  ENGINE=INNODB;

CREATE TABLE stratego.board (
    id int NOT NULL auto_increment,
    game_id VARCHAR(36) NOT NULL,
	position_1_1 int NOT NULL,
	position_1_2 int NOT NULL,
	position_1_3 int NOT NULL,
	position_1_4 int NOT NULL,
	position_1_5 int NOT NULL,
	position_1_6 int NOT NULL,
	position_1_7 int NOT NULL,
	position_1_8 int NOT NULL,
	position_1_9 int NOT NULL,
	position_1_10 int NOT NULL,
	position_2_1 int NOT NULL,
	position_2_2 int NOT NULL,
	position_2_3 int NOT NULL,
	position_2_4 int NOT NULL,
	position_2_5 int NOT NULL,
	position_2_6 int NOT NULL,
	position_2_7 int NOT NULL,
	position_2_8 int NOT NULL,
	position_2_9 int NOT NULL,
	position_2_10 int NOT NULL,
	position_3_1 int NOT NULL,
	position_3_2 int NOT NULL,
	position_3_3 int NOT NULL,
	position_3_4 int NOT NULL,
	position_3_5 int NOT NULL,
	position_3_6 int NOT NULL,
	position_3_7 int NOT NULL,
	position_3_8 int NOT NULL,
	position_3_9 int NOT NULL,
	position_3_10 int NOT NULL,
	position_4_1 int NOT NULL,
	position_4_2 int NOT NULL,
	position_4_3 int NOT NULL,
	position_4_4 int NOT NULL,
	position_4_5 int NOT NULL,
	position_4_6 int NOT NULL,
	position_4_7 int NOT NULL,
	position_4_8 int NOT NULL,
	position_4_9 int NOT NULL,
	position_4_10 int NOT NULL,
	position_5_1 int NOT NULL,
	position_5_2 int NOT NULL,
	position_5_3 int NOT NULL,
	position_5_4 int NOT NULL,
	position_5_5 int NOT NULL,
	position_5_6 int NOT NULL,
	position_5_7 int NOT NULL,
	position_5_8 int NOT NULL,
	position_5_9 int NOT NULL,
	position_5_10 int NOT NULL,
	position_6_1 int NOT NULL,
	position_6_2 int NOT NULL,
	position_6_3 int NOT NULL,
	position_6_4 int NOT NULL,
	position_6_5 int NOT NULL,
	position_6_6 int NOT NULL,
	position_6_7 int NOT NULL,
	position_6_8 int NOT NULL,
	position_6_9 int NOT NULL,
	position_6_10 int NOT NULL,
	position_7_1 int NOT NULL,
	position_7_2 int NOT NULL,
	position_7_3 int NOT NULL,
	position_7_4 int NOT NULL,
	position_7_5 int NOT NULL,
	position_7_6 int NOT NULL,
	position_7_7 int NOT NULL,
	position_7_8 int NOT NULL,
	position_7_9 int NOT NULL,
	position_7_10 int NOT NULL,
	position_8_1 int NOT NULL,
	position_8_2 int NOT NULL,
	position_8_3 int NOT NULL,
	position_8_4 int NOT NULL,
	position_8_5 int NOT NULL,
	position_8_6 int NOT NULL,
	position_8_7 int NOT NULL,
	position_8_8 int NOT NULL,
	position_8_9 int NOT NULL,
	position_8_10 int NOT NULL,
	position_9_1 int NOT NULL,
	position_9_2 int NOT NULL,
	position_9_3 int NOT NULL,
	position_9_4 int NOT NULL,
	position_9_5 int NOT NULL,
	position_9_6 int NOT NULL,
	position_9_7 int NOT NULL,
	position_9_8 int NOT NULL,
	position_9_9 int NOT NULL,
	position_9_10 int NOT NULL,
	position_10_1 int NOT NULL,
	position_10_2 int NOT NULL,
	position_10_3 int NOT NULL,
	position_10_4 int NOT NULL,
	position_10_5 int NOT NULL,
	position_10_6 int NOT NULL,
	position_10_7 int NOT NULL,
	position_10_8 int NOT NULL,
	position_10_9 int NOT NULL,
	position_10_10 int NOT NULL,	
    PRIMARY KEY (id),
	FOREIGN KEY (game_id) REFERENCES stratego.game(id)
)  ENGINE=INNODB;

CREATE TABLE stratego.piece_lookup (
    piece_id INT AUTO_INCREMENT,
    piece VARCHAR(255) NOT NULL,
    PRIMARY KEY (piece_id)
);

insert into stratego.piece_lookup (piece)
VALUES ('Flag');

insert into stratego.piece_lookup (piece)
VALUES ('Bomb');

insert into stratego.piece_lookup (piece)
VALUES ('Marshal');

insert into stratego.piece_lookup (piece)
VALUES ('General');

insert into stratego.piece_lookup (piece)
VALUES ('Colonel');

insert into stratego.piece_lookup (piece)
VALUES ('Major');

insert into stratego.piece_lookup (piece)
VALUES ('Captain');

insert into stratego.piece_lookup (piece)
VALUES ('Lieutenant');

insert into stratego.piece_lookup (piece)
VALUES ('Sergeant');

insert into stratego.piece_lookup (piece)
VALUES ('Miner');

insert into stratego.piece_lookup (piece)
VALUES ('Scout');

insert into stratego.piece_lookup (piece)
VALUES ('Spy');

insert into stratego.piece_lookup (piece)
VALUES ('Empty');

CREATE TABLE stratego.piece (
    id int NOT NULL auto_increment,
    piece_id int NOT NULL,
	owner int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (piece_id) REFERENCES stratego.piece_lookup(piece_id),
	FOREIGN KEY (owner) REFERENCES stratego.player(id)
)  ENGINE=INNODB;

CREATE TABLE stratego.movesHistory (
    id int NOT NULL auto_increment,
    user_id int NOT NULL,
    game_id VARCHAR(36) NOT NULL,
	move VARCHAR(12),
    dateAdded datetime NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES stratego.users(id),
	FOREIGN KEY (game_id) REFERENCES stratego.game(id)
)  ENGINE=INNODB;

