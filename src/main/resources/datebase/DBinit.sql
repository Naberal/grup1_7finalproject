CREATE TABLE IF NOT EXISTS post (
  id          INT(2) AUTO_INCREMENT PRIMARY KEY,
  post        VARCHAR(100)  NOT NULL UNIQUE,
  hourly_rate DECIMAL(5, 2) NOT NULL
);
CREATE TABLE IF NOT EXISTS department (
  id   INT(2) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS workers (
  id            BINARY(16) UNIQUE                     NOT NULL PRIMARY KEY,
  first_name    VARCHAR(50)                           NOT NULL,
  last_name     VARCHAR(100)                          NOT NULL,
  post_id       INT(11)                               NOT NULL,
  FOREIGN KEY (post) REFERENCES post (id),
  department_id INT(11)                               NOT NULL,
  FOREIGN KEY (department) REFERENCES department (id),
  password      VARCHAR(100)                          NOT NULL,
  email         VARCHAR(100)                          NOT NULL UNIQUE,
  role          ENUM ('ADMIN', 'MODER', 'WORKER')     NOT NULL DEFAULT 'WORkER',
  status        ENUM ('hospital', 'work', 'vacation') NOT NULL
);

CREATE TABLE IF NOT EXISTS event (
  id   BINARY(16) UNIQUE      NOT NULL PRIMARY KEY,
  name VARCHAR(50)            NOT NULL,
  date DATE                   NOT NULL,
  time TIME                   NOT NULL,
  type ENUM ('Work', 'Study') NOT NULL,
);
CREATE TABLE IF NOT EXISTS event_participants (
  event   BINARY(16) NOT NULL,
  workers BINARY(16) NOT NULL,
  FOREIGN KEY (event) REFERENCES event (id),
  FOREIGN KEY (workers) REFERENCES workers (id)
);