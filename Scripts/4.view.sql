DROP VIEW IF EXISTS ctTable;
DROP VIEW IF EXISTS odTable;

DROP VIEW IF EXISTS salebylLaundry;
DROP VIEW IF EXISTS salebyCt;
DROP VIEW IF EXISTS salebyDate;

CREATE VIEW laundry_ju.ctTable
AS
SELECT cNo, cName, gender, ponNumber, address, joinDate,
	count(complete =FALSE) AS unReleased,
	count(laundryCount) AS count,
	(CASE   WHEN count(laundryCount) <= 50 THEN 'C'
			WHEN 50 < count(laundryCount) <= 100 THEN 'B'
			WHEN 100 < count(laundryCount) <= 200 THEN 'A'
			ELSE 'S'
			END) AS 'cGrade'
	FROM customer LEFT JOIN `order` ON cNo = ctNo
	GROUP BY cNo;

CREATE VIEW laundry_ju.odTable
AS
SELECT o.complete, o.`no`,
	c.cNo, c.cName, g.gGrade, g.discountRate,
	o.color, l.lLaundryCode, l.product, l.unitPrice, o.laundryCount,
	laundryCount * unitPrice*(1 - g.discountRate *0.01) AS 'price',
	o.receiveDate,
	date_add(receiveDate,INTERVAL 7 DAY) AS 'releaseDate',
	o.etc
FROM `order` o LEFT JOIN laundry l ON o.LaundryCode = l.lLaundryCode
LEFT JOIN ctTable c ON o.ctNo = c.cNo
LEFT JOIN grade g ON c.cGrade = g.gGrade;

CREATE VIEW laundry_ju.salebylLaundry
AS
SELECT l.lLaundryCode , sum(o.laundryCount) AS 'totalCount' , sum(o.price) AS 'totalPrice'  
FROM laundry l LEFT JOIN odTable o ON l.lLaundryCode = o.lLaundryCode
GROUP BY l.lLaundryCode;

CREATE VIEW laundry_ju.salebyCt
AS
SELECT c.cNo, c.cName, sum(o.laundryCount) AS 'totalCount' , sum(o.price) AS 'totalPrice'  
FROM ctTable c LEFT JOIN odTable o ON c.cNo = o.cNo
GROUP BY c.cNo;

CREATE VIEW laundry_ju.salebyDate
AS
SELECT month(receiveDate) AS 'month' ,lLaundryCode , sum(laundryCount) AS 'totalCount' , sum(price) AS 'totalPrice'  
FROM odTable 
where year(receiveDate) = year(now())
GROUP BY month(receiveDate), lLaundryCode;




