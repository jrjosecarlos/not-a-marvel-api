CREATE TABLE nama.creator (
	id_creator UUID NOT NULL CONSTRAINT pk_creator PRIMARY KEY,
	first_name varchar(40) NOT NULL,
	middle_name varchar(60) NULL,
	last_name varchar(60) NOT NULL,
	suffix varchar(60) NULL,
	modified TIMESTAMP WITH TIME ZONE NOT NULL
);
