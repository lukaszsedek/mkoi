#! /bin/bash
Echo "Testowy skrypt ENIGMA\n"
mvn clean install -DskipTests=true
java -jar target/mkoi-0.2.jar 
