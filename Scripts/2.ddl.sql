-- laundry_jy
DROP SCHEMA IF EXISTS laundry_jy;

-- laundry_jy
CREATE SCHEMA laundry_jy;

-- 세탁물 주문표
CREATE TABLE laundry_jy.Order (
	complete     BOOLEAN     NULL     DEFAULT  FALSE	COMMENT '완료', -- 완료
	no           INTEGER     NOT NULL COMMENT '순번', -- 순번
	ctNo         INTEGER     NULL     COMMENT '고객번호', -- 고객번호
	LaundryCode  CHAR(3)     NOT NULL COMMENT '세탁물코드', -- 세탁물코드
	color        VARCHAR(50) NULL     COMMENT '색상', -- 색상
	laundryCount INTEGER(2)  NOT NULL COMMENT '세탁수량', -- 세탁수량
	receiveDate  DATETIME    NULL 	  DEFAULT CURRENT_TIMESTAMP COMMENT '입고일', -- 입고일
	etc          VARCHAR(50) NULL     COMMENT '기타사항' -- 기타사항
)
COMMENT '세탁물 주문표';

-- 세탁물 주문표
ALTER TABLE laundry_jy.Order
	ADD CONSTRAINT PK_Order -- 세탁물 주문표 기본키
		PRIMARY KEY (
			no -- 순번
		);
	
ALTER TABLE laundry_jy.Order
	MODIFY COLUMN no INTEGER NOT NULL AUTO_INCREMENT COMMENT '순번';	

-- 등급별 할인율
CREATE TABLE laundry_jy.Grade (
	gGrade       CHAR(2)    NOT NULL COMMENT '등급', -- 등급
	discountRate INTEGER(3) NULL     COMMENT '할인율' -- 할인율
)
COMMENT '등급별 할인율';

-- 등급별 할인율
ALTER TABLE laundry_jy.Grade
	ADD CONSTRAINT PK_Grade -- 등급별 할인율 기본키
		PRIMARY KEY (
			gGrade -- 등급
		);

-- 세탁물 코드표
CREATE TABLE laundry_jy.Laundry (
	lLaundryCode CHAR(3)     NOT NULL COMMENT '세탁물코드', -- 세탁물코드
	product      VARCHAR(50) NULL     COMMENT '제품명', -- 제품명
	unitPrice    INTEGER     NULL     COMMENT '단가' -- 단가
)
COMMENT '세탁물 코드표';

-- 세탁물 코드표
ALTER TABLE laundry_jy.Laundry
	ADD CONSTRAINT PK_Laundry -- 세탁물 코드표 기본키
		PRIMARY KEY (
			lLaundryCode -- 세탁물코드
		);

-- 고객정보
CREATE TABLE laundry_jy.Customer (
	cNo       INTEGER     NOT NULL COMMENT '고객번호', -- 고객번호
	cName     VARCHAR(50) NOT NULL COMMENT '고객명', -- 고객명
	gender    TINYBLOB    NULL     COMMENT '성별', -- 성별
	ponNumber VARCHAR(30) NOT NULL COMMENT '연락처', -- 연락처
	address   VARCHAR(50) NULL     COMMENT '고객주소', -- 고객주소
	joinDate  DATETIME    NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '가입일' -- 가입일
)
COMMENT '고객정보';

-- 고객정보
ALTER TABLE laundry_jy.Customer
	ADD CONSTRAINT PK_Customer -- 고객정보 기본키
		PRIMARY KEY (
			cNo -- 고객번호
		);

ALTER TABLE laundry_jy.Customer
	MODIFY COLUMN cNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '고객번호';

-- 세탁물 주문표
ALTER TABLE laundry_jy.Order
	ADD CONSTRAINT FK_Laundry_TO_Order -- 세탁물 코드표 -> 세탁물 주문표
		FOREIGN KEY (
			LaundryCode -- 세탁물코드
		)
		REFERENCES laundry_jy.Laundry ( -- 세탁물 코드표
			lLaundryCode -- 세탁물코드
		);

-- 세탁물 주문표
ALTER TABLE laundry_jy.Order
	ADD CONSTRAINT FK_Customer_TO_Order -- 고객정보 -> 세탁물 주문표
		FOREIGN KEY (
			ctNo -- 고객번호
		)
		REFERENCES laundry_jy.Customer ( -- 고객정보
			cNo -- 고객번호
		);
