--liquibase formatted sql
--changeset lindsey neidig:create-tables
--tag:1

create table states (
   id INT AUTO_INCREMENT,
   abbreviation VARCHAR(2) NOT NULL,
   name VARCHAR(50) NOT NULL,
   PRIMARY KEY (id)
);

create table address (
    id BIGINT AUTO_INCREMENT,
    street_one VARCHAR(255) NOT NULL,
    street_two VARCHAR(150),
    city VARCHAR(45) NOT NULL,
    state INT NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (state) REFERENCES states(id)
);

create table person (
    id bigint AUTO_INCREMENT,
    first_name VARCHAR(45) NOT NULL,
    middle_name VARCHAR(45),
    last_name VARCHAR(45) NOT NULL,
    address_key BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (address_key) REFERENCES address(id)
);

INSERT into states (abbreviation, name) values
    ('AK', 'Alaska'),
    ('AL', 'Alabama'),
    ('AZ', 'Arizona'),
    ('AR', 'Arkansas'),
    ('CA', 'California'),
    ('CO', 'Colorado'),
    ('CT', 'Connecticut'),
    ('DE', 'Delaware'),
    ('DC', 'District of Columbia'),
    ('FL', 'Florida'),
    ('GA', 'Georgia'),
    ('HI', 'Hawaii'),
    ('ID', 'Idaho'),
    ('IL', 'Illinois'),
    ('IN', 'Indiana'),
    ('IA', 'Iowa'),
    ('KS', 'Kansas'),
    ('KY', 'Kentucky'),
    ('LA', 'Louisiana'),
    ('ME', 'Maine'),
    ('MD', 'Maryland'),
    ('MA', 'Massachusetts'),
    ('MI', 'Michigan'),
    ('MN', 'Minnesota'),
    ('MS', 'Mississippi'),
    ('MO', 'Missouri'),
    ('MT', 'Montana'),
    ('NE', 'Nebraska'),
    ('NV', 'Nevada'),
    ('NH', 'New Hampshire'),
    ('NJ', 'New Jersey'),
    ('NM', 'New Mexico'),
    ('NY', 'New York'),
    ('NC', 'North Carolina'),
    ('ND', 'North Dakota'),
    ('OH', 'Ohio'),
    ('OK', 'Oklahoma'),
    ('OR', 'Oregon'),
    ('PA', 'Pennsylvania'),
    ('PR', 'Puerto Rico'),
    ('RI', 'Rhode Island'),
    ('SC', 'South Carolina'),
    ('SD', 'South Dakota'),
    ('TN', 'Tennessee'),
    ('TX', 'Texas'),
    ('UT', 'Utah'),
    ('VT', 'Vermont'),
    ('VA', 'Virginia'),
    ('WA', 'Washington'),
    ('WV', 'West Virginia'),
    ('WI', 'Wisconsin'),
    ('WY', 'Wyoming');

-- rollback DROP TABLE person;
-- rollback DROP TABLE address;
-- rollback DROP TABLE states;
