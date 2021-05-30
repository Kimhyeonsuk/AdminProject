insert into person(`id`,`name`,`age`,`blood_type`,`year_of_birthday`,`month_of_birthday`,`day_of_birthday`) values(1,'martin',12,'A',1991,8,21)
insert into person(`id`,`name`,`age`,`blood_type`,`year_of_birthday`,`month_of_birthday`,`day_of_birthday`) values(2,'david',12,'B',1993,10,2)
insert into person(`id`,`name`,`age`,`blood_type`,`year_of_birthday`,`month_of_birthday`,`day_of_birthday`) values(3,'dennis',12,'O',1997,2,1)
insert into person(`id`,`name`,`age`,`blood_type`,`year_of_birthday`,`month_of_birthday`,`day_of_birthday`) values(4,'sophia',12,'AB',1997,2,14)
insert into person(`id`,`name`,`age`,`blood_type`,`year_of_birthday`,`month_of_birthday`,`day_of_birthday`) values(5,'berry',12,'A',1995,8,31)


insert into block(`id`,`name`) values(1,'dennis')
insert into block(`id`,`name`) values(2,'sophia')

update person set block_id=1 where id=3
update person set block_id=2 where id=4