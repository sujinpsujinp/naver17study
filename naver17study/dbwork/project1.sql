 
create table animal(
	idx smallint auto_increment primary key,
    aniname varchar(30) not null,
    anikind varchar(30),
    aniphoto varchar(50),
    animessage varchar(1000) not null,
    aniday datetime);

create table member(
	id varchar(30) primary key,
    name varchar(30) not null,
    pw varchar(50) not null);
    
create table anireple(
	num smallint auto_increment primary key,
    idx smallint,
    nickname varchar(30) not null,
    replemessage varchar(1000) not null,
    writeday datetime,
    foreign key(idx) references animal(idx) on delete cascade);

alter table animal MODIFY aniphoto varchar(50);
