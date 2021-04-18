select user(), database();

select gGrade, discountRate from grade;
select lLaundryCode, product, unitPrice from laundry;

select cNo, cName, gender, ponNumber, address, joinDate, unDelivered, count, cGrade from customer;
select complete, `no`, ctNo, LaundryCode, color, laundryCount, totalPrice, receiveDate, releaseDate, etc from `order`;

select sNo, lLaundryCode, totalCount, totalSales from sales;


insert into grade values("S",30);
insert into grade values("A",20);
insert into grade values("B",10);
insert into grade values("C",5);

insert into laundry values("AAA","양복상의",8000);
insert into laundry values("BBB","양복하의",5000);
insert into laundry values("CCC","점퍼",10000);
insert into laundry values("DDD","바지",6000);
insert into laundry values("EEE","코트",15000);
insert into laundry values("FFF","치마",7000);
insert into laundry values("GGG","가디건",9000);
insert into laundry values("HHH","신발",3000);

insert into customer(cName, gender, ponNumber, address) values("이영호",true,"01012345678","달서구");

insert into customer values(1,"이영호",true,"01012345678","달서구","2021-04-18",0,0,null);
insert into customer values(2,"이영호",true,"01012345678","달서구",null,0,0,null);
insert into customer values(3,"이영호",true,"01012345678","달서구",null,0,0,null);



insert into Customer values(2,"김상호","S",01012345678);
insert into Customer values(3,"박일권","B",01012345678);
insert into Customer values(4,"이기영","B",01012345678);
insert into Customer values(5,"이정호","C",01012345678);

