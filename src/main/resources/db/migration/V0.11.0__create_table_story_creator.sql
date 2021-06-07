CREATE TABLE nama.story_creator (
	story_id UUID NOT NULL,
	creator_id UUID NOT NULL,
	role VARCHAR(40) NOT NULL,
	CONSTRAINT pk_story_creator PRIMARY KEY (story_id, creator_id),
	CONSTRAINT fk_creator_story_story FOREIGN KEY (story_id)
		REFERENCES nama.story(id_story),
	CONSTRAINT fk_creator_story_creator FOREIGN KEY (creator_id)
		REFERENCES nama.creator(id_creator)
);
