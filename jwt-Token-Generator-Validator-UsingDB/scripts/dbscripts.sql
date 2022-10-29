CREATE TABLE `jwt_user` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `password` varchar(255) DEFAULT NULL,
   `username` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ;