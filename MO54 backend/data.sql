create database mo54;
use mo54;

create table `piece` (
    `id` int(11) AUTO_INCREMENT,
    `name` varchar(50) NOT NULL DEFAULT '',
    `price` int(50) NOT NULL DEFAULT 0,
    `type` int(11) NOT NULL DEFAULT 0,
    `rate` varchar(10),
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