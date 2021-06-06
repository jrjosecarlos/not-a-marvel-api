CREATE TABLE nama.comic_story (
	comic_id UUID NOT NULL,
	story_id UUID NOT NULL,
	CONSTRAINT pk_comic_story PRIMARY KEY (comic_id, story_id),
	CONSTRAINT fk_comic_story_comic FOREIGN KEY (comic_id)
		REFERENCES nama.comic (id_comic),
	CONSTRAINT fk_comic_story_story FOREIGN KEY (story_id)
		REFERENCES nama.story (id_story)
);
