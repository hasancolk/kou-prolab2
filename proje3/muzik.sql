-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 20 May 2021, 15:03:42
-- Sunucu sürümü: 10.4.19-MariaDB
-- PHP Sürümü: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `muzik`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `password` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `album`
--

CREATE TABLE `album` (
  `id` int(11) NOT NULL,
  `ad` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `sanatci_id` int(11) NOT NULL,
  `tarih` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `tur_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `album`
--

INSERT INTO `album` (`id`, `ad`, `sanatci_id`, `tarih`, `tur_id`) VALUES
(1, 'Karma', 1, '2001', 1),
(2, 'Dudu', 1, '2003', 1),
(3, 'Gönül Sayfam', 2, '2000', 1),
(6, 'Confident', 5, '2015', 1),
(7, 'Bad', 6, '1987', 1),
(8, 'Ella and Louis', 7, '1956', 2),
(9, 'Hello,Dolly!', 7, '1964', 2),
(10, 'Caravan', 8, '1962', 2),
(11, 'Kara Toprak', 9, '2003', 3),
(14, 'Music For Films', 11, '1994', 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `calma_listeleri`
--

CREATE TABLE `calma_listeleri` (
  `id` int(11) NOT NULL,
  `kullaniciId` int(11) NOT NULL,
  `turId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `calma_listeleri`
--

INSERT INTO `calma_listeleri` (`id`, `kullaniciId`, `turId`) VALUES
(85, 32, 1),
(86, 32, 2),
(87, 32, 3),
(88, 33, 1),
(89, 33, 2),
(90, 33, 3),
(91, 34, 1),
(92, 34, 2),
(93, 34, 3),
(94, 35, 1),
(95, 35, 2),
(96, 35, 3),
(97, 36, 1),
(98, 36, 2),
(99, 36, 3),
(100, 37, 1),
(101, 37, 2),
(102, 37, 3),
(103, 38, 1),
(104, 38, 2),
(105, 38, 3),
(106, 39, 1),
(107, 39, 2),
(108, 39, 3),
(109, 40, 1),
(110, 40, 2),
(111, 40, 3),
(112, 41, 1),
(113, 41, 2),
(114, 41, 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanici`
--

CREATE TABLE `kullanici` (
  `id` int(11) NOT NULL,
  `ad` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `email` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `sifre` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `abonelik_tur` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `ulke` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `kullanici`
--

INSERT INTO `kullanici` (`id`, `ad`, `email`, `sifre`, `abonelik_tur`, `ulke`) VALUES
(32, 'teyfik', 'teyfik@gmail.com', '1234', 'pre', 'Türkiye'),
(33, 'hasan', 'hasan@gmail.com', '1234', 'pre', 'Türkiye'),
(34, 'furkan', 'furkan@gmail.com', '1234', 'pre', 'Türkiye'),
(35, 'recep', 'recep@gmail.com', '1234', 'pre', 'ABD'),
(36, 'hamza', 'hamza@gmail.com', '1234', 'pre', 'Türkiye'),
(37, 'adsız', 'adsız@gmail.com', '1234', 'nor', 'Türkiye'),
(38, 'adsız1', 'adsız1@gmail.com', '1234', 'nor', 'Türkiye'),
(39, 'adsız2', 'adsız2@gmail.com', '1234', 'nor', 'ABD'),
(40, 'adsız3', 'adsız3@gmail.com', '1234', 'nor', 'Türkiye'),
(41, 'adsız4', 'adsız4@gmail.com', '1234', 'nor', 'ABD');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sanatci`
--

CREATE TABLE `sanatci` (
  `id` int(11) NOT NULL,
  `ad` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `ülke` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `sanatci`
--

INSERT INTO `sanatci` (`id`, `ad`, `ülke`) VALUES
(1, 'Tarkan', 'Türkiye'),
(2, 'Kayahan', 'Türkiye'),
(5, 'Demi Lovato', 'ABD'),
(6, 'Michael Jackson', 'ABD'),
(7, 'Louis Armstrong', 'ABD'),
(8, 'Art Blakey', 'ABD'),
(9, 'Fazıl Say', 'Türkiye'),
(11, 'Aaron Copland', 'ABD'),
(14, 'Teyfik', 'Türkiye');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sarki`
--

CREATE TABLE `sarki` (
  `id` int(11) NOT NULL,
  `ad` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `tarih` int(11) NOT NULL,
  `sanatci_id` int(11) NOT NULL,
  `album_id` int(11) NOT NULL,
  `tur_id` int(11) NOT NULL,
  `sure` float NOT NULL,
  `dinleme_sayisi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `sarki`
--

INSERT INTO `sarki` (`id`, `ad`, `tarih`, `sanatci_id`, `album_id`, `tur_id`, `sure`, `dinleme_sayisi`) VALUES
(1, 'Aşk', 2001, 1, 1, 1, 3.3, 213),
(2, 'Hüp', 2001, 1, 1, 1, 3.25, 156),
(3, 'Kuzu Kuzu', 2001, 1, 1, 1, 3.4, 189),
(4, 'Verme', 2001, 1, 1, 1, 4.15, 266),
(5, 'Sorma Kalbim', 2003, 1, 2, 1, 3.5, 125),
(6, 'Uzun İnce Bir Yoldayım', 2003, 1, 2, 1, 4.3, 1700),
(7, 'Gülümse Kaderine', 2003, 1, 2, 1, 3, 702),
(8, 'Sevdaya Mahsus', 2000, 2, 3, 1, 3.55, 185),
(9, 'Kağıttan Kayıklar', 2000, 2, 3, 1, 3.1, 205),
(10, 'Söz Güzelim', 2000, 2, 3, 1, 4.5, 340),
(11, 'Old Days', 2015, 5, 6, 1, 4.02, 1080),
(12, 'For You', 2015, 5, 6, 1, 3.31, 265),
(13, 'Stone Cold', 2015, 5, 6, 1, 3.18, 232),
(14, 'Speed Demon', 1987, 6, 7, 1, 3.48, 255),
(15, 'Liberian Girl', 1987, 6, 7, 1, 2.45, 300),
(16, 'Dirty Diana', 1987, 6, 7, 1, 3.24, 222),
(17, 'Tenderly', 1956, 7, 8, 2, 4.47, 1300),
(18, 'A Foggy Day', 1956, 7, 8, 2, 3.38, 196),
(19, 'April In Paris', 1956, 7, 8, 2, 3.14, 256),
(20, 'Mac The Knife', 1964, 7, 9, 2, 3.38, 350),
(21, 'Indiana', 1964, 7, 9, 2, 2.53, 177),
(22, 'Black And Blue', 1964, 7, 9, 2, 3.24, 316),
(23, 'This Is For Albert', 1962, 8, 10, 2, 5.5, 700),
(24, 'Thermo', 1962, 8, 10, 2, 6.25, 347),
(25, 'Skylark', 1962, 8, 10, 2, 3.2, 203),
(26, 'Black Earth', 2003, 9, 11, 3, 2.59, 155),
(27, 'Paganini Variations', 2003, 9, 11, 3, 5.4, 351),
(28, 'Dervish In Manhattan', 2003, 9, 11, 3, 8.2, 2600),
(33, 'Morning On The Ranch', 1994, 11, 14, 3, 4.37, 1013),
(34, 'Dream March', 1994, 11, 14, 3, 7, 344),
(35, 'Our Town', 1994, 11, 14, 3, 3.07, 175),
(36, 'Conterto Silkroad', 2003, 9, 11, 3, 4.24, 145),
(37, 'Black Earth', 2003, 9, 11, 3, 4.24, 286),
(38, 'Dört Mevsim', 2003, 9, 11, 3, 4.24, 313),
(39, 'Memleketim', 2003, 9, 11, 3, 5.25, 444),
(40, 'For Motets', 1994, 11, 14, 3, 5.25, 256),
(41, 'At the River', 1994, 11, 14, 3, 5.25, 1111),
(42, 'Dance Symphony', 1994, 11, 14, 3, 5.25, 299),
(43, 'The best of Music', 1994, 11, 14, 3, 5.25, 368),
(44, 'Good Music', 1994, 11, 14, 3, 5.25, 566),
(45, 'Malatya\'s apricot', 1994, 11, 14, 3, 5.25, 44444),
(46, ' La Vie En Rose', 1964, 7, 9, 2, 5.15, 231),
(47, 'Go Down Moses ', 1964, 7, 9, 2, 5.15, 156),
(48, 'When You\'re Smiling', 1964, 7, 9, 2, 5.15, 323),
(49, 'A Fine Romance', 1964, 7, 9, 2, 5.15, 868),
(50, 'Skokiaan ', 1964, 7, 8, 2, 5.15, 913),
(51, 'Cornet Chop Suey ', 1956, 7, 8, 2, 2.12, 1224),
(52, 'Let\'s Do It', 1956, 7, 8, 2, 2.12, 385);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sarki_ekleme`
--

CREATE TABLE `sarki_ekleme` (
  `calmaListesiId` int(11) NOT NULL,
  `sarkiId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `sarki_ekleme`
--

INSERT INTO `sarki_ekleme` (`calmaListesiId`, `sarkiId`) VALUES
(85, 1),
(85, 2),
(85, 3),
(85, 4),
(85, 6),
(85, 8),
(85, 11),
(86, 17),
(86, 19),
(86, 20),
(86, 22),
(86, 23),
(86, 24),
(86, 25),
(86, 46),
(86, 52),
(87, 26),
(87, 27),
(87, 28),
(87, 33),
(87, 34),
(87, 35),
(87, 37),
(87, 38),
(87, 45),
(88, 4),
(88, 6),
(88, 7),
(88, 11),
(88, 15),
(88, 16),
(89, 17),
(89, 20),
(89, 22),
(89, 23),
(89, 24),
(89, 48),
(89, 50),
(90, 28),
(90, 33),
(90, 38),
(90, 39),
(90, 41),
(90, 44),
(90, 45),
(93, 26),
(93, 27),
(93, 28),
(94, 3),
(94, 6),
(94, 7),
(95, 17),
(95, 19),
(95, 22),
(95, 50),
(96, 28),
(96, 34),
(96, 35),
(100, 1),
(100, 9),
(100, 16),
(101, 25),
(102, 37),
(102, 43),
(102, 45);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `takip_tablo`
--

CREATE TABLE `takip_tablo` (
  `id` int(11) NOT NULL,
  `takip_edilen` int(11) NOT NULL,
  `takipci` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `takip_tablo`
--

INSERT INTO `takip_tablo` (`id`, `takip_edilen`, `takipci`) VALUES
(29, 32, 34),
(30, 32, 35),
(31, 32, 37),
(27, 33, 34),
(32, 33, 37),
(33, 34, 37);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tur`
--

CREATE TABLE `tur` (
  `id` int(11) NOT NULL,
  `tur` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `tur`
--

INSERT INTO `tur` (`id`, `tur`) VALUES
(1, 'pop'),
(2, 'jazz'),
(3, 'klasik');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sanatci_id` (`sanatci_id`),
  ADD KEY `tur_id` (`tur_id`);

--
-- Tablo için indeksler `calma_listeleri`
--
ALTER TABLE `calma_listeleri`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kullaniciId` (`kullaniciId`),
  ADD KEY `turId` (`turId`);

--
-- Tablo için indeksler `kullanici`
--
ALTER TABLE `kullanici`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `sanatci`
--
ALTER TABLE `sanatci`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `sarki`
--
ALTER TABLE `sarki`
  ADD PRIMARY KEY (`id`),
  ADD KEY `album_id` (`album_id`),
  ADD KEY `sanatci_id` (`sanatci_id`),
  ADD KEY `tur_id` (`tur_id`);

--
-- Tablo için indeksler `sarki_ekleme`
--
ALTER TABLE `sarki_ekleme`
  ADD UNIQUE KEY `calmaListesiId` (`calmaListesiId`,`sarkiId`),
  ADD KEY `sarkiId` (`sarkiId`);

--
-- Tablo için indeksler `takip_tablo`
--
ALTER TABLE `takip_tablo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `takip_edilen` (`takip_edilen`,`takipci`),
  ADD KEY `takipci` (`takipci`);

--
-- Tablo için indeksler `tur`
--
ALTER TABLE `tur`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `album`
--
ALTER TABLE `album`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Tablo için AUTO_INCREMENT değeri `calma_listeleri`
--
ALTER TABLE `calma_listeleri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

--
-- Tablo için AUTO_INCREMENT değeri `kullanici`
--
ALTER TABLE `kullanici`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- Tablo için AUTO_INCREMENT değeri `sanatci`
--
ALTER TABLE `sanatci`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Tablo için AUTO_INCREMENT değeri `sarki`
--
ALTER TABLE `sarki`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- Tablo için AUTO_INCREMENT değeri `takip_tablo`
--
ALTER TABLE `takip_tablo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Tablo için AUTO_INCREMENT değeri `tur`
--
ALTER TABLE `tur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `album_ibfk_1` FOREIGN KEY (`sanatci_id`) REFERENCES `sanatci` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `album_ibfk_3` FOREIGN KEY (`tur_id`) REFERENCES `tur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `calma_listeleri`
--
ALTER TABLE `calma_listeleri`
  ADD CONSTRAINT `calma_listeleri_ibfk_1` FOREIGN KEY (`kullaniciId`) REFERENCES `kullanici` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `calma_listeleri_ibfk_2` FOREIGN KEY (`turId`) REFERENCES `tur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `sarki`
--
ALTER TABLE `sarki`
  ADD CONSTRAINT `sarki_ibfk_1` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sarki_ibfk_2` FOREIGN KEY (`sanatci_id`) REFERENCES `sanatci` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sarki_ibfk_3` FOREIGN KEY (`tur_id`) REFERENCES `tur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `sarki_ekleme`
--
ALTER TABLE `sarki_ekleme`
  ADD CONSTRAINT `sarki_ekleme_ibfk_1` FOREIGN KEY (`calmaListesiId`) REFERENCES `calma_listeleri` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sarki_ekleme_ibfk_2` FOREIGN KEY (`sarkiId`) REFERENCES `sarki` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `takip_tablo`
--
ALTER TABLE `takip_tablo`
  ADD CONSTRAINT `takip_tablo_ibfk_1` FOREIGN KEY (`takip_edilen`) REFERENCES `kullanici` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `takip_tablo_ibfk_2` FOREIGN KEY (`takipci`) REFERENCES `kullanici` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
