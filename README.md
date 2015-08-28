# Hair-Salon

## Synopsis

This is an application that will allow the user to add, edit, and delete stylists and clients from a fictional beauty school website. 

## Motivation

This is an exercise completed at the end of the third week of Epicodus, a code school, to see if we have successfully learned the basics of adding data to databases using Postgres.

## Installation

In order to install hair-salon, you'll need to have [Java] (https://www.learnhowtoprogram.com/lessons/java-setup), [Gradle] (https://www.learnhowtoprogram.com/lessons/setting-up-a-project-with-gradle) and [Postgres] (https://www.learnhowtoprogram.com/lessons/installing-postgres) installed on your computer.

Databases are stored in the ``hair_salon.sql`` and ``hair_salon_test.sql`` files. To use them locally, type in ``psql [database_name] < [sqlfile]`` into your command line. You can also create them in Postgres manually by typing in the following information in your command line after going into the ``psql`` application:

``CREATE DATABASE hair_salon;``

``\c hair_salon``

``CREATE TABLE clients (id SERIAL PRIMARY KEY, name varchar, phone int, stylist_id int);``

``CREATE TABLE stylists (id SERIAL PRIMARY KEY, name varchar);``

``CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;``


 In order to run the application, you'll need to type ``gradle run`` on your command line. All additional libraries will be installed after running gradle.

## Tests

There are both unit tests for each object and integration tests associated with this application. The test files can be found under /src/test/java in the ``AppIntegrationTest.java``, ``ClientTest.java``, ``StylistTest.java`` files. To run the test suite, you'll need to type ``gradle test`` in your command line.

## Contributors

Created by Ashley Sullins.

## License

MIT License 2015