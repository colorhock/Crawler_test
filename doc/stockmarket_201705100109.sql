CREATE DATABASE  IF NOT EXISTS `stockmarket`;
USE `stockmarket`;
DROP TABLE IF EXISTS `t_sharereprot`;
DROP TABLE IF EXISTS `t_share`;
DROP TABLE IF EXISTS `t_shareweight`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_share
-- ----------------------------
CREATE TABLE `t_shareweight` (
  `shareweightid` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '股票权重id',
  `shareid`   bigint(16) DEFAULT NULL COMMENT '股票id',
  `othershareid`  bigint(16) DEFAULT NULL COMMENT '股票id',
  `weight`   bigint(16) DEFAULT 0 COMMENT '相对权重',
  `changedirection` bigint(16) DEFAULT 0 COMMENT '相对上一次变化升降方向',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creatorid` bigint(16) NOT NULL COMMENT '创建人',
  `editetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `editorid` bigint(16) DEFAULT NULL COMMENT '修改人',
  `isdelete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `islockup` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否冻结',
  `version` bigint(32) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`shareweightid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 
-- ----------------------------
-- Table structure for t_share
-- ----------------------------
CREATE TABLE `t_share` (
  `shareid` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '股票id',
  `companyname`  varchar(128) DEFAULT NULL COMMENT '公司名称',
  `companyshort` varchar(128) DEFAULT NULL COMMENT '公司简称',
  `sharecode`  varchar(128) DEFAULT NULL COMMENT '股票编号',
  `sharename` varchar(128) DEFAULT NULL COMMENT '股票名字',
  `todaybeginprice`  decimal(16,2) DEFAULT NULL COMMENT '今日开盘价',
  `yesterdaycloseprice` decimal(16,2) DEFAULT NULL COMMENT '昨日收盘价',
  `nowprice` decimal(16,2) DEFAULT '0.00' COMMENT '当前价格',
  `highprice`  decimal(16,2) DEFAULT NULL COMMENT '今日最高价',
  `lowprice` decimal(16,2) DEFAULT NULL COMMENT '今日最低价',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creatorid` bigint(16) NOT NULL COMMENT '创建人',
  `editetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `editorid` bigint(16) DEFAULT NULL COMMENT '修改人',
  `isdelete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `islockup` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否冻结',
  `version` bigint(32) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`shareid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sharereprot
-- ----------------------------
CREATE TABLE `t_sharereprot` (
  `sharereprotid` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '股票单日数据id',
  `shareid` bigint(16) DEFAULT NULL COMMENT '股票id',
  `sharecode`  varchar(128) DEFAULT NULL COMMENT '股票编号',
  `sharename` varchar(128) DEFAULT NULL COMMENT '股票名字',
  `todaybeginprice`  decimal(16,2) DEFAULT NULL COMMENT '今日开盘价',
  `yesterdaycloseprice` decimal(16,2) DEFAULT NULL COMMENT '昨日收盘价',
  `nowprice` decimal(16,2) DEFAULT '0.00' COMMENT '当前价格',
  `highprice`  decimal(16,2) DEFAULT NULL COMMENT '今日最高价',
  `lowprice` decimal(16,2) DEFAULT NULL COMMENT '今日最低价',
  `buyprice` decimal(16,2) DEFAULT NULL  COMMENT '竞买价，即“买一”报价',
  `saleprice` decimal(16,2) DEFAULT NULL COMMENT '竞卖价，即“卖一”报价',
  `dealnum` int(16) DEFAULT NULL COMMENT '成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百',
  `dealmoney` decimal(16,2) DEFAULT NULL COMMENT '成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万',
  `buyone1` decimal(16,2) DEFAULT NULL COMMENT '“买一”申请4695股，即47手',
  `buyone2` decimal(16,2) NOT NULL DEFAULT '1' COMMENT '“买一”报价',
  `buytwo1` decimal(16,2) DEFAULT NULL COMMENT '买二',
  `buytwo2` decimal(16,2) DEFAULT NULL COMMENT '买二',
  `buythree1` decimal(16,2) DEFAULT NULL COMMENT '买三',
  `buythree2` decimal(16,2) DEFAULT NULL COMMENT '买三',
  `buyfour1` decimal(16,2) DEFAULT NULL COMMENT '买四',
  `buyfour2` decimal(16,2) DEFAULT NULL COMMENT '买四',
  `buyfive1` decimal(16,2) DEFAULT NULL COMMENT '买五',
  `buyfive2` decimal(16,2) DEFAULT NULL COMMENT '买五',
  `thedate` date DEFAULT NULL COMMENT '日期',
  `thetime` varchar(128) DEFAULT NULL COMMENT '时间',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creatorid` bigint(16) NOT NULL COMMENT '创建人',
  `editetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `editorid` bigint(16) DEFAULT NULL COMMENT '修改人',
  `isdelete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `islockup` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否冻结',
  `version` bigint(32) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`sharereprotid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;