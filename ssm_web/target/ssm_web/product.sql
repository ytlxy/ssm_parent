# product表
use ssm;
CREATE TABLE product(
id BIGINT(32) Not NULL AUTO_INCREMENT COMMENT '主键',
productNum VARCHAR(50) COLLATE utf8_bin NOT NULL COMMENT '产品编号',
productName VARCHAR(50) COLLATE utf8_bin DEFAULT NULL COMMENT '产品名称',
cityName VARCHAR(50) COLLATE utf8_bin DEFAULT NULL COMMENT '出发城市',
departrueTime TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '出发时间',
productPrice DECIMAL(10,2) DEFAULT NULL COMMENT '产品价格',
productDesc VARCHAR(500) COLLATE utf8_bin DEFAULT NULL COMMENT '产品描述',
productStatus bigint DEFAULT NULL COMMENT '状态(0 关闭 1 开启)',
PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
# 添加数据
INSERT INTO product(productNum,productName,cityName,departrueTime,productPrice,productDesc,productStatus) VALUES ('message-01','西安一日游','西安','2020-05-30 11:50:12',500,'去西安',1);
