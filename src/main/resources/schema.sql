DROP TABLE if EXISTS item;
DROP TABLE if EXISTS user;

CREATE TABLE item(
item_uid Int auto_increment primary key,
name varchar(50) not null,
description varchar(100),
market varchar(50),
stock int,
price_tag int not null,
state varchar(50),
reserved_stock int
);

CREATE TABLE user(
user_uid Int auto_increment primary key,
name varchar(50),
password varchar(100),
email varchar(50)
);
