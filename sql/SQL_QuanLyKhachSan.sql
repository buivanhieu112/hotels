
create database QLKS
go
use QLKS

go
create table ChucVu
(
	maCV varchar(6) not null primary key,
	tenCV nvarchar(255),
)
create table LoaiPhong
(
	maLP varchar(6) not null primary key,
	tenLP nvarchar(255),
	giaLP money
)

create table Phong
(
	maPhong varchar(6) not null primary key,
	maLP varchar(6) not null,
	tenPhong nvarchar(255),
	tinhTrang nvarchar(255)
)

create table KhachHang
(	
	maKH varchar(6) not null primary key,
	tenKH nvarchar(255) not null,
	gioiTinh nvarchar(4),
	diaChi nvarchar(255) ,
	soCMND varchar(9) not null,
	soDT varchar(10) not null,
)
tie
create table NhanVien
(
	maNV varchar(6) not null primary key,
	tenNV nvarchar(255) not null,
	gioiTinh nvarchar(4),
	soCMND varchar(12) not null,
	maCV varchar(6) not null,
	soDT varchar(10),
	ngayVaoLam date,
	matKhau varchar(10),
	tinhTrang bit
)

create table DonVi
(
	maDonVi varchar(6) not null primary key,
	tenDonVi nvarchar(255) not null
)

create table LoaiDichVu
(
	maLDV varchar(6) not null primary key,
	tenLDV nvarchar(255)not null
)

create table DichVu
(
	maDV varchar(6) not null primary key,
	maLDV varchar(6) not null,
	maDonVi varchar(6) not null,
	tenDV nvarchar(255) not null,
	soLuongTon int,
	donGia money
)

create table DichVuSuDung
(
	maHDDV int identity(1,1) not null primary key,
	maPT int not null,
	maDV varchar(6) not null,
	soLuong int,
	gioDatDV datetime,
	tienDV money
)

create table PhieuThue
(
	maPT int identity(1,1) not null primary key,
	maPhong varchar(6) not null,
	maHD varchar(6) not null,
	tinhTrang nvarchar(255),
	ngayDatPhong datetime,
	ngayTraPhong datetime,
	tienPhong money,
	tienCoc money,
)

create table HoaDon
(
	maHD varchar(6) not null primary key,
	maNV varchar(6),
	maKH varchar(6) not null,
	ngayLapHD datetime,
	tongTien money,
	tinhTrang bit
)

ALTER TABLE [dbo].[NhanVien]
	ADD CONSTRAINT fk_MaCV FOREIGN KEY([maCV]) 
	REFERENCES [dbo].[ChucVu]([maCV])

ALTER TABLE [dbo].[Phong]
	ADD CONSTRAINT fk_MaLP FOREIGN KEY([maLP]) 
	REFERENCES [dbo].[LoaiPhong]([maLP])

ALTER TABLE [dbo].[DichVu]
	ADD CONSTRAINT fk_MaLDV FOREIGN KEY([maLDV]) 
	REFERENCES [dbo].[LoaiDichVu]([maLDV])

ALTER TABLE [dbo].[DichVu]
	ADD CONSTRAINT fk_MaDonVi FOREIGN KEY([maDonVi]) 
	REFERENCES [dbo].[DonVi]([maDonVi])

ALTER TABLE [dbo].[PhieuThue]
	ADD CONSTRAINT fk_PTP FOREIGN KEY([maPhong]) 
	REFERENCES [dbo].[Phong]([maPhong])

ALTER TABLE [dbo].[PhieuThue]
	ADD CONSTRAINT fk_PTHD FOREIGN KEY([maHD]) 
	REFERENCES [dbo].[HoaDon]([maHD])

ALTER TABLE [dbo].DichVuSuDung
	ADD CONSTRAINT fk_DV FOREIGN KEY([maDV]) 
	REFERENCES [dbo].[DichVu]([maDV])

ALTER TABLE [dbo].DichVuSuDung
	ADD CONSTRAINT fk_MaPT FOREIGN KEY([maPT])
	REFERENCES [dbo].[PhieuThue]([maPT])

ALTER TABLE [dbo].[HoaDon]
	ADD CONSTRAINT fk_MaKH FOREIGN KEY([maKH]) 
	REFERENCES [dbo].[KhachHang]([maKH])

