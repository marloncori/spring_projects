--create database booktstore
DROP SCHEMA IF EXISTS `book-store-dev`;
CREATE SCHEMA `book-store-dev`;

--seletect the database --
USE `book-store-dev`;

-- create category table --
CREATE TABLE IF NOT EXISTS `book-store-dev`.`tbl_category` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `category_name` VARCHAR(255) NULL DEFAULT NULL);

-- create book table tbl_book --
CREATE TABLE IF NOT EXISTS `book-store-dev`.`tbl_book` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `sku` VARCHAR(255) DEFAULT NULL,
    `name` VARCHAR(255) DEFAULT NULL,
    `description` VARCHAR(255) DEFAULT NULL,
    `unit_price` DECIMAL(13,2) DEFAULT NULL,
    `image_url` VARCHAR(255) DEFAULT NULL,
    `active` BIT DEFAULT 1,
    `units_in_stock` INT(11) DEFAULT NULL,
    `data_created` DATETIME DEFAULT NULL,
    `last_updated` DATETIME DEFAULT NULL,
    `category_id` BIGINT(20) NOT NULL,
    FOREIGN KEY (`category_id`) REFERENCES `tbl_category` (`id`)	
);

-- insert sample data to category table --
INSERT INTO tbl_category(category_name) VALUES('Textbooks');
INSERT INTO tbl_category(category_name) VALUES('Fantasy');

-- insert sample data to book table --
INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id
)
VALUES (

   'book-100',
   'C Programming Language',
   'Learn C Programming Language',
    35.00,
   'C:\Users\NUC\Desktop\java_codes\img-100.jfif',
   1,
   100,
   1
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-101',
   'C# Crash Course',
   'Learn C# Programming Language',
	45.00,
   'C:\Users\NUC\Desktop\java_codes\img-101.jfif',
   1,
   85,
   1
);

INSERT INTO tbl_book(
  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id
)
VALUES (

   'book-102',
   'The Modern C++ Challenge',
   'Learn C++ Programming Language',
	52.00,
   'C:\Users\NUC\Desktop\java_codes\img-102.jfif',
   1,
   90,
   1
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-103',
   'Mastering ROS for Robotics Programming',
   'Learn to program robots with ROS Melodic',
	69.00,
   'C:\Users\NUC\Desktop\java_codes\img-103.jfif',
   1,
   110,
   1
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-104',
   'Reactive Programming with RxJava',
   'Learn reactive programming in Java',
	78.00,
   'C:\Users\NUC\Desktop\java_codes\img-104.jfif',
   1,
   120,
   1
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-105',
   'Programming Rust',
   'Learn Rust programming language',
	48.00,
   'C:\Users\NUC\Desktop\java_codes\img-105.jfif',
   1,
   100,
   1
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-106',
   'Building RESTful Web Services with Go',
   'Learn to code rest apps with Golang',
	93.00,
   'C:\Users\NUC\Desktop\java_codes\img-106.jfif',
   1,
   70,
   1
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-107',
   'Learn You a Haskell For Great Good',
   'Learning functional programming with Haskell',
    115.00,
   'C:\Users\NUC\Desktop\java_codes\img-107.jfif',
   1,
   150,
   1
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-108',
   'Think Python',
   'Learn Python 3 programming language',
    127.00,
   'C:\Users\NUC\Desktop\java_codes\img-108.jfif',
   1,
   180,
   1
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-109',
   'Programming Kotlin',
   'Learn Kotlin programming language',
    139.00,
   'C:\Users\NUC\Desktop\java_codes\img-109.jfif',
    1,
   200,
   1
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-110',
   'Angular Development with TypeScript',
   'Learn Angular Framework and TypeScript programming language',
    150.00,
   'C:\Users\NUC\Desktop\java_codes\img-110.jfif',
   1,
   210,
   1
);	

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-111',
   'Hacking Electronics',
   'Learning electronics with Arduino and Raspberry Pi',
    90.00,
   'assets/img/img-111.jpg',
   1,
   100,
   2
);


INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-112',
   'Make: Getting Started With Sensors',
   'Measure the world with electronics, Arduino and Raspberry Pi',
    72.00,
   'assets/img/img-112.jpg',
   1,
   110,
   2
);


INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-113',
   'Make: Learn Electronics With Arduino',
   "An illustrated beginner's guide to physical computing",
    81.00,
   'assets/img/img-113.jpg',
   1,
   130,
   2
);


INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-114',
   'Arduino Applied',
   'Comprehensive projects for everyday electronics',
    112.00,
   'assets/img/img-114.jpg',
   1,
   150,
   2
);


INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-115',
   'Make: More Electronics',
   '36 illustrated experiments that explains logic, chips, sensors and more',
    132.00,
   'assets/img/img-115.jpg',
   1,
   140,
   2
);


INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-116',
   'Electronics: Principles and Applications',
   'Learn all about electronics and how to apply it is applied in everyday life',
    63.00,
   'assets/img/img-116.jpg',
   1,
   200,
   2
);


INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-117',
   'Make: Getting Started With Raspbberry Pi',
   'Getting to know the inexpensive ARM-powered Linux computer',
    142.00,
   'assets/img/img-117.jpg',
   1,
   180,
   2
);


INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-118',
   'Learn Electronics With Raspberry Pi',
   'Physical computing with circuits, sensors, outputs and interesting projects',
    105.00,
   'assets/img/img-118.jpg',
   1,
   170,
   2
);


INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-119',
   'Electronics Projects with ESP8266 and ESP32',
   'Building web pages, applications and WiFi-enabled devices',
    159.00,
   'assets/img/img-119.jpg',
   1,
   210,
   2
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-120',
   'Beginning BBC Micro:bit',
   'A practical introduction to Micro:bit development',
   125.00,
   'assets/img/img-120.jpg',
   1,
   70,
   2
);


INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-121',
   "L'Arabe Sans Peine",
   'Learn arabic with the effective Assimil Method used by many polyglots',
   155.00,
   'assets/img/arabic.jpg',
   1,
   140,
   3
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-122',
   'Colloquial Basque',
   'The complete course for beginners. Learn Euskara with Routledge Method!',
   135.00,
   'assets/img/basque.jpg',
   1,
   175,
   3
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-123',
   "Le Bulgare Sans Peine",
   'Learn Bulgarian with the effective Assimil Method used by many polyglots',
   160.00,
   'assets/img/bulgarian.jpg',
   1,
   110,
   3
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-124',
   "Beginner's Chinese",
   'Teach yourself the Mandarin Chinese with the method many learners has trusted',
   155.00,
   'assets/img/chinese.jpg',
   1,
   120,
   3
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-125',
   "English Made Easy",
   'Learn English todat to be able to communicate with people all over the world',
   155.00,
   'assets/img/english.jpg',
   1,
   140,
   3
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-126',
   'Colloquial Estonian',
   "The complete course for beginners to discover the beautiful language of the startups' country",
   145.00,
   'assets/img/estonian.jpg',
   1,
   180,
   3
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-127',
   "GERMAN",
   'Learn German with ease and no pain with the wolrdwide known Assimil Method',
   165.00,
   'assets/img/german.jpg',
   1,
   170,
   3
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-128',
   "Colloquial Hebrew",
   'Learn the language of Israel to be eable to read the Holy Scriptures in the original text',
   155.00,
   'assets/img/hebrew.jpg',
   1,
   140,
   3
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-129',
   "Colloquial Hungarian",
   'The complete course for beginners. Learn Hungarian today with the Routledge Method',
   155.00,
   'assets/img/hungarian.jpg',
   1,
   140,
   3
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-130',
   "Teach Yourself Japanese",
   "Learn spoken and written Japanese and open yourself the doors to world's most developed country",
   174.00,
   'assets/img/japanese.jpg',
   1,
   200,
   3
);

INSERT INTO tbl_book (

  sku,
  name,
  description,
  unit_price,
  image_url,
  active,
  units_in_stock,
  category_id

)
VALUES (

   'book-131',
   "Get Started In Polish",
   'Teach yourself Polish with our very effective method trusted by many worlwide polyglots',
   134.00,
   'assets/img/polish.jpg',
   1,
   210,
   3
);