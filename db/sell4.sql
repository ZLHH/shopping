/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : sell

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-06 22:13:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `last_time` datetime DEFAULT NULL,
  `last_ip` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', '2018-05-05 02:18:19', '127.0.0.1', '小白');
INSERT INTO `admin` VALUES ('2', 'abc', 'abc', null, null, 'pony');

-- ----------------------------
-- Table structure for adress
-- ----------------------------
DROP TABLE IF EXISTS `adress`;
CREATE TABLE `adress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `adress` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adress
-- ----------------------------
INSERT INTO `adress` VALUES ('1', 'asdf', 'asdfg', 'asdga', '2018-05-06 20:29:05', '1');
INSERT INTO `adress` VALUES ('2', 'zhang', '15279106323', 'sdafdasf', '2018-05-06 20:31:25', '1');
INSERT INTO `adress` VALUES ('3', '张丽华', '15279106323', '江西财经大学', '2018-05-06 20:35:37', '1');
INSERT INTO `adress` VALUES ('4', '李白', '15976852147', '的非官方冻干粉', '2018-05-06 21:13:56', '1');

-- ----------------------------
-- Table structure for cooperation
-- ----------------------------
DROP TABLE IF EXISTS `cooperation`;
CREATE TABLE `cooperation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `time` varchar(11) DEFAULT NULL,
  `message` text,
  `status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cooperation
-- ----------------------------
INSERT INTO `cooperation` VALUES ('3', '大师傅', '15279106323', '工作日', '', '0', '2018-05-06 12:29:06', null);

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `information` longtext,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES ('1', '谁在为“蒜你狠”推波助澜', '近期，部分城市大蒜零售价格超过每公斤20元，多地大蒜价格同比上涨90％以上，不少人惊呼“蒜你狠”卷土重来。\n　　“新华视点”记者在山东金乡、河南中牟等大蒜主产区调查发现，受天气影响大蒜产量下降、供应量减少是价格上涨的主要原因，但在看涨预期下，游资炒作起了推波助澜的作用。\n　　国家发改委相关负责人近日表示，已部署山东、河南、江苏三省大蒜主产区开展大蒜价格巡查，对具有一定规模的储存商、批发商进行提醒告诫，并对大蒜冷库出库、批发等环节进行摸底调查，发现串通、哄抬等价格违法行为，将迅速予以查处。\n　　批发价同比上涨九成多，有拆迁户用补偿款炒蒜\n　　山东省金乡县是“中国大蒜之乡”，每天来自全国各地的蒜商汇集于此、撮合买卖，主导着全国甚至全世界的大蒜价格。\n　　“今年大蒜价格涨得太快了，几乎一天一个价。”金乡县丰盛果蔬有限公司董事长隋云玉说，5月份鲜蒜上市时，地头收购价为每公斤4元至5元，6月份干蒜价格涨到每公斤9元至11元。此后，大蒜价格一路上涨，目前已涨到每公斤约14元。\n　　据金乡大蒜专业批发市场信息中心监测，近期，大蒜的平均批发价格为每公斤13．25元，去年同期为每公斤6．9元，同比上涨92．03％。\n　　河南省中牟县也是大蒜的主产区之一。中牟县冷藏保鲜协会副会长校三保从事大蒜生意已经30余年，“蒜价从7月份开始快速上涨，目前批发价已经涨到每公斤13元，同比上涨九成以上”。\n　　中国大蒜产业信息联盟秘书长、金乡县大蒜产业信息协会常务会长杨桂华说，产量下降、供应量减少是这轮大蒜价格上涨的主要原因。去年11月份，阴雨天气持续了近20天。还未等天晴，大蒜主产地突降大雪，山东、河北产地大蒜冻害较为严重。今年上市期，全国大蒜总产量较去年相比减少20％左右。\n　　在大蒜减产的市场背景和蒜价上涨的预期下，许多游资进入大蒜市场。“一些大的投机商在大蒜上市前会到全国主要大蒜产地考察、收集信息，如果大蒜面积减少了、减产了，就开始囤积大蒜，一出手就是三四万吨。”从事了38年大蒜生意的中牟县冷藏保鲜协会会长刘少臣说。\n　　张先生是炒蒜者之一，今年5月份从云南到山东金乡收储大蒜。“我从云南筹措了400万元，在金乡收购了三四百吨大蒜，预计能盈利70多万元。”他说。\n　　校三保说，今年，中牟县的一些拆迁户拿着补偿款投到了蒜市，一名拆迁户存了60吨蒜，前几天卖出去挣了20万元，利润率37％。\n　　有经纪人“炒蒜”已获益上百万元\n　　金乡、中牟等地多名蒜商告诉记者，大多数蒜商收购大蒜后，储存一段时间达到预期盈利后即卖出，然后再根据行情进行新一轮操作，一轮一轮滚动赚钱。比如每公斤5元收购，过段时间每公斤6元卖出；然后过一段时间以每公斤6．5元收购，再以每公斤7．5元销售，如此反复。\n　　这种方式在中牟县大蒜经纪人毛小安眼里就是“炒蒜”，他已从业20年，今年通过“炒蒜”获益上百万元。\n　　“‘炒蒜’并不是什么行业秘密。有时一批蒜在冷库里不动，就被转手好几次。大家在涨价的预期下疯狂买进卖出，每转一次，价格就涨一次。”毛小安说，“也有那种五六月份收购大蒜后放到冷库中储存，等着来年一次性出售这样赌徒式的蒜商，但这样做风险极大，可能一夜暴富但更多时候是一夜赔光。”\n　　隋云玉说：“当一种商品供不应求时价格会上涨，盈利预期会吸引更多资金参与其中，然后再推高这种商品价格，如此反复，大蒜行业也是如此。从金乡来看，至少有上千名大小蒜商各自为战，但没有一家独大或者能够号令其他蒜商步调一致的大蒜商。”\n　　“蒜价能炒高的主要原因是供应量少，如果蒜丰收了是炒不起来的。像2008年，供应量特别大，一吨60元都没人要，谁进去谁赔钱。”刘少臣说。\n　　据了解，这一轮的大蒜批发价已上涨到每公斤14元左右，比今年4月份的那一轮上涨高2元到3元。业内人士分析，今年5月份新蒜的产量下降了，新蒜的地头价就比去年高1元到2元，这为“炒蒜”提供了更大空间。\n　　如何破解游资乱市\n　　专家表示，大量游资涌入大蒜市场，甚至有大户动辄投几亿元囤积数万吨大蒜，加剧了市场短缺，造成价格异动，扰乱了正常市场秩序，政府应当用有效的市场化手段干预。\n　　刘少臣说，政府应当重点关注、查处“炒蒜”大户，因为他们囤积量大，小户是跟着大户跑的。对于那些多进少售、只进不售或囤积拒售等加剧市场供应紧张的行为，要严厉打击。\n　　“尽管今年大蒜减产，但大蒜存量并没有那么少，今年的价格历年高，涨得有些离谱。”刘少臣说，政府需要做的是如何保障蒜农的利益，从供应端稳定市场。\n　　校三保说，比如，大蒜过剩的时候，政府可以采取收储的办法，稳定市场价格，保护蒜农利益；在蒜价暴涨的时候释放库存，稳定市场。\n　　专家建议，政府应建立大数据库，动态监测全国大蒜主产区的种植、生产、销售、库存、出口等情况，动态发布数据，增加市场透明度，减少炒作空间。许多专家表示，最根本的还是应采取措施稳定种植面积和产量，如推行大蒜价格保险，降低农民种植大蒜的风险，稳定大蒜种植面积。\n　　据了解，由于今年大蒜价格普遍较高，中牟县周边的尉氏、通许、扶沟等县的一些农民也开始种蒜，种植面积在增大，同时蒜种的价格大涨，不算人工，种蒜成本已达到每亩约4000元，同比增加一倍。\n　　“信息不对称也是农民种植收益大起大落的重要原因，政府应通过对市场信息的搜集和公开披露，引导农民按需种植。”刘少臣说。', '2018-04-21 13:32:47', null);
INSERT INTO `information` VALUES ('2', '美国一批次洋葱重金属超标被通报', '11月8日台湾食药署发布边境查验不合格食品名单显示，美国一批次洋葱重金属超标被通报。\n一批次洋葱的进口商为“舒坦达贸易有限公司”，美国制造厂或出口商名称为JASPO INC.。\n不合格产品品牌名称为“HORSE HEAVEN”，检出镉0.07 ppm，超过台湾地区规定的0.05 ppm的残留限量。\n不合格产品共计为24586公斤，均被退运或销毁处理。\n', '2018-04-21 13:33:26', '2018-05-05 02:16:22');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL,
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '当前价格,单位分',
  `product_quantity` int(11) NOT NULL COMMENT '数量',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1523850102965279402', '1523850102949386412', '3', '葡萄', '10.00', '1', '返回', '2018-04-16 11:41:43', '2018-04-16 11:41:43');
INSERT INTO `order_detail` VALUES ('1523850103101818904', '1523850103100508871', '3', '葡萄', '10.00', '1', '返回', '2018-04-16 11:41:43', '2018-04-16 11:41:43');
INSERT INTO `order_detail` VALUES ('1523850984000553550', '1523850983997717968', '2', '橙子', '127.00', '1', 'tyjdty', '2018-04-16 11:56:24', '2018-04-16 11:56:24');
INSERT INTO `order_detail` VALUES ('1524305199789964414', '1524305199786839810', '2', '橙子', '127.00', '1', 'tyjdty', '2018-04-21 18:06:39', '2018-04-21 18:06:39');
INSERT INTO `order_detail` VALUES ('1524305199796736470', '1524305199786839810', '3', '葡萄', '10.00', '1', '返回', '2018-04-21 18:06:39', '2018-04-21 18:06:39');
INSERT INTO `order_detail` VALUES ('1525598101521416207', '1525598100736560645', '2', '橙子', '18.00', '1', '2.jpg', '2018-05-06 17:15:01', '2018-05-06 17:15:01');
INSERT INTO `order_detail` VALUES ('1525598101661888971', '1525598100736560645', '3', '葡萄', '9.90', '1', '3.jpg', '2018-05-06 17:15:01', '2018-05-06 17:15:01');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` varchar(32) NOT NULL,
  `buyer_name` varchar(32) NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '订单状态, 默认为新下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付状态, 默认未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1523850102949386412', 'fdgd', '15279106323', 'dfgbdfgbdf', 'abc123', '10.00', '0', '0', '2018-04-16 11:41:43', '2018-04-16 11:41:43');
