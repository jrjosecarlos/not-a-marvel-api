CREATE TABLE nama.comic_collection (
	collection_comic_id UUID NOT NULL,
	collected_comic_id UUID NOT NULL,
	CONSTRAINT pk_comic_collection PRIMARY KEY (collection_comic_id, collected_comic_id),
	CONSTRAINT fk_comic_collection_collection_comic FOREIGN KEY (collection_comic_id)
		REFERENCES nama.comic (id_comic),
	CONSTRAINT fk_comic_collection_collected_comic FOREIGN KEY (collected_comic_id)
		REFERENCES nama.comic (id_comic)
);
