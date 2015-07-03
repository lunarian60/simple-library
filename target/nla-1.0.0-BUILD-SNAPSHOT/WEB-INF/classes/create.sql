CREATE TABLE PERSON (
  person_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  phone_number VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY (person_id));
  
CREATE TABLE BOOK (
  book_id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL,
  author VARCHAR(45) NOT NULL,
  isbn VARCHAR(45) NOT NULL,
  person_id INT NOT NULL,
  PRIMARY KEY (book_id));

CREATE INDEX fk_book_person 
    ON PERSON(person_id ASC);

ALTER TABLE BOOK 
    ADD CONSTRAINT fk_book_person 
    FOREIGN KEY (person_id) 
    REFERENCES PERSON(person_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION;