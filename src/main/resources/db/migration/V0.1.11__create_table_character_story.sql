CREATE TABLE nama.character_story (
	character_id UUID NOT NULL,
	story_id UUID NOT NULL,
	CONSTRAINT pk_character_story PRIMARY KEY (character_id, story_id),
	CONSTRAINT fk_character_story_character FOREIGN KEY (character_id)
		REFERENCES nama."character" (id_character),
	CONSTRAINT fk_character_story_story FOREIGN KEY (story_id)
		REFERENCES nama.story (id_story)
);
