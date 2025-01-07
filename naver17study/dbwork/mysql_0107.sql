create table foodrest
(
num smallint auto_increment primary key,
foodname varchar(30),
foodprice int,
foodsize varchar(20) default '보통');

create table foodorder
(
	idx smallint auto_increment primary key,
	num smallint,
	ordername varchar(20),
	ordercnt smallint,
    bookingday datetime,
    constraint fk_foodorder_num foreign key(num) references foodrest(num));
    
    alter table foodorder modify bookingday varchar(30);
    
    desc foodorder;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    