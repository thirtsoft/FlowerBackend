/* CATEGORY */
INSERT INTO category(id,categoryName,description,actif) VALUES(1,'Accessoire','Categorie contenant tout fleur accessoire', 1);
INSERT INTO category(id,categoryName,description,actif) VALUES(2,'Artificielle','Categorie contenant tout fleur artificielle', 1);
INSERT INTO category(id,categoryName,description,actif) VALUES(3,'Anniversaire','Categorie contenant tout fleur anniversaire', 1);
INSERT INTO category(id,categoryName,description,actif) VALUES(4,'Decoration','Categorie contenant tout fleur de decoration', 1);
INSERT INTO category(id,categoryName,description,actif) VALUES(5,'Mariage','Categorie contenant tout fleur de mariage', 1);
INSERT INTO category(id,categoryName,description,actif) VALUES(6,'Jardinage','Categorie contenant tout fleur de jardinage', 1);
INSERT INTO category(id,categoryName,description,actif) VALUES(7,'Naissance','Categorie contenant tout fleur de naissance', 1);
INSERT INTO category(id,categoryName,description,actif) VALUES(8,'Tropical','Categorie contenant tout fleur tropical', 1);
INSERT INTO category(id,categoryName,description,actif) VALUES(9,'Gerbe accueil','Categorie contenant tout gerbe accueil', 1);
INSERT INTO category(id,categoryName,description,actif) VALUES(10,'Plante exterieure','Categorie contenant tout plante exterieur', 1);
INSERT INTO category(id,categoryName,description,actif) VALUES(11,'Remise diplome','Categorie contenant tout fleur pour remise de diplome', 1);
INSERT INTO category(id,categoryName,description,actif) VALUES(12,'Saint valentin','Categorie contenant tout fleur saint valentin', 1);


/* SUBCATEGORY */
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(1,'Accessoire','SousCategorie contenant tout fleur accessoire',1,1);
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(2,'Artificielle','SousCategorie contenant tout fleur artificielle',2,1);
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(3,'Bougie','SousCategorie contenant tout fleur pour bougie',3,1);
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(4,'Bouquets de la marie','SousCategorie contenant tout fleur pour mariage',5,1);
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(5,'Deco eglise','SousCategorie contenant tout fleur pour decoration',4,1);
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(6,'Espace vert','SousCategorie contenant tout fleur pour espace vert',6,1);
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(7,'Fleur anniversire','SousCategorie contenant tout fleur pour anniversaire',6,1);
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(8,'Fleur naissance','SousCategorie contenant tout fleur de naissance',7,1);
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(9,'Fleur tropical','SousCategorie contenant tout fleur tropical',8,1);
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(10,'Gerbe accueil','SousCategorie contenant tout fleur gerbe accueil',9,1);
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(11,'Plante exterieure','SousCategorie contenant tout fleur pour plante exterieur',10,1);
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(12,'Remise diplome','SousCategorie contenant tout fleur pour remise diplome',11,1);
INSERT INTO subcategory(id,subCategoryName,description,catId,actif) VALUES(13,'Saint valentin','SousCategorie contenant tout fleur saint valentin',12,1);

/* product */
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(1,'prod1','HP-ProBooks',1700,1800.0,32,'product-1.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(2,'prod2','HP-ProBooks',1700,1800.0,32,'product-2.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',2,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(3,'prod3','Lave Linge Original',1700,1800.0,32,'product-3.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',3,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(4,'prod4','Ecouteur Montage vidéos',1700,1800.0,32,'product-4.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',4,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(5,'prod5','Lave Linges marque USA',1700,1800.0,32,'product-5.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',5,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(6,'prod6','Lot de Machine à café',1700,1800.0,32,'product-6.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',6,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(7,'prod7','Frigo Samsung Blanc',1700,1800.0,32,'product-7.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',7,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(8,'prod8','Lacoste Eté Classe',1700,1800.0,32,'product-8.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',8,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(9,'prod9','Tablettes Samsung Galaxie',1700,1800.0,32,'8.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',9,1);


INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(10,'prod10','Robe Ete',1700,1800.0,32,'14.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',10,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(11,'prod11','HuperCool',1700,1800.0,32,'11.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',11,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(12,'prod12','Parfums',1700,1800.0,32,'12.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',12,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(13,'prod13','Eaux de Cologne',1700,1800.0,32,'13.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',13,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(14,'prod14','Ordinateurs',1700,1800.0,32,'23.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(15,'prod15','Mini PC',1700,1800.0,32,'26.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(16,'prod16','Fleur-16',1700,1800.0,32,'11.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',3,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(17,'prod17','Fleurs-17',1700,1800.0,32,'17.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',3,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(18,'prod17','Fleur-18',1700,1800.0,32,'20.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',5,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(19,'prod19','Fleur-19',1700,1800.0,32,'28.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',1,1);
INSERT INTO product(id,reference,designation,price,currentPrice,quantity,imageUrl,isSelected,isPromo,isInstock,description,manufactured,createdDate,lastUpDated,scat_id,actif) VALUES(20,'prod20','Fleur-20',1700,1800.0,32,'34.jpg', true, true,true, 'prod1','prod1', '2023-06-17 12:36:48','2023-06-17 12:36:48',6,1);

/* REGIONS */
INSERT INTO country(id,code,name,actif) VALUES(1,'DK','Dakar');
INSERT INTO country(id,code,name,actif) VALUES(2,'DL','Diourbel');
INSERT INTO country(id,code,name,actif) VALUES(3,'FT','Fatick');
INSERT INTO country(id,code,name,actif) VALUES(4,'KF','Kaffrine');
INSERT INTO country(id,code,name,actif) VALUES(5,'KL','Kaolack');
INSERT INTO country(id,code,name,actif) VALUES(6,'KD','Kolda');
INSERT INTO country(id,code,name,actif) VALUES(7,'LG','Louga');
INSERT INTO country(id,code,name,actif) VALUES(8,'ST','Saint-Louis');
INSERT INTO country(id,code,name,actif) VALUES(9,'SD','Sedhiou');
INSERT INTO country(id,code,name,actif) VALUES(10,'TB','Tambacounda');
INSERT INTO country(id,code,name,actif) VALUES(11,'TH','Thiès');
INSERT INTO country(id,code,name,actif) VALUES(12,'ZG','Ziguinchor');

/* DEPARTEMENTS */
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Amitié 1', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Amitié 2', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Amitié 3', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Bambilor', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Bargny', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Bel Air 1', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Bop', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Camberene', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Castor', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Centenaire', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Cité Keur Damel', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Cité Keur Gorgui', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Colobane', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Castor', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Dalifort', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Derklet', 1,1);
INSERT INTO state(id,name,countryId,actif) VALUES(1,'Diamaguene', 1,1);


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

