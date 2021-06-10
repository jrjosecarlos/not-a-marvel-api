CREATE TABLE nama.story_character (
	story_id UUID NOT NULL,
	character_id UUID NOT NULL,
	CONSTRAINT pk_story_character PRIMARY KEY (story_id, character_id),
	CONSTRAINT fk_story_character_story FOREIGN KEY (story_id)
		REFERENCES nama.story (id_story),
	CONSTRAINT fk_story_character_character FOREIGN KEY (character_id)
		REFERENCES nama."character" (id_character)
);
