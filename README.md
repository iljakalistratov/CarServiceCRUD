# CarService CRUD

## Contents
- [Overview](#Overview)
- [Requirements](#Requirements)
- [Installation](#Installation)
- [Documentation](#Documentation)
- [Testing](#Testing)
- [Frontend (Angular)](#Frontend (Angular))
- [Usage](#Usage)

## Overview
A web application based on a restful CRUD API, that allows you to manage an Inventory of cars, with options to list, create, update and delete entrys. 
The Project utilizes the Spring Boot framework in order to manage it's API, postgres to store the data and angular to display it in the front end.

## Requirements
- JVM and JRE running on Java 11 (or higher)
- Maven
- Docker
- NodeJs
- Angular
- Typescript
- Kubernetes
- Minikube

## Installation (Kubernetes)
- Step 1: Install all dependencies named above (example given using chocolaty)
    - ``choco install openjdk:11 maven docker nodejs minikube``
    - ``npm intsall -g typescript angular``
- Step 2: Add ``springboot`` to the host file and point it towards the minikube ip
    - Example: ``192.168.99.107    springboot``
- Step 3: Run the deployment script ``bash ./setup.sh``
- Step 4: The webapp should now be running at ``http://minikube``
- Step 5: If failed run: ``eval "$(minikube docker-env --shell=bash)"`` and repeat steps 2-3

## Installation (Local)
- Step 1: Install all dependencies named above (example given using chocolaty)
    - ``choco install openjdk:11 maven docker nodejs minikube``
    - ``npm intsall -g typescript angular``
- Step 2: Add ``ultraservicespringboot`` to the host file and point it towards localhost
    - Example: ``localhost    springboot``
- Step 3: Pull up docker-compose file (to get postgres to run)
    - ``docker-compose up -d -f ./docker-compose.yml``
- Step 4: Run Angular and Spring Boot
    - ``mvn package && java -jar ./target/RestfulCarlist-0.0.1.jar``
     - ``cd ./src/main/angular && ng serve --open``
- Step 5: Access the service over ``http://localhost:4200``

## Testing (Local)
- The project has two types of test already setup: 
    - Integration tests using Newman (/Postman)
    - Unit tests using Junit

## Documentation
- The java portion of project is compatible with java docs
    - If you wish to generate that documentation, run the following command: ``mvn javadoc:javadoc`` in the project root
    - The files can then be found under ``./target/site/apidocs`` in your project directory
- Furthermore, precise documentation for using the API can be found under ``http://minikube/backend/swagger-ui/`` at runtime

## Usage of PostgreSQL in Docker
- Get PostgreSQL going: ``docker-compose up -d``
- Entering Postgres
    - Step 1: ``docker exec -it postgres bash``
    - Step 2: ``psql -U docker``
    
## Usage Frontend (Angular)
- To access to front end (with Spring boot and Postgres running in the background):
    - navigate to ``./CarService`` from the root directory
    - make sure angular & typescript are installed 
    - start the angular app using: ``ng serve --open``
    - (your browser should open the page automatically)
- Overview:
    - List of all cars: ``http://minikube/cars`` or ``http://minikube/``
    - Create car entries: ``http://minikube/create-car``
    - Edit existing car entries: ``http://minikube/update-car/"id"``

## Usage Backend
- General Overview:
    - **C**reate entries: POST-Request to ``minikube:30002/car/"id"`` and a JSON Object in the body containing the following items:
        - model
        - brand
        - leistung
        - baujahr
        - motor
        - verbrauch

    - **R**ead entries
        - to read all entries: GET-Request to ``http://minikube:30002/carlist``
        - to read out single entries: GET-Request to ``http://minikube:30002/car/"id"`` (here the id 19 is being checked)
    - **U**pdate entries: PUT-Request to ``http://minikube:30002/car/"id"``
        - with the id number displaying the id of what car has to be updated 
        - as well as a JSON Object in the body containing the same items as the create method
    - **D**elete entries: DELETE-Request to ``http://minikube:30002/car/"id"``
- For precise Usage info, please visit ``http://minikube:30002/swagger-ui/``

