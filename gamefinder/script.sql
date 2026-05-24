-- DDL: Criação das Tabelas

CREATE TABLE genre (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE platform (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE game (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(1000),
    release_date DATE,
    rating DOUBLE PRECISION,
    cover_url VARCHAR(255),
    backdrop_url VARCHAR(255),
    in_wishlist BOOLEAN,
    genre_id BIGINT,
    platform_id BIGINT,
    FOREIGN KEY (genre_id) REFERENCES genre(id),
    FOREIGN KEY (platform_id) REFERENCES platform(id)
);