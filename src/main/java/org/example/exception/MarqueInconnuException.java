package org.example.exception;
//Exception quand la marque est inconnue dans le constructeur pour une Moto

public class MarqueInconnuException extends Exception{
    public MarqueInconnuException(){
        super("La marque de l'object Moto n'est pas connue");
    }

}
