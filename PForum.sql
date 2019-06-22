drop database if exists PForum;
create database PForum;
use PForum;

create table ulvname(
	ulv tinyint primary key,
	ulvname char(16) not null
)engine=innodb,charset=utf8mb4;

create table user(
	uid		 	  	int primary key auto_increment,
	uname	 		char(16) not null unique,
	unickname 		char(16) not null unique,
	upassword 		char(32) not null,
	ulv			 	tinyint,
	uregtime 		timestamp,
	ulastlogintime 	timestamp,
	ulastloginip 	varchar(64),
	ubirth		 	datetime,
	uage		 	tinyint unsigned,
	usex		 	boolean,
	uprovince	 	char(16),
	ucity		 	char(16),
	uarea		 	char(16),
	usignature	 	varchar(256),
	uhobby		 	varchar(64),
	umail 			varchar(64),
	upagecount	 	tinyint unsigned,
	constraint fk_u_ulv foreign key (ulv) references ulvname(ulv)
	 	on delete restrict on update cascade
)engine=innodb,charset=utf8mb4;

create table blockcategory(
	bcid  			int primary key auto_increment,
	bcname 			varchar(64) not null
)engine=innodb,charset=utf8mb4;

create table block(
	bid 			int primary key auto_increment,
	bname 			varchar(64) not null,
	bdescription 	varchar(256)
)engine=innodb,charset=utf8mb4;

create table blockinblockcategory(
	bid 		int primary key,
	bcid 		int,
	constraint fk_bbl_bid foreign key (bid) references block(bid)
	 	on delete restrict on update cascade,
	constraint fk_bbl_bcid foreign key (bcid) references blockcategory(bcid)
		on delete restrict on update cascade
)engine=innodb,charset=utf8mb4;

create table blockcategoryinblock(
	bid 		int,
	bcid 		int primary key,
	constraint fk_blb_bid foreign key (bid) references block(bid)
	 	on delete restrict on update cascade,
	constraint fk_blb_bcid foreign key (bcid) references blockcategory(bcid)
		on delete restrict on update cascade
)engine=innodb,charset=utf8mb4;

create table chaining(
	cid 	int primary key auto_increment,
	uid 	int,
	bid 	int,
	ctitle 	varchar(64),
	ctime 	timestamp,
	key (ctime),
	key (ctitle),
	constraint fk_c_uid foreign key (uid) references user(uid)
	 	on delete restrict on update cascade,
	constraint fk_c_bid foreign key (bid) references block(bid)
	 	on delete restrict on update cascade
)engine=innodb,charset=utf8mb4;

create table posting(
	pid 				int primary key auto_increment,
	ptitle 				varchar(64),
	pcontent 			varchar(1024),
	cid 				int,
	uid 				int,
	uip 				varchar(64),
	ptime 				timestamp,
	floorinchaining 	int,
	key (ptime),
	key (ptitle),
	fulltext (pcontent),
	constraint fk_p_cid foreign key (cid) references chaining(cid)
	 	on delete restrict on update cascade,
	constraint fk_p_uid foreign key (uid) references user(uid)
	 	on delete restrict on update cascade
)engine=innodb,charset=utf8mb4;

create table blacklist(
	blid 	int primary key auto_increment,
	blip 	varchar(64),
	bldate 	timestamp,
	key (blip)
)engine=innodb,charset=utf8mb4;
