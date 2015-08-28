Database Information

Databases are stored in the hair_salon.sql and hair_salon_test.sql files. To use them locally, type in psql [database_name] < [sqlfile] into your command line. You can also create them in Postgres by typing in the following information in your command line after typing psql:

CREATE DATABASE hair_salon;
CREATE TABLE clients (id SERIAL PRIMARY KEY, name varchar, phone int, stylist_id int);
CREATE TABLE stylists (id SERIAL PRIMARY KEY, name varchar);
CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;