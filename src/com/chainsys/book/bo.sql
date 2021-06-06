Create table book_2590 (id number,name varchar(200),Publish_date date);
insert into book_2590 values(1, 'Wild Things', DATE '2003-02-01');
insert into book_2590 values(2, 'Mysterious World',  DATE '2006-04-08');
insert into book_2590 values(3, 'Crime',  DATE '2009-02-05');
insert into book_2590 values(4, 'Harry Potter',  DATE '2000-02-11');
insert into book_2590 values(5, 'Little Princess',  DATE '2001-07-10');

commit;
select * from book_2590;