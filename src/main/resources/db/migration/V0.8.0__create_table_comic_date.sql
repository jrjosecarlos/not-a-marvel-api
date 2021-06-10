CREATE TABLE nama.comic_date (
	id_comic_date UUID NOT NULL CONSTRAINT pk_comic_date PRIMARY KEY,
	comic_id UUID NOT NULL,
	"type" VARCHAR(30) NOT NULL,
	"date" TIMESTAMP WITH TIME ZONE NOT NULL,
	modified TIMESTAMP WITH TIME ZONE NOT NULL,
	CONSTRAINT fk_comic_date_comic FOREIGN KEY (comic_id)
		REFERENCES nama.comic(id_comic)
);
