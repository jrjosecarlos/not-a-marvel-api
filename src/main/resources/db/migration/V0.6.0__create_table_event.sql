CREATE TABLE nama.event (
	id_event UUID NOT NULL CONSTRAINT pk_event PRIMARY KEY,	
	title varchar(100) NOT NULL,
	description TEXT NULL,
	start_date TIMESTAMP WITHOUT TIME ZONE NULL,
	end_date TIMESTAMP WITHOUT TIME ZONE NULL,
	modified TIMESTAMP WITH TIME ZONE NOT NULL,
	previous_event_id UUID NULL,
	CONSTRAINT fk_event_previous_event FOREIGN KEY (previous_event_id)
		REFERENCES nama.event (id_event)
);
