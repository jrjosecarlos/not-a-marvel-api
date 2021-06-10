CREATE TABLE nama.event_comic (
	event_id UUID NOT NULL,
	comic_id UUID NOT NULL,
	CONSTRAINT pk_event_comic PRIMARY KEY (event_id, comic_id),
	CONSTRAINT fk_event_comic_event FOREIGN KEY (event_id)
		REFERENCES nama.event (id_event),
	CONSTRAINT fk_event_comic_comic FOREIGN KEY (comic_id)
		REFERENCES nama.comic (id_comic)
);