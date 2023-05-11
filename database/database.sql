CREATE TABLE PROFILE (
    id character varying(255) PRIMARY KEY,
    backend_experience smallint NOT NULL,
    business_key character varying(255),
    camunda_experience smallint NOT NULL,
    camunda_id character varying(255),
    database_experience smallint NOT NULL,
    email character varying(255) UNIQUE,
    frontend_experience smallint NOT NULL,
    health_experience smallint NOT NULL,
    name character varying(60),
    phone_number character varying(15) UNIQUE
);
