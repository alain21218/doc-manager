CREATE DATABASE environmentTest;
use environmentTest;

CREATE TABLE environmentTest.`documents` (
    `docid` int(10) NOT NULL AUTO_INCREMENT,
    `type` varchar(50) DEFAULT NULL,
    `nom` varchar(50) DEFAULT NULL,
    `date` date DEFAULT NULL,
    PRIMARY KEY (`docid`)
) ENGINE=INNODB AUTO_INCREMENT=9 DEFAULT charset=utf8