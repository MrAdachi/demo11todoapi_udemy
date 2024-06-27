DROP TABLE IF EXISTS samples;
DROP TABLE IF EXISTS tasks;

CREATE TABLE samples(
	id INTEGER NOT NULL AUTO_INCREMENT,
	content VARCHAR(256) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE tasks(
	id INTEGER NOT NULL AUTO_INCREMENT,
	title VARCHAR(256) NOT NULL,
	PRIMARY KEY(id)
);