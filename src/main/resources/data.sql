DROP TABLE IF EXISTS persons;

CREATE TABLE persons (
  id INT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  age INT,
  favourite_colour VARCHAR(250) DEFAULT NULL
);