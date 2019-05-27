set names utf8;

drop database if exists website;
create database if not exists website;

use website;

create table user_info(
	id int not null primary key auto_increment comment "ID",
	user_id varchar(16) unique not null comment "ユーザーID",
	password varchar(16) unique not null comment "パスワード",
	regist_date datetime comment "登録日"
);

insert into user_info values
(1,"guest","guest",now());

create table product_info(
	id int not null primary key auto_increment comment "ID",
	product_id int unique not null comment "商品ID",
	product_name varchar(100) not null comment "商品名",
	product_description varchar(255) comment "商品詳細記述部分",
	price int not null comment "商品値段",
	image_file_path varchar(100) not null comment "画像ファイルパス",
	image_file_name varchar(50) not null comment "画像ファイル名"
);

insert into product_info values
(1,1,"商品名","商品詳細",2100,"./images","product.jpg"),
(2,2,"商品名","商品詳細",2500,"./images","product1.jpg"),
(3,3,"商品名","商品詳細",2000,"./images","product2.jpg"),
(4,4,"商品名","商品詳細",2000,"./images","product3.jpg"),
(5,5,"商品名","商品詳細",1890,"./images","product4.jpg"),
(6,6,"商品名","商品詳細",1890,"./images","product5.jpg"),
(7,7,"商品名","商品詳細",1890,"./images","product6.jpg"),
(8,8,"商品名","商品詳細",1890,"./images","product7.jpg"),
(9,9,"商品名","商品詳細",1890,"./images","product8.jpg");

create table store_info(
	id int not null primary key auto_increment comment "ID",
	store_id int unique not null comment "店舗ID",
	store_name varchar(50) not null comment "店舗名",
	store_description varchar(255) comment "店舗詳細",
	image_file_path varchar(100) not null comment "画像ファイルパス",
	image_file_name varchar(50) not null comment "画像ファイル名"
);

insert into store_info values
(1,1,"店舗名","店舗詳細","./images","store.jpg"),
(2,2,"店舗名","店舗詳細","./images","store2.jpg"),
(3,3,"店舗名","店舗詳細","./images","store3.jpg"),
(4,4,"店舗名","店舗詳細","./images","store4.jpg"),
(5,5,"店舗名","店舗詳細","./images","store5.jpg"),
(6,6,"店舗名","店舗詳細","./images","store6.jpg");


create table hair_info(
	id int not null primary key auto_increment comment "ID",
	hair_id int unique not null comment "ヘアーID",
	hair_description varchar(255) comment "ヘアー詳細",
	image_file_path varchar(100) not null comment "画像ファイルパス",
	image_file_name varchar(50) not null comment "画像ファイル名"
);

insert into hair_info values
(1,1,"hair詳細","./images/hair","hair.jpg"),
(2,2,"hair詳細","./images/hair","hair1.jpg"),
(3,3,"hair詳細","./images/hair","hair2.jpg"),
(4,4,"hair詳細","./images/hair","hair3.jpg"),
(5,5,"hair詳細","./images/hair","hair4.jpg"),
(6,6,"hair詳細","./images/hair","hair5.jpg"),
(7,7,"NewHair詳細","./images/hair","newhair.jpg"),
(8,8,"NewHair詳細","./images/hair","newhair.jpg"),
(9,9,"NewHair詳細","./images/hair","newhair.jpg");

create table stylist_info(
	id int not null primary key auto_increment comment "ID",
	stylist_id int unique not null comment "スタイリストID",
	stylist_name varchar(50) comment "スタイリスト名",
	stylist_description varchar(255) comment "スタイリスト詳細",
	image_file_path varchar(100) not null comment "スタイリスト画像パス",
	image_file_name varchar(50) not null comment "スタイリスト画像ファイル名"
);

insert into stylist_info values
(1,1,"stylist名","stylist詳細","/images/stylist","stylist.jpg"),
(2,2,"stylist名","stylist詳細","/images/stylist","stylist1.jpg"),
(3,3,"stylist名","stylist詳細","/images/stylist","stylist2.jpg"),
(4,4,"stylist名","stylist詳細","/images/stylist","stylist3.jpg"),
(5,5,"stylist名","stylist詳細","/images/stylist","stylist4.jpg"),
(6,6,"stylist名","stylist詳細","/images/stylist","stylist5.jpg");
