-- Laundry
DROP SCHEMA IF EXISTS laundry;

-- Laundry
CREATE SCHEMA laundry;

-- 세탁물 주문표
CREATE TABLE laundry.Order (
	complete     BOOLEAN     NULL     COMMENT '완료', -- 완료
	no           INTEGER     NOT NULL COMMENT '순번', -- 순번
	ctNo         INTEGER     NULL     COMMENT '고객번호', -- 고객번호
	LaundryCode  char(3)     NOT NULL COMMENT '세탁물코드', -- 세탁물코드
	color        VARCHAR(50) NULL     COMMENT '색상', -- 색상
	laundryCount INTEGER(2)  NOT NULL COMMENT '세탁수량', -- 세탁수량
	totalPrice   INTEGER     NULL COMMENT '세탁가격', -- 세탁가격
	receiveDate  DATETIME    default CURRENT_TIMESTAMP COMMENT '입고일', -- 입고일
	releaseDate  DATETIME    NULL COMMENT '출고일', -- 출고일
	etc          CHAR        NULL     COMMENT '기타사항' -- 기타사항
)
COMMENT '세탁물 주문표';

-- 세탁물 주문표
ALTER TABLE laundry.Order
	ADD CONSTRAINT PK_Order -- 세탁물 주문표 기본키
		PRIMARY KEY (
			no -- 순번
		);

-- 등급별 할인율
CREATE TABLE laundry.Grade (
	gGrade       CHAR(2)    NOT NULL COMMENT '등급', -- 등급
	discountRate INTEGER(3) NULL     COMMENT '할인율' -- 할인율
)
COMMENT '등급별 할인율';

-- 등급별 할인율
ALTER TABLE laundry.Grade
	ADD CONSTRAINT PK_Grade -- 등급별 할인율 기본키
		PRIMARY KEY (
			gGrade -- 등급
		);

-- 세탁물 코드표
CREATE TABLE laundry.Laundry (
	lLaundryCode char(3)     NOT NULL COMMENT '세탁물코드', -- 세탁물코드
	product      VARCHAR(50) NULL     COMMENT '제품명', -- 제품명
	unitPrice    INTEGER     NULL     COMMENT '단가' -- 단가
)
COMMENT '세탁물 코드표';

-- 세탁물 코드표
ALTER TABLE laundry.Laundry
	ADD CONSTRAINT PK_Laundry -- 세탁물 코드표 기본키
		PRIMARY KEY (
			lLaundryCode -- 세탁물코드
		);

-- 고객정보
CREATE TABLE laundry.Customer (
	cNo         INTEGER     NOT NULL COMMENT '고객번호', -- 고객번호
	cName       VARCHAR(50) NOT NULL COMMENT '고객명', -- 고객명
	gender      BOOLEAN     NULL     COMMENT '성별', -- 성별
	ponNumber   VARCHAR(30) NOT NULL COMMENT '연락처', -- 연락처
	address     VARCHAR(50) NULL     COMMENT '고객주소', -- 고객주소
	joinDate    DATETIME    NULL     COMMENT '가입일', -- 가입일
	unDelivered INTEGER     NULL     COMMENT '미출고량', -- 미출고량
	count       INTEGER     NULL     COMMENT '총거래량' -- 총거래량
)
COMMENT '고객정보';

-- 고객정보
ALTER TABLE laundry.Customer
	ADD CONSTRAINT PK_Customer -- 고객정보 기본키
		PRIMARY KEY (
			cNo -- 고객번호
		);

ALTER TABLE laundry.Customer
	MODIFY COLUMN cNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '고객번호';

-- 세탁물 주문표
ALTER TABLE laundry.Order
	ADD CONSTRAINT FK_Laundry_TO_Order -- 세탁물 코드표 -> 세탁물 주문표
		FOREIGN KEY (
			LaundryCode -- 세탁물코드
		)
		REFERENCES laundry.Laundry ( -- 세탁물 코드표
			lLaundryCode -- 세탁물코드
		);

-- 세탁물 주문표
ALTER TABLE laundry.Order
	ADD CONSTRAINT FK_Customer_TO_Order -- 고객정보 -> 세탁물 주문표
		FOREIGN KEY (
			ctNo -- 고객번호
		)
		REFERENCES laundry.Customer ( -- 고객정보
			cNo -- 고객번호
		);