INSERT INTO `order_master` VALUES ('1523850103100508871', 'fdgd', '15279106323', 'dfgbdfgbdf', 'abc123', '10.00', '0', '0', '2018-04-16 11:41:43', '2018-04-16 11:41:43');
INSERT INTO `order_master` VALUES ('1523850983997717968', 'kjhljk', '15279106323', 'truyjrt', 'abc123', '127.00', '0', '0', '2018-04-16 11:56:24', '2018-04-16 11:56:24');
INSERT INTO `order_master` VALUES ('1524305199786839810', '李白', '15279106323', '撒打算大V', 'abc123', '137.00', '0', '0', '2018-04-21 18:06:39', '2018-04-21 18:06:39');
INSERT INTO `order_master` VALUES ('1525598100736560645', 'zhangl', '15279106323', 'dsfdsafsd', 'abc123', '27.90', '0', '0', '2018-05-06 17:15:01', '2018-05-06 17:15:01');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('6', '国产水果', '1', '2018-05-05 01:37:54', '2018-05-05 01:37:53');
INSERT INTO `product_category` VALUES ('7', '进口水果', '2', '2018-05-05 01:38:10', '2018-05-05 01:38:09');
INSERT INTO `product_category` VALUES ('8', ' 新鲜时蔬', '3', '2018-05-05 01:38:28', '2018-05-05 01:38:28');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` int(32) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('2', '橙子', '18.00', '23', '鲜美多汁', '2.jpg', '0', '2', '2018-05-05 00:05:43', '2018-05-06 17:15:01');
INSERT INTO `product_info` VALUES ('3', '葡萄', '9.90', '19', '脆爽香甜', '3.jpg', '0', '2', '2018-05-05 00:30:18', '2018-05-06 17:15:01');
INSERT INTO `product_info` VALUES ('4', '美国进口红啤梨 6个', '18.00', '45', '软糯细腻', '4.jpg', '0', '2', '2018-05-05 00:41:33', '2018-05-05 00:58:00');
INSERT INTO `product_info` VALUES ('5', '大红脆甜水蜜桃 5斤', '29.00', '45', '皮薄果大，色泽鲜黄，营养丰富', '5.jpg', '0', '2', '2018-05-05 01:44:30', '2018-05-05 01:44:29');
INSERT INTO `product_info` VALUES ('6', '大红脆甜水蜜桃 5斤', '29.00', '45', '皮薄果大，色泽鲜黄，营养丰富', '5.jpg', '0', '2', '2018-05-05 02:16:15', '2018-05-05 02:16:14');

-- ----------------------------
-- Table structure for seller_info
-- ----------------------------
DROP TABLE IF EXISTS `seller_info`;
CREATE TABLE `seller_info` (
  `id` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `openid` varchar(64) NOT NULL COMMENT '微信openid',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='卖家信息表';

-- ----------------------------
-- Records of seller_info
-- ----------------------------
INSERT INTO `seller_info` VALUES ('1', '张三', '1132', '1', '2018-03-07 17:24:27', '2018-03-07 17:24:36');

-- ----------------------------
-- Table structure for shopping_car
-- ----------------------------
DROP TABLE IF EXISTS `shopping_car`;
CREATE TABLE `shopping_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_price` decimal(11,0) DEFAULT NULL,
  `counts` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_car
-- ----------------------------
INSERT INTO `shopping_car` VALUES ('14', '1', '2', '18', '1', '2018-05-05 01:19:47', '橙子', '0');
INSERT INTO `shopping_car` VALUES ('15', '1', '3', '10', '1', '2018-05-06 00:15:35', '葡萄', '1');
INSERT INTO `shopping_car` VALUES ('16', '1', '5', '29', '1', '2018-05-06 00:15:41', '大红脆甜水蜜桃 5斤', '0');
INSERT INTO `shopping_car` VALUES ('17', '2', '4', '18', '1', '2018-05-06 00:16:19', '美国进口红啤梨 6个', '0');
INSERT INTO `shopping_car` VALUES ('18', '2', '5', '29', '1', '2018-05-06 00:16:30', '大红脆甜水蜜桃 5斤', '0');
INSERT INTO `shopping_car` VALUES ('19', '3', '6', '29', '1', '2018-05-06 00:17:14', '大红脆甜水蜜桃 5斤', '0');
INSERT INTO `shopping_car` VALUES ('20', '4', '2', '18', '1', '2018-05-06 00:17:45', '橙子', '0');
INSERT INTO `shopping_car` VALUES ('21', '6', '6', '29', '1', '2018-05-06 00:18:09', '大红脆甜水蜜桃 5斤', '0');
INSERT INTO `shopping_car` VALUES ('22', '6', '4', '18', '1', '2018-05-06 00:18:15', '美国进口红啤梨 6个', '0');
INSERT INTO `shopping_car` VALUES ('23', '6', '3', '10', '1', '2018-05-06 00:18:20', '葡萄', '0');
INSERT INTO `shopping_car` VALUES ('24', '7', '4', '18', '1', '2018-05-06 10:58:03', '美国进口红啤梨 6个', '0');
INSERT INTO `shopping_car` VALUES ('25', '7', '5', '29', '1', '2018-05-06 10:59:08', '大红脆甜水蜜桃 5斤', '0');
INSERT INTO `shopping_car` VALUES ('26', '7', '3', '10', '1', '2018-05-06 10:59:16', '葡萄', '0');
INSERT INTO `shopping_car` VALUES ('27', '7', '6', '29', '1', '2018-05-06 10:59:28', '大红脆甜水蜜桃 5斤', '0');
INSERT INTO `shopping_car` VALUES ('28', '7', '2', '18', '1', '2018-05-06 10:59:33', '橙子', '0');
INSERT INTO `shopping_car` VALUES ('29', '7', '2', '18', '1', '2018-05-06 10:59:40', '橙子', '0');
INSERT INTO `shopping_car` VALUES ('30', '7', '2', '18', '1', '2018-05-06 21:35:17', '橙子', '0');
INSERT INTO `shopping_car` VALUES ('31', '1', '3', '10', '1', '2018-05-06 21:50:54', '葡萄', '0');

-- ----------------------------
-- Table structure for user_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_detail
-- ----------------------------
INSERT INTO `user_detail` VALUES ('1', 'admin', '15879463215', '2018-03-13 14:21:56', null, '1');
INSERT INTO `user_detail` VALUES ('2', 'asd', '15279106323', '2018-04-10 09:53:44', null, '2');
INSERT INTO `user_detail` VALUES ('3', '123456', '15279106323', '2018-04-17 17:17:35', null, '3');
INSERT INTO `user_detail` VALUES ('4', '123', '15279106323', '2018-04-17 17:36:26', null, '4');
INSERT INTO `user_detail` VALUES ('6', 'asdf', '15279106323', '2018-04-18 15:43:42', null, '6');
INSERT INTO `user_detail` VALUES ('7', 'zlh', '15279106323', '2018-05-06 10:57:45', null, '7');

-- ----------------------------
-- Table structure for user_main
-- ----------------------------
DROP TABLE IF EXISTS `user_main`;
CREATE TABLE `user_main` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_main
-- ----------------------------
INSERT INTO `user_main` VALUES ('1', 'admin', '152546@163.com', 'docker', '0', '2018-03-13 11:28:17', null, '1');
INSERT INTO `user_main` VALUES ('2', 'asdf', '', 'user', '0', '2018-04-10 09:53:44', null, '0');
INSERT INTO `user_main` VALUES ('3', 'gfhgf', 'dfgfdg@qq.com', 'user', '0', '2018-04-17 17:17:35', null, '0');
INSERT INTO `user_main` VALUES ('4', 'fdgf', '', 'user', '0', '2018-04-17 17:36:26', null, '0');
INSERT INTO `user_main` VALUES ('6', 'admind', 'dsfasd@qq.com', 'user', '0', '2018-04-18 15:43:42', '2018-05-05 02:16:38', '0');
INSERT INTO `user_main` VALUES ('7', 'zlh', '53666@qq.com', 'user', '0', '2018-05-06 10:57:45', null, '0');
