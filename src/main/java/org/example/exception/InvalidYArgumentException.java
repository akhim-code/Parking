package org.example.exception;
//Exception quand l'Integer Y est moins de nombrePlaceMotoMin dans le constructeur pour un parking
public class InvalidYArgumentException extends Exception{
    public InvalidYArgumentException(){super("La valeur Y doit être supérieure ou égale à la minimum valeur définie par l'objet Parking");
    }
}