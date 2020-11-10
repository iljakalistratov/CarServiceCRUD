# CarService CRUD

## Contents
- [Overview](#Overview)
- [Requirements](#Requirements)
- [Installation](#Installation)
- [Documentation](#Documentation)
- [Testing](#Testing)
- [Frontend (Angular)](#Frontend (Angular))

## Overview
A CRUD based REST API, that allows you to manage an Inventory of cars, with options to list, create, update and delete entrys. 
The Project utilizes the Spring Boot framework in order to manage it's API.

## Requirements
- JVM and JRE running on Java 11
- Maven
- Docker
- NodeJs
- Angular

## Installation
- After cloning the git repo into your local file system first use Maven to download all the nessicary dependencys and build the project
    - On Windows:   ``mvnw package``
    - On Unix:  ``mvn package`` 
- Setup the database using ``docker-compose up -d`` from the root directory
- The API should now be running on ``http://localhost:8080/cars/``

## Documentation
- This project is compatible with java docs
- if you wish to generate the documentation, run the following command: ``mvn javadoc:javadoc``
- The files can then be found under ``./target/site/apidocs`` in your project directory
- Furthermore, precise documentation for using the API can be found under ``http://localhost:8080/swagger-ui/`` at runtime

## Testing
- The project has two types of test already setup: 
    - Integration tests using Newman (/Postman)
    - Unit tests using Junit
- The Newman tests can be found under ``./src/newman api test``
- The integration tests can be run using ``newman run ./newman api test`` from the project root
- Unit Tests can be found under ``./src/test/java``
- Running all Unit tests at once can be achieved by running the Test Suite ``TestAll.java``

## Usage of PostgreSQL in Docker
- Get PostgreSQL going: ``docker-compose up -d``
- Entering Postgres
    - Step 1: ``winpty docker exec -it postgres bash``
    - Step 2: ``psql -U docker``
    
## Frontend (Angular)
- To access to front end (with Spring boot and Postgres running in the background):
    - navigate to ``./CarService`` from the root directory
    - make sure angular & typescript are installed 
    - start the angular app using: ``ng serve --open``
    - (your browser should open the page automatically)
- Overview:
    - List of all cars: ``http://localhost:4200/cars`` or ``http://localhost:4200/``
    - Search for individual cars: ``http://localhost:4200/list-single-car?id=1000``
    - Create car entries: ``http://localhost:4200/create-car``
    - Edit existing car entries: ``http://localhost:4200/update-car/1000``
    - View car details: ``http://localhost:4200/car-details/1000``
