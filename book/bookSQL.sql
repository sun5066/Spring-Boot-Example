CREATE database mydb;
SHOW databases;
use mydb;
show tables;
desc tbl_book;

INSERT INTO tbl_book(title, author, comp, price)
VALUES('Do it 자바', '이지즈퍼블리시', '박은종', 30000);

INSERT INTO tbl_book(title, author, comp, price)
VALUES('자바의 정석', '도우출판', '남궁성', 30000);

INSERT INTO tbl_book(title, author, comp, price)
VALUES('열혈자바', '오랜지북', '윤성우', 30000);