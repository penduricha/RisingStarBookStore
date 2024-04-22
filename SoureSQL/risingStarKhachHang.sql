--insert maKH t? 1-1000
--KhachHang
--l?c KhachHang tang d?n theo maKH
use RisingStar
--Lấy full dữ liệu
SELECT *
FROM KhachHang
ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;
--xóa d? li?u b?ng KhachHang
DELETE FROM KhachHang;
--chuyển đổi dữ liệu maKH thành tự phát sinh
-- Xác định index tiếp theo trong bảng KhachHang
--insert KhachHang
DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT)), 0) + 1 FROM KhachHang;
-- Tạo mã maKH dựa trên index
DECLARE @NewMaKH VARCHAR(20);
SET @NewMaKH = 'KH' + CAST(@NextIndex AS VARCHAR);
INSERT INTO KhachHang (maKH, tenKH, sdt, gioiTinh, diaChi)
VALUES (@NewMaKH, 'Van Minh', '0976646635', 1, '1 Os street');
--NẠP Dữ liệu
--chạy từng cái
DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT)), 0) + 1 FROM KhachHang;
DECLARE @NewMaKH VARCHAR(20);
SET @NewMaKH = 'KH' + CAST(@NextIndex AS VARCHAR);
INSERT INTO KhachHang (maKH, tenKH, sdt, gioiTinh, diaChi)
VALUES (@NewMaKH, 'Minh Anh', '0976646635', 0, '3 Ras street');
--
DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT)), 0) + 1 FROM KhachHang;
DECLARE @NewMaKH VARCHAR(20);
SET @NewMaKH = 'KH' + CAST(@NextIndex AS VARCHAR);
INSERT INTO KhachHang (maKH, tenKH, sdt, gioiTinh, diaChi)
VALUES (@NewMaKH, 'Minh Đăng', '0976646635', 1, '3 Ras street');
--xóa theo điều kiện
DELETE FROM KhachHang where maKH='KH11';
--cập nhật theo điều kiện
UPDATE KhachHang
SET tenKH = 'Van Dat', sdt = '0987646656', gioiTinh = 1, diaChi = 'Main Board'
WHERE maKH = 'KH8';
--Lấy cột maKH và sắp xếp theo KH1 KH2 KH3
SELECT maKH
FROM KhachHang
ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;
--Lấy cột tenKH
SELECT tenKH
FROM KhachHang
ORDER BY tenKH ASC;
--Lấy cột diaChi
SELECT diaChi
FROM KhachHang
ORDER BY diaChi ASC;
--Lấy cột sdt
SELECT sdt
FROM KhachHang
ORDER BY sdt ASC;
--Lấy dữ liệu KhachHang theo maKH
SELECT *
FROM KhachHang
WHERE maKH='KH1';
--Lấy dữ liệu KhachHang theo gioiTinh
SELECT *
FROM KhachHang
WHERE gioiTinh=1
ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;
--Theo tên
SELECT *
FROM KhachHang
WHERE tenKH='Van An'
ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;
--Truy vấn đặt biệt
SELECT *
FROM KhachHang
WHERE
    tenKH = 'Van Minh'
    AND sdt = '0976646635'
    AND gioiTinh = 1
    AND diaChi = '1 Os street';
--theo tên và địa chỉ
SELECT *
FROM KhachHang
WHERE 
	tenKH='Dương Nhi'
	--AND diaChi='1 Os street'
ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;
--theo tên và sdt
SELECT *
FROM KhachHang
WHERE 
	tenKH='Van Minh'
	AND sdt='0976646635';
--theo ten va gioiTinh
SELECT *
FROM KhachHang
WHERE 
	tenKH='Van Minh'
	AND gioiTinh=1
ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;

DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT)), 0) + 1 FROM KhachHang;
DECLARE @NewMaKH VARCHAR(20);
SET @NewMaKH = 'KH' + CAST(@NextIndex AS VARCHAR);
INSERT [dbo].[KhachHang] ([gioiTinh], [diaChi], [maKH], [sdt], [tenKH]) VALUES (0, N'Trường Chinh Khu Liên Hợp Tân An', @NewMaKH, N'0817646656', N'Nguyễn Khang')

DELETE FROM KhachHang;
--Làm lại

SELECT *
FROM KhachHang
WHERE tenKH='Le Thanh Teo'
ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;
--RisingStar
use RisingStarDataBase
SELECT *
FROM KhachHang
--
SELECT SERVERPROPERTY('Collation');
SELECT DATABASEPROPERTYEX('RisingStarDataBase', 'Collation') 

use RisingStar
select * from KhachHang

SELECT *
FROM KhachHang
WHERE tenKH  = 'Lê Thanh Ngọc'
ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;
--Lấy dữ liệu
select * from [dbo].[KhachHang]
ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;
--
SELECT * FROM [dbo].[KhachHang] ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;