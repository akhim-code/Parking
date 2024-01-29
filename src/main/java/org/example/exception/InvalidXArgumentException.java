package org.example.exception;
//Exception quand l'Integer X est moins de nombrePlaceVoitureMin dans le constructeur pour un parking
public class InvalidXArgumentException extends Exception{
    public InvalidXArgumentException(){super("La valeur X doit être supérieure ou égale à la minimum valeur " +
            "définie par l'objet Parking");
    }
}
