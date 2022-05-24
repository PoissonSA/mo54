create database mo54;
use mo54;

create table `piece` (
    `id` int(11) AUTO_INCREMENT,
    `name` varchar(50) NOT NULL DEFAULT '',
    `price` int(50) NOT NULL DEFAULT 0,
    `type` int(11) NOT NULL,
    `rate` varchar(10) NOT NULL DEFAULT '0',
    `ctimes` int(11) NOT NULL DEFAULT 0,
    `imgurl` varchar(255),
    primary key(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table `panier` (
    `id` int(11) AUTO_INCREMENT,
    `pid` int(11) NOT NULL,
    `number` int(50) NOT NULL DEFAULT 0,
    primary key(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into piece (name,price,type,imgurl)
values
    ('Filtre à l\'huile',10,0,'https://www.ncarzone.com/static/upload/image/20210708/1625721362362720.jpg'),
    ('Filtre à carburant',16,1,'https://www.ncarzone.com/static/upload/image/20200322/1584841988807095.jpg'),
    ('Filtre de climatisation',18,2,'https://www.ncarzone.com/static/upload/image/20200322/1584841960923377.jpg'),
    ('Filtre à air',30,3,'https://www.ncarzone.com/static/upload/image/20200322/1584841928100946.jpg'),
    ('Batterie',75,4,'https://www.ncarzone.com/static/upload/image/20200322/1584841114930539.jpg'),
    ('Trompette',25,5,'https://www.ncarzone.com/static/upload/image/20200322/1584841083916421.jpg'),
    ('Lame d\'essuie-glace',8,6,'https://www.ncarzone.com/static/upload/image/20200322/1584841053381846.jpg'),
    ('Plaquettes de frein',20,7,'https://www.ncarzone.com/static/upload/image/20200322/1584841764515718.jpg');
