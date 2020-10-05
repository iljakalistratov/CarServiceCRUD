# Simple SpringBoot Carservice CRUD Application  

## Beschreibung
Ein einfache Applikation zum verwalten einer Liste von Autos.  
Die verfügbaren Parameter sind: Model, Marke, Leistung, Baujahr, Motor und Verbrauch.

## Bedienung
* Git rep herunterladen
* Maven Projekt importieren
* Starten des Projekts in der IDE
* Unter http://localhost:8080/carlist sollte die Liste der aktuell eingespeicherten Autos im json-Format erscheinen (3 Autos sind als Samples bereits vorgegeben)
* Unter http://localhost:8080/car/"modelname" kann jeder einzelne Eintrag in der Liste seperat betrachtet werden
* Um CRUD am einfachsten benutzen zu können, installiere den REST Client als Addon für deinen Browser oder installiere die Windows Anwendung.
* Mit der POST Methode lassen sich neue Objekte hinzufügen, Bsp: {"model":"abc","brand":"def","leistung":"250","baujahr":"2010","motor":"2 Benzin","verbrauch":"9"} in den Request Body eingeben und absenden
* Mit der GET Methode lässt sich prüfen ob die Operation erfolgreich war.
* Ein Objekt aus der Liste löschen lässt sich mit der DELETE Methode. Dabei gibt man als URL beispielsweise http://localhost:8080/car/abc an und sendet den Request ab. Nun sollte das Objekt nicht mehr auf der Liste stehen