create view odTable
as
select complete, `no`, ctNo, LaundryCode, color, laundryCount,
		laundryCount * unitPrice as 'totalPrice',
		receiveDate,
		date_add(receiveDate,interval 7 day) as 'releaseDate',
		etc
	from `order` o left join laundry l on LaundryCode = lLaundryCode;


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

create view sale
as
select lLaundryCode, sum(laundryCount), sum(totalPrice)
from laundry left join odTable on lLaundryCode = LaundryCode
group by lLaundryCode;





