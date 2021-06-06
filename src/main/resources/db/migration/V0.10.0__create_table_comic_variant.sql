CREATE TABLE nama.comic_variant (
	variant_comic_id UUID NOT NULL,
	original_comic_id UUID NOT NULL,
	variant_description TEXT NULL,
	CONSTRAINT pk_comic_variant PRIMARY KEY (variant_comic_id, original_comic_id),
	CONSTRAINT fk_comic_variant_variant_comic FOREIGN KEY (variant_comic_id)
		REFERENCES nama.comic (id_comic),
	CONSTRAINT fk_comic_variant_original_comic FOREIGN KEY (original_comic_id)
		REFERENCES nama.comic (id_comic)
);
