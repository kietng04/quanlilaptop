SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `taikhoan` (
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


INSERT INTO `sanpham` (`masanpham`, `tensanpham`, `hinhanh`, `boxuly`, `hedieuhanh`, `thoigianbaohanh`, `maloai`, `khuvuckho`, `thuonghieu`,  `trangthai`) VALUES
(1, 'LÁP TÓP GA MINH', 'warning.png', 'I9 202444', 'MAC OS', '1 năm', 'GM1', 'Kho A', 'Apple', 1);

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

CREATE TABLE `nhacungcapdemo` (
  `MaNCC` int(11) NOT NULL,
  `TenNCC` varchar(255) DEFAULT NULL,
  `TrangThaiNCC` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `nhacungcapdemo` (`MaNCC`, `TenNCC`, `TrangThaiNCC`) VALUES
(1, 'WindowsNCC', 1),
(2, 'MAC OS NCC', 1),
(3, 'Linux nCC', 1);



COMMIT;