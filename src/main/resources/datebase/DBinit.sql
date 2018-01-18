CREATE TABLE IF NOT EXISTS post (
  workerId          INT(2) AUTO_INCREMENT PRIMARY KEY,
  post        VARCHAR(100)  NOT NULL UNIQUE,
  hourly_rate DECIMAL(5, 2) NOT NULL
);
CREATE TABLE IF NOT EXISTS department (
  workerId   INT(2) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS workers (
  workerId            BINARY(16) UNIQUE                     NOT NULL PRIMARY KEY,
  first_name    VARCHAR(50)                           NOT NULL,
  last_name     VARCHAR(100)                          NOT NULL,
  post_id       INT(11)                               NOT NULL,
  FOREIGN KEY (post_id) REFERENCES post (workerId),
  department_id INT(11)                               NOT NULL,
  FOREIGN KEY (department_id) REFERENCES department (workerId),
  password      VARCHAR(100)                          NOT NULL,
  email         VARCHAR(100)                          NOT NULL UNIQUE,
  role          ENUM ('ADMIN', 'MODER', 'WORKER')     NOT NULL DEFAULT 'WORKER',
  status        ENUM ('hospital', 'work', 'vacation') NOT NULL
);

CREATE TABLE IF NOT EXISTS event (
  workerId   BINARY(16) UNIQUE                    NOT NULL PRIMARY KEY,
  name VARCHAR(50)                          NOT NULL,
  date DATE                                 NOT NULL,
  time TIME                                 NOT NULL,
  type ENUM ('Work', 'Study', 'Night_time') NOT NULL
);
CREATE TABLE IF NOT EXISTS event_participants (
  event   BINARY(16) NOT NULL,
  workers BINARY(16) NOT NULL,
  FOREIGN KEY (event) REFERENCES event (workerId),
  FOREIGN KEY (workers) REFERENCES workers (workerId)
);

CREATE TABLE IF NOT EXISTS salary (
  workerId         INT(100) AUTO_INCREMENT PRIMARY KEY,
  workers_id BINARY(16)     NOT NULL,
  FOREIGN KEY (workers_id) REFERENCES workers (workerId),
  date       DATE           NOT NULL,
  time       TIME           NOT NULL,
  salary     DECIMAL(10, 2) NOT NULL
);