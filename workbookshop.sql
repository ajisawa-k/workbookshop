-- workbookshop.sql
-- Workbook Shop database initialization script
-- This script creates the workbookshop database and populates it with product data

-- Create database
CREATE DATABASE IF NOT EXISTS workbookshop;
USE workbookshop;

-- Create product table
CREATE TABLE IF NOT EXISTS product (
    p_id VARCHAR(10) PRIMARY KEY,
    p_name VARCHAR(100) NOT NULL,
    price INT NOT NULL
);

-- Create usr table for user accounts
CREATE TABLE IF NOT EXISTS usr (
    user_id VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    l_name VARCHAR(50) NOT NULL,
    f_name VARCHAR(50) NOT NULL,
    l_name_kana VARCHAR(50),
    f_name_kana VARCHAR(50),
    prefecture VARCHAR(50),
    city VARCHAR(100),
    o_address VARCHAR(200),
    tel VARCHAR(20),
    email VARCHAR(100)
);

-- Create order_main table for order headers
CREATE TABLE IF NOT EXISTS order_main (
    po_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50) NOT NULL,
    order_date DATE NOT NULL,
    delivery_date DATE
);

-- Create order_desc table for order line items
CREATE TABLE IF NOT EXISTS order_desc (
    po_id INT NOT NULL,
    p_id VARCHAR(10) NOT NULL,
    count INT NOT NULL,
    PRIMARY KEY (po_id, p_id)
);

-- Insert product data
INSERT INTO product (p_id, p_name, price) VALUES
('P001', 'キャビネット（大）', 15000),
('P002', 'キャビネット（中）', 12000),
('P003', 'キャビネット（小）', 8000),
('P004', 'オフィスデスク', 25000),
('P005', 'オフィスチェア', 18000),
('P006', 'ノート', 120),
('P007', 'ボールペン', 80),
('P008', '消しゴム', 60),
('P009', '定規', 150),
('P010', 'ファイル', 200),
('P011', 'プリンタートナー（黒）', 5500),
('P012', 'プリンタートナー（カラー）', 7800),
('P013', 'A4用紙（500枚）', 800),
('P014', 'ホチキス', 450),
('P015', 'ホチキス針', 150),
('P016', 'ペンケース', 350),
('P017', 'カッター', 180),
('P018', 'のり', 120),
('P019', 'テープ', 200),
('P020', 'クリップ', 100),
('P021', 'レターケース', 2500),
('P022', 'デスクライト', 3800),
('P023', 'デスクマット', 1200),
('P024', 'マウスパッド', 600),
('P025', 'USBメモリ 16GB', 1800)
ON DUPLICATE KEY UPDATE p_name=VALUES(p_name), price=VALUES(price);

-- Insert sample user for testing
INSERT INTO usr (user_id, password, l_name, f_name, l_name_kana, f_name_kana, prefecture, city, o_address, tel, email) VALUES
('testuser', 'password', '田中', '太郎', 'タナカ', 'タロウ', '東京都', '千代田区', '神田錦町1-19-1', '03-5259-0070', 'test@workbookshop.com')
ON DUPLICATE KEY UPDATE password=VALUES(password);