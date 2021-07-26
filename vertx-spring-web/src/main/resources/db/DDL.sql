CREATE TABLE `category` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `version` bigint(20) DEFAULT NULL,
    `catagory_name` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类表';