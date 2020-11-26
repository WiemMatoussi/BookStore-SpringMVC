create table publishers (
	publisherID INT GENERATED BY DEFAULT AS IDENTITY,
	publisherName VARCHAR (30) NOT NULL,
	PRIMARY KEY (publisherID)
);

create table authors (
	authorID INT GENERATED BY DEFAULT AS IDENTITY,
	firstName VARCHAR (20) NOT NULL,
	lastName VARCHAR (30) NOT NULL,
	PRIMARY KEY (authorID)
);

create table titles (
	isbn VARCHAR (20) NOT NULL,
	title VARCHAR (100) NOT NULL,
	editionNumber INT NOT NULL,
	copyright VARCHAR (4) NOT NULL,
	publisherID INT NOT NULL,
	imageFile VARCHAR (20) NOT NULL,
	price real NOT NULL,
	PRIMARY KEY (isbn)
);

create table authorISBN (
	authorID INT NOT NULL,
	isbn VARCHAR (20) NOT NULL
);