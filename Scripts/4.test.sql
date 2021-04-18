select * from grade;
select * from customer;
select * from laundry;
select * from `order`;
select * from sales;

select gGrade, discountRate from grade;
select cNo, cName, gender, ponNumber, address, joinDate, unDelivered, count, cGrade from customer;
select lLaundryCode, product, unitPrice from laundry;
select complete, `no`, ctNo, LaundryCode, color, laundryCount, totalPrice, receiveDate, releaseDate, etc from `order`;
select sNo, lLaundryCode, totalCount, totalSales from sales;

select gGrade, discountRate from grade;