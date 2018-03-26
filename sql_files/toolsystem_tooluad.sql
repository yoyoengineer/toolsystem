-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: toolsystem
-- ------------------------------------------------------
-- Server version	5.7.13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tooluad`
--

DROP TABLE IF EXISTS `tooluad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tooluad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `toolName` varchar(45) NOT NULL,
  `category` int(11) NOT NULL,
  `version` varchar(45) NOT NULL,
  `directory` varchar(100) NOT NULL,
  `uploadTime` date NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `likeNum` int(11) DEFAULT '0',
  `downloadtimes` int(11) DEFAULT '0',
  `description` varchar(300) DEFAULT NULL,
  `toolTags` varchar(100) DEFAULT NULL,
  `systemSupport` varchar(60) DEFAULT NULL,
  `sizeOfTool` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tooluad`
--

LOCK TABLES `tooluad` WRITE;
/*!40000 ALTER TABLE `tooluad` DISABLE KEYS */;
INSERT INTO `tooluad` VALUES (54,'Brackets.Release.1.7.rar',22,'1.7','Uploads/22/Brackets.Release.1.7.rar/1.7_1494501556009','2017-05-11','2017310009',0,2,'Brackets专注前端开发，它的插件和代码提示都是相当\r\n强悍的，尤其是实时浏览，这更加是前端开发人员的最\r\n爱。','前端,实时预览','windows64/32','42MB'),(55,'360浏览器.rar',23,'2.2','Uploads/23/360浏览器.rar/2.2_1494502051244','2017-05-11','2017310009',0,0,'360安全浏览器拥有全国最大的恶意网址库，采用恶意\r\n网址拦截技术，可自动拦截挂马、欺诈、网银仿冒等恶\r\n意网址。独创沙箱技术，在隔离模式即使访问木马也不\r\n会感染。','360,浏览器','windows64/32','39MB'),(58,'oCam.7z',9,'2.3','Uploads/9/oCam.7z/2.3_1494512950407','2017-05-11','2017310012',0,0,'oCam – 免费屏幕录像利器！这款免费屏幕录像捕捉\r\n软件，编码功能强大，支持游戏录像，可录制任何区\r\n域，可选全屏模式或自定义区域截图；还可捕捉到正\r\n在播放的声音；非常简单易用，而且完全免费。操作\r\n步骤只需三步：1、设置屏幕录制范围；2、点击录\r\n制按钮；3、停止录制并保存；即可完成录像！','屏幕,录制,绿色','Linux','6MB'),(59,'FormatFactory.7z',12,'3.9','Uploads/12/FormatFactory.7z/3.9_1494513022423','2017-05-11','2017310014',0,1,'格式工厂是免费多功能的多媒体文件转换工具，最得\r\n力的转换帮手！它可以实现大多数视频、音频以及图\r\n像不同格式之间的相互转换。包括视频：MP4、\r\nAVI、3GP、WMV、MKV、VOB、MOV、FLV、\r\nSWF、GIF；音频：MP3、WMA、FLAC、AAC、\r\nMMF、AMR、M4A、M4R、OGG、MP2、WAV、\r\nWavPack；图像：JPG、PNG、ICO、BMP、GIF、\r\nTIF、PCX、TGA 等。','格式,转换','Linux','40MB'),(60,'flux.rar',8,'1.0','Uploads/8/flux.rar/1.0_1494556636625','2017-05-12','2017310011',0,0,'f.lux是一款电脑显示器色温调节工具，该工具能根据时\r\n间和所处的时区天气情况，日出日落时间自动调节电脑\r\n的显示器色温，降低屏幕对眼睛的刺激，有效的减少眼\r\n睛疲劳和长时间对着电脑屏幕造成的视力下降情况。','护眼,色温','windows64/32','454KB'),(62,'MPC-HC.rar',12,'1.7','Uploads/12/MPC-HC.rar/1.7_1494557295315','2017-05-12','2017310016',0,0,'MPC是国外开源软件，也是全能的免费影音播放\r\n器，在非商业影音软件中，MPC是最好的一个了。\r\n媒体播放器(MPC-HC)是一款简洁的媒体播放器，\r\nMedia Player Classic 的后续版本，有32位和64位版\r\n本。','视频播放','windows64','12MB'),(63,'Wireshark.rar',24,'2.0','Uploads/24/Wireshark.rar/2.0_1494557925056','2017-05-12','2017310010',0,0,'Wireshark是免费的网络协议检测程序，支持Unix，\r\nWindows。让您经由程序抓取运行的网站的相关资\r\n讯，包括每一封包流向及其内容、资讯可依操作系统\r\n语系看出，方便查看、监控TCP session动态等等。','抓包,网络协议','windows64','45MB'),(64,'EasyRecovery.rar',8,'6.2','Uploads/8/EasyRecovery.rar/6.2_1494558277749','2017-05-12','2017310010',0,0,'EasyRecovery 是世界著名数据恢复公司 Ontrack 的技\r\n术杰作，它是一个威力非常强大的硬盘数据恢复工具。\r\n能够帮你恢复丢失的数据以及重建文件系统。你可以从\r\n被病毒破坏或是已经格式化的硬盘中恢复数据。','文件恢复','Linux','17MB');
/*!40000 ALTER TABLE `tooluad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-26 17:09:45
