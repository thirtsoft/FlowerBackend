/* CATEGORY */
INSERT INTO category(id,category_name,description,actif) VALUES(1,'Accessoire','Categorie contenant tout fleur accessoire', 1);
INSERT INTO category(id,category_name,description,actif) VALUES(2,'Artificielle','Categorie contenant tout fleur artificielle', 1);
INSERT INTO category(id,category_name,description,actif) VALUES(3,'Anniversaire','Categorie contenant tout fleur anniversaire', 1);
INSERT INTO category(id,category_name,description,actif) VALUES(4,'Decoration','Categorie contenant tout fleur de decoration', 1);
INSERT INTO category(id,category_name,description,actif) VALUES(5,'Mariage','Categorie contenant tout fleur de mariage', 1);
INSERT INTO category(id,category_name,description,actif) VALUES(6,'Jardinage','Categorie contenant tout fleur de jardinage', 1);
INSERT INTO category(id,category_name,description,actif) VALUES(7,'Naissance','Categorie contenant tout fleur de naissance', 1);
INSERT INTO category(id,category_name,description,actif) VALUES(8,'Gerbe accueil','Categorie contenant tout gerbe accueil', 1);
INSERT INTO category(id,category_name,description,actif) VALUES(9,'Plante exterieure','Categorie contenant tout plante exterieur', 1);
INSERT INTO category(id,category_name,description,actif) VALUES(10,'Remise diplome','Categorie contenant tout fleur pour remise de diplome', 1);
INSERT INTO category(id,category_name,description,actif) VALUES(11,'Saint valentin','Categorie contenant tout fleur saint valentin', 1);
INSERT INTO category(id,category_name,description,actif) VALUES(12,'Tropical','Categorie contenant tout fleur tropical', 1);

