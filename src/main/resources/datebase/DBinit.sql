CREATE TABLE IF NOT EXISTS post (
  id          INT(2) AUTO_INCREMENT PRIMARY KEY,
  post        VARCHAR(100)  NOT NULL UNIQUE,
  hourly_rate DECIMAL(5, 2) NOT NULL
);
CREATE TABLE IF NOT EXISTS department (
  id   INT(2) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS role (
  id   INT(2) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL  UNIQUE
);
CREATE TABLE IF NOT EXISTS workers (
  id         BINARY(16) UNIQUE NOT NULL PRIMARY KEY,
  first_name VARCHAR(50)       NOT NULL,
  last_name  VARCHAR(100)      NOT NULL,
  post       INT(2)            NOT NULL,
  FOREIGN KEY (post) REFERENCES post (id),
  department INT(2)            NOT NULL,
  FOREIGN KEY (department) REFERENCES department (id),
  password   INT(100)          NOT NULL,
  email      VARCHAR(100)      NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS event_type (
  id   INT(2) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL  UNIQUE
);
CREATE TABLE IF NOT EXISTS event (
  id   BINARY(16) UNIQUE NOT NULL PRIMARY KEY,
  name VARCHAR(50)       NOT NULL,
  date DATE              NOT NULL,
  time TIME              NOT NULL,
  type INT(2)            NOT NULL,
  FOREIGN KEY (type) REFERENCES event_type (id)
);
CREATE TABLE IF NOT EXISTS event_participants (
  event   BINARY(16) NOT NULL,
  workers BINARY(16) NOT NULL,
  FOREIGN KEY (event) REFERENCES event (id),
  FOREIGN KEY (workers) REFERENCES workers (id)
);