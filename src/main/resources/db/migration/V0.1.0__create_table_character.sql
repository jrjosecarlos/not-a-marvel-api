CREATE TABLE nama."character" (
	id_character UUID NOT NULL CONSTRAINT pk_character PRIMARY KEY,	
	name VARCHAR(100) NOT NULL,
	description TEXT NULL,
	modified TIMESTAMP WITH TIME ZONE NOT NULL
);
