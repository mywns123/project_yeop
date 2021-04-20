select * from grade;
select * from laundry;

select * from customer;
select * from `order`;

select gGrade, discountRate from grade;
select lLaundryCode, product, unitPrice from laundry;

select cNo, cName, gender, ponNumber, address, joinDate from customer;
select complete, `no`, ctNo, LaundryCode, color, laundryCount, receiveDate, etc from `order`;

select complete, `no`, ctNo, LaundryCode, color, laundryCount,
		laundryCount * unitPrice as 'totalPrice',
		receiveDate,
		receiveDate + '7day' as 'releaseDate',
		etc
	from `order` o left join laundry l on LaundryCode = lLaundryCode;

select cNo, cName, gender, ponNumber, address, joinDate,
		count(complete = false) as 'unDelivered',
		count(ctNo) as 'count',
		(case
			when count(ctNo) <= 50 then 'C'
			when 50 < count(ctNo) <= 100 then 'B'
			when 100 < count(ctNo) <= 200 then 'A'
			else 'S'
			end) as 'cGrade'
	from customer left join `order` on ctNo = cNo;

select lLaundryCode, count(), sum()
	from laundry left join `order` on lLaundryCode = LaundryCode;