ALTER TABLE [dbo].[HoaDon]
	ADD CONSTRAINT fk_MaNV FOREIGN KEY([maNV]) 
	REFERENCES [dbo].[NhanVien]([maNV])


INSERT into [LoaiPhong]
	VALUES  ('LP001', N'Single',	 120000),
			('LP002', N'Double',	 150000),
			('LP003', N'Tripple',	 200000)

INSERT into [Phong]
	VALUES	('PH001','LP001',	N'PH001',	N'Còn Trống'),
			('PH002','LP001',	N'PH002',	N'Còn Trống'),
			('PH003','LP001',	N'PH003',	N'Còn Trống'),
			('PH004','LP001',	N'PH004',	N'Còn Trống'),
			('PH005','LP002',	N'PH005',	N'Còn Trống'),
			('PH006','LP002',	N'PH006',	N'Còn Trống'),
			('PH007','LP003',	N'PH007',	N'Còn Trống'),
			('PH008','LP003',	N'PH008',	N'Còn Trống')

insert into ChucVu
	values	('CV001', N'Quản Lý'),
			('CV002', N'Nhân Viên')
			
INSERT into [NhanVien]
	VALUES	('NV001', N'Bùi Văn Hiếu',N'Nam', '281213144','CV001',	'0948546390','2022-10-13','1234',0),
			('NV002', N'Nguyễn Phúc Văn',N'Nam', '281314155','CV002',	'0948546391','2022-11-13','1234',0),
			('NV003', N'Thái Anh Kiều',N'Nữ', '281314156','CV002',	'0948546392','2021-12-14','1234',0)

insert into [DonVi]
	VALUES  ('DVI001', N'Chai'),
			('DVI002', N'Dĩa'),
			('DVI003', N'Kg'),
			('DVI004', N'Chén'),
			('DVI005', N'1 Phần')

insert into [LoaiDichVu]
	VALUES  ('LDV001', N'Thức Ăn'),
			('LDV002', N'Thức Uống'),
			('LDV003', N'Chăm Sóc Khách Hàng')

INSERT into [KhachHang]
	VALUES	('KH001',N'Đinh Trọng Tú' ,'Nam', N'217 hưng lộc', '123456789', '0933224332' ),
			('KH002',N'Phan Nhân','Nam', N'217 hưng lộc', '987654321', '0978443123' )

INSERT into [DichVu]
	VALUES	('DV001','LDV002','DVI001',N'CoCaCoLa',	2000,12000),
			('DV002','LDV002','DVI001',N'Snack',	2000,12000),
			('DV003','LDV002','DVI001',N'PepSi',	2000,12000),
			('DV004','LDV002','DVI001',N'Bia 333',	2000,18000),
			('DV005','LDV002','DVI001',N'Bia Tiger',	2000,18000),
			('DV006','LDV001','DVI004',N'Súp Cua',	2000,15000),
			('DV007','LDV001','DVI004',N'Súp Khoai Tây',	2000,15000),
			('DV008','LDV001','DVI005',N'Lẩu Thập Cẩm',	2000,120000),
			('DV009','LDV001','DVI005',N'Combo Chiên Giòn',	2000,80000),
			('DV010','LDV002','DVI001',N'Rượu Chivas 18',	2000,500000),
			('DV011','LDV001','DVI005',N'Thịt Ba Rọi Nướng',	2000,150000),
			('DV012','LDV001','DVI005',N'Lẩu Cua Đồng',	2000,180000),
			('DV013','LDV001','DVI002',N'Ếch Chiên Nước Mắm',	2000,75000),
			('DV014','LDV001','DVI001',N'Bia Heniken',	2000,18000),
			('DV015','LDV001','DVI002',N'Bánh Tráng Trộn',	2000,10000),
			('DV016','LDV003','DVI003',N'Giặt Ủi',	2000,8000),
			('DV017','LDV003','DVI003',N'Đấm Bóp Giác Hơi',	2000,90000),
			('DV018','LDV001','DVI002',N'Ốc Bươu Nướng Tiêu',	2000,80000),
			('DV019','LDV001','DVI002',N'Bắp Xào',	2000,20000)

			
			