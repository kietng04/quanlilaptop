SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
CREATE DATABASE IF NOT EXISTS quanlilaptop;
USE quanlilaptop;
CREATE TABLE IF NOT EXISTS `taikhoan` (
  `manv` int(11) NOT NULL,
  `matkhau` varchar(255) NOT NULL,
  `manhomquyen` int(11) NOT NULL,
  `tendangnhap` varchar(50) NOT NULL DEFAULT '',
  `trangthai` int(11) NOT NULL,
  `otp` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`manv`, `matkhau`, `manhomquyen`, `tendangnhap`, `trangthai`, `otp`) VALUES
(1, '123456', 1, 'admin', 1, 'null');

CREATE TABLE `sanpham` (
  `masanpham` int(11) NOT NULL,
  `tensanpham` varchar(255) DEFAULT NULL,
  `hinhanh` varchar(255) DEFAULT NULL,
  `boxuly` varchar(255) DEFAULT NULL,
  `hedieuhanh` varchar(255) DEFAULT NULL,
  `thoigianbaohanh` int(11) DEFAULT NULL,
  `maloai` int(11) DEFAULT NULL,
  `khuvuckho` varchar(255) DEFAULT NULL,
  `thuonghieu` varchar(255) DEFAULT NULL,
  `trangthai` tinyint(1) DEFAULT 1	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `sanpham` (`masanpham`, `tensanpham`, `hinhanh`, `boxuly`, `hedieuhanh`, `thoigianbaohanh`, `maloai`, `khuvuckho`, `thuonghieu`,  `trangthai`) 
VALUES (1, 'LÁP TÓP GA MINH', 'warning.png', 'I9 202444', 'MAC OS', '1 năm', 'GM1', 'Kho A', 'Apple', 1),
(2, 'Laptop Lenovo Gaming Legion Slim 5', 'warning.png', ' i7 1355U', 'Win 11', '1 năm', 'LGS5', 'Kho B', 'Lenovo', 1),
(3, 'Laptop Lenovo Gaming Legion Pro 5', 'warning.png', 'i714650HX', 'Win 11', '1 năm', 'LGP5', 'Kho B', 'Lenovo', 1),
(4, 'Laptop Lenovo Gaming Legion 5', 'warning.png', 'i714650HX', 'Win 11', '1 năm', 'LG5', 'Kho B', 'Lenovo', 1),
(5, 'Laptop Dell Inspiron 15', 'warning.png', ' i7 1355U', 'Win 10', '1 năm', 'DI15', 'Kho A', 'Dell', 1),
(6, 'Laptop Dell Inspiron 14', 'warning.png', ' i5 11400H', 'Win 10', '1 năm', 'DI14', 'Kho A', 'Dell', 1);

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` int(11) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `gioitinh` int(11) NOT NULL,
  `ngaysinh` date NOT NULL,
  `sdt` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `hoten`, `gioitinh`, `ngaysinh`, `sdt`, `email`, `trangthai`) VALUES
(1, 'Phạm Văn Kiệt', 1, '2004-12-20', '0976204879', 'phamvankietgmail.com', 1),
(2, 'Nguyễn Phan Tuấn Kiệt', 1, '2004-04-11', '0355374322', 'nguyenphantuankiet@gmail.com', 1),
(3, 'Nguyễn Thế Kiên', 0, '2004-04-11', '0123456789', 'nguyenthekien@gmail.com', 1),
(4, 'Nguyễn Trung Hưng', 0, '2004-04-03', '0123456789', 'hunggaylo@gmail.com', 1),
(5, 'Huỳnh Minh Phúc', 1, '2004-05-06', '0123456789', 'minhphuc@gmail.com', 1),
(6, 'Diệp Thụy An', 1, '2004-05-06', '0123456789', 'thuyan@gmail.com', 1);



CREATE TABLE `phienbansanpham` (
  `maphienbansp` int(11) NOT NULL,
  `masanpham` int(11) DEFAULT NULL,
  `rom` int(11) DEFAULT NULL,
  `ram` int(11) DEFAULT 0,
  `gianhap` int(11) DEFAULT NULL,
  `giaxuat` int(11) DEFAULT NULL,
  `soluongton` int(11) DEFAULT 0,
  `trangthai` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `phienbansanpham` (`maphienbansp`, `masanpham`, `rom`, `ram`, `gianhap`, `giaxuat`, `soluongton`, `trangthai`) VALUES
(1, 1, 512, 8, 10000000, 16000000, 12, 1);


CREATE TABLE `thuonghieu` (
  `tenthuonghieu` varchar(255) DEFAULT NULL,
  `trangthai` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `thuonghieu` (`tenthuonghieu`, `trangthai`) VALUES
('Apple', 1);


CREATE TABLE `kho` (
  `MaKho` int(11) NOT NULL,
  `TenKho` varchar(255) NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `kho` (`MaKho`, `TenKho`, `TrangThai`) VALUES
(1, 'Kho 1', 1),
(2, 'Kho 2', 1),
(3, 'Kho 3', 1);

CREATE TABLE `RAM` (
  `MaRAM` int(11) NOT NULL,
  `KichThuocRAM` int(11) DEFAULT NULL,
  `TrangThai` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `RAM` (`MaRAM`, `KichThuocRAM`, `TrangThai`) VALUES
(1, 8, 1),
(2, 16, 1),
(3, 32, 1);

CREATE TABLE `ROM` (
  `MaROM` int(11) NOT NULL,
  `KichThuocROM` int(11) DEFAULT NULL,
  `TrangThai` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `ROM` (`MaROM`, `KichThuocROM`, `TrangThai`) VALUES
(1, 256, 1),
(2, 512, 1),
(3, 1024, 1);

CREATE TABLE `hedieuhanh` (
  `MaHDH` int(11) NOT NULL,
  `TenHDH` varchar(255) DEFAULT NULL,
  `TrangThai` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `hedieuhanh` (`MaHDH`, `TenHDH`, `TrangThai`) VALUES
(1, 'Windows', 1),
(2, 'MAC OS', 1),
(3, 'Linux', 1);

CREATE TABLE `nhacungcap` (
  `manhacungcap` int(11) NOT NULL,
  `tennhacungcap` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`manhacungcap`, `tennhacungcap`, `diachi`, `email`, `sdt`, `trangthai`) 
VALUES
(1, 'Công Ty TNHH Thế Giới Di Động', ' Phòng 6.5, Tầng6, Tòa Nhà E. Town 2, 364 Cộng Hòa, P. 13, Q. Tân Bình, Tp. Hồ Chí Minh', 'lienhe@thegioididong.com', '02835100100', 1),
(2, 'Công ty Laptop FPT Việt Nam', 'Số 79 đường số 6, Hưng Phước 4, Phú Mỹ Hưng, quận 7, TPHCM', 'contact@paviet.vn', '19009477', 1),
(3, 'Công Ty PC TayNguyeSound', '8/38 Đinh Bô Lĩnh, P.24, Q. Bình Thạnh, Tp. Hồ Chí Minh', 'contact@baola.vn', '02835119060', 1),
(4, 'Công Ty ASUS', 'Phòng 703, Tầng7, Tòa Nhà Metropolitan, 235 Đồng Khởi, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh (TPHCM)', 'chau.nguyen@nokia.com', '02838236894', 1),
(5, 'Hệ Thống Phân Phối Chính Hãng Lenovo Gaming', '261 Lê Lợi, P. Lê Lợi, Q. Ngô Quyền, Tp. Hải Phòng', 'info@mihome.vn', '0365888866', 1),
(6, 'Công Ty Macbook Việt Nam', 'Tòa nhà tài chính Bitexco, 2 Hải Triều, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh', 'contact@samsung.vn', '0988788456', 1),
(7, 'Công ty Grear Việt Nam', '27 Đ. Nguyễn Trung Trực, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh', 'oppovietnam@oppo.vn', '0456345234', 1);

-- --------------------------------------------------------

CREATE TABLE `KhachHang` (
  `MaKH` int(11) NOT NULL,
  `TenKH` varchar(255) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `SDT` varchar(255) DEFAULT NULL,
  `NgayThamGia` date DEFAULT NULL,
  `GioiTinh` varchar(255) DEFAULT NULL,
  `TrangThai` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `KhachHang` (`MaKH`, `TenKH`, `DiaChi`, `SDT`, `NgayThamGia`, `GioiTinh`, `TrangThai`) VALUES
(1, 'Nguyễn Văn A', '123 Lê Lợi, P. Lê Lợi, Q. Ngô Quyền, Tp. Hải Phòng', '0365888866', '2022-12-12', 'Nam', 1),
(2, 'Nguyễn Văn B', '123 Lê Lợi, P. Lê Lợi, Q. Ngô Quyền, Tp. Hải Phòng', '0365888866', '2022-12-12', 'Nam', 1),
(3, 'Nguyễn Văn C', '123 Lê Lợi, P. Lê Lợi, Q. Ngô Quyền, Tp. Hải Phòng', '0365888866', '2022-12-12', 'Nam', 1),
(4, 'Nguyễn Văn D', '123 Lê Lợi, P. Lê Lợi, Q. Ngô Quyền, Tp. Hải Phòng', '0365888866', '2022-12-12', 'Nam', 1),
(5, 'Nguyễn Văn E', '123 Lê Lợi, P. Lê Lợi, Q. Ngô Quyền, Tp. Hải Phòng', '0365888866', '2022-12-12','Nam', 1),
(6, 'Nguyễn Văn F', '123 Lê Lợi, P. Lê Lợi, Q. Ngô Quyền, Tp. Hải Phòng', '0365888866', '2022-12-12', 'Nam', 1);


COMMIT;