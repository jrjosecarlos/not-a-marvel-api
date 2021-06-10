CREATE TABLE nama.comic_descriptive_text (
	id_comic_descriptive_text UUID NOT NULL CONSTRAINT pk_comic_descriptive_text PRIMARY KEY,
	comic_id UUID NOT NULL,
	"type" VARCHAR(30) NOT NULL,
	language VARCHAR(30) NOT NULL,
	"text" TEXT NOT NULL,
	modified TIMESTAMP WITH TIME ZONE NOT NULL,
	CONSTRAINT fk_comic_descriptive_text_comic FOREIGN KEY (comic_id)
		REFERENCES nama.comic(id_comic)
);