/* SUBCATEGORY */
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(1,'Accessoire','SousCategorie contenant tout fleur accessoire',1,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(1,'Fleurs Artificielles','SousCategorie contenant tout fleur artificielle',1,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(3,'Bougie','SousCategorie contenant tout fleur pour bougie',3,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(4,'Bouquets de mariage','SousCategorie contenant tout fleur pour mariage',5,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(5,'Decooration','SousCategorie contenant tout fleur pour decoration',4,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(13,'Ammeublement','SousCategorie contenant tout fleur pour decoration',4,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(6,'Espace vert','SousCategorie contenant tout fleur pour espace vert',6,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(7,'Fleur anniversire','SousCategorie contenant tout fleur pour anniversaire',6,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(8,'Fleur naissance','SousCategorie contenant tout fleur de naissance',7,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(9,'Fleur tropical','SousCategorie contenant tout fleur tropical',8,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(10,'Gerbe accueil','SousCategorie contenant tout fleur gerbe accueil',9,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(11,'Plante exterieure','SousCategorie contenant tout fleur pour plante exterieur',10,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(12,'Remise diplome','SousCategorie contenant tout fleur pour remise diplome',11,1);
INSERT INTO subcategory(id,sub_category_name,description,cat_id,actif) VALUES(13,'Saint valentin','SousCategorie contenant tout fleur saint valentin',12,1);

/* product */
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif) VALUES
(1,'prod1','HP-ProBooks',38000,38000.0,32,'product-1.jpg', true, true,true, 'Bouqets de fleur composé de : 4 roses Belize, 4 rosettes Teeny ','Fleur provenant de l\'Europe', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif) VALUES
(2,'vanille-fraise','Vanille fraise',330000,33000.0,12,'vanille-fraise.jpg', true, true,true, 'Bouquet de fleurs composé de : 4 roses rouges, 4 roses rosettes, 4 roses blanches et gipso','Fleur provenant de l\'Europe ', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif) VALUES
(3,'le-flamingo','Le Flamingo',30000,30000,11,'le-flamingo.jpg', true, true,true, 'Bouquet de fleur composé de : 8 roses, 5 limonium','Fleur provenant de l\'Europe', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif)
VALUES(4,'le-bonheur','Le Bonheur',40000,40000.0,32,'le-bonheur.jpg', true, true,true, 'Bouquet de fleur composé de : 10 roses rouges, 5 limonium','Fleur provenant de l\'Europe', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif)
VALUES(5,'bisou','Bisou',38000,38000.0,14,'bisou.jpg', true, true,true, 'Bouquet de fleur composé de : 10 roses blanches','Fleur provenant de l\'Europe', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif)
VALUES(6,'venus','Venus',18000,18000,22,'venus.jpg', true, true,true, 'Bouquet de fleur composé de : 10 roses rouges, 1 gypso','Fleur provenant de l\'Europe', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif)
VALUES(7,'prod7','Frigo Samsung Blanc',38000,38000,23,'product-7.jpg', true, true,true, 'Bouquet de fleur composé de : 5 roses belize, 3 roses, 1 santini, 2 gypso orangés, 2 rosettes wild radish, 1 box,  rouges, 1 gypso','Fleur provenant de l\'Europe', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif)
VALUES(8,'prod8','Lacoste Eté Classe',27000,27000,32,'product-8.jpg', true, true,true, 'Bouquet de fleur composé de : 3 liatrics, 2 magnum, 3 santini','Fleur provenant de l\'Europe', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif)
VALUES(9,'prod9','Tablettes Samsung Galaxie',73000,73000,32,'8.jpg', true, true,true, 'Bouquet de fleur composé de : 5 liatrics, 3 roses spray, 4 santini, 3 astromeria','Fleur provenant de l\'Europe', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);


INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif)
VALUES(10,'sensation','Sensation',43000,43000,32,'sensation.jpg', true, true,true, 'Bouquet de fleur composé de : 5 lys, 4 roses rouges, 2 roses blanches, 1 imonium, 2 rosettes roses, 1 rosette blanc, margerite blanc et rouge, feullle de palme, 4 santini, 3 astromeria','Fleur provenant de l\'Europe', '2023-06-17 12:36:48','2023-06-17 12:36:48',10,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif)
VALUES(11,'le-mirage','Le mirage',43000,43000,12,'le-mirage.jpg', true, true,true, 'Bouquet de fleur composé de : 3 roses rouges, 2 roses blanches, 2 lys, 1 florinca, 1 gypso, 1 teeny weeny jaune et belize','Fleur provenant de l\'Europe', '2023-06-17 12:36:48','2023-06-17 12:36:48',11,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif)
VALUES(12,'bisous','Bisous',33000,33000,32,'bisous.jpg', true, true,true, 'Bouquet de fleur composé de : 5 pink floyd roses, 1 lysimachia eucalyptus','Fleur provenant de l\'Europe', '2023-06-17 12:36:48','2023-06-17 12:36:48',12,1);

INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif)
VALUES(13,'prod13','Eaux de Cologne',1700,1800.0,32,'paradis.jpg', true, true,true, 'Bouquet de fleur composé de : 5 pink floyd roses, 1 lysimachia eucalyptus','Fleur provenant de l\'Europe', '2023-06-17 12:36:48','2023-06-17 12:36:48',13,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif) VALUES(14,'prod14','Ordinateurs',1700,1800.0,32,'23.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif) VALUES(15,'prod15','Mini PC',1700,1800.0,32,'26.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif) VALUES(16,'prod16','Fleur-16',1700,1800.0,32,'11.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',3,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif) VALUES(17,'prod17','Fleurs-17',1700,1800.0,32,'17.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',3,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif) VALUES(18,'prod17','Fleur-18',1700,1800.0,32,'20.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',5,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif) VALUES(19,'prod19','Fleur-19',1700,1800.0,32,'28.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,current_price,quantity,image_url,is_selected,is_promo,is_in_stock,description,manufactured,created_date,last_up_dated,scat_id,actif) VALUES(20,'prod20','Fleur-20',1700,1800.0,32,'34.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',6,1);

/* REGIONS */
INSERT INTO country(id,code,name,actif) VALUES(1,'DK','Dakar',1);
INSERT INTO country(id,code,name,actif) VALUES(2,'DL','Diourbel',1);
INSERT INTO country(id,code,name,actif) VALUES(3,'FT','Fatick',1);
INSERT INTO country(id,code,name,actif) VALUES(4,'KF','Kaffrine',1);
INSERT INTO country(id,code,name,actif) VALUES(5,'KL','Kaolack',1);
INSERT INTO country(id,code,name,actif) VALUES(6,'KD','Kolda',1);
INSERT INTO country(id,code,name,actif) VALUES(7,'LG','Louga',1);
INSERT INTO country(id,code,name,actif) VALUES(8,'ST','Saint-Louis',1);
INSERT INTO country(id,code,name,actif) VALUES(9,'SD','Sedhiou',1);
INSERT INTO country(id,code,name,actif) VALUES(10,'TB','Tambacounda',1);
INSERT INTO country(id,code,name,actif) VALUES(11,'TH','Thiès',1);
INSERT INTO country(id,code,name,actif) VALUES(12,'ZG','Ziguinchor',1);

/* DEPARTEMENTS */
INSERT INTO state(id,name,country_id,actif) VALUES(1,'Amitié 1', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(2,'Amitié 2', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(3,'Amitié 3', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(3,'Almadies', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(4,'Bambilor', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(5,'Bargny', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(6,'Bel Air 1', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(7,'Bop', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(7,'Camberene', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(8,'Castor', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(10,'Centenaire', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(11,'Cité Keur Damel', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(12,'Cité Keur Gorgui', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(13,'Colobane', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(14,'Castor', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(15,'Dalifort', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(15,'Dakar plateau', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(15,'Dalifort', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(16,'Derklet', 1,1);
INSERT INTO state(id,name,country_id,actif) VALUES(17,'Diamaguene', 1,1);


INSERT INTO state(id,name,countryId,actif) VALUES(1,'Dakar', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Guédiawaye', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Pikine', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Rufisque', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Bambey', 2,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Diourbel', 2,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Mbacké', 2,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Fatick', 3,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Foundiougne', 3,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Gossas', 3,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Birkelane', 4,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Kaffrine', 4,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Koungheul', 4,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Malem-Hodar',4,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Guinguinéo', 5,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Kaolack', 5,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Nioro du Rip',5,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Kolda', 6,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Velingara', 6,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Medina yoro foulah',6,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Kébémer',7,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Linguère',7,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Louga',7,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Dagana',8,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Podor', 8,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Saint-Louis',8,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Bounkiling',9,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Goudomp', 9,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Sedhiou',9,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Bakel', 10,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Goudiry', 10,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Koumpentoum', 10,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Tambacounda', 10,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Mbour', 11,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Thies', 11,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Tivaoune', 11,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Bignona', 12,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Oussouye', 12,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Ziguinchor', 12,1);




/* ROLES */
INSERT INTO roles(id,name) VALUES(1,'ROLE_VENDEUR');
INSERT INTO roles(id,name) VALUES(1,'ROLE_GERANT');
INSERT INTO roles(id,name) VALUES(1,'ROLE_MANAGER');
INSERT INTO roles(id,name) VALUES(1,'ROLE_ADMIN');

/* UTILISATEURS */
INSERT INTO utilisateur(id,name,username,email,password,photo,isActive,actif) VALUES(1,'Admin','admin','admin@gmail.com','$2a$10$R44dGnwuk2cMQFQXc35fXOER2c8XLC6Sll4j/fqjepLplg4gBG.sK','',true);
INSERT INTO utilisateur(id,name,username,email,password,photo,isActive,actif) VALUES(1,'Vendeur','vendeur','vendeur@gmail.com','$2a$10$v5RaZqqWEs.iupW7r.oErOSqlb4CJjWUXY5XepZ4O8Vt.lOYQiDMi','',true);
INSERT INTO utilisateur(id,name,username,email,password,photo,isActive,actif) VALUES(1,'Gerant','gerant','gerant@gmail.com','$2a$10$1Ch4l3YxBNzsQXTOLflqmOnxLQbp9XwGkSeTEmcucCtHvcYauXzo2','',true);
INSERT INTO utilisateur(id,name,username,email,password,photo,isActive,actif) VALUES(1,'Manageur','manageur','manageur@gmail.com','$2a$10$QCtMpd6M1ShbWcnDGrIYzO1hfQc0FS.EWrt68hDLe2mh64gEYVHqe','',true);

