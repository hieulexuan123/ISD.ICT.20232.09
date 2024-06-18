--
-- File generated with SQLiteStudio v3.4.4 on Tue Jun 18 09:27:21 2024
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Book
CREATE TABLE IF NOT EXISTS "Book" (
	"id"	INTEGER,
	"media_id"	INTEGER NOT NULL,
	"author"	TEXT NOT NULL,
	"publisher"	TEXT NOT NULL,
	"cover_type"	TEXT NOT NULL,
	"publication_date"	TEXT NOT NULL,
	"pages"	INTEGER,
	"genre"	TEXT,
	"language"	TEXT,
	FOREIGN KEY("media_id") REFERENCES "Media"("id"),
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (3, 1, 'sd', 'sdf', 'Paperback', '2024-06-05', 10, 'sadf', 'sdaf');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (4, 1, 'sadf', 'asf', 'Paperback', '2024-06-13', 10, 'asdf', 'asdf');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (5, 1, 'ádf', 'ádf', 'Hardcover', '2024-06-10', 10, 'ádf', 'sdaf');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (6, 1, 'dsf', 'sadf', 'Paperback', '2024-06-10', 234, 'sadf', 'asdfdsf');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (7, 1, 'asdf', 'asdf', 'Paperback', '2024-06-11', 324, 'sadfsadf', 'dsfasdf');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (8, 22, 'JK Rowling', 'Nha Nam', 'Paperback', '2000-10-10', 1000, 'fiction', 'vietnamese');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (9, 38, 'George Orwell', 'Penguin', 'Hardcover', '1949-06-08', 328, 'dystopian', 'english');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (10, 39, 'J.R.R. Tolkien', 'HarperCollins', 'Paperback', '1954-07-29', 423, 'fantasy', 'english');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (11, 40, 'F. Scott Fitzgerald', 'Scribner', 'Hardcover', '1925-04-10', 180, 'novel', 'english');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (12, 41, 'Harper Lee', 'J.B. Lippincott & Co.', 'Paperback', '1960-07-11', 281, 'fiction', 'english');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (13, 43, 'Jane Austen', 'T. Egerton', 'Hardcover', '1813-01-28', 279, 'romance', 'english');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (14, 44, 'Mark Twain', 'American Publishing Company', 'Paperback', '1884-12-10', 366, 'adventure', 'english');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (15, 46, 'Mary Shelley', 'Lackington, Hughes, Harding, Mavor & Jones', 'Hardcover', '1818-01-01', 280, 'gothic', 'english');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (16, 48, 'Leo Tolstoy', 'The Russian Messenger', 'Paperback', '1869-03-04', 1225, 'historical', 'russian');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (17, 50, 'Herman Melville', 'Harper & Brothers', 'Hardcover', '1851-10-18', 635, 'adventure', 'english');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (18, 57, 'J.K. Rowling', 'Bloomsbury', 'Paperback', '1997-06-26', 223, 'fantasy', 'english');
INSERT INTO Book (id, media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (19, 62, 'Ernest Hemingway', 'Charles Scribners Sons', 'Hardcover', '1952-09-01', 127, 'novel', 'english');

-- Table: CD
CREATE TABLE IF NOT EXISTS "CD" (
	"id"	INTEGER,
	"media_id"	INTEGER NOT NULL,
	"artist"	TEXT NOT NULL,
	"record_label"	TEXT NOT NULL,
	"tracklist"	TEXT NOT NULL,
	"genre"	TEXT NOT NULL,
	"release_date"	TEXT,
	FOREIGN KEY("media_id") REFERENCES "Media"("id"),
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO CD (id, media_id, artist, record_label, tracklist, genre, release_date) VALUES (2, 30, 'MCK', 'RPT MCK', '1. 00 (Intro)
2. Chìm sâu (feat. Trung Trần)
3. Suit & Tie (feat. Hoàng Tôn)
4. Va vào giai điệu này
5. Tối nay ta đi đâu nhờ
6. Chỉ một đêm nữa thôi (feat. tlinh)
7. Thôi em đừng đi (feat. Trung Trần)
8. 50/50 (Interlude)
9. Cuốn cho anh một điếu nữa đi
10. Show Me Love
11. Tại vì sao
12. Thờ er
13. Ai là kẻ xấu xa
14. Anh đã ổn hơn
15. Badtrip
16. 99', 'Hip Hop', '2023-03-02');
INSERT INTO CD (id, media_id, artist, record_label, tracklist, genre, release_date) VALUES (3, 42, 'Adele', 'XL Recordings', '1. Rolling in the Deep, 2. Someone Like You, 3. Set Fire to the Rain', 'Pop', '2011-01-24');
INSERT INTO CD (id, media_id, artist, record_label, tracklist, genre, release_date) VALUES (4, 45, 'Taylor Swift', 'Republic Records', '1. Willow, 2. Cardigan, 3. August', 'Pop', '2020-12-11');
INSERT INTO CD (id, media_id, artist, record_label, tracklist, genre, release_date) VALUES (5, 52, 'BTS', 'Big Hit Entertainment', '1. Dynamite, 2. Butter, 3. Life Goes On', 'K-Pop', '2020-08-21');
INSERT INTO CD (id, media_id, artist, record_label, tracklist, genre, release_date) VALUES (6, 55, 'Ed Sheeran', 'Atlantic Records', '1. Shape of You, 2. Perfect, 3. Castle on the Hill', 'Pop', '2017-03-03');
INSERT INTO CD (id, media_id, artist, record_label, tracklist, genre, release_date) VALUES (7, 56, 'Drake', 'OVO Sound', '1. Hotline Bling, 2. God\s Plan, 3. In My Feelings', 'Hip Hop', '2018-06-29');
INSERT INTO CD (id, media_id, artist, record_label, tracklist, genre, release_date) VALUES (8, 61, 'Billie Eilish', 'Interscope Records', '1. Bad Guy, 2. Bury a Friend, 3. When the Party\s Over', 'Alternative', '2019-03-29');
INSERT INTO CD (id, media_id, artist, record_label, tracklist, genre, release_date) VALUES (9, 63, 'The Weeknd', 'XO', '1. Blinding Lights, 2. Save Your Tears, 3. In Your Eyes', 'R&B', '2020-03-20');
INSERT INTO CD (id, media_id, artist, record_label, tracklist, genre, release_date) VALUES (13, 69, 'Bruno Mars', 'Atlantic Records', '1. Uptown Funk, 2. 24K Magic, 3. Locked Out of Heaven', 'Pop', '2016-11-18');
INSERT INTO CD (id, media_id, artist, record_label, tracklist, genre, release_date) VALUES (14, 73, 'Lady Gaga', 'Interscope Records', '1. Poker Face, 2. Bad Romance, 3. Just Dance', 'Pop', '2008-08-19');

-- Table: DVD
CREATE TABLE IF NOT EXISTS "DVD" (
	"id"	INTEGER,
	"media_id"	INTEGER NOT NULL,
	"disc_type"	TEXT NOT NULL,
	"runtime"	INTEGER NOT NULL,
	"studio"	TEXT NOT NULL,
	"language"	TEXT NOT NULL,
	"subtitle"	TEXT,
	"release_date"	TEXT,
	"genre"	TEXT,
	FOREIGN KEY("media_id") REFERENCES "Media"("id"),
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (1, 31, 'Blu-ray', 162, '20th Century Fox', 'English', 'Vietnamese', '2009-12-10', 'Science-Fiction');
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (2, 47, 'DVD', 120, 'Warner Bros.', 'English', 'French', '2018-05-15', 'Action');
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (3, 49, 'Blu-ray', 140, 'Universal Pictures', 'English', 'Spanish', '2019-11-20', 'Adventure');
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (4, 51, 'DVD', 115, 'Paramount Pictures', 'English', 'German', '2020-07-25', 'Drama');
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (5, 53, 'Blu-ray', 105, 'Sony Pictures', 'English', 'Italian', '2021-09-18', 'Comedy');
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (6, 54, 'DVD', 95, 'Lionsgate', 'English', 'Portuguese', '2017-03-12', 'Horror');
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (7, 58, 'Blu-ray', 130, 'Walt Disney', 'English', 'Dutch', '2016-12-01', 'Family');
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (8, 59, 'DVD', 100, 'DreamWorks', 'English', 'Japanese', '2015-06-08', 'Animation');
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (9, 60, 'Blu-ray', 150, 'MGM', 'English', 'Chinese', '2022-02-14', 'Thriller');
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (10, 68, 'DVD', 110, 'Columbia Pictures', 'English', 'Korean', '2023-01-20', 'Romance');
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (11, 70, 'Blu-ray', 135, 'New Line Cinema', 'English', 'Russian', '2018-08-30', 'Fantasy');
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (12, 71, 'DVD', 145, 'TriStar Pictures', 'English', 'Thai', '2021-04-17', 'Mystery');
INSERT INTO DVD (id, media_id, disc_type, runtime, studio, language, subtitle, release_date, genre) VALUES (13, 72, 'Blu-ray', 125, 'Pixar', 'English', 'Hindi', '2019-12-25', 'Animation');

-- Table: Media
CREATE TABLE IF NOT EXISTS "Media" (
	"id"	INTEGER,
	"category"	TEXT NOT NULL,
	"title"	TEXT NOT NULL,
	"value"	INTEGER NOT NULL,
	"price"	INTEGER NOT NULL,
	"quantity"	INTEGER NOT NULL,
	"image_url"	TEXT NOT NULL,
	"is_rush_support"	INTEGER NOT NULL,
	"weight"	INTEGER DEFAULT 0,
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (22, 'book', 'Harry Potter', 100, 90, 5, 'assets/images/book/harry_potter.jpg', 1, 800);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (30, 'cd', '99%', 150, 135, 8, 'assets/images/cd/99%.png', 1, 200);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (31, 'dvd', 'Avatar', 200, 180, 6, 'assets/images/dvd/avatar.jpg', 1, 500);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (38, 'book', 'story', 29, 32, 12, 'assets/images/book/book2.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (39, 'book', 'adventure', 20, 21, 2, 'assets/images/book/book9.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (40, 'book', 'adventure', 69, 73, 11, 'assets/images/book/book10.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (41, 'book', 'story', 62, 66, 2, 'assets/images/book/book6.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (42, 'cd', 'pop', 20, 24, 6, 'assets/images/cd/cd7.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (43, 'book', 'story', 44, 50, 7, 'assets/images/book/book12.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (44, 'book', 'story', 53, 57, 10, 'assets/images/book/book4.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (45, 'cd', 'pop', 60, 66, 8, 'assets/images/cd/cd3.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (46, 'book', 'bussiness', 72, 79, 17, 'assets/images/book/book1.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (47, 'dvd', 'cartoon', 78, 82, 1, 'assets/images/dvd/dvd12.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (48, 'book', 'science', 22, 25, 10, 'assets/images/book/book3.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (49, 'dvd', 'science fiction', 74, 75, 3, 'assets/images/dvd/dvd10.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (50, 'book', 'bussiness', 19, 26, 4, 'assets/images/book/book11.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (51, 'dvd', 'action', 52, 61, 18, 'assets/images/dvd/dvd11.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (52, 'cd', 'rock', 35, 40, 4, 'assets/images/cd/cd4.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (53, 'dvd', 'action', 60, 70, 16, 'assets/images/dvd/dvd9.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (54, 'dvd', 'romance', 39, 47, 19, 'assets/images/dvd/dvd2.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (55, 'cd', 'pop', 71, 74, 6, 'assets/images/cd/cd2.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (56, 'cd', 'rock', 60, 70, 20, 'assets/images/cd/cd1.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (57, 'book', 'adventure', 36, 38, 2, 'assets/images/book/book8.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (58, 'dvd', 'cartoon', 51, 55, 13, 'assets/images/dvd/dvd3.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (59, 'dvd', 'action', 26, 28, 1, 'assets/images/dvd/dvd6.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (60, 'dvd', 'romance', 33, 38, 17, 'assets/images/dvd/dvd4.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (61, 'cd', 'pop', 38, 42, 15, 'assets/images/cd/cd12.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (62, 'book', 'bussiness', 29, 34, 15, 'assets/images/book/book5.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (63, 'cd', 'ballad', 92, 99, 4, 'assets/images/cd/cd5.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (64, 'cd', 'pop', 32, 38, 10, 'assets/images/cd/cd8.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (65, 'cd', 'classic', 31, 37, 10, 'assets/images/cd/cd6.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (66, 'book', 'bussiness', 88, 93, 15, 'assets/images/book/book7.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (67, 'cd', 'classic', 23, 25, 5, 'assets/images/cd/cd9.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (68, 'dvd', 'romance', 64, 71, 4, 'assets/images/dvd/dvd5.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (69, 'cd', 'pop', 89, 97, 17, 'assets/images/cd/cd10.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (70, 'dvd', 'romance', 37, 47, 19, 'assets/images/dvd/dvd8.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (71, 'dvd', 'science fiction', 92, 95, 11, 'assets/images/dvd/dvd1.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (72, 'dvd', 'action', 16, 23, 9, 'assets/images/dvd/dvd7.jpg', 1, 100);
INSERT INTO Media (id, category, title, value, price, quantity, image_url, is_rush_support, weight) VALUES (73, 'cd', 'classic', 20, 28, 3, 'assets/images/cd/cd11.jpg', 1, 100);

-- Table: Order
CREATE TABLE IF NOT EXISTS "Order" (
	"id"	INTEGER,
	"name"	TEXT NOT NULL,
	"phone"	TEXT NOT NULL,
	"email"	TEXT NOT NULL,
	"province"	TEXT NOT NULL,
	"address"	TEXT NOT NULL,
	"instruction"	TEXT NOT NULL,
	"is_rush"	INTEGER NOT NULL,
	"rush_instruction"	TEXT,
	"delivery_time"	TEXT,
	"shipping_fee"	INTEGER NOT NULL,
	"total_cost"	INTEGER NOT NULL,
	"status"	TEXT NOT NULL DEFAULT 'pending',
	"is_paid"	INTEGER NOT NULL DEFAULT 0,
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (1, 'sdfsdf', '0123456789', 'lexuanhieu20032003@gmail.com', 'Cao Bằng', 'sdfasdf', 'asdfasdf', 0, '', NULL, 20, 366, 'pending', 0);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (2, 'Hieu', '0123456789', 'lexuanhieu20032003@gmail.com', 'Lạng Sơn', 'sdfsdf', 'sadfsdf', 0, '', NULL, 20, 168, 'pending', 0);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (3, 'hIEU', '0123456789', 'lexuanhieu20032003@gmail.com', 'Yên Bái', 'asdfsda', 'sdaf', 0, '', NULL, 20, 218, 'pending', 0);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (4, 'asdf', '0123456789', 'lexuanhieu20032003@gmail.com', 'Cao Bằng', 'asdf', 'asdf', 0, '', NULL, 20, 218, 'pending', 0);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (5, 'assadf', '0123456789', 'lexuanhieu20032003@gmail.com', 'Nam Định', 'asdf', 'asdf', 0, '', NULL, 20, 218, 'pending', 1);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (6, 'John Doe', '0987654321', 'johndoe@example.com', 'Hà Nội', '123 Main St', 'Leave at door', 1, 'Handle with care', '2023-06-20 10:00:00', 30, 250, 'processing', 1);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (7, 'Jane Smith', '0912345678', 'janesmith@example.com', 'Hồ Chí Minh', '456 Elm St', 'Ring bell', 0, '', '2023-06-21 14:00:00', 25, 300, 'shipped', 0);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (8, 'Alice Johnson', '0908765432', 'alicej@example.com', 'Đà Nẵng', '789 Oak St', 'Call upon arrival', 1, 'Fragile', '2023-06-22 09:00:00', 40, 275, 'delivered', 1);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (9, 'Bob Brown', '0934567890', 'bobbrown@example.com', 'Cần Thơ', '101 Pine St', '', 0, '', '2023-06-23 16:00:00', 35, 320, 'canceled', 0);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (10, 'Charlie White', '0923456789', 'charliew@example.com', 'Hải Phòng', '202 Birch St', 'Leave with neighbor', 1, 'Urgent', '2023-06-24 11:00:00', 50, 280, 'returned', 1);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (11, 'David Green', '0912987654', 'davidg@example.com', 'Quảng Ninh', '303 Cedar St', 'Do not leave unattended', 0, '', '2023-06-25 15:00:00', 28, 315, 'pending', 0);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (12, 'Eva Black', '0912765432', 'evab@example.com', 'Bình Dương', '404 Maple St', 'Secure package', 1, 'Handle with care', '2023-06-26 13:00:00', 45, 290, 'processing', 1);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (13, 'Frank King', '0912543768', 'frankk@example.com', 'Khánh Hòa', '505 Spruce St', 'Deliver to back door', 0, '', '2023-06-27 17:00:00', 33, 340, 'shipped', 0);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (14, 'Grace Lee', '0912324576', 'gracel@example.com', 'Thừa Thiên Huế', '606 Walnut St', 'Sign on delivery', 1, 'Priority', '2023-06-28 10:00:00', 42, 305, 'delivered', 1);
INSERT INTO "Order" (id, name, phone, email, province, address, instruction, is_rush, rush_instruction, delivery_time, shipping_fee, total_cost, status, is_paid) VALUES (15, 'Hank Young', '0912209843', 'hanky@example.com', 'Bắc Ninh', '707 Fir St', 'Contact upon arrival', 0, '', '2023-06-29 14:00:00', 29, 310, 'canceled', 0);

-- Table: OrderMedia
CREATE TABLE IF NOT EXISTS "OrderMedia" (
	"id"	INTEGER,
	"order_id"	INTEGER NOT NULL,
	"media_id"	INTEGER NOT NULL,
	"quantity"	INTEGER NOT NULL,
	"price"	INTEGER NOT NULL,
	FOREIGN KEY("order_id") REFERENCES "Order"("id"),
	FOREIGN KEY("media_id") REFERENCES "Media"("id"),
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO OrderMedia (id, order_id, media_id, quantity, price) VALUES (1, 1, 30, 1, 135);
INSERT INTO OrderMedia (id, order_id, media_id, quantity, price) VALUES (2, 1, 31, 1, 180);
INSERT INTO OrderMedia (id, order_id, media_id, quantity, price) VALUES (3, 2, 30, 1, 135);
INSERT INTO OrderMedia (id, order_id, media_id, quantity, price) VALUES (4, 3, 31, 1, 180);
INSERT INTO OrderMedia (id, order_id, media_id, quantity, price) VALUES (5, 4, 31, 1, 180);
INSERT INTO OrderMedia (id, order_id, media_id, quantity, price) VALUES (6, 5, 31, 1, 180);

-- Table: PaymentTransaction
CREATE TABLE IF NOT EXISTS "PaymentTransaction" (
	"id"	TEXT,
	"order_id"	INTEGER NOT NULL,
	"paid_time"	TEXT NOT NULL,
	"amount"	INTEGER NOT NULL,
	"content"	TEXT NOT NULL,
	PRIMARY KEY("id"),
	FOREIGN KEY("order_id") REFERENCES "Order"("id")
);
INSERT INTO PaymentTransaction (id, order_id, paid_time, amount, content) VALUES ('14462711', 5, '2024-06-17', 218, 'Pay+AIMS+invoice');
INSERT INTO PaymentTransaction (id, order_id, paid_time, amount, content) VALUES ('14462717', 7, '2024-06-17', 250, 'Pay+AIMS+invoice');
INSERT INTO PaymentTransaction (id, order_id, paid_time, amount, content) VALUES ('14462718', 8, '2024-06-17', 275, 'Pay+AIMS+invoice');
INSERT INTO PaymentTransaction (id, order_id, paid_time, amount, content) VALUES ('14462719', 9, '2024-06-17', 225, 'Pay+AIMS+invoice');
INSERT INTO PaymentTransaction (id, order_id, paid_time, amount, content) VALUES ('14462720', 10, '2024-06-17', 240, 'Pay+AIMS+invoice');
INSERT INTO PaymentTransaction (id, order_id, paid_time, amount, content) VALUES ('14462721', 11, '2024-06-17', 260, 'Pay+AIMS+invoice');
INSERT INTO PaymentTransaction (id, order_id, paid_time, amount, content) VALUES ('14462722', 12, '2024-06-17', 280, 'Pay+AIMS+invoice');

-- Table: User
CREATE TABLE IF NOT EXISTS "User" (
	"id"	INTEGER,
	"name"	TEXT NOT NULL,
	"email"	TEXT NOT NULL,
	"phone"	TEXT NOT NULL,
	"password"	TEXT,
	PRIMARY KEY("id")
);
INSERT INTO User (id, name, email, phone, password) VALUES (1, 'Hieu', 'asdfas@mail.com', '124323543245', NULL);
INSERT INTO User (id, name, email, phone, password) VALUES (2, 'John', 'john.doe@example.com', '1234567890', NULL);
INSERT INTO User (id, name, email, phone, password) VALUES (3, 'Jane', 'jane.doe@example.com', '2345678901', NULL);
INSERT INTO User (id, name, email, phone, password) VALUES (4, 'Alice', 'alice@example.com', '3456789012', NULL);
INSERT INTO User (id, name, email, phone, password) VALUES (5, 'Bob', 'bob@example.com', '4567890123', NULL);
INSERT INTO User (id, name, email, phone, password) VALUES (6, 'Charlie', 'charlie@example.com', '5678901234', NULL);
INSERT INTO User (id, name, email, phone, password) VALUES (7, 'David', 'david@example.com', '6789012345', NULL);
INSERT INTO User (id, name, email, phone, password) VALUES (8, 'Eva', 'eva@example.com', '7890123456', NULL);
INSERT INTO User (id, name, email, phone, password) VALUES (9, 'Frank', 'frank@example.com', '8901234567', NULL);
INSERT INTO User (id, name, email, phone, password) VALUES (10, 'Grace', 'grace@example.com', '9012345678', NULL);
INSERT INTO User (id, name, email, phone, password) VALUES (11, 'Hank', 'hank@example.com', '0123456789', NULL);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
