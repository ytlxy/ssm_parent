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

# member表
use ssm;
CREATE table member(
id BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
name VARCHAR(20) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
nickname VARCHAR(20) COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
phoneNum VARCHAR(20) COLLATE utf8_bin DEFAULT NULL COMMENT '电话号码',
email VARCHAR(20) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
# 添加数据
INSERT INTO member VALUES(1,'张山','小站','19216822712','8888888@gmail.com');

# traveller表
use ssm;
CREATE TABLE traveller(
id BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
name VARCHAR(20) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
sex VARCHAR(20)COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
phoneNum VARCHAR(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
credentialsType int(11) DEFAULT NULL COMMENT '证件类型(0 身份证 1 护照 2 军官证)',
creaentialsNum VARCHAR(50) COLLATE utf8_bin DEFAULT NULL COMMENT '证件号码',
travlelerType int(11) DEFAULT NULL COMMENT '旅客类型(0 成人 1 儿童)',
PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
# 添加数据
INSERT INTO traveller(name,sex,phoneNum,credentialsType,creaentialsNum,travlelerType)VALUES('张三','男','12912356636',0,'6101103200005021564',0);

# orders表
use ssm;
CREATE TABLE  orders (
id BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
orderNum VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单编号',
orderTime TIMESTAMP NULL DEFAULT NULL COMMENT '下单时间',
peopleCount int(11) NULL DEFAULT NULL COMMENT '出行人数',
orderDesc VARCHAR(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单描述(其他信息)',
payType int(11) NULL DEFAULT NULL COMMENT '支付方式(0 支付宝 1 微信 3 其他)',
orderStatus int(11) NULL DEFAULT NULL COMMENT '订单状态(0 未支付 1 已支付)',
productId int(11) NULL DEFAULT NULL COMMENT '产品 id 外键',
memberId int(11) NULL DEFAULT NULL COMMENT '会员(联系人) id 外键',
PRIMARY KEY(id)
) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_bin;
# 添加数据
INSERT INTO orders(orderNum,orderTime,peopleCount,orderDesc,payType,orderStatus,productId,memberId)VALUES('144','2020-5-2 08:55:12',2,'没啥',0,1,1,1)

# 订单和旅客 中间表 order_traveller
USE ssm;
CREATE TABLE order_traveller(
orderId BIGINT(32) NOT NULL COMMENT '订单id',
travellerId BIGINT(32) NOT NULL COMMENT '旅客id'
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
# 添加数据
INSERT INTO order_traveller VALUES(1,1)

# users表
use ssm;
CREATE TABLE users(
id BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
email VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '邮箱',
username VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
password VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码(加密)',
phoneNum VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话',
status INT(11) NULL DEFAULT NULL COMMENT '状态(0 未开启,1 开启)',
PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
# 添加数据
insert into users VALUES('tom@gmail.com','tom','12345','14444',1);

# role表
use ssm;
CREATE TABLE role(
id BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
roleName VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色名',
roleDesc VARCHAR(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色描述',
PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
# 添加数据
INSERT INTO role VALUES(1,'ROLE_USER','用户角色');
INSERT INTO role VALUES(2,'ROLE_ADMIN','管理员角色');
INSERT INTO role VALUES(3,'MAIN','主函数');
INSERT INTO role VALUES(4,'TEST','测试角色');

# permission表
use ssm;
CREATE TABLE permission(
id BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
permissionName VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '权限名',
url VARCHAR(500) CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '资源路径',
PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
# 添加数据
INSERT INTO permission VALUES(1,'user find All','/user/findAll.do');
INSERT INTO permission VALUES(2,'user find By one','/user/findById.do');
INSERT INTO permission VALUES(3,'insert into user info','/user/findAll.do');
INSERT INTO permission VALUES(4,'show all roles','/role/findAll.do');
INSERT INTO permission VALUES(5,'test','/user/findAll.do');

# users_role表
use ssm;
CREATE TABLE users_role(
userId BIGINT(32) null DEFAULT NULL COMMENT 'user的id',
roleId BIGINT(32) null DEFAULT NULL COMMENT 'role的id'
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

# role_permission表
use ssm;
CREATE TABLE role_permission(
permissionId BIGINT(32) NULL DEFAULT NULL COMMENT 'permission 权限的 id',
roleId BIGINT(32) NULL DEFAULT NULL COMMENT 'role 角色的id'
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;