CREATE DATABASE Hospital

USE Hospital

CREATE TABLE BacSi
(
	msbacsi nvarchar(25) PRIMARY KEY,
	hotenbacsi nvarchar(150),
)

CREATE TABLE BenhNhan
(
	msbn nvarchar(15) PRIMARY KEY,
	socmnd nvarchar(25),
	hotenbn nvarchar(150),
	diachi nvarchar(250),
)

CREATE TABLE KhamBenh
(
	mskb int  PRIMARY KEY,
	msbacsi nvarchar(25),
	msbn nvarchar(15), 
	ngaykham date,
	ghichu text,
	CONSTRAINT fk_KB1 FOREIGN KEY (msbn)
	REFERENCES BenhNhan(msbn),
	CONSTRAINT fk_KB2 FOREIGN KEY (msbacsi)
	REFERENCES BacSi(msbacsi),
)

CREATE TRIGGER mskbTuDong1
ON KhamBenh
INSTEAD OF INSERT
AS
DECLARE @mskb int,@msbacsi nvarchar(25),
@msbn nvarchar(15),@ngaykham date,@ghichu nvarchar(250)
SELECT @mskb=ABS(CHECKSUM(NEWID())) % 9999,@msbacsi=msbacsi,@msbn=msbn,@ngaykham=ngaykham,@ghichu=ghichu
FROM INSERTED
INSERT INTO KhamBenh VALUES (@mskb,@msbacsi,@msbn,@ngaykham,@ghichu)

INSERT INTO KhamBenh(msbacsi,msbn,ngaykham,ghichu) VALUES ('abc','abc','2017-02-09','het thuoc')
INSERT INTO KhamBenh(msbacsi,msbn,ngaykham,ghichu) VALUES ('abc','abc','2017-02-09','het thuoc')