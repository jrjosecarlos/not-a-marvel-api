CREATE TABLE nama.comic (
	id_comic UUID NOT NULL CONSTRAINT pk_comic PRIMARY KEY,
	series_id UUID NOT NULL,
	digital_id INT(20) NULL,
	title VARCHAR(100) NOT NULL,
	issue_number INT NOT NULL,
	description TEXT NULL,
	isbn VARCHAR(25) NULL,
	upc VARCHAR(25) NULL,
	diamond_code VARCHAR(25) NULL,
	ean VARCHAR(25) NULL,
	issn VARCHAR(25) NULL,
	format VARCHAR(25) NULL,
	page_count INT NOT NULL,
	modified TIMESTAMP WITH TIME ZONE NOT NULL,
	CONSTRAINT fk_comic_series FOREIGN KEY (series_id)
		REFERENCES nama.series (id_series)
);
