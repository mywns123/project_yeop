create view ctTable
as
select cNo, cName, gender, ponNumber, address, joinDate,
	count(complete =false) as unDelivered,
	count(laundryCount) as count,
	(case   when count(laundryCount) <= 50 then 'C'
			when 50 < count(laundryCount) <= 100 then 'B'
			when 100 < count(laundryCount) <= 200 then 'A'
			else 'S'
			end) as 'cGrade'
	from customer left join `order` on cNo = ctNo
	group by cNo;




create view odTable
as
select o.complete, o.`no`,
	o.ctNo, c.cName, c.cGrade, g.discountRate,
	o.color, o.LaundryCode, l.product, l.unitPrice, o.laundryCount,
	laundryCount * unitPrice*(1 - g.discountRate *0.01) as 'price',
	o.receiveDate,
	date_add(receiveDate,interval 7 day) as 'releaseDate',
	o.etc
from `order` o left join laundry l on o.LaundryCode = l.lLaundryCode
left join ctTable c on o.ctNo = c.cNo
left join grade g on c.cGrade = g.gGrade;



create view sale
as
select lLaundryCode, sum(laundryCount) as 'totalCount' , sum(price) as 'totalPrice'  
from laundry left join odTable on lLaundryCode = LaundryCode
group by lLaundryCode;





