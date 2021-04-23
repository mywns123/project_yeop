select * from grade order by field(gGrade,'S','A','B','C') ;
select * from laundry;
select * from customer;
select * from `order`;

select * from ctTable;
select * from odTable;
select * from sale;


select gGrade, discountRate from grade order by field(gGrade,'S','A','B','C') ;
select lLaundryCode, product, unitPrice from laundry;
select cNo, cName, gender, ponNumber, address, joinDate from customer;
select complete, `no`, ctNo, LaundryCode, color, laundryCount, receiveDate, etc from `order`;

select cNo, cName, gender, ponNumber, address, joinDate, unDelivered, count, cGrade from ctTable;
select cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable;
select lLaundryCode, totalCount, totalPrice from sale;





