CREATE TABLE 'Students' (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'firstName' varchar(255) NOT NULL,
  'lastName' varchar(255) NOT NULL,
  'year' varchar(255) NOT NULL,
  'school' varchar(255) NOT NULL,
  'username' varchar(255) NOT NULL,
  'password' varchar(255) NOT NULL,
  PRIMARY KEY ('id'),
  UNIQUE KEY 'id_UNIQUE' ('id'),
  UNIQUE KEY 'username_UNIQUE' ('username')
);

CREATE TABLE 'admin_user' (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'username' varchar(255) NOT NULL,
  'password' varchar(255) NOT NULL,
  PRIMARY KEY ('id'),
  UNIQUE KEY 'username_UNIQUE' ('username')
);
