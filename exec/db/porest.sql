-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: k4b208.p.ssafy.io    Database: hansup
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ban`
--

DROP TABLE IF EXISTS `ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ban` (
  `ban_id` bigint NOT NULL AUTO_INCREMENT,
  `ban_status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ban_user_id` bigint DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `ban_release_date` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `ban_report_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ban_id`),
  KEY `FKm6ey89nubukqaw9gw7v3y8qpf` (`ban_report_id`),
  CONSTRAINT `FKm6ey89nubukqaw9gw7v3y8qpf` FOREIGN KEY (`ban_report_id`) REFERENCES `ban_report` (`ban_report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ban`
--

LOCK TABLES `ban` WRITE;
/*!40000 ALTER TABLE `ban` DISABLE KEYS */;
/*!40000 ALTER TABLE `ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ban_report`
--

DROP TABLE IF EXISTS `ban_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ban_report` (
  `ban_report_id` bigint NOT NULL AUTO_INCREMENT,
  `ban_reason` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ban_report_status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ban_counsel_id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `reporter_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ban_report_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ban_report`
--

LOCK TABLES `ban_report` WRITE;
/*!40000 ALTER TABLE `ban_report` DISABLE KEYS */;
INSERT INTO `ban_report` VALUES (5,'성적인 대화 및 음란한 단어 사용','PROCEEDING',37,'2021-05-21 06:55:16.048881',5);
/*!40000 ALTER TABLE `ban_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counsel`
--

DROP TABLE IF EXISTS `counsel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `counsel` (
  `counsel_id` bigint NOT NULL AUTO_INCREMENT,
  `counsellor_id` bigint DEFAULT NULL,
  `counsellor_nickname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_opened` bit(1) DEFAULT b'0',
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT 'CONNECT',
  `story_id` bigint DEFAULT NULL,
  PRIMARY KEY (`counsel_id`),
  KEY `FKc12klnuk6t8l38j9u7wt2qejm` (`story_id`),
  CONSTRAINT `FKc12klnuk6t8l38j9u7wt2qejm` FOREIGN KEY (`story_id`) REFERENCES `story` (`story_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counsel`
--

LOCK TABLES `counsel` WRITE;
/*!40000 ALTER TABLE `counsel` DISABLE KEYS */;
INSERT INTO `counsel` VALUES (32,7,'사랑스러운 까막별',NULL,'CONNECT',23),(33,12,'따뜻한 샛별',NULL,'CONNECT',22),(34,5,'자유로운 샛별',NULL,'CONNECT',21),(35,5,'낙관적인 새벽별',NULL,'CONNECT',22),(36,5,'온화한 까막별',NULL,'CONNECT',23),(37,2,'온화한 떠돌이별',_binary '\0','CONNECT',18),(38,2,'든든한 작은곰별',NULL,'CONNECT',24),(39,5,'온화한 여우별',NULL,'CONNECT',23),(40,5,'투머치토커 까막별',NULL,'CONNECT',24),(41,2,'흐뭇한 새벽별',NULL,'CONNECT',19);
/*!40000 ALTER TABLE `counsel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emotion`
--

DROP TABLE IF EXISTS `emotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emotion` (
  `emotion_id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `feeling` int DEFAULT NULL,
  `image_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`emotion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emotion`
--

LOCK TABLES `emotion` WRITE;
/*!40000 ALTER TABLE `emotion` DISABLE KEYS */;
INSERT INTO `emotion` VALUES (9,'오늘 돈까스를 먹었다. 맛있었다!','2021-04-28 14:11:09.000000',5,'49.png','2021-04-28 14:11:09.000000',5),(10,'열심히 운동을 했다. 힘들었지만 보람있었다','2021-04-30 14:11:09.000000',4,'48.png','2021-04-30 14:11:09.000000',5),(11,'꿀꿀했던 하루였다','2021-05-01 14:11:09.000000',1,'38.png','2021-05-16 23:40:51.077053',5),(12,'날씨가 흐려서 그런지 종일 졸렸다','2021-05-03 14:11:09.000000',2,'45.png','2021-05-03 14:11:09.000000',5),(13,'오늘은 그림을 그렸다. 처음 그려봐서 쉽지 않았지만 그래도 재밌었다!','2021-05-04 14:11:09.000000',5,'2.png','2021-05-18 17:57:44.494727',5),(14,'핸드폰을 바꾸고 싶다','2021-05-05 14:11:09.000000',1,'24.png','2021-05-17 00:20:25.075050',5),(15,'번뜩이는 아이디어가 생각났다','2021-05-10 14:11:09.000000',4,'8.png','2021-05-17 00:20:50.696385',5),(18,'ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요ㅁㅁ안녕하세요','2021-05-16 23:36:33.687079',3,'8.png','2021-05-18 17:51:54.274216',5),(19,'오늘은 햄볶은 날이다.','2021-05-17 06:05:11.205622',5,'2.png','2021-05-17 06:07:07.212679',6),(20,'dsds','2021-05-18 00:18:05.259400',3,'44.png','2021-05-18 00:18:05.259410',4),(21,'오늘은 날이 참 좋은 것 같아','2021-05-18 14:57:38.912829',4,'8.png','2021-05-18 14:57:38.912855',7),(23,'오늘은 피곤한 하루가 될것 같아','2021-05-19 11:05:55.527949',5,'7.png','2021-05-20 22:36:22.667573',7),(24,'ㅎㅎㅎㅎ','2021-05-19 23:50:33.107073',2,'3.png','2021-05-19 23:50:33.107096',1),(26,'너무 졸려요...','2021-05-20 16:52:42.080906',2,'50.png','2021-05-20 16:52:42.080919',4),(27,'오늘은 밤을 새워야 할 것 같다','2021-05-20 20:55:29.137143',2,'35.png','2021-05-20 20:55:29.137164',7),(28,'그림을 그려봤다. 어려웠지만 재밌었다! :)','2021-05-20 20:55:53.459585',5,'2.png','2021-05-20 20:55:53.459596',5),(30,'오늘은 너무 행복한 날이에요!!!!','2021-05-21 04:00:46.719337',5,'1.png','2021-05-21 09:05:15.092100',2),(31,'오늘은 정말 기분좋은 하루가 될 것 같아','2021-05-21 09:58:45.790291',2,'3.png','2021-05-21 09:58:45.790303',5);
/*!40000 ALTER TABLE `emotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (16);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `letter`
--

DROP TABLE IF EXISTS `letter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `letter` (
  `letter_id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `content` text COLLATE utf8mb4_unicode_ci,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `writer_id` bigint DEFAULT NULL,
  `counsel_id` bigint DEFAULT NULL,
  PRIMARY KEY (`letter_id`),
  KEY `FKtdmdk9mhl1cr161tk4dgw2yeo` (`counsel_id`),
  CONSTRAINT `FKtdmdk9mhl1cr161tk4dgw2yeo` FOREIGN KEY (`counsel_id`) REFERENCES `counsel` (`counsel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `letter`
--

LOCK TABLES `letter` WRITE;
/*!40000 ALTER TABLE `letter` DISABLE KEYS */;
INSERT INTO `letter` VALUES (1,'2021-05-20 22:44:55.999223','저는 하루에 1.5L ~ 3L의 탄산음료를 물처럼 마십니다.\n이런 생활이 반복되다 보니...\n피도 탄산음료화 하는 기분입니다.\n제가 어떻게 하면 탄산음료를 줄일 수 있을까요..? ','탄산음료가 너무 좋아서 큰일입니다.','READ',1,32),(2,'2021-05-20 22:44:56.273281','안녕하세요. 탄산음료를 좋아하시는 분이시군요.\n보통 탄산음료는 건강에 좋지 않다는 의견이 많은데요, 외국의 어떤 할머니는 몇십년동안 닥터 페퍼라는 탄산음료를 하루에 한잔씩 마셨다고 합니다. 그 할머니는 어떻게 됐을까요? 탄산음료를 마시는 것을 자제시키던 할머니의 주치의가 먼저 하늘 나라로 떠났다고 합니다.\n요즘처럼 살기 팍팍한 시기에 탄산음료를 마시는 것으로 기분이 좋아진다면\n그것만으로 충분하지 않을까요?','탄산음료를 좋아하시는 분께','WAIT',7,32),(3,'2021-05-20 23:04:57.941976','1년차 취준생입니다.\n최근 몇번의 면접이 있었는데 모두 최종에서 탈락했어요.\n계속된 탈락 때문에 자신감도 줄어들었는데 이제 너무 지치고 힘드네요...\n주변에서는 아직 제가 어리다면서 시간이 많다고 하지만 저는 잘 모르겠습니다.\n제가 지난 1년동안 한 노력은 모두 헛수고가 된 것 같습니다.\n매일 밤 찾아오는 우울한 감정 때문에 잠을 설치는 것은 일상이 되어버렸네요.\n취준생이 힘들다는 이야기는 많이 들었지만 직접 취준생이 되고 나니 버거울 정도로 힘이 드네요. 제가 도대체 무엇을 해야 이 두려운 감정을 떨쳐내고 취업을 할 수 있을까요?','취준하는 것이 너무 두렵습니다...','READ',7,33),(4,'2021-05-20 23:04:57.973190','저도 취업준비를 하고 있는데... 제 생각에는 열심히 하고 있는데... 어떻게 해야할지 모르겠어요!! 저는 그래서 다양한 주변사람들의 도움을 받아 하고 있습니다.','저도 같은 고민이 있습니다...','WAIT',12,33),(5,'2021-05-21 03:32:18.521606','요즘 삶에 회의감이 들기 시작했습니다.\n\n코로나 영향일까요..?\n\n요즘 비도 너무 많이와서 더 우울하고 힘든거 같습니다.\n\n어떻게하면 이겨낼 수 있을까요..?','삶이 너무 힘들어요...','READ',1,34),(6,'2021-05-21 03:32:18.604913','저도 코로나 때문에 많이 힘들더라구요ㅠㅠ\n개인적으로 운동이나 취미생활을 하는 것이 많이 도움이 됐습니다\n항상 힘내시기를 바랄게요','공감합니다','WAIT',5,34),(7,'2021-05-21 03:47:32.556843','1년차 취준생입니다.\n최근 몇번의 면접이 있었는데 모두 최종에서 탈락했어요.\n계속된 탈락 때문에 자신감도 줄어들었는데 이제 너무 지치고 힘드네요...\n주변에서는 아직 제가 어리다면서 시간이 많다고 하지만 저는 잘 모르겠습니다.\n제가 지난 1년동안 한 노력은 모두 헛수고가 된 것 같습니다.\n매일 밤 찾아오는 우울한 감정 때문에 잠을 설치는 것은 일상이 되어버렸네요.\n취준생이 힘들다는 이야기는 많이 들었지만 직접 취준생이 되고 나니 버거울 정도로 힘이 드네요. 제가 도대체 무엇을 해야 이 두려운 감정을 떨쳐내고 취업을 할 수 있을까요?','취준하는 것이 너무 두렵습니다...','READ',7,35),(8,'2021-05-21 03:47:32.884084','ㅁㅁㅁ\nㅁ\nㅁ\nㅁ\n','저도 비슷한 고민이 있습니다','WAIT',5,35),(9,'2021-05-21 03:49:12.927140','저는 하루에 1.5L ~ 3L의 탄산음료를 물처럼 마십니다.\n이런 생활이 반복되다 보니...\n피도 탄산음료화 하는 기분입니다.\n제가 어떻게 하면 탄산음료를 줄일 수 있을까요..? ','탄산음료가 너무 좋아서 큰일입니다.','READ',1,36),(10,'2021-05-21 03:49:13.121348','헉\n전문 상담을 받아보는건 어떨까요?\n탄산음료 몸에 안좋아요 ㅜㅜ','중독 아닌가요??ㅠㅠ','WAIT',5,36),(11,'2021-05-21 04:02:29.888934','끝없는 조별과제도 스트레스고 과제도 산더미처럼 쌓여있고... 너무 바쁜데 다들 어떻게 할일들을 착착 잘 하는걸까요? ','학교 학점 챙기기가 너무 힘들어요 ㅠㅠ','READ',5,37),(12,'2021-05-21 04:02:29.972621','아하텍에 입사하시면 됩니다','음... 그건 말이죠.....','WAIT',2,37),(13,'2021-05-21 04:03:37.746128','저는 개발자를 희망하는 사람입니다.\n\n하지만 개발자 중 프론트, 백엔드, dev&ops 등 여러가지 직군이 있습니다.\n근데 모든 분야가 너무 재미있습니다.\n\n만약 딱 하나만 선택해야할 상황이 오면 어떻게 해야 할까요?','진로에 대한 고민 입니다.','READ',1,38),(14,'2021-05-21 04:03:37.786214','아하텍에 입사하시면 모든 직군을 경험하실 수 있습니다 아하텍으로 오시죠 ㅋ ','흠 그건 말이죠','READ',2,38),(15,'2021-05-21 06:54:13.247662','저는 하루에 1.5L ~ 3L의 탄산음료를 물처럼 마십니다.\n이런 생활이 반복되다 보니...\n피도 탄산음료화 하는 기분입니다.\n제가 어떻게 하면 탄산음료를 줄일 수 있을까요..? ','탄산음료가 너무 좋아서 큰일입니다.','READ',1,39),(16,'2021-05-21 06:54:13.362424','화이팅 입니다! ','많이 힘드시죠!?','WAIT',5,39),(17,'2021-05-21 09:54:30.020486','저는 개발자를 희망하는 사람입니다.\n\n하지만 개발자 중 프론트, 백엔드, dev&ops 등 여러가지 직군이 있습니다.\n근데 모든 분야가 너무 재미있습니다.\n\n만약 딱 하나만 선택해야할 상황이 오면 어떻게 해야 할까요?','진로에 대한 고민 입니다.','READ',1,40),(18,'2021-05-21 09:54:30.103471','화이팅 입니다! ','많이 힘드시죠!?','WAIT',5,40),(19,'2021-05-21 10:10:12.015126','이놈의 코로나는 대체 언제 끝날까요? 초반에는 금방 끝나겠지 했는데 이렇게까지 길어질줄 몰랐네요.. 먹고 살기 너무 힘든 것 같아요ㅠㅠ 휴','코로나때문에 매출 타격이 너무 크네요','READ',5,41),(20,'2021-05-21 10:10:12.047801','저도 공감합니다 조금만 더 힘냅시다 우리.. 거의 다 끝났다고 믿어요 화이팅!','코로나 너무 힘들죠 ㅠㅠ','WAIT',2,41);
/*!40000 ALTER TABLE `letter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story`
--

DROP TABLE IF EXISTS `story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `story` (
  `story_id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `content` text COLLATE utf8mb4_unicode_ci,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `picked` int DEFAULT '0',
  `updated_at` datetime(6) DEFAULT NULL,
  `writer_id` bigint NOT NULL,
  `writer_nickname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_opened` bit(1) DEFAULT b'0',
  PRIMARY KEY (`story_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story`
--

LOCK TABLES `story` WRITE;
/*!40000 ALTER TABLE `story` DISABLE KEYS */;
INSERT INTO `story` VALUES (17,'2021-05-20 21:29:23.292531','오늘 면접을 보러 갔는데... 같이 면접 들어간 지원자가 저보다 대답을 훨씬 더 잘 하더라구요..ㅠㅠ 저,, 가망 있는거 맞을까요? 너무 슬퍼요','면접을 보러 갔는데...',0,'2021-05-20 21:29:23.292542',5,'서투른 샛별',_binary '\0'),(18,'2021-05-20 21:35:42.191162','끝없는 조별과제도 스트레스고 과제도 산더미처럼 쌓여있고... 너무 바쁜데 다들 어떻게 할일들을 착착 잘 하는걸까요? ','학교 학점 챙기기가 너무 힘들어요 ㅠㅠ',1,'2021-05-21 04:02:29.895478',5,'조급한 초신성',_binary '\0'),(19,'2021-05-20 21:38:43.156685','이놈의 코로나는 대체 언제 끝날까요? 초반에는 금방 끝나겠지 했는데 이렇게까지 길어질줄 몰랐네요.. 먹고 살기 너무 힘든 것 같아요ㅠㅠ 휴','코로나때문에 매출 타격이 너무 크네요',1,'2021-05-21 10:10:12.016818',5,'빛을 잃은 닻별',_binary '\0'),(20,'2021-05-20 21:40:13.961582','기약 없는 준비기간이라는게 너무 힘든 것 같아요. 준비할 것도 너무 많고 뒤쳐진 것 같아서 괜히 조급해지네요ㅠㅠ','취업 준비가 너무 힘들어요',0,'2021-05-20 21:40:13.961594',5,'전전긍긍하는 초신성',_binary '\0'),(21,'2021-05-20 21:48:23.047265','요즘 삶에 회의감이 들기 시작했습니다.\n\n코로나 영향일까요..?\n\n요즘 비도 너무 많이와서 더 우울하고 힘든거 같습니다.\n\n어떻게하면 이겨낼 수 있을까요..?','삶이 너무 힘들어요...',1,'2021-05-21 03:32:18.524442',1,'전전긍긍하는 작은곰별',_binary '\0'),(22,'2021-05-20 21:56:10.867384','1년차 취준생입니다.\n최근 몇번의 면접이 있었는데 모두 최종에서 탈락했어요.\n계속된 탈락 때문에 자신감도 줄어들었는데 이제 너무 지치고 힘드네요...\n주변에서는 아직 제가 어리다면서 시간이 많다고 하지만 저는 잘 모르겠습니다.\n제가 지난 1년동안 한 노력은 모두 헛수고가 된 것 같습니다.\n매일 밤 찾아오는 우울한 감정 때문에 잠을 설치는 것은 일상이 되어버렸네요.\n취준생이 힘들다는 이야기는 많이 들었지만 직접 취준생이 되고 나니 버거울 정도로 힘이 드네요. 제가 도대체 무엇을 해야 이 두려운 감정을 떨쳐내고 취업을 할 수 있을까요?','취준하는 것이 너무 두렵습니다...',2,'2021-05-21 03:47:32.576362',7,'부끄러운 푸른별',_binary '\0'),(23,'2021-05-20 22:13:28.892070','저는 하루에 1.5L ~ 3L의 탄산음료를 물처럼 마십니다.\n이런 생활이 반복되다 보니...\n피도 탄산음료화 하는 기분입니다.\n제가 어떻게 하면 탄산음료를 줄일 수 있을까요..? ','탄산음료가 너무 좋아서 큰일입니다.',3,'2021-05-21 06:54:13.256504',1,'슬픈 길잡이별',_binary '\0'),(24,'2021-05-20 22:18:35.775705','저는 개발자를 희망하는 사람입니다.\n\n하지만 개발자 중 프론트, 백엔드, dev&ops 등 여러가지 직군이 있습니다.\n근데 모든 분야가 너무 재미있습니다.\n\n만약 딱 하나만 선택해야할 상황이 오면 어떻게 해야 할까요?','진로에 대한 고민 입니다.',2,'2021-05-21 09:54:30.028404',1,'서글픈 푸른별',_binary '\0'),(25,'2021-05-20 22:20:40.507957','안녕하세요 2년차 회사원입니다.\n2년 정도 회사를 다니니 회사 업무도 어느 정도 적응해 업무 수행에 큰 어려움은 없습니다. 하지만 회사 내 인간관계 때문에 머리가 터질 것 같습니다.\n부장님은 올해 초 저희 부서에 새롭게 오셨습니다. 그래서 저희 부서 업무를 완벽하게 이해하고 계시진 않습니다. 그래서 부하 직원들에게 여러 가지를 물어보시면서 업무를 수행하십니다. 문제는 사원인 저에게 너무 많은 것을 물어보시는 것입니다... 부장님을 도와드리느라 제 업무는 뒤로 밀려났고 심한날은 야근을 해 남은 업무를 처리할 지경입니다. 그렇다고해서 부장님을 도와드리지 않는 것도 눈치가 보입니다...ㅠㅠ \n도대체 제가 어떻게 해야 제 업무와 회사 생활의 균형을 맞출 수 있을까요??','회사 생활 잘하고 있는 것 맞겠죠?',0,'2021-05-20 22:20:40.507969',7,'녹초가 된 새벽별',_binary '\0'),(27,'2021-05-21 10:30:07.018315','웹 디자이너가 너무너무 되고 싶은데... css가 너무너무 싫어요.... 왜 CSS는 제 마음대로 적용되지 않는 걸까요... ㅜㅜㅜ','웹 디자이너가 되고 싶어요',0,'2021-05-21 10:30:07.018326',4,'빛을 잃은 길잡이별',_binary '\0');
/*!40000 ALTER TABLE `story` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nickname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `profile_img` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `profile_img_number` bigint DEFAULT '1',
  `role` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT 'ROLE_USER',
  `temperature` int DEFAULT '36',
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2021-05-16 06:37:27.897550','ykh094@naver.com','윤두','$2a$10$VWOgkWWr/vDLvhUlfcuO/eKMWJsLc2f97o71tth66Toz2dcwe1hoq',NULL,5,'ROLE_USER',75,'2021-05-20 21:44:31.311809'),(2,'2021-05-16 07:06:56.824021','yunkh094@gmail.com','lemon2','$2a$10$y88ANhpDeSmOJXSN/dRuf.fCUVrlADZ9VZgKdbCRBUYwG.omA7KfW',NULL,0,'ROLE_USER',76,'2021-05-21 06:55:02.304090'),(4,'2021-05-16 07:28:01.177579','yskwon0619@gmail.com','개구리','$2a$10$5I9c2XGaaZZS1ZELXAdBeec3PCERS.Sy18w9nnDawMLWr./KASvfi',NULL,3,'ROLE_USER',75,'2021-05-21 02:54:11.905947'),(5,'2021-05-16 07:34:12.899212','najse77@naver.com','강모라','$2a$10$CfaL30ivCVPQL/uQbrDr/OLf9UYzgTsd2C0VkgY/gVrvABKKRWPFG',NULL,0,'ROLE_USER',75,'2021-05-21 10:18:49.765480'),(6,'2021-05-17 05:45:01.177579','test@test.test','test','$2a$10$i8.hF3apHbd1kbRewp/NbuL7n8dtGyi35fe4nknMYnnzHRakwTC4K',NULL,5,'ROLE_USER',75,'2021-05-20 07:12:16.580988'),(7,'2021-05-17 22:11:50.050604','rlawhdtjd9@naver.com','롬아','$2a$10$4SBR7NVvBMUR6gReJyDqxuFshN7mFDVzyxU1UR7wA4KM0dmSXNgna',NULL,2,'ROLE_ADMIN',75,'2021-05-20 22:57:58.495344'),(8,'2021-05-19 20:29:34.732882','hlery1206@naver.com','ming','$2a$10$QMqf9weB5bFbW2kKL3ViHecrGJcnzmXJVshGZ/ZeHC090z4MsFoDq',NULL,1,'ROLE_USER',75,'2021-05-19 20:29:34.732895'),(12,'2021-05-20 22:40:50.657663','hlery1206@gmail.com','민지','$2a$10$qkbtLfXoVqvtGbNgeYGYnuZhztfnYKOK6gNWxov2AfzWJ3VxmDEEu',NULL,5,'ROLE_USER',100,'2021-05-20 22:57:40.982893'),(14,'2021-05-21 03:52:42.585079','lay0711@naver.com','지우지마요 ㅠㅠㅠㅠ','$2a$10$rzt0Jg7wsh8J7/TEdmLcUuza5igzKHAQZA9IgT/9oV2dzL6c8i.DW',NULL,1,'ROLE_USER',36,'2021-05-21 03:52:42.585096');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-21 10:48:56
