CREATE TABLE nama.series (
	id_series UUID NOT NULL CONSTRAINT pk_series PRIMARY KEY,	
	title VARCHAR(100) NOT NULL,
	description TEXT NULL,
	start_year INT NOT NULL,
	end_year INT NOT NULL,
	rating VARCHAR(40) NULL, 
	modified TIMESTAMP WITH TIME ZONE NOT NULL,
	next_series_id UUID NULL,
	CONSTRAINT fk_series_next_series FOREIGN KEY (next_series_id)
		REFERENCES nama.series (id_series)
);
