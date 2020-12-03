use mysql;
show tables ;

SHOW databases;

CREATE DATABASE mybbs;
SHOW databases;
use mybbs;
SHOW TABLES;
DESC tbl_bbs;

INSERT INTO tbl_bbs(b_writer,b_date_time,b_content,b_count)
values ('으용이가','2020-11-18','게시판만들깅',0);

SELECT * FROM tbl_bbs;
DROP TABLE tbl_book;