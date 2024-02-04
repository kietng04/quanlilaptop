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
  `soluong` int(11) DEFAULT 0,
  `thoigianbaohanh` int(11) DEFAULT NULL,
  `maloai` varchar(255) DEFAULT NULL,
  `khuvuckho` varchar(255) DEFAULT NULL,
  `trangthai` tinyint(1) DEFAULT 1	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `sanpham` (`masanpham`, `tensanpham`, `hinhanh`, `boxuly`, `hedieuhanh`, `soluong`, `thoigianbaohanh`, `maloai`, `khuvuckho`, `trangthai`) VALUES
(1, 'LÁP TÓP GA MINH', 'warning.png', 'I9 202444', 'MAC OS', 10, '1 năm', 'GM1', 'Kho A', 1);


CREATE TABLE `phienbansanpham` (
  `maphienbansp` int(11) NOT NULL,
  `masanpham` int(11) DEFAULT NULL,
  `rom` int(11) DEFAULT NULL,
  `ram` int(11) DEFAULT 0,
  `mausac` int(11) DEFAULT NULL,
  `gianhap` int(11) DEFAULT NULL,
  `giaxuat` int(11) DEFAULT NULL,
  `soluongton` int(11) DEFAULT 0,
  `trangthai` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `phienbansanpham` (`maphienbansp`, `masanpham`, `rom`, `ram`, `mausac`, `gianhap`, `giaxuat`, `soluongton`, `trangthai`) VALUES
(1, 1, 512, 8, 'Đỏ', 10000000, 16000000, 12, 1);

CREATE TABLE `thuonghieu` (
  `tenthuonghieu` varchar(255) DEFAULT NULL,
  `trangthai` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `thuonghieu` (`tenthuonghieu`, `trangthai`) VALUES
('Apple', 1);
COMMIT;