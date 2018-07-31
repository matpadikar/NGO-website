CREATE TABLE restaurant (
  resId VARCHAR(10) NOT NULL,
  resName VARCHAR(100) NOT NULL,
  resAddress VARCHAR(150) NOT NULL,
  resMob VARCHAR(15) NOT NULL,
  resEmail VARCHAR(25),
  resOwner VARCHAR(25),
  PRIMARY KEY (resId)
);