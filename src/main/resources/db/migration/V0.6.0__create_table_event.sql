CREATE TABLE nama.event (
	id_event UUID NOT NULL CONSTRAINT pk_event PRIMARY KEY,	
	title varchar(100) NOT NULL,
	description TEXT NULL,
	start_date TIMESTAMP WITHOUT TIME ZONE NULL,
	end_date TIMESTAMP WITHOUT TIME ZONE NULL,
	modified TIMESTAMP WITH TIME ZONE NOT NULL,
	next_event_id UUID NULL,
	CONSTRAINT fk_event_next_event FOREIGN KEY (next_event_id)
		REFERENCES nama.event (id_event)
);
