CREATE TABLE IF NOT EXISTS product (
    identifier INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    price INT NOT NULL
);