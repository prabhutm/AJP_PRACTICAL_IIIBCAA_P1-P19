drop database PRT1;
CREATE DATABASE PRT1;

USE PRT1;

CREATE TABLE Authors (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);

CREATE TABLE Titles (
    isbn VARCHAR(20) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE AuthorISBN (
    author_id INT,
    isbn VARCHAR(20),
    PRIMARY KEY (author_id, isbn),
    FOREIGN KEY (author_id) REFERENCES Authors(author_id),
    FOREIGN KEY (isbn) REFERENCES Titles(isbn)
);

SELECT * FROM Authors;
Select * from AuthorISBN;