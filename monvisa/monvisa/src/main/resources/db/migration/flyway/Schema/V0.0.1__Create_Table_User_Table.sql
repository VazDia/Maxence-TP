CREATE TABLE Utilisateurs(
id_u SERIAL PRIMARY KEY,
nom VARCHAR(255) NOT NULL,
prenom VARCHAR(255) NOT NULL,
email CHAR(255) NOT NULL,
password CHAR(200) NOT NULL
);