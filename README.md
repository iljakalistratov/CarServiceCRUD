# Simple SpringBoot Carservice CRUD Application  

## Description
A simple application to manage cars. 
Available parameters are: model, brand, leistung, baujahr, motor und verbrauch.
The app automatically generates an id for every car to make the management easier.

## Usage
* download the git repo
* import maven project
* start project in your favorite IDE (in the best case IntelliJ)
* Under http://localhost:8080/carlist the current list of cars should show up in json format (3 cars are already given for sample purposes)
* Under http://localhost:8080/car/id every single entry can be viewed separatly
* To use CRUD the simple way, please intall the REST Client addon for your browser or install the windows application.
* With the POST method you can add new objects to the list, for example: put {"model":"abc","brand":"def","leistung":"250","baujahr":"2010","motor":"2 Benzin","verbrauch":"9"} into the Request Body and send. It is important for this operation to have http://localhost:8080/car in the URL Box.
* The GET method shows the whole list with all parameters of every single object. With this method you can prove if the POST operation was succesful.
* With the DELETE method you can remove an object from the list. For example: http://localhost:8080/car/id and send with DELETE Request.