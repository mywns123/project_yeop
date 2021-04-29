select * from grade order by field(gGrade,'S','A','B','C') ;
select * from laundry;
select * from customer;
select * from `order`;

select * from ctTable;
select * from odTable;
select * from salebylLaundry;
select * from salebyCt;
select * from salebyDate;

select gGrade, losal, hiosal, discountRate from grade order by field(gGrade,'S','A','B','C') ;
select lLaundryCode, product, unitPrice from laundry;
select cNo, cName, gender, ponNumber, address, joinDate from customer;
select complete, `no`, ctNo, LaundryCode, color, laundryCount, receiveDate, etc from `order`;

select cNo, cName, gender, ponNumber, address, joinDate, unReleased, count, cGrade from ctTable;
select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable;
select lLaundryCode, totalCount, totalPrice from salebylLaundry;
select cNo, cName, totalCount, totalPrice from salebyCt;
select `month`, lLaundryCode, totalCount, totalPrice from salebyDate;
select `month`, totalCount, totalPrice from salebyDate group by `month`;


delete from customer where cNo =7;

SELECT  COLUMN_NAME
FROM    INFORMATION_SCHEMA.columns
WHERE   TABLE_NAME = 'odTable';

select * from odTable where complete = false;

select * from odTable where complete = false and releaseDate < now();

update `order` set complete = true where  `no`=4; 

select cNo, cName, gender, ponNumber, address, joinDate, unReleased, count, cGrade from ctTable
where gender = false;

select cNo, cName, gender, ponNumber, address, joinDate, unReleased, count, cGrade from ctTable
where cName like '%이%';

where cGrade = 'A'; 


where unReleased > 0;


select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable
where complete = false and releaseDate < now() and cNo = 8; 




SELECT *
	FROM customer c LEFT JOIN `order` o ON cNo = ctNo	
	LEFT JOIN laundry l ON o.LaundryCode = l.lLaundryCode join grade g	
	GROUP BY cNo
	having sum(laundryCount * unitPrice) between g.losal and g.hiosal;