CREATE TABLE nama.comic_price (
	id_comic_price UUID NOT NULL CONSTRAINT pk_comic_price PRIMARY KEY,
	comic_id UUID NOT NULL,
	"type" varchar(30) NOT NULL,
	price NUMERIC(15, 2) NOT NULL,
	modified TIMESTAMP WITH TIME ZONE NOT NULL,
	CONSTRAINT fk_comic_price_comic FOREIGN KEY (comic_id)
		REFERENCES nama.comic(id_comic)
);
