select * from grade order by field(gGrade,'S','A','B','C') ;
select * from laundry;
select * from customer;
select * from `order`;
select * from odTable;
select * from ctTable;
select * from sale;


select gGrade, discountRate from grade order by field(gGrade,'S','A','B','C') ;
select lLaundryCode, product, unitPrice from laundry;
select cNo, cName, gender, ponNumber, address, joinDate from customer;
select complete, `no`, ctNo, LaundryCode, color, laundryCount, receiveDate, etc from `order`;
select complete, `no`, ctNo, LaundryCode, color, laundryCount, totalPrice, receiveDate, releaseDate, etc from odTable;
select cNo, cName, gender, ponNumber, address, joinDate, unDelivered, count, cGrade from ctTable;
select lLaundryCode, `sum(laundryCount)`, `sum(totalPrice)` from sale;





