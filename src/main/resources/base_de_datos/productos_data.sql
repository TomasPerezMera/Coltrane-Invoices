-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: invoices_db
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Calle Ficticia 123','2026-02-15 20:49:24.687995',12345678,'jcgomez123@gmail.com','Juan Carlos','Gomez',1145453214),(2,'Av. Olazábal, 4321, CABA','2026-02-15 20:53:28.541839',87654321,'mjbenitezzz@gmail.com','María Juana','Benitez',1145438779),(4,'Calle Moldes, 321, CABA','2026-02-16 12:17:52.332301',45678912,'tperez321@gmail.com','Tomás','Pérez',1145242132),(5,'Calle Vía Láctea, 328.474','2026-02-16 13:29:09.259090',38642534,'tefi.andromeda111@yahoo.com','Estefanía','Andrómeda',11545442480);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `invoice_details`
--

LOCK TABLES `invoice_details` WRITE;
/*!40000 ALTER TABLE `invoice_details` DISABLE KEYS */;
INSERT INTO `invoice_details` VALUES (1,2,92800.00,46400.00,1,1),(2,1,86200.00,86200.00,1,3),(3,3,228300.00,76100.00,2,7),(4,1,67200.00,67200.00,2,2),(5,2,136600.00,68300.00,3,6),(6,4,185600.00,46400.00,3,1),(7,1,57180.00,57180.00,4,9),(8,2,134400.00,67200.00,4,2),(9,1,63880.00,63880.00,4,8),(10,3,171540.00,57180.00,5,9),(11,1,76100.00,76100.00,5,7),(12,5,336000.00,67200.00,5,2),(13,3,171540.00,57180.00,6,9),(14,1,57180.00,57180.00,7,9),(15,3,228300.00,76100.00,7,7),(16,8,537600.00,67200.00,7,2);
/*!40000 ALTER TABLE `invoice_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `invoices`
--

LOCK TABLES `invoices` WRITE;
/*!40000 ALTER TABLE `invoices` DISABLE KEYS */;
INSERT INTO `invoices` VALUES (1,'2026-02-15 21:22:19.666598',1,1,0.00),(2,'2026-02-15 21:30:05.148818',4,2,295500.00),(3,'2026-02-15 21:32:45.463775',6,1,322200.00),(4,'2026-02-15 21:35:49.937498',4,2,255460.00),(5,'2026-02-16 12:19:30.354387',9,4,583640.00),(6,'2026-02-16 14:34:34.951395',3,1,171540.00),(7,'2026-02-16 14:35:51.419265',12,4,823080.00);
/*!40000 ALTER TABLE `invoices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Coltrane Albums',46400.00,'Blue Train es un álbum de John Coltrane publicado en 1957 por Blue Note Records, y grabado en Nueva Jersey. \nEs la única grabación de Coltrane como director de sesión para Blue Note, y ha sido certificado Disco de Oro.<br><br>Se grabó durante su tiempo trabajando con Thelonious Monk, con la participación de Miles Davis, Paul Chambers y Philly Joe Jones, quienes tocaron junto con Coltrane en \"Milestones\" de Davis.',_binary '','Blue Train',74,'./images/covers/blueTrain.jpg'),(2,'Coltrane Albums',67200.00,'Stardust es un álbum de Coltrane publicado en 1963 por Prestige Records, y compilado a partir de dos sesiones de 1958 en Nueva Jersey. <br><br>A medida que la fama de Coltrane crecía durante la década de 1960, mucho después de que hubiera dejado de grabar para la discográfica, Prestige utilizó grabaciones no editadas para crear nuevos álbumes comercializables sin el aporte ni la aprobación de Coltrane.',_binary '','Stardust',44,'./images/covers/stardust.jpg'),(3,'Coltrane Albums',86200.00,'Giant Steps es el quinto álbum de estudio de John Coltrane como líder, publicado en 1960 por Atlantic Records. Es el primer álbum de Coltrane como líder para Atlantic, y muchos de sus temas se han convertido en estándares para saxofonistas.<br><br>En 2004, fue uno de los cincuenta álbumes elegidos por la Biblioteca del Congreso de los EE. UU. para su inclusión en el Registro Nacional de Grabaciones.',_binary '','Giant Steps',119,'./images/covers/giantSteps.jpg'),(4,'Coltrane Albums',64840.00,'Ballads es un álbum de jazz de Coltrane, grabado entre diciembre de 1961 y 1962, y publicado por Impulse! en 1963.<br><br>El crítico Gene Lees declaró que el cuarteto nunca antes había tocado las canciones: “Llegaron con partituras de las canciones de una tienda de música, y justo antes de las grabaciones, discutían cada melodía, ensayaban a medias durante media hora y luego lo grababan”. Cada pieza se grabó en una sola toma, excepto “All or Nothing at All”.<br><br>En 2008, el álbum recibió el premio Grammy del Salón de la Fama.',_binary '','Ballads',80,'./images/covers/ballads.jpg'),(5,'Coltrane Albums',58570.00,'My Favorite Things es el séptimo álbum de estudio de John Coltrane, publicado en 1961 por Atlantic Records. Fue el primer álbum en el que Coltrane tocó el saxofón soprano. Una versión editada de la canción que da título al álbum se convirtió en un sencillo de éxito en la radio en 1961.<br><br>El disco se convirtió en un gran éxito comercial, y en 1998, recibió el Grammy del Salón de la Fama.',_binary '\0','My Favorite Things',0,'./images/covers/myFavoriteThings.jpg'),(6,'Coltrane Albums',68300.00,'John Coltrane and Johnny Hartman es un álbum de estudio de 1963, siendo Hartman el único vocalista con el que Coltrane grabaría como líder. Fue incluido en el Salón de la Fama de los Grammy en 2013.  El álbum se publicó en 1963, en un momento en el que Hartman estaba en la cresta de la ola por el éxito de su álbum \"I Just Dropped By to Say Hello\".<br><br>Hartman dijo más tarde que todas las canciones del álbum se grabaron en una sola toma, excepto por \"You Are Too Beautiful\", que requirió dos tomas porque a Elvin Jones se le cayó una de sus baquetas durante la primera toma.',_binary '','John Coltrane and Johnny Hartman',78,'./images/covers/johnnyHartman.jpg'),(7,'Coltrane Albums',76100.00,'A Love Supreme es un álbum de estudio de John Coltrane. Fue publicado en 1965 por Impulse! Records y se considera una de sus mejores obras. El álbum es una suite en cuatro partes, dividida entre las pistas: «Acknowledgement», «Resolution», «Pursuance» y «Psalm».<br><br>Es uno de los álbumes más vendidos de Coltrane y es ampliamente considerado como uno de los mejores álbumes de jazz de todos los tiempos, la obra maestra de Coltrane, y es “sin duda el álbum más querido de Coltrane”, según Robert Christgau, quien añade que “cimentó el estatus divino de Trane en Japón”.',_binary '','A Love Supreme',153,'./images/covers/aLoveSupreme.jpg'),(8,'Coltrane Albums',63880.00,'Meditations es un álbum de 1966 de John Coltrane. En él aparecen Coltrane y el legendario Pharoah Sanders como solistas, ambos tocando el saxofón tenor.<br><br>El álbum fue considerado por muchos como una desviación de la obra anterior de Coltrane, ya que se alejaba del cuarteto estándar. Además de contar con el cuarteto clásico de Coltrane, también incorpora a un segundo baterista, Rashied Ali. El álbum fue considerado la “continuación espiritual” de “A Love Supreme”.',_binary '','Meditations',39,'./images/covers/meditations.jpg'),(9,'Coltrane Albums',57180.00,'Ascension es un álbum de jazz de John Coltrane publicado en 1966. A menudo se considera la piedra angular de su obra, ya que los álbumes anteriores tenían una estructura más convencional, y los posteriores fueron más sueltos y se inspiraban en el “free jazz”.<br><br>Además de Coltrane, el álbum incluye actuaciones del quinteto de trabajo de Coltrane de la época, formado por McCoy Tyner, Jimmy Garrison y Elvin Jones, además de contribuciones de Art Davis, Freddie Hubbard, Dewey Johnson, Marion Brown, John Tchicai y Pharoah Sanders.',_binary '','Ascension',62,'./images/covers/ascension.jpg'),(10,'Coltrane Albums',140500.00,'John Coltrane with the Red Garland Trio is the third studio album by the jazz musician John Coltrane. It was released in early 1958 through Prestige Records. The recording took place at Rudy Van Gelder\'s studio on August 23, 1957.',_binary '\0','The First Trane!',30,'./images/theFirstTrane.jpg');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-16 15:55:17
