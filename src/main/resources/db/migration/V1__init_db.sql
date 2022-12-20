CREATE TABLE client(
	id IDENTITY PRIMARY KEY,
	name VARCHAR(200) CONSTRAINT client_name_length CHECK (LENGTH(name)>=3) NOT NULL
);

CREATE TABLE planet(
	id VARCHAR(100) PRIMARY KEY,
	name VARCHAR(500) CONSTRAINT planet_name_length CHECK (LENGTH(name)>=1) NOT NULL
);

CREATE TABLE ticket(
	id IDENTITY PRIMARY KEY,
	created_at TIMESTAMP,
	client_id BIGINT NOT NULL,
	from_planet_id VARCHAR(100),
	to_planet_id VARCHAR(100),
	FOREIGN KEY(client_id) REFERENCES client(id)
);
