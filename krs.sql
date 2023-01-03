-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Jan 2023 pada 04.46
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `krs`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `krs`
--

CREATE TABLE `krs` (
  `id_krs` int(10) NOT NULL,
  `id_nama` varchar(50) NOT NULL,
  `id_namamapel` varchar(50) NOT NULL,
  `tanggal` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `krs`
--

INSERT INTO `krs` (`id_krs`, `id_nama`, `id_namamapel`, `tanggal`) VALUES
(1, '1998010001-Ricky Mahendra', '1-PPN', '2021-01-01'),
(2, '1998010002-Helmina', '2-PBO', '2021-02-02'),
(3, '1998010001-Ricky', '4-VISUAL', '2021-03-03');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `Jenis_kelamin` varchar(20) NOT NULL,
  `tanggal_lahir` varchar(50) NOT NULL,
  `jurusan` varchar(20) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nama`, `Jenis_kelamin`, `tanggal_lahir`, `jurusan`, `alamat`) VALUES
(1998010001, 'Ricky', 'Laki-laki', '19-01-2002', 'Teknik Informatika', 'Banjarmasin'),
(1998010002, 'Helmina', 'Laki-laki', '21-05-2002', 'Sistem Informasi', 'Banjarmasin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `matakuliah`
--

CREATE TABLE `matakuliah` (
  `id` int(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `kelas` text NOT NULL,
  `dosen` varchar(30) NOT NULL,
  `waktu` text NOT NULL,
  `sks` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `matakuliah`
--

INSERT INTO `matakuliah` (`id`, `nama`, `kelas`, `dosen`, `waktu`, `sks`) VALUES
(1, 'PPN', '1A', 'Ricky Mahendra', 'selasa', 2),
(2, 'PBO', '1A', 'Helmi', 'Senin', 2),
(3, 'STATISTIK', '1B', 'Iwan', 'Rabu', 3),
(4, 'VISUAL', '1D', 'Shindy ', 'Kamis', 3);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `krs`
--
ALTER TABLE `krs`
  ADD PRIMARY KEY (`id_krs`),
  ADD KEY `nim` (`id_nama`),
  ADD KEY `id_matakuliah` (`id_namamapel`);

--
-- Indeks untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `matakuliah`
--
ALTER TABLE `matakuliah`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
