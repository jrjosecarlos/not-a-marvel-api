CREATE TABLE nama.creator_story (
	creator_id UUID NOT NULL,
	story_id UUID NOT NULL,
	role VARCHAR(40) NOT NULL,
	CONSTRAINT pk_creator_story PRIMARY KEY (creator_id, story_id),
	CONSTRAINT fk_creator_story_creator FOREIGN KEY (creator_id)
		REFERENCES nama.creator(id_creator),
	CONSTRAINT fk_creator_story_story FOREIGN KEY (story_id)
		REFERENCES nama.story(id_story)
);
