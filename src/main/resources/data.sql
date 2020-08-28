DROP TABLE IF EXISTS shortenURL;
 
CREATE TABLE shortenurl (
  short_url VARCHAR(7)  PRIMARY KEY,
  long_url VARCHAR(250) NOT NULL
);

INSERT INTO shortenurl 
    (short_url, long_url) 
VALUES
	('AAAAAA','https://zoom.us/join');