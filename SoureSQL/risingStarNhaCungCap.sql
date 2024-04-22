use RisingStar
--đổi kiểu dữ liệu thành nvarchar(50)
ALTER TABLE NhaCungCap
ALTER COLUMN tenNCC nvarchar(50);
ALTER TABLE NhaCungCap
ALTER COLUMN diaChi nvarchar(100);
ALTER TABLE KhachHang
ALTER COLUMN diaChi nvarchar(100);
--Lọc dữ liệu
select*from [dbo].[NhaCungCap]
ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
--Nạp dữ liệu
--NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdtNCC, String email) 
DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT)), 0) + 1 FROM NhaCungCap;
DECLARE @NewMaKH VARCHAR(20);
SET @NewMaKH = 'NCC' + CAST(@NextIndex AS VARCHAR);
INSERT INTO NhaCungCap(maNCC,tenNCC,sdtNCC,email,diaChi)
VALUES (@NewMaKH, 'Kim Khánh', '02333272029', 'khanh@gmail.com', '5 Võ Nguyễn Giáp Tp. Đà Nẵng');
--Cập nhật
UPDATE [dbo].[NhaCungCap]
SET [tenNCC] = 'Van Minh',
    [diaChi] = '12 Nguyễn Thông',
    [sdtNCC] = '0981646632',
    [email] = 'vm@gmail.com'
WHERE [maNCC] = 'NCC1'
--Nạp
DECLARE @NextIndex INT;
SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT)), 0) + 1 FROM NhaCungCap;
DECLARE @NewMaNCC VARCHAR(20);
SET @NewMaNCC = 'NCC' + CAST(@NextIndex AS VARCHAR);
INSERT [dbo].[NhaCungCap] ([diaChi], [email], [maNCC], [sdtNCC], [tenNCC]) 
VALUES (N'45 Tôn Ðản Quận 4', N'mc@gmail.com', @NewMaNCC, N'02838452708', N'mcBook');
--xóa hết
DELETE FROM NhaCungCap;
--Update
UPDATE [dbo].[NhaCungCap] SET [tenNCC]= 'Minh' , [sdtNCC]= '098166354' ,[email]= 'mgit@gmail.com' ,[diaChi]= '34 Nguyễn Thông' WHERE [maNCC]= 'NCC1'
--Theo maNCC
select maNCC from [dbo].[NhaCungCap] 
ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
--Theo diaChi
select diaChi from [dbo].[NhaCungCap] 
ORDER BY diaChi;
--Theo sdt
select sdtNCC from [dbo].[NhaCungCap] 
ORDER BY sdtNCC;
select email from [dbo].[NhaCungCap] 
ORDER BY email;
--Lọc theo maNCC
select * from [dbo].[NhaCungCap]
where maNCC='NCC5'
ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
--Lọc theo tenNCC
select * from [dbo].[NhaCungCap]
where tenNCC='Văn Đạt'
ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
--Theo sdtNCC
select * from [dbo].[NhaCungCap]
where sdtNCC='02836007777'
ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
--Theo diaChi
select * from [dbo].[NhaCungCap]
where diaChi='249 Lý Thường Kiệt, KP. Thống Nhất 1, Dĩ An, Bình Dương'
ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
--Theo email
select * from [dbo].[NhaCungCap]
where email='daikavan@iuh.com'
ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
--theo tenNCC và maNCC
select * from [dbo].[NhaCungCap]
where maNCC='NCC10' and tenNCC='02838207153'
ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;