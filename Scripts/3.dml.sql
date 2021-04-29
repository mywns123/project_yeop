SELECT USER(), DATABASE();

select gGrade, discountRate from grade  order by field(gGrade,'S','A','B','C') ;
select lLaundryCode, product, unitPrice from laundry;
select cNo, cName, gender, ponNumber, address, joinDate from customer;
select complete, `no`, ctNo, LaundryCode, color, laundryCount, receiveDate, etc from `order`;

insert into grade(gGrade, losal, discountRate) values("S", 400001, 30);
insert into grade(gGrade, losal, hiosal, discountRate)  values("A", 200001, 400000, 20);
insert into grade(gGrade, losal, hiosal, discountRate)  values("B", 100001, 200000, 10);
insert into grade(gGrade, losal, hiosal, discountRate)  values("C", 0, 100000,5);

insert into laundry values("AAA","양복상의",8000);
insert into laundry values("BBB","양복하의",5000);
insert into laundry values("CCC","점퍼",10000);
insert into laundry values("DDD","바지",6000);
insert into laundry values("EEE","코트",15000);
insert into laundry values("FFF","치마",7000);
insert into laundry values("GGG","가디건",9000);
insert into laundry values("HHH","신발",3000);

insert into customer(cName, gender, ponNumber, address) values("이영호",0,"01012345678","달서구");
insert into customer(cName, gender, ponNumber, address) values("김상호",0,"01012345678","남구");
insert into customer(cName, gender, ponNumber, address) values("박일권",0,"01012345678","남구");
insert into customer(cName, gender, ponNumber, address) values("이기영",1,"01012345678","달서구");
insert into customer(cName, gender, ponNumber, address) values("이정호",0,"01012345678","달서구");
insert into customer(cName, gender, ponNumber, address) values("이지수",1,"01012345678","달서구");
insert into customer(cName, gender, ponNumber, address) values("기미경",1,"01012345678","달서구");
insert into customer(cName, gender, ponNumber, address) values("이정호",0,"01012345678","달서구");
insert into customer(cName, gender, ponNumber, address) values("박영호",0,"01012345678","달서구");
insert into customer(cName, gender, ponNumber, address) values("이예지",1,"01012345678","달서구");
insert into customer(cName, gender, ponNumber, address) values("이인욱",0,"01012345678","달서구");
insert into customer(cName, gender, ponNumber, address) values("이정호",0,"01012345678","달서구");

insert into  `order`(complete,ctNo, LaundryCode, color, laundryCount,receiveDate)
	values(true,5,"BBB","BLACK",7,"2021-01-01");

insert into  `order`(complete,ctNo, LaundryCode, color, laundryCount,receiveDate)
	values(true,4,"DDD","BLACK",7,"2021-02-01");

insert into  `order`(complete, ctNo, LaundryCode, color, laundryCount,receiveDate)
	values(true,3,"BBB","BLACK",7,"2021-03-01");

insert into  `order`(ctNo, LaundryCode, color, laundryCount,receiveDate,etc)
	values(8,"EEE","BLACK",7,"2021-03-04",null);

insert into  `order`(ctNo, LaundryCode, color, laundryCount,receiveDate,etc)
	values(6,"BBB","BLACK",7,"2021-03-22",null);
insert into  `order`(ctNo, LaundryCode, color, laundryCount,receiveDate,etc)
	values(9,"FFF","BLACK",7,"2021-03-25",null);

insert into  `order`(ctNo, LaundryCode, color, laundryCount,receiveDate,etc)
	values(5,"HHH","BLACK",7,"2021-03-25",null);

insert into  `order`(ctNo, LaundryCode, color, laundryCount,receiveDate,etc)
	values(7,"HHH","BLACK",7,"2021-04-01",null);

insert into  `order`(ctNo, LaundryCode, color, laundryCount,receiveDate,etc)
	values(10,"HHH","BLACK",7,"2021-04-01",null);

insert into  `order`(ctNo, LaundryCode, color, laundryCount,receiveDate,etc)
	values(11,"HHH","BLACK",7,"2021-04-01",null);

insert into  `order`(ctNo, LaundryCode, color, laundryCount,receiveDate,etc)
	values(12,"HHH","BLACK",7,"2021-04-01",null);

insert into  `order`(ctNo, LaundryCode, color, laundryCount,etc)
	values(1,"AAA","blue",3,null);

insert into  `order`(ctNo, LaundryCode, color, laundryCount,etc)
	values(2,"CCC","blue",1,null);

insert into  `order`(ctNo, LaundryCode, color, laundryCount,etc)
	values(3,"AAA","blue",4,null);

insert into  `order`(ctNo, LaundryCode, color, laundryCount,etc)
	values(4,"EEE","blue",5,null);

insert into  `order`(ctNo, LaundryCode, color, laundryCount,etc)
	values(1,"GGG","blue",2,null);